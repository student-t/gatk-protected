/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 (“BROAD”) and the LICENSEE and is effective at the date the downloading is completed (“EFFECTIVE DATE”).
* 
* WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
* WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
* NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
* 
* 1. DEFINITIONS
* 1.1 PROGRAM shall mean copyright in the object code and source code known as GATK3 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute.org/gatk on the EFFECTIVE DATE.
* 
* 2. LICENSE
* 2.1 Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. LICENSEE hereby automatically grants to BROAD a non-exclusive, royalty-free, irrevocable license to any LICENSEE bug fixes or modifications to the PROGRAM with unlimited rights to sublicense and/or distribute.  LICENSEE agrees to provide any such modifications and bug fixes to BROAD promptly upon their creation.
* The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only. For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
* 2.2 No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD. LICENSEE shall ensure that all of its users agree to the terms of this Agreement. LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
* 2.3 License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.
* 
* 3. PHONE-HOME FEATURE
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system (“PHONE-HOME”) which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2015 Broad Institute, Inc.
* Notice of attribution: The GATK3 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
* LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
* 
* 5. INDEMNIFICATION
* LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
* 
* 6. NO REPRESENTATIONS OR WARRANTIES
* THE PROGRAM IS DELIVERED AS IS. BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
* IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
* 
* 7. ASSIGNMENT
* This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
* 
* 8. MISCELLANEOUS
* 8.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
* 8.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
* 8.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
* 8.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested. All notices under this Agreement shall be deemed effective upon receipt.
* 8.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter.
* 8.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
* 8.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.variant.variantcontext.v13;

import org.apache.log4j.Logger;
import org.broad.tribble.Feature;
import org.broad.tribble.FeatureCodec;
import org.broad.tribble.NameAwareCodec;
import org.broad.tribble.TribbleException;
import org.broad.tribble.readers.LineReader;
import org.broad.tribble.util.BlockCompressedInputStream;
import org.broad.tribble.util.ParsingUtils;
import org.broadinstitute.sting.utils.exceptions.ReviewedStingException;
import org.broadinstitute.sting.utils.exceptions.UserException;

import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;


abstract class AbstractVCFCodec implements FeatureCodec, NameAwareCodec, VCFParser {

    protected final static Logger log = Logger.getLogger(VCFCodec.class);
    protected final static int NUM_STANDARD_FIELDS = 8;  // INFO is the 8th column

    protected VCFHeaderVersion version;

    // we have to store the list of strings that make up the header until they're needed
    protected VCFHeader header = null;

    // a mapping of the allele
    protected Map<String, List<Allele>> alleleMap = new HashMap<String, List<Allele>>(3);

    // for ParsingUtils.split
    protected String[] GTValueArray = new String[100];
    protected String[] genotypeKeyArray = new String[100];
    protected String[] infoFieldArray = new String[1000];
    protected String[] infoValueArray = new String[1000];

    // for performance testing purposes
    public static boolean validate = true;

    // a key optimization -- we need a per thread string parts array, so we don't allocate a big array over and over
    // todo: make this thread safe?
    protected String[] parts = null;
    protected String[] genotypeParts = null;

    // for performance we cache the hashmap of filter encodings for quick lookup
    protected HashMap<String,LinkedHashSet<String>> filterHash = new HashMap<String,LinkedHashSet<String>>();

    // a mapping of the VCF fields to their type, filter fields, and format fields, for quick lookup to validate against
    TreeMap<String, VCFHeaderLineType> infoFields = new TreeMap<String, VCFHeaderLineType>();
    TreeMap<String, VCFHeaderLineType> formatFields = new TreeMap<String, VCFHeaderLineType>();
    Set<String> filterFields = new HashSet<String>();

    // we store a name to give to each of the variant contexts we emit
    protected String name = "Unknown";

    protected int lineNo = 0;

    protected Map<String, String> stringCache = new HashMap<String, String>();


    /**
     * @param reader the line reader to take header lines from
     * @return the number of header lines
     */
    public abstract Object readHeader(LineReader reader);

