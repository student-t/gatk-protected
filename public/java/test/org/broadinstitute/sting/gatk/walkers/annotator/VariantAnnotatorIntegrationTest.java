package org.broadinstitute.sting.gatk.walkers.annotator;

import org.broadinstitute.sting.WalkerTest;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.testng.annotations.Test;

import java.util.Arrays;

public class VariantAnnotatorIntegrationTest extends WalkerTest {

    public static String baseTestString() {
        return "-T VariantAnnotator -R " + b36KGReference + " -NO_HEADER -o %s";
    }

    @Test
    public void testHasAnnotsNotAsking1() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --variant:VCF3 " + validationDataLocation + "vcfexample2.vcf -I " + validationDataLocation + "low_coverage_CEU.chr1.10k-11k.bam -L 1:10,020,000-10,021,000", 1,
                Arrays.asList("8a105fa5eebdfffe7326bc5b3d8ffd1c"));
        executeTest("test file has annotations, not asking for annotations, #1", spec);
    }

    @Test
    public void testHasAnnotsNotAsking2() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --variant:VCF3 " + validationDataLocation + "vcfexample3.vcf -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -L 1:10,000,000-10,050,000", 1,
                Arrays.asList("964f1016ec9a3c55333f62dd834c14d6"));
        executeTest("test file has annotations, not asking for annotations, #2", spec);
    }

    @Test
    public void testHasAnnotsAsking1() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " -G Standard --variant:VCF3 " + validationDataLocation + "vcfexample2.vcf -I " + validationDataLocation + "low_coverage_CEU.chr1.10k-11k.bam -L 1:10,020,000-10,021,000", 1,
                Arrays.asList("ac5f409856a1b79316469733e62abb91"));
        executeTest("test file has annotations, asking for annotations, #1", spec);
    }

    @Test
    public void testHasAnnotsAsking2() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " -G Standard --variant:VCF3 " + validationDataLocation + "vcfexample3.vcf -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -L 1:10,000,000-10,050,000", 1,
                Arrays.asList("f9aa7bee5a61ac1a9187d0cf1e8af471"));
        executeTest("test file has annotations, asking for annotations, #2", spec);
    }

    @Test
    public void testNoAnnotsNotAsking1() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --variant:VCF3 " + validationDataLocation + "vcfexample2empty.vcf -I " + validationDataLocation + "low_coverage_CEU.chr1.10k-11k.bam -L 1:10,020,000-10,021,000", 1,
                Arrays.asList("42ccee09fa9f8c58f4a0d4f1139c094f"));
        executeTest("test file doesn't have annotations, not asking for annotations, #1", spec);
    }

    @Test
    public void testNoAnnotsNotAsking2() {
        // this genotype annotations in this file are actually out of order.  If you don't parse the genotypes
        // they don't get reordered.  It's a good test of the genotype ordering system.
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --variant:VCF3 " + validationDataLocation + "vcfexample3empty.vcf -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -L 1:10,000,000-10,050,000", 1,
                Arrays.asList("f2ddfa8105c290b1f34b7a261a02a1ac"));
        executeTest("test file doesn't have annotations, not asking for annotations, #2", spec);
    }

    @Test
    public void testNoAnnotsAsking1() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " -G Standard --variant:VCF3 " + validationDataLocation + "vcfexample2empty.vcf -I " + validationDataLocation + "low_coverage_CEU.chr1.10k-11k.bam -L 1:10,020,000-10,021,000", 1,
                Arrays.asList("6f27fd863b6718d59d2a2d8e2a20bcae"));
        executeTest("test file doesn't have annotations, asking for annotations, #1", spec);
    }

    @Test
    public void testNoAnnotsAsking2() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " -G Standard --variant:VCF3 " + validationDataLocation + "vcfexample3empty.vcf -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -L 1:10,000,000-10,050,000", 1,
                Arrays.asList("40bbd3d5a2397a007c0e74211fb33433"));
        executeTest("test file doesn't have annotations, asking for annotations, #2", spec);
    }

    @Test
    public void testExcludeAnnotations() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " -G Standard -XA FisherStrand -XA ReadPosRankSumTest --variant:VCF3 " + validationDataLocation + "vcfexample2empty.vcf -I " + validationDataLocation + "low_coverage_CEU.chr1.10k-11k.bam -L 1:10,020,000-10,021,000", 1,
                Arrays.asList("40622d39072b298440a77ecc794116e7"));
        executeTest("test exclude annotations", spec);
    }

    @Test
    public void testOverwritingHeader() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " -G Standard --variant " + validationDataLocation + "vcfexample4.vcf -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -L 1:10,001,292", 1,
                Arrays.asList("31faae1bc588d195ff553cf6c47fabfa"));
        executeTest("test overwriting header", spec);
    }

    @Test
    public void testNoReads() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " -G Standard --variant " + validationDataLocation + "vcfexample3empty.vcf -L " + validationDataLocation + "vcfexample3empty.vcf", 1,
                Arrays.asList("06635f2dd91b539bfbce9bf7914d8e43"));
        executeTest("not passing it any reads", spec);
    }

    @Test
    public void testDBTagWithDbsnp() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --dbsnp " + b36dbSNP129 + " -G Standard --variant " + validationDataLocation + "vcfexample3empty.vcf -L " + validationDataLocation + "vcfexample3empty.vcf", 1,
                Arrays.asList("820eeba1f6e3a0758a69d937c524a38e"));
        executeTest("getting DB tag with dbSNP", spec);
    }

    @Test
    public void testDBTagWithHapMap() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --comp:H3 " + validationDataLocation + "fakeHM3.vcf -G Standard --variant " + validationDataLocation + "vcfexample3empty.vcf -L " + validationDataLocation + "vcfexample3empty.vcf", 1,
                Arrays.asList("31cc2ce157dd20771418c08d6b3be1fa"));
        executeTest("getting DB tag with HM3", spec);
    }

    @Test
    public void testUsingExpression() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --resource:foo " + validationDataLocation + "targetAnnotations.vcf -G Standard --variant:VCF3 " + validationDataLocation + "vcfexample3empty.vcf -E foo.AF -L " + validationDataLocation + "vcfexample3empty.vcf", 1,
                Arrays.asList("074865f8f8c0ca7bfd58681f396c49e9"));
        executeTest("using expression", spec);
    }

    @Test
    public void testUsingExpressionWithID() {
        WalkerTestSpec spec = new WalkerTestSpec(
                baseTestString() + " --resource:foo " + validationDataLocation + "targetAnnotations.vcf -G Standard --variant:VCF3 " + validationDataLocation + "vcfexample3empty.vcf -E foo.ID -L " + validationDataLocation + "vcfexample3empty.vcf", 1,
                Arrays.asList("97b26db8135d083566fb585a677fbe8a"));
        executeTest("using expression with ID", spec);
    }

    @Test
    public void testTabixAnnotations() {
        final String MD5 = "13269d5a2e16f06fd755cc0fb9271acf";
        for ( String file : Arrays.asList("CEU.exon.2010_03.sites.vcf", "CEU.exon.2010_03.sites.vcf.gz")) {
            WalkerTestSpec spec = new WalkerTestSpec(
                    baseTestString() + " -A HomopolymerRun --variant:vcf " + validationDataLocation + file + " -L " + validationDataLocation + "CEU.exon.2010_03.sites.vcf -NO_HEADER", 1,
                    Arrays.asList(MD5));
            executeTest("Testing lookup vcf tabix vs. vcf tribble", spec);
        }
    }

    @Test(enabled = false)
    public void testSnpEffAnnotations() {
        WalkerTestSpec spec = new WalkerTestSpec(
            "-T VariantAnnotator -R " + hg19Reference + " -NO_HEADER -o %s -A SnpEff --variant " +
            validationDataLocation + "1kg_exomes_unfiltered.AFR.unfiltered.vcf --snpEffFile  " + validationDataLocation +
            "snpEff2.0.4.AFR.unfiltered.vcf -L 1:1-1,500,000 -L 2:232,325,429",
            1,
            Arrays.asList("51258f5c880bd1ca3eb45a1711335c66")
        );
        executeTest("Testing SnpEff annotations", spec);
    }

    @Test(enabled = false)
    public void testSnpEffAnnotationsUnsupportedVersion() {
        WalkerTestSpec spec = new WalkerTestSpec(
            "-T VariantAnnotator -R " + hg19Reference + " -NO_HEADER -o %s -A SnpEff --variant " +
            validationDataLocation + "1kg_exomes_unfiltered.AFR.unfiltered.vcf --snpEffFile  " + validationDataLocation +
            "snpEff.AFR.unfiltered.unsupported.version.vcf -L 1:1-1,500,000",
            1,
            UserException.class
        );
        executeTest("Testing SnpEff annotations (unsupported version)", spec);
    }

    @Test
    public void testTDTAnnotation() {
        final String MD5 = "204e67536a17af7eaa6bf0a910818997";
        WalkerTestSpec spec = new WalkerTestSpec(
                "-T VariantAnnotator -R " + b37KGReference + " -A TransmissionDisequilibriumTest --variant:vcf " + validationDataLocation + "ug.random50000.subset300bp.chr1.family.vcf" +
                        " -L " + validationDataLocation + "ug.random50000.subset300bp.chr1.family.vcf -NO_HEADER -ped " + validationDataLocation + "ug.random50000.family.ped -o %s", 1,
                Arrays.asList(MD5));
        executeTest("Testing TDT annotation", spec);
    }

}
