/*
 * Copyright (c) 2010, The Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package org.broadinstitute.sting.gatk.walkers.genotyper;

import org.broadinstitute.sting.commandline.ArgumentCollection;
import org.broadinstitute.sting.commandline.Input;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.commandline.RodBinding;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.RodWalker;
import org.broadinstitute.sting.utils.SampleUtils;
import org.broadinstitute.sting.utils.codecs.vcf.*;
import org.broadinstitute.sting.utils.codecs.vcf.writer.VCFWriter;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.variantcontext.*;

import java.util.*;

/**
 * Uses the UG engine to call variants based off of VCFs annotated with GLs (or PLs).
 * Absolutely not supported or recommended for public use.
 * Run this as you would the UnifiedGenotyper, except that instead of '-I reads' it expects any number
 * of GL/PL-annotated VCFs bound to a name starting with 'variant'.
 */
public class UGCallVariants extends RodWalker<VariantContext, Integer> {

    @ArgumentCollection
    private UnifiedArgumentCollection UAC = new UnifiedArgumentCollection();

    @Input(fullName="variant", shortName = "V", doc="Input VCF file", required=true)
    public List<RodBinding<VariantContext>> variants;

    // control the output
    @Output(doc="File to which variants should be written",required=true)
    protected VCFWriter writer = null;

    // the calculation arguments
    private UnifiedGenotyperEngine UG_engine = null;

    // variant track names
    private Set<String> trackNames = new HashSet<String>();

    public void initialize() {
        for ( RodBinding<VariantContext> rb : variants )
            trackNames.add(rb.getName());
        Set<String> samples = SampleUtils.getSampleListWithVCFHeader(getToolkit(), trackNames);

        UG_engine = new UnifiedGenotyperEngine(getToolkit(), UAC, logger, null, null, samples, VariantContextUtils.DEFAULT_PLOIDY);

        Set<VCFHeaderLine> headerInfo = new HashSet<VCFHeaderLine>();

        // If relevant, add in the alleles ROD's header fields (first, so that they can be overriden by the fields we manually add below):
        if (UAC.GenotypingMode == GenotypeLikelihoodsCalculationModel.GENOTYPING_MODE.GENOTYPE_GIVEN_ALLELES) {
            LinkedList<String> allelesRods = new LinkedList<String>();
            allelesRods.add(UAC.alleles.getName());
            headerInfo.addAll(VCFUtils.getHeaderFields(getToolkit(), allelesRods));
        }
        headerInfo.add(new VCFInfoHeaderLine(VCFConstants.ALLELE_FREQUENCY_KEY, -1, VCFHeaderLineType.Float, "Allele Frequency, for each ALT allele, in the same order as listed"));
        headerInfo.add(new VCFInfoHeaderLine(VCFConstants.ALLELE_COUNT_KEY, -1, VCFHeaderLineType.Integer, "Allele count in genotypes, for each ALT allele, in the same order as listed"));
        headerInfo.add(new VCFInfoHeaderLine(VCFConstants.ALLELE_NUMBER_KEY, 1, VCFHeaderLineType.Integer, "Total number of alleles in called genotypes"));
        headerInfo.add(new VCFFormatHeaderLine(VCFConstants.GENOTYPE_KEY, 1, VCFHeaderLineType.String, "Genotype"));
        headerInfo.add(new VCFFormatHeaderLine(VCFConstants.GENOTYPE_QUALITY_KEY, 1, VCFHeaderLineType.Float, "Genotype Quality"));
        headerInfo.add(new VCFFormatHeaderLine(VCFConstants.DEPTH_KEY, 1, VCFHeaderLineType.Integer, "Read Depth (only filtered reads used for calling)"));
        headerInfo.add(new VCFFormatHeaderLine(VCFConstants.PHRED_GENOTYPE_LIKELIHOODS_KEY, 3, VCFHeaderLineType.Float, "Normalized, Phred-scaled likelihoods for AA,AB,BB genotypes where A=ref and B=alt; not applicable if site is not biallelic"));
        if ( UAC.STANDARD_CONFIDENCE_FOR_EMITTING < UAC.STANDARD_CONFIDENCE_FOR_CALLING )
            headerInfo.add(new VCFFilterHeaderLine(UnifiedGenotyperEngine.LOW_QUAL_FILTER_NAME, "Low quality"));

        // initialize the header
        writer.writeHeader(new VCFHeader(headerInfo, samples));
    }

