/*
 * Copyright (c) 2010 The Broad Institute
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
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.broadinstitute.sting.analyzecovariates;

import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.CommandLineProgram;
import org.broadinstitute.sting.commandline.Input;
import org.broadinstitute.sting.gatk.walkers.recalibration.Covariate;
import org.broadinstitute.sting.gatk.walkers.recalibration.RecalDatum;
import org.broadinstitute.sting.gatk.walkers.recalibration.RecalibrationArgumentCollection;
import org.broadinstitute.sting.utils.R.RScriptExecutor;
import org.broadinstitute.sting.utils.classloader.PluginManager;
import org.broadinstitute.sting.utils.exceptions.DynamicClassResolutionException;
import org.broadinstitute.sting.utils.help.DocumentedGATKFeature;
import org.broadinstitute.sting.utils.text.XReadLines;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Call R scripts to plot residual error versus the various covariates.
 *
 * <p>
 * After counting covariates in either the initial BAM File or again in the recalibrated BAM File, an analysis tool is available which
 * reads the .csv file and outputs several PDF (and .dat) files for each read group in the given BAM. These PDF files graphically
 * show the various metrics and characteristics of the reported quality scores (often in relation to the empirical qualities).
 * In order to show that any biases in the reported quality scores have been generally fixed through recalibration one should run
 * CountCovariates again on a bam file produced by TableRecalibration. In this way users can compare the analysis plots generated
 * by pre-recalibration and post-recalibration .csv files. Our usual chain of commands that we use to generate plots of residual
 * error is: CountCovariates, TableRecalibrate, samtools index on the recalibrated bam file, CountCovariates again on the recalibrated
 * bam file, and then AnalyzeCovariates on both the before and after recal_data.csv files to see the improvement in recalibration.
 *
 * <p>
 * The color coding along with the RMSE is included in the plots to give some indication of the number of observations that went into
 * each of the quality score estimates. It is defined as follows for N, the number of observations:
 *
 * <ul>
 * <li>light blue means N < 1,000</li>
 * <li>cornflower blue means 1,000 <= N < 10,000</li>
 * <li>dark blue means N >= 10,000</li>
 * <li>The pink dots indicate points whose quality scores are special codes used by the aligner and which are mathematically
 * meaningless and so aren't included in any of the numerical calculations.</li>
 * </ul>
 *
 * <p>
 * NOTE: For those running this tool externally from the Broad, it is crucial to note that both the -Rscript and -resources options
 * must be changed from the default. -Rscript needs to point to your installation of Rscript (this is the scripting version of R,
 * not the interactive version) while -resources needs to point to the folder holding the R scripts that are used. For those using
 * this tool as part of the Binary Distribution the -resources should point to the resources folder that is part of the tarball.
 * For those using this tool by building from the git repository the -resources should point to the R/ subdirectory of the Sting checkout.
 *
 * <p>
 * See the GATK wiki for a tutorial and example recalibration accuracy plots.
 * http://www.broadinstitute.org/gsa/wiki/index.php/Base_quality_score_recalibration
 *
 * <h2>Input</h2>
 * <p>
 * The recalibration table file in CSV format that was generated by the CountCovariates walker.
 * </p>
 *
 * <h2>Examples</h2>
 * <pre>
 * java -Xmx4g -jar AnalyzeCovariates.jar \
 *   -recalFile /path/to/recal.table.csv  \
 *   -outputDir /path/to/output_dir/  \
 *   -resources resources/  \
 *   -ignoreQ 5
 * </pre>
 *
 */

@DocumentedGATKFeature(
        groupName = "AnalyzeCovariates",
        summary = "Package to plot residual accuracy versus error covariates for the base quality score recalibrator")
public class AnalyzeCovariates extends CommandLineProgram {