    /**
     * create a genotype map
     * @param str the string
     * @param alleles the list of alleles
     * @param chr chrom
     * @param pos position
     * @return a mapping of sample name to genotype object
     */
    public abstract Map<String, Genotype> createGenotypeMap(String str, List<Allele> alleles, String chr, int pos);


    /**
     * parse the filter string, first checking to see if we already have parsed it in a previous attempt
     * @param filterString the string to parse
     * @return a set of the filters applied
     */
    protected abstract Set<String> parseFilters(String filterString);

    /**
     * create a VCF header
     * @param headerStrings a list of strings that represent all the ## entries
     * @param line the single # line (column names)
     * @return the count of header lines
     */
    protected Object createHeader(List<String> headerStrings, String line) {

        headerStrings.add(line);

        Set<VCFHeaderLine> metaData = new TreeSet<VCFHeaderLine>();
        Set<String> auxTags = new LinkedHashSet<String>();
        // iterate over all the passed in strings
        for ( String str : headerStrings ) {
            if ( !str.startsWith(VCFHeader.METADATA_INDICATOR) ) {
                String[] strings = str.substring(1).split(VCFConstants.FIELD_SEPARATOR);
                if ( strings.length < VCFHeader.HEADER_FIELDS.values().length )
                    throw new TribbleException.InvalidHeader("there are not enough columns present in the header line: " + str);

                int arrayIndex = 0;
                for (VCFHeader.HEADER_FIELDS field : VCFHeader.HEADER_FIELDS.values()) {
                    try {
                        if (field != VCFHeader.HEADER_FIELDS.valueOf(strings[arrayIndex]))
                            throw new TribbleException.InvalidHeader("we were expecting column name '" + field + "' but we saw '" + strings[arrayIndex] + "'");
                    } catch (IllegalArgumentException e) {
                        throw new TribbleException.InvalidHeader("unknown column name '" + strings[arrayIndex] + "'; it does not match a legal column header name.");
                    }
                    arrayIndex++;
                }

                boolean sawFormatTag = false;
                if ( arrayIndex < strings.length ) {
                    if ( !strings[arrayIndex].equals("FORMAT") )
                        throw new TribbleException.InvalidHeader("we were expecting column name 'FORMAT' but we saw '" + strings[arrayIndex] + "'");
                    sawFormatTag = true;
                    arrayIndex++;
                }

                while ( arrayIndex < strings.length )
                    auxTags.add(strings[arrayIndex++]);

                if ( sawFormatTag && auxTags.size() == 0 )
                    throw new UserException.MalformedVCFHeader("The FORMAT field was provided but there is no genotype/sample data");

            } else {
                if ( str.startsWith("##INFO=") ) {
                    VCFInfoHeaderLine info = new VCFInfoHeaderLine(str.substring(7),version);
                    metaData.add(info);
                    infoFields.put(info.getName(), info.getType());
                } else if ( str.startsWith("##FILTER=") ) {
                    VCFFilterHeaderLine filter = new VCFFilterHeaderLine(str.substring(9),version);
                    metaData.add(filter);
                    filterFields.add(filter.getName());
                } else if ( str.startsWith("##FORMAT=") ) {
                    VCFFormatHeaderLine format = new VCFFormatHeaderLine(str.substring(9),version);
                    metaData.add(format);
                    formatFields.put(format.getName(), format.getType());
                } else {
                    int equals = str.indexOf("=");
                    if ( equals != -1 )
                        metaData.add(new VCFHeaderLine(str.substring(2, equals), str.substring(equals+1)));
                }
            }
        }

        header = new VCFHeader(metaData, auxTags);
        return header;
    }