    public VariantContext map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if ( tracker == null )
            return null;

        List<VariantContext> VCs = tracker.getValues(variants, context.getLocation());

        VariantContext mergedVC = mergeVCsWithGLs(VCs, tracker, context);
        if ( mergedVC == null )
            return null;

        VariantContext mergedVCwithGT = UG_engine.calculateGenotypes(tracker, ref, context, mergedVC);

        if (mergedVCwithGT == null)
            return null;

        // Add the filters and attributes from the mergedVC first (so they can be overriden as necessary by mergedVCwithGT):
        Set<String> filters = new HashSet<String>();
        Map<String, Object> attributes = new HashMap<String, Object>();

        filters.addAll(mergedVC.getFilters());
        attributes.putAll(mergedVC.getAttributes());

        filters.addAll(mergedVCwithGT.getFilters());
        attributes.putAll(mergedVCwithGT.getAttributes());

        return new VariantContextBuilder(mergedVCwithGT).filters(filters).attributes(attributes).make();
    }

    public Integer reduceInit() { return 0; }

    public Integer reduce(VariantContext value, Integer sum) {
        if ( value == null )
            return sum;

        try {
            VariantContextBuilder builder = new VariantContextBuilder(value);
            VariantContextUtils.calculateChromosomeCounts(builder, true);
            writer.add(builder.make());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return sum + 1;
    }

    public void onTraversalDone(Integer result) {
        logger.info(String.format("Visited sites: %d", result));
    }

    private VariantContext mergeVCsWithGLs(List<VariantContext> VCs, RefMetaDataTracker tracker, AlignmentContext context) {
        // we can't use the VCUtils classes because our VCs can all be no-calls
        if ( VCs.size() == 0 )
            return null;

        VariantContext variantVC = null;
        GenotypesContext genotypes = GenotypesContext.create();
        for ( VariantContext vc : VCs ) {
            if ( variantVC == null && vc.isVariant() )
                variantVC = vc;
            genotypes.addAll(getGenotypesWithGLs(vc.getGenotypes()));
        }

        if ( variantVC == null ) {
            VariantContext vc = VCs.get(0);
            throw new UserException("There is no ALT allele in any of the VCF records passed in at " + vc.getChr() + ":" + vc.getStart());
        }

        Set<String> filters = new HashSet<String>();
        Map<String, Object> attributes = new HashMap<String, Object>();

        // If relevant, add the attributes from the alleles ROD first (so they can be overriden as necessary by variantVC below):
        if (UAC.GenotypingMode == GenotypeLikelihoodsCalculationModel.GENOTYPING_MODE.GENOTYPE_GIVEN_ALLELES) {
            List<VariantContext> allelesVCs = tracker.getValues(UAC.alleles, context.getLocation());
            for (VariantContext alleleVC : allelesVCs) {
                filters.addAll(alleleVC.getFilters());
                attributes.putAll(alleleVC.getAttributes());
            }
        }
        filters.addAll(variantVC.getFilters());
        attributes.putAll(variantVC.getAttributes());

        VariantContextBuilder vcb = new VariantContextBuilder(variantVC);
        vcb.filters(filters);
        vcb.attributes(attributes);

        return vcb.source("VCwithGLs").genotypes(genotypes).make();
    }

    private static GenotypesContext getGenotypesWithGLs(GenotypesContext genotypes) {
        GenotypesContext genotypesWithGLs = GenotypesContext.create(genotypes.size());
        for ( final Genotype g : genotypes ) {
            if ( g.hasLikelihoods() && g.getLikelihoods().getAsVector() != null )
                genotypesWithGLs.add(g);
        }
        return genotypesWithGLs;
    }
}