    /////////////////////////////
    // Command Line Arguments
    /////////////////////////////
    /**
     * After the header, data records occur one per line until the end of the file. The first several items on a line are the
     * values of the individual covariates and will change depending on which covariates were specified at runtime. The last
     * three items are the data- that is, number of observations for this combination of covariates, number of reference mismatches,
     * and the raw empirical quality score calculated by phred-scaling the mismatch rate.
     */
    @Input(fullName = "recal_file", shortName = "recalFile", doc = "The input recal csv file to analyze", required = false)
    private String RECAL_FILE = "output.recal_data.csv";
    @Argument(fullName = "output_dir", shortName = "outputDir", doc = "The directory in which to output all the plots and intermediate data files", required = false)
    private String OUTPUT_DIR = "analyzeCovariates/";
    @Argument(fullName = "path_to_Rscript", shortName = "Rscript", doc = "The path to your implementation of Rscript. For Broad users this is maybe /broad/software/free/Linux/redhat_5_x86_64/pkgs/r_2.12.0/bin/Rscript", required = false)
    private String PATH_TO_RSCRIPT = "Rscript";
    @Argument(fullName = "path_to_resources", shortName = "resources", doc = "Path to resources folder holding the Sting R scripts.", required = false)
    private String PATH_TO_RESOURCES = "public/R/";
    @Argument(fullName = "ignoreQ", shortName = "ignoreQ", doc = "Ignore bases with reported quality less than this number.", required = false)
    private int IGNORE_QSCORES_LESS_THAN = 5;
    @Argument(fullName = "numRG", shortName = "numRG", doc = "Only process N read groups. Default value: -1 (process all read groups)", required = false)
    private int NUM_READ_GROUPS_TO_PROCESS = -1; // -1 means process all read groups

    /**
     * Combinations of covariates in which there are zero mismatches technically have infinite quality. We get around this situation
     * by capping at the specified value. We've found that Q40 is too low when using a more completely database of known variation like dbSNP build 132 or later.
     */
    @Argument(fullName="max_quality_score", shortName="maxQ", required = false, doc="The integer value at which to cap the quality scores, default is 50")
    private int MAX_QUALITY_SCORE = 50;

    /**
     * This argument is useful for comparing before/after plots and you want the axes to match each other.
     */
    @Argument(fullName="max_histogram_value", shortName="maxHist", required = false, doc="If supplied, this value will be the max value of the histogram plots")
    private int MAX_HISTOGRAM_VALUE = 0;
    @Argument(fullName="do_indel_quality", shortName="indels", required = false, doc="If supplied, do indel quality plotting")
    private boolean DO_INDEL_QUALITY = false;


    /////////////////////////////
    // Private Member Variables
    /////////////////////////////
    private AnalysisDataManager dataManager; // Holds the data HashMap, mostly used by TableRecalibrationWalker to create collapsed data hashmaps
    private ArrayList<Covariate> requestedCovariates; // List of covariates to be used in this calculation
    private final Pattern COMMENT_PATTERN = Pattern.compile("^#.*");
    private final Pattern OLD_RECALIBRATOR_HEADER = Pattern.compile("^rg,.*");
    private final Pattern COVARIATE_PATTERN = Pattern.compile("^ReadGroup,QualityScore,.*");
    protected static final String EOF_MARKER = "EOF";

    protected int execute() {

        // create the output directory where all the data tables and plots will go
        try {
            Process p = Runtime.getRuntime().exec("mkdir " + OUTPUT_DIR);
        } catch (IOException e) {
            System.out.println("Couldn't create directory: " + OUTPUT_DIR);
            System.out.println("User is responsible for making sure the output directory exists.");
        }
        if( !OUTPUT_DIR.endsWith("/") ) { OUTPUT_DIR = OUTPUT_DIR + "/"; }
        if( !PATH_TO_RESOURCES.endsWith("/") ) { PATH_TO_RESOURCES = PATH_TO_RESOURCES + "/"; }

        // initialize all the data from the csv file and allocate the list of covariates
        System.out.println("Reading in input csv file...");
        initializeData();
        System.out.println("...Done!");

        // output data tables for Rscript to read in
        System.out.println("Writing out intermediate tables for R...");
        writeDataTables();
        System.out.println("...Done!");

        // perform the analysis using Rscript and output the plots
        System.out.println("Calling analysis R scripts and writing out figures...");
        callRScripts();
        System.out.println("...Done!");

        return 0;
    }