    /**
     * the fast decode function
     * @param line the line of text for the record
     * @return a feature, (not guaranteed complete) that has the correct start and stop
     */
    public Feature decodeLoc(String line) {
        lineNo++;

        // the same line reader is not used for parsing the header and parsing lines, if we see a #, we've seen a header line
        if (line.startsWith(VCFHeader.HEADER_INDICATOR)) return null;

        // our header cannot be null, we need the genotype sample names and counts
        if (header == null) throw new ReviewedStingException("VCF Header cannot be null when decoding a record");

        final String[] locParts = new String[6];
        int nParts = ParsingUtils.split(line, locParts, VCFConstants.FIELD_SEPARATOR_CHAR, true);

        if ( nParts != 6 )
            throw new UserException.MalformedVCF("there aren't enough columns for line " + line, lineNo);

        // get our alleles (because the end position depends on them)
        final String ref = getCachedString(locParts[3].toUpperCase());
        final String alts = getCachedString(locParts[4].toUpperCase());
        final List<Allele> alleles = parseAlleles(ref, alts, lineNo);

        // find out our location
        final int start = Integer.valueOf(locParts[1]);
        int stop = start;

        // ref alleles don't need to be single bases for monomorphic sites
        if ( alleles.size() == 1 ) {
            stop = start + alleles.get(0).length() - 1;
        } else if ( !isSingleNucleotideEvent(alleles) ) {
            stop = clipAlleles(start, ref, alleles, null, lineNo);
        }

        return new VCFLocFeature(locParts[0], start, stop);
    }

    private final static class VCFLocFeature implements Feature {

        final String chr;
        final int start, stop;

        private VCFLocFeature(String chr, int start, int stop) {
            this.chr = chr;
            this.start = start;
            this.stop = stop;
        }

        public String getChr() { return chr; }
        public int getStart() { return start; }
        public int getEnd() { return stop; }
    }


    /**
     * decode the line into a feature (VariantContext)
     * @param line the line
     * @return a VariantContext
     */
    public Feature decode(String line) {
        // the same line reader is not used for parsing the header and parsing lines, if we see a #, we've seen a header line
        if (line.startsWith(VCFHeader.HEADER_INDICATOR)) return null;

        // our header cannot be null, we need the genotype sample names and counts
        if (header == null) throw new ReviewedStingException("VCF Header cannot be null when decoding a record");

        if (parts == null)
            parts = new String[Math.min(header.getColumnCount(), NUM_STANDARD_FIELDS+1)];

        int nParts = ParsingUtils.split(line, parts, VCFConstants.FIELD_SEPARATOR_CHAR, true);

        // if we have don't have a header, or we have a header with no genotyping data check that we have eight columns.  Otherwise check that we have nine (normal colummns + genotyping data)
        if (( (header == null || !header.hasGenotypingData()) && nParts != NUM_STANDARD_FIELDS) ||
             (header != null && header.hasGenotypingData() && nParts != (NUM_STANDARD_FIELDS + 1)) )
            throw new UserException.MalformedVCF("there aren't enough columns for line " + line + " (we expected " + (header == null ? NUM_STANDARD_FIELDS : NUM_STANDARD_FIELDS + 1) +
                    " tokens, and saw " + nParts + " )", lineNo);

        return parseVCFLine(parts);
    }

    protected void generateException(String message) {
        throw new UserException.MalformedVCF(message, lineNo);
    }

    protected static void generateException(String message, int lineNo) {
        throw new UserException.MalformedVCF(message, lineNo);
    }

    /**
     * parse out the VCF line
     *
     * @param parts the parts split up
     * @return a variant context object
     */
    private VariantContext parseVCFLine(String[] parts) {
        // increment the line count
        lineNo++;

        // parse out the required fields
        String contig = getCachedString(parts[0]);
        int pos = Integer.valueOf(parts[1]);
        String id = null;
        if ( parts[2].length() == 0 )
            generateException("The VCF specification requires a valid ID field");
        else if ( parts[2].equals(VCFConstants.EMPTY_ID_FIELD) )
            id = VCFConstants.EMPTY_ID_FIELD;
        else
            id = new String(parts[2]);
        String ref = getCachedString(parts[3].toUpperCase());
        String alts = getCachedString(parts[4].toUpperCase());
        Double qual = parseQual(parts[5]);
        String filter = getCachedString(parts[6]);
        String info = new String(parts[7]);

        // get our alleles, filters, and setup an attribute map
        List<Allele> alleles = parseAlleles(ref, alts, lineNo);
        Set<String> filters = parseFilters(filter);
        Map<String, Object> attributes = parseInfo(info, id);

        // find out our current location, and clip the alleles down to their minimum length
        int loc = pos;
        // ref alleles don't need to be single bases for monomorphic sites
        if ( alleles.size() == 1 ) {
            loc = pos + alleles.get(0).length() - 1;
        } else if ( !isSingleNucleotideEvent(alleles) ) {
            ArrayList<Allele> newAlleles = new ArrayList<Allele>();
            loc = clipAlleles(pos, ref, alleles, newAlleles, lineNo);
            alleles = newAlleles;
        }

        // do we have genotyping data
        if (parts.length > NUM_STANDARD_FIELDS) {
            attributes.put(VariantContext.UNPARSED_GENOTYPE_MAP_KEY, new String(parts[8]));
            attributes.put(VariantContext.UNPARSED_GENOTYPE_PARSER_KEY, this);
        }

        VariantContext vc = null;
        try {
            vc =  new VariantContext(name, contig, pos, loc, alleles, qual, filters, attributes, ref.getBytes()[0]);
        } catch (Exception e) {
            generateException(e.getMessage());
        }

        // did we resort the sample names?  If so, we need to load the genotype data
        if ( !header.samplesWereAlreadySorted() )
            vc.getGenotypes();

        return vc;
    }