    private void initializeData() {

        // Get a list of all available covariates
        Collection<Class<? extends Covariate>> classes = new PluginManager<Covariate>(Covariate.class).getPlugins();

        int lineNumber = 0;
        boolean foundAllCovariates = false;

        // Read in the covariates that were used from the input file
        requestedCovariates = new ArrayList<Covariate>();

        try {
            for ( String line : new XReadLines(new File( RECAL_FILE )) ) {
                lineNumber++;
                if( COMMENT_PATTERN.matcher(line).matches() || OLD_RECALIBRATOR_HEADER.matcher(line).matches() || line.equals(EOF_MARKER) )  {
                    ; // Skip over the comment lines, (which start with '#')
                }
                else if( COVARIATE_PATTERN.matcher(line).matches() ) { // The line string is either specifying a covariate or is giving csv data
                    if( foundAllCovariates ) {
                        throw new RuntimeException( "Malformed input recalibration file. Found covariate names intermingled with data in file: " + RECAL_FILE );
                    } else { // Found the covariate list in input file, loop through all of them and instantiate them
                        String[] vals = line.split(",");
                        for( int iii = 0; iii < vals.length - 3; iii++ ) { // There are n-3 covariates. The last three items are nObservations, nMismatch, and Qempirical
                            boolean foundClass = false;
                            for( Class<?> covClass : classes ) {
                                if( (vals[iii] + "Covariate").equalsIgnoreCase( covClass.getSimpleName() ) ) {
                                    foundClass = true;
                                    try {
                                        Covariate covariate = (Covariate)covClass.newInstance();
                                        requestedCovariates.add( covariate );
                                    } catch (Exception e) {
                                        throw new DynamicClassResolutionException(covClass, e);
                                    }
                                }
                            }

                            if( !foundClass ) {
                                throw new RuntimeException( "Malformed input recalibration file. The requested covariate type (" + (vals[iii] + "Covariate") + ") isn't a valid covariate option." );
                            }
                        }

                    }

                } else { // Found a line of data
                    if( !foundAllCovariates ) {

                        foundAllCovariates = true;

                        // At this point all the covariates should have been found and initialized
                        if( requestedCovariates.size() < 2 ) {
                            throw new RuntimeException( "Malformed input recalibration file. Covariate names can't be found in file: " + RECAL_FILE );
                        }

                        // Initialize any covariate member variables using the shared argument collection
                        for( Covariate cov : requestedCovariates ) {
                            cov.initialize( new RecalibrationArgumentCollection() );
                        }

                        // Initialize the data hashMaps
                        dataManager = new AnalysisDataManager( requestedCovariates.size() );

                    }
                    addCSVData(line); // Parse the line and add the data to the HashMap
                }
            }

        } catch ( FileNotFoundException e ) {
            throw new RuntimeException("Can not find input file: " + RECAL_FILE);
        } catch ( NumberFormatException e ) {
            throw new RuntimeException("Error parsing recalibration data at line " + lineNumber + ". Perhaps your table was generated by an older version of CovariateCounterWalker.");
        }
    }

    private void addCSVData(String line) {
        String[] vals = line.split(",");

        // Check if the data line is malformed, for example if the read group string contains a comma then it won't be parsed correctly
        if( vals.length != requestedCovariates.size() + 3 ) { // +3 because of nObservations, nMismatch, and Qempirical
            throw new RuntimeException("Malformed input recalibration file. Found data line with too many fields: " + line +
                    " --Perhaps the read group string contains a comma and isn't being parsed correctly.");
        }

        Object[] key = new Object[requestedCovariates.size()];
        Covariate cov;
        int iii;
        for( iii = 0; iii < requestedCovariates.size(); iii++ ) {
            cov = requestedCovariates.get( iii );
            key[iii] = cov.getValue( vals[iii] );
        }
        // Create a new datum using the number of observations, number of mismatches, and reported quality score
        RecalDatum datum = new RecalDatum( Long.parseLong( vals[iii] ), Long.parseLong( vals[iii + 1] ), Double.parseDouble( vals[1] ), 0.0 );
        // Add that datum to all the collapsed tables which will be used in the sequential calculation
        dataManager.addToAllTables( key, datum, IGNORE_QSCORES_LESS_THAN );

    }