    /**
     *
     * @return the type of record
     */
    public Class<VariantContext> getFeatureType() {
        return VariantContext.class;
    }

    /**
     * get the name of this codec
     * @return our set name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of this codec
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return a cached copy of the supplied string.
     *
     * @param str string
     * @return interned string
     */
    protected String getCachedString(String str) {
        String internedString = stringCache.get(str);
        if ( internedString == null ) {
            internedString = new String(str);
            stringCache.put(internedString, internedString);
        }
        return internedString;
    }

    /**
     * parse out the info fields
     * @param infoField the fields
     * @param id the indentifier
     * @return a mapping of keys to objects
     */
    private Map<String, Object> parseInfo(String infoField, String id) {
        Map<String, Object> attributes = new HashMap<String, Object>();

        if ( infoField.length() == 0 )
            generateException("The VCF specification requires a valid info field");

        if ( !infoField.equals(VCFConstants.EMPTY_INFO_FIELD) ) {
            if ( infoField.indexOf("\t") != -1 || infoField.indexOf(" ") != -1 )
                generateException("The VCF specification does not allow for whitespace in the INFO field");

            int infoFieldSplitSize = ParsingUtils.split(infoField, infoFieldArray, VCFConstants.INFO_FIELD_SEPARATOR_CHAR, false);
            for (int i = 0; i < infoFieldSplitSize; i++) {
                String key;
                Object value;

                int eqI = infoFieldArray[i].indexOf("=");
                if ( eqI != -1 ) {
                    key = infoFieldArray[i].substring(0, eqI);
                    String str = infoFieldArray[i].substring(eqI+1);

                    // split on the INFO field separator
                    int infoValueSplitSize = ParsingUtils.split(str, infoValueArray, VCFConstants.INFO_FIELD_ARRAY_SEPARATOR_CHAR, false);
                    if ( infoValueSplitSize == 1 ) {
                        value = infoValueArray[0];
                    } else {
                        ArrayList<String> valueList = new ArrayList<String>(infoValueSplitSize);
                        for ( int j = 0; j < infoValueSplitSize; j++ )
                            valueList.add(infoValueArray[j]);
                        value = valueList;
                    }
                } else {
                    key = infoFieldArray[i];
                    value = true;
                }

                attributes.put(key, value);
            }
        }

        if ( ! id.equals(VCFConstants.EMPTY_ID_FIELD) )
            attributes.put(VariantContext.ID_KEY, id);
        return attributes;
    }

    /**
     * create a an allele from an index and an array of alleles
     * @param index the index
     * @param alleles the alleles
     * @return an Allele
     */
    protected static Allele oneAllele(String index, List<Allele> alleles) {
        if ( index.equals(VCFConstants.EMPTY_ALLELE) )
            return Allele.NO_CALL;
        int i = Integer.valueOf(index);
        if ( i >= alleles.size() )
            throw new TribbleException.InternalCodecException("The allele with index " + index + " is not defined in the REF/ALT columns in the record");
        return alleles.get(i);
    }


    /**
     * parse genotype alleles from the genotype string
     * @param GT         GT string
     * @param alleles    list of possible alleles
     * @param cache      cache of alleles for GT
     * @return the allele list for the GT string
     */
    protected static List<Allele> parseGenotypeAlleles(String GT, List<Allele> alleles, Map<String, List<Allele>> cache) {
        // cache results [since they are immutable] and return a single object for each genotype
        List<Allele> GTAlleles = cache.get(GT);

        if ( GTAlleles == null ) {
            StringTokenizer st = new StringTokenizer(GT, VCFConstants.PHASING_TOKENS);
            GTAlleles = new ArrayList<Allele>(st.countTokens());
            while ( st.hasMoreTokens() ) {
                String genotype = st.nextToken();
                GTAlleles.add(oneAllele(genotype, alleles));
            }
            cache.put(GT, GTAlleles);
        }

        return GTAlleles;
    }

    /**
     * parse out the qual value
     * @param qualString the quality string
     * @return return a double
     */
    protected static Double parseQual(String qualString) {
        // if we're the VCF 4 missing char, return immediately
        if ( qualString.equals(VCFConstants.MISSING_VALUE_v4))
            return VariantContext.NO_NEG_LOG_10PERROR;

        Double val = Double.valueOf(qualString);

        // check to see if they encoded the missing qual score in VCF 3 style, with either the -1 or -1.0.  check for val < 0 to save some CPU cycles
        if ((val < 0) && (Math.abs(val - VCFConstants.MISSING_QUALITY_v3_DOUBLE) < VCFConstants.VCF_ENCODING_EPSILON))
            return VariantContext.NO_NEG_LOG_10PERROR;

        // scale and return the value
        return val / 10.0;
    }

    /**
     * parse out the alleles
     * @param ref the reference base
     * @param alts a string of alternates to break into alleles
     * @param lineNo  the line number for this record
     * @return a list of alleles, and a pair of the shortest and longest sequence
     */
    protected static List<Allele> parseAlleles(String ref, String alts, int lineNo) {
        List<Allele> alleles = new ArrayList<Allele>(2); // we are almost always biallelic
        // ref
        checkAllele(ref, true, lineNo);
        Allele refAllele = Allele.create(ref, true);
        alleles.add(refAllele);

        if ( alts.indexOf(",") == -1 ) // only 1 alternatives, don't call string split
            parseSingleAltAllele(alleles, alts, lineNo);
        else
            for ( String alt : alts.split(",") )
                parseSingleAltAllele(alleles, alt, lineNo);

        return alleles;
    }

    /**
     * check to make sure the allele is an acceptable allele
     * @param allele the allele to check
     * @param isRef are we the reference allele?
     * @param lineNo  the line number for this record
     */
    private static void checkAllele(String allele, boolean isRef, int lineNo) {
	if ( allele == null || allele.length() == 0 )
	    generateException("Empty alleles are not permitted in VCF records", lineNo);

        if ( isSymbolicAllele(allele) ) {
            if ( isRef ) {
                generateException("Symbolic alleles not allowed as reference allele: " + allele, lineNo);
            }
        } else {
            // check for VCF3 insertions or deletions
            if ( (allele.charAt(0) == VCFConstants.DELETION_ALLELE_v3) || (allele.charAt(0) == VCFConstants.INSERTION_ALLELE_v3) )
                generateException("Insertions/Deletions are not supported when reading 3.x VCF's. Please" +
                        " convert your file to VCF4 using VCFTools, available at http://vcftools.sourceforge.net/index.html", lineNo);

            if (!Allele.acceptableAlleleBases(allele))
                generateException("Unparsable vcf record with allele " + allele, lineNo);

            if ( isRef && allele.equals(VCFConstants.EMPTY_ALLELE) )
                generateException("The reference allele cannot be missing", lineNo);
        }
    }

    /**
     * return true if this is a symbolic allele (e.g. <SOMETAG>) otherwise false
     * @param allele the allele to check
     * @return true if the allele is a symbolic allele, otherwise false
     */
    private static boolean isSymbolicAllele(String allele) {
        return (allele != null && allele.startsWith("<") && allele.endsWith(">") && allele.length() > 2);
    }