    private void writeDataTables() {

        int numReadGroups = 0;

        // for each read group
        for( Object readGroupKey : dataManager.getCollapsedTable(0).data.keySet() ) {

            if(NUM_READ_GROUPS_TO_PROCESS == -1 || ++numReadGroups <= NUM_READ_GROUPS_TO_PROCESS) {
                String readGroup = readGroupKey.toString();
                RecalDatum readGroupDatum = (RecalDatum) dataManager.getCollapsedTable(0).data.get(readGroupKey);
                System.out.print("Writing out data tables for read group: " + readGroup + "\twith " + readGroupDatum.getNumObservations() + " observations"  );
                System.out.println("\tand aggregate residual error = " + String.format("%.3f", readGroupDatum.empiricalQualDouble(0, MAX_QUALITY_SCORE) - readGroupDatum.getEstimatedQReported()));

                // for each covariate
                for( int iii = 1; iii < requestedCovariates.size(); iii++ ) {
                    Covariate cov = requestedCovariates.get(iii);

                    // Create a PrintStream
                    PrintStream output = null;
                    try {
                        output = new PrintStream(new FileOutputStream(OUTPUT_DIR + readGroup + "." + cov.getClass().getSimpleName()+ ".dat"));

                    } catch (FileNotFoundException e) {
                        System.err.println("Can't create file: " + OUTPUT_DIR + readGroup + "." + cov.getClass().getSimpleName()+ ".dat");
                        System.exit(-1);
                    }

                    // Output the header
                    output.println("Covariate\tQreported\tQempirical\tnMismatches\tnBases");

                    for( Object covariateKey : ((Map)dataManager.getCollapsedTable(iii).data.get(readGroupKey)).keySet()) {
                        output.print( covariateKey.toString() + "\t" );                                                     // Covariate
                        RecalDatum thisDatum = (RecalDatum)((Map)dataManager.getCollapsedTable(iii).data.get(readGroupKey)).get(covariateKey);
                        output.print( String.format("%.3f", thisDatum.getEstimatedQReported()) + "\t" );                    // Qreported
                        output.print( String.format("%.3f", thisDatum.empiricalQualDouble(0, MAX_QUALITY_SCORE)) + "\t" );  // Qempirical
                        output.print( thisDatum.getNumMismatches() + "\t" );                                                // nMismatches
                        output.println( thisDatum.getNumObservations() );                                                   // nBases
                    }

                    // Close the PrintStream
                    output.close();
                }
            } else {
                break;
            }

        }
    }

    private void callRScripts() {
        RScriptExecutor.RScriptArgumentCollection argumentCollection =
                new RScriptExecutor.RScriptArgumentCollection(PATH_TO_RSCRIPT, Arrays.asList(PATH_TO_RESOURCES));
        RScriptExecutor executor = new RScriptExecutor(argumentCollection, true);

        int numReadGroups = 0;

        // for each read group
        for( Object readGroupKey : dataManager.getCollapsedTable(0).data.keySet() ) {
            if(++numReadGroups <= NUM_READ_GROUPS_TO_PROCESS || NUM_READ_GROUPS_TO_PROCESS == -1) {

                String readGroup = readGroupKey.toString();
                System.out.println("Analyzing read group: " + readGroup);

                // for each covariate
                for( int iii = 1; iii < requestedCovariates.size(); iii++ ) {
                    Covariate cov = requestedCovariates.get(iii);
                    final String outputFilename = OUTPUT_DIR + readGroup + "." + cov.getClass().getSimpleName()+ ".dat";
                    if (DO_INDEL_QUALITY) {
                        executor.callRScripts("plot_indelQuality.R", outputFilename,
                                cov.getClass().getSimpleName().split("Covariate")[0]); // The third argument is the name of the covariate in order to make the plots look nice
                    }   else {
                        if( iii == 1 ) {
                            // Analyze reported quality
                            executor.callRScripts("plot_residualError_QualityScoreCovariate.R", outputFilename,
                                    IGNORE_QSCORES_LESS_THAN, MAX_QUALITY_SCORE, MAX_HISTOGRAM_VALUE); // The third argument is the Q scores that should be turned pink in the plot because they were ignored
                        } else { // Analyze all other covariates
                            executor.callRScripts("plot_residualError_OtherCovariate.R", outputFilename,
                                    cov.getClass().getSimpleName().split("Covariate")[0]); // The third argument is the name of the covariate in order to make the plots look nice
                        }
                    }
                }
            } else { // at the maximum number of read groups so break out
                break;
            }
        }
    }

    public static void main(String args[]) {
        try {
            AnalyzeCovariates clp = new AnalyzeCovariates();
            start(clp, args);
            System.exit(CommandLineProgram.result);
        } catch (Exception e) {
            exitSystemWithError(e);
        }
    }
}