    /**
     * parse a single allele, given the allele list
     * @param alleles the alleles available
     * @param alt the allele to parse
     * @param lineNo  the line number for this record
     */
    private static void parseSingleAltAllele(List<Allele> alleles, String alt, int lineNo) {
        checkAllele(alt, false, lineNo);

        Allele allele = Allele.create(alt, false);
        if ( ! allele.isNoCall() )
            alleles.add(allele);
    }

    protected static boolean isSingleNucleotideEvent(List<Allele> alleles) {
        for ( Allele a : alleles ) {
            if ( a.length() != 1 )
                return false;
        }
        return true;
    }

    public static int computeForwardClipping(List<Allele> unclippedAlleles, String ref) {
        boolean clipping = true;

        for ( Allele a : unclippedAlleles ) {
            if ( a.isSymbolic() )
                continue;

            if ( a.length() < 1 || (a.getBases()[0] != ref.getBytes()[0]) ) {
                clipping = false;
                break;
            }
        }

        return (clipping) ? 1 : 0;
    }

    protected static int computeReverseClipping(List<Allele> unclippedAlleles, String ref, int forwardClipping, int lineNo) {
        int clipping = 0;
        boolean stillClipping = true;

        while ( stillClipping ) {
            for ( Allele a : unclippedAlleles ) {
                if ( a.isSymbolic() )
                    continue;

                if ( a.length() - clipping <= forwardClipping || a.length() - forwardClipping == 0 )
                    stillClipping = false;
                else if ( ref.length() == clipping )
                    generateException("bad alleles encountered", lineNo);
                else if ( a.getBases()[a.length()-clipping-1] != ref.getBytes()[ref.length()-clipping-1] )
                    stillClipping = false;
            }
            if ( stillClipping )
                clipping++;
        }

        return clipping;
    }
    /**
     * clip the alleles, based on the reference
     *
     * @param position the unadjusted start position (pre-clipping)
     * @param ref the reference string
     * @param unclippedAlleles the list of unclipped alleles
     * @param clippedAlleles output list of clipped alleles
     * @param lineNo the current line number in the file
     * @return the new reference end position of this event
     */
    protected static int clipAlleles(int position, String ref, List<Allele> unclippedAlleles, List<Allele> clippedAlleles, int lineNo) {

        int forwardClipping = computeForwardClipping(unclippedAlleles, ref);
        int reverseClipping = computeReverseClipping(unclippedAlleles, ref, forwardClipping, lineNo);

        if ( clippedAlleles != null ) {
            for ( Allele a : unclippedAlleles ) {
                if ( a.isSymbolic() ) {
                    clippedAlleles.add(a);
                } else {
                    clippedAlleles.add(Allele.create(Arrays.copyOfRange(a.getBases(), forwardClipping, a.getBases().length-reverseClipping), a.isReference()));
                }
            }
        }

        // the new reference length
        int refLength = ref.length() - reverseClipping;

        return position+Math.max(refLength - 1,0);
    }

    public final static boolean canDecodeFile(final File potentialInput, final String MAGIC_HEADER_LINE) {
        try {
            return isVCFStream(new FileInputStream(potentialInput), MAGIC_HEADER_LINE) ||
                    isVCFStream(new GZIPInputStream(new FileInputStream(potentialInput)), MAGIC_HEADER_LINE) ||
                    isVCFStream(new BlockCompressedInputStream(new FileInputStream(potentialInput)), MAGIC_HEADER_LINE);
        } catch ( FileNotFoundException e ) {
            return false;
        } catch ( IOException e ) {
            return false;
        }
    }

    private final static boolean isVCFStream(final InputStream stream, final String MAGIC_HEADER_LINE) {
        try {
            byte[] buff = new byte[MAGIC_HEADER_LINE.length()];
            int nread = stream.read(buff, 0, MAGIC_HEADER_LINE.length());
            boolean eq = Arrays.equals(buff, MAGIC_HEADER_LINE.getBytes());
            return eq;
//            String firstLine = new String(buff);
//            return firstLine.startsWith(MAGIC_HEADER_LINE);
        } catch ( IOException e ) {
            return false;
        } catch ( RuntimeException e ) {
            return false;
        } finally {
            try { stream.close(); } catch ( IOException e ) {}
        }
    }
}
