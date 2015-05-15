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
* Copyright 2012-2014 Broad Institute, Inc.
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

package org.broadinstitute.sting.gatk;

import com.google.java.contract.Ensures;
import net.sf.picard.reference.IndexedFastaSequenceFile;
import net.sf.picard.reference.ReferenceSequenceFile;
import net.sf.samtools.SAMFileHeader;
import net.sf.samtools.SAMRecord;
import net.sf.samtools.SAMSequenceDictionary;
import org.apache.log4j.Logger;
import org.broadinstitute.sting.commandline.*;
import org.broadinstitute.sting.gatk.arguments.GATKArgumentCollection;
import org.broadinstitute.sting.gatk.arguments.ValidationExclusion;
import org.broadinstitute.sting.gatk.datasources.reads.*;
import org.broadinstitute.sting.gatk.datasources.reference.ReferenceDataSource;
import org.broadinstitute.sting.gatk.datasources.rmd.ReferenceOrderedDataSource;
import org.broadinstitute.sting.gatk.downsampling.DownsamplingMethod;
import org.broadinstitute.sting.gatk.executive.MicroScheduler;
import org.broadinstitute.sting.gatk.filters.FilterManager;
import org.broadinstitute.sting.gatk.filters.ReadFilter;
import org.broadinstitute.sting.gatk.filters.ReadGroupBlackListFilter;
import org.broadinstitute.sting.gatk.io.OutputTracker;
import org.broadinstitute.sting.gatk.io.stubs.Stub;
import org.broadinstitute.sting.gatk.iterators.ReadTransformer;
import org.broadinstitute.sting.gatk.iterators.ReadTransformersMode;
import org.broadinstitute.sting.gatk.refdata.tracks.RMDTrackBuilder;
import org.broadinstitute.sting.gatk.refdata.utils.RMDTriplet;
import org.broadinstitute.sting.gatk.resourcemanagement.ThreadAllocation;
import org.broadinstitute.sting.gatk.samples.SampleDB;
import org.broadinstitute.sting.gatk.samples.SampleDBBuilder;
import org.broadinstitute.sting.gatk.walkers.*;
import org.broadinstitute.sting.utils.*;
import org.broadinstitute.sting.utils.classloader.GATKLiteUtils;
import org.broadinstitute.sting.utils.classloader.PluginManager;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.exceptions.ReviewedStingException;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.interval.IntervalUtils;
import org.broadinstitute.sting.utils.recalibration.BaseRecalibration;
import org.broadinstitute.sting.utils.threading.ThreadEfficiencyMonitor;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * A GenomeAnalysisEngine that runs a specified walker.
 */
public class GenomeAnalysisEngine {
    /**
     * our log, which we want to capture anything from this class
     */
    private static Logger logger = Logger.getLogger(GenomeAnalysisEngine.class);
    public static final long NO_RUNTIME_LIMIT = -1;

    /**
     * The GATK command-line argument parsing code.
     */
    private ParsingEngine parsingEngine;

    /**
     * The genomeLocParser can create and parse GenomeLocs.
     */
    private GenomeLocParser genomeLocParser;

    /**
     * Accessor for sharded read data.
     */
    private SAMDataSource readsDataSource = null;

    /**
     * Accessor for sharded reference data.
     */
    private ReferenceDataSource referenceDataSource = null;

    /**
     * Accessor for sample metadata
     */
    private SampleDB sampleDB = null;

    /**
     * Accessor for sharded reference-ordered data.
     */
    private List<ReferenceOrderedDataSource> rodDataSources;

    // our argument collection
    private GATKArgumentCollection argCollection;

    /**
     * Collection of intervals used by the engine.
     */
    private GenomeLocSortedSet intervals = null;

    /**
     * Explicitly assign the interval set to use for this traversal (for unit testing purposes)
     * @param intervals set of intervals to use for this traversal
     */
    public void setIntervals( GenomeLocSortedSet intervals ) {
        this.intervals = intervals;
    }

    /**
     * Collection of inputs used by the engine.
     */
    private Map<ArgumentSource, Object> inputs = new HashMap<ArgumentSource, Object>();

    /**
     * Collection of outputs used by the engine.
     */
    private Collection<Stub<?>> outputs = new ArrayList<Stub<?>>();

    /**
     * Collection of the filters applied to the input data.
     */
    private Collection<ReadFilter> filters;

    /**
     * Collection of the read transformers applied to the reads
     */
    private List<ReadTransformer> readTransformers;

    /**
     * Controls the allocation of threads between CPU vs IO.
     */
    private ThreadAllocation threadAllocation;

    private ReadMetrics cumulativeMetrics = null;

    /**
     * A currently hacky unique name for this GATK instance
     */
    private String myName = "GATK_" + Math.abs(getRandomGenerator().nextInt());

    /**
     * our walker manager
     */
    private final WalkerManager walkerManager = new WalkerManager();

    private Walker<?, ?> walker;

    public void setWalker(Walker<?, ?> walker) {
        this.walker = walker;
    }

    /**
     * A processed collection of SAM reader identifiers.
     */
    private Collection<SAMReaderID> samReaderIDs = Collections.emptyList();

    /**
     * Set the SAM/BAM files over which to traverse.
     * @param samReaderIDs Collection of ids to use during this traversal.
     */
    public void setSAMFileIDs(Collection<SAMReaderID> samReaderIDs) {
        this.samReaderIDs = samReaderIDs;
    }

    /**
     * Collection of reference metadata files over which to traverse.
     */
    private Collection<RMDTriplet> referenceMetaDataFiles;

    /**
     * The threading efficiency monitor we use in the GATK to monitor our efficiency.
     *
     * May be null if one isn't active, or hasn't be initialized yet
     */
    private ThreadEfficiencyMonitor threadEfficiencyMonitor = null;

    /**
     * Set the reference metadata files to use for this traversal.
     * @param referenceMetaDataFiles Collection of files and descriptors over which to traverse.
     */
    public void setReferenceMetaDataFiles(Collection<RMDTriplet> referenceMetaDataFiles) {
        this.referenceMetaDataFiles = referenceMetaDataFiles;
    }

    /**
     *  Static random number generator and seed.
     */
    private static final long GATK_RANDOM_SEED = 47382911L;
    private static Random randomGenerator = new Random(GATK_RANDOM_SEED);
    public static Random getRandomGenerator() { return randomGenerator; }
    public static void resetRandomGenerator() { randomGenerator.setSeed(GATK_RANDOM_SEED); }
    public static void resetRandomGenerator(long seed) { randomGenerator.setSeed(seed); }

    /**
     *  Base Quality Score Recalibration helper object
     */
    private BaseRecalibration baseRecalibration = null;
    public BaseRecalibration getBaseRecalibration() { return baseRecalibration; }
    public boolean hasBaseRecalibration() { return baseRecalibration != null; }
    public void setBaseRecalibration(final File recalFile, final int quantizationLevels, final boolean disableIndelQuals, final int preserveQLessThan, final boolean emitOriginalQuals) {
        baseRecalibration = new BaseRecalibration(recalFile, quantizationLevels, disableIndelQuals, preserveQLessThan, emitOriginalQuals);
    }

    /**
     * Utility method to determine whether this is the lite version of the GATK
     */
    public boolean isGATKLite() {
        return GATKLiteUtils.isGATKLite();
    }

    /**
     * Actually run the GATK with the specified walker.
     *
     * @return the value of this traversal.
     */
    public Object execute() {
        //HeapSizeMonitor monitor = new HeapSizeMonitor();
        //monitor.start();
        setStartTime(new java.util.Date());

        final GATKArgumentCollection args = this.getArguments();

        // validate our parameters
        if (args == null) {
            throw new ReviewedStingException("The GATKArgumentCollection passed to GenomeAnalysisEngine can not be null.");
        }

        // validate our parameters              
        if (this.walker == null)
            throw new ReviewedStingException("The walker passed to GenomeAnalysisEngine can not be null.");

        if (args.nonDeterministicRandomSeed)
            resetRandomGenerator(System.currentTimeMillis());

        // if the use specified an input BQSR recalibration table then enable on the fly recalibration
        if (args.BQSR_RECAL_FILE != null)
            setBaseRecalibration(args.BQSR_RECAL_FILE, args.quantizationLevels, args.disableIndelQuals, args.PRESERVE_QSCORES_LESS_THAN, args.emitOriginalQuals);

        // Determine how the threads should be divided between CPU vs. IO.
        determineThreadAllocation();

        // Prepare the data for traversal.
        initializeDataSources();

        // initialize sampleDB
        initializeSampleDB();

        // initialize and validate the interval list
        initializeIntervals();
        validateSuppliedIntervals();

        // our microscheduler, which is in charge of running everything
        MicroScheduler microScheduler = createMicroscheduler();
        threadEfficiencyMonitor = microScheduler.getThreadEfficiencyMonitor();

        // create temp directories as necessary
        initializeTempDirectory();

        // create the output streams
        initializeOutputStreams(microScheduler.getOutputTracker());

        Iterable<Shard> shardStrategy = getShardStrategy(readsDataSource,microScheduler.getReference(),intervals);

        // execute the microscheduler, storing the results
        return microScheduler.execute(this.walker, shardStrategy);

        //monitor.stop();
        //logger.info(String.format("Maximum heap size consumed: %d",monitor.getMaxMemoryUsed()));

        //return result;
    }

    // TODO -- Let's move this to a utility class in unstable - but which one?
    // **************************************************************************************
    // *                            Handle Deprecated Walkers                               *
    // **************************************************************************************

    // Mapping from walker name to major version number where the walker first disappeared
    private static Map<String, String> deprecatedGATKWalkers = new HashMap<String, String>();
    static {
        deprecatedGATKWalkers.put("CountCovariates", "2.0");
        deprecatedGATKWalkers.put("TableRecalibration", "2.0");
        deprecatedGATKWalkers.put("AlignmentWalker", "2.2");
        deprecatedGATKWalkers.put("CountBestAlignments", "2.2");
    }

    /**
     * Utility method to check whether a given walker has been deprecated in a previous GATK release
     *
     * @param walkerName   the walker class name (not the full package) to check
     */
    public static boolean isDeprecatedWalker(final String walkerName) {
        return deprecatedGATKWalkers.containsKey(walkerName);
    }

    /**
     * Utility method to check whether a given walker has been deprecated in a previous GATK release
     *
     * @param walkerName   the walker class name (not the full package) to check
     */
    public static String getDeprecatedMajorVersionNumber(final String walkerName) {
        return deprecatedGATKWalkers.get(walkerName);
    }

    // **************************************************************************************

    /**
     * Retrieves an instance of the walker based on the walker name.
     *
     * @param walkerName Name of the walker.  Must not be null.  If the walker cannot be instantiated, an exception will be thrown.
     * @return An instance of the walker.
     */
    public Walker<?, ?> getWalkerByName(String walkerName) {
        try {
            return walkerManager.createByName(walkerName);
        } catch ( UserException e ) {
            if ( isGATKLite() && GATKLiteUtils.isAvailableOnlyInFullGATK(walkerName) ) {
                e = new UserException.NotSupportedInGATKLite("the " + walkerName + " walker is available only in the full version of the GATK");
            }
            else if ( isDeprecatedWalker(walkerName) ) {
                e = new UserException.DeprecatedWalker(walkerName, getDeprecatedMajorVersionNumber(walkerName));
            }
            throw e;
        }
    }

    /**
     * Gets the name of a given walker type.
     * @param walkerType Type of walker.
     * @return Name of the walker.
     */
    public String getWalkerName(Class<? extends Walker> walkerType) {
        return walkerManager.getName(walkerType);
    }

    public String getName() {
        return myName;
    }

    /**
     * Gets a list of the filters to associate with the given walker.  Will NOT initialize the engine with this filters;
     * the caller must handle that directly.
     * @return A collection of available filters.
     */
    public Collection<ReadFilter> createFilters() {
        final List<ReadFilter> filters = WalkerManager.getReadFilters(walker,this.getFilterManager());
        if (this.getArguments().readGroupBlackList != null && this.getArguments().readGroupBlackList.size() > 0)
            filters.add(new ReadGroupBlackListFilter(this.getArguments().readGroupBlackList));
        for(final String filterName: this.getArguments().readFilters)
            filters.add(this.getFilterManager().createByName(filterName));
        return Collections.unmodifiableList(filters);
    }

    /**
     * Returns a list of active, initialized read transformers
     *
     * @param walker the walker we need to apply read transformers too
     * @return a non-null list of read transformers
     */
    public void initializeReadTransformers(final Walker walker) {
        final List<ReadTransformer> activeTransformers = new ArrayList<ReadTransformer>();

        final ReadTransformersMode overrideMode = WalkerManager.getWalkerAnnotation(walker, ReadTransformersMode.class);
        final ReadTransformer.ApplicationTime overrideTime = overrideMode != null ? overrideMode.ApplicationTime() : null;

        final PluginManager<ReadTransformer> pluginManager = new PluginManager<ReadTransformer>(ReadTransformer.class);

        for ( final ReadTransformer transformer : pluginManager.createAllTypes() ) {
            transformer.initialize(overrideTime, this, walker);
            if ( transformer.enabled() )
                activeTransformers.add(transformer);
        }

        setReadTransformers(activeTransformers);
    }

    public List<ReadTransformer> getReadTransformers() {
        return readTransformers;
    }

    private void setReadTransformers(final List<ReadTransformer> readTransformers) {
        if ( readTransformers == null )
            throw new ReviewedStingException("read transformers cannot be null");
        this.readTransformers = readTransformers;
    }

    /**
     * Parse out the thread allocation from the given command-line argument.
     */
    private void determineThreadAllocation() {
        if ( argCollection.numberOfDataThreads < 1 ) throw new UserException.BadArgumentValue("num_threads", "cannot be less than 1, but saw " + argCollection.numberOfDataThreads);
        if ( argCollection.numberOfCPUThreadsPerDataThread < 1 ) throw new UserException.BadArgumentValue("num_cpu_threads", "cannot be less than 1, but saw " + argCollection.numberOfCPUThreadsPerDataThread);
        if ( argCollection.numberOfIOThreads < 0 ) throw new UserException.BadArgumentValue("num_io_threads", "cannot be less than 0, but saw " + argCollection.numberOfIOThreads);

        this.threadAllocation = new ThreadAllocation(argCollection.numberOfDataThreads,
                argCollection.numberOfCPUThreadsPerDataThread,
                argCollection.numberOfIOThreads,
                argCollection.monitorThreadEfficiency);
    }

    public int getTotalNumberOfThreads() {
        return this.threadAllocation == null ? 1 : threadAllocation.getTotalNumThreads();
    }



    /**
     * Allow subclasses and others within this package direct access to the walker manager.
     * @return The walker manager used by this package.
     */
    protected WalkerManager getWalkerManager() {
        return walkerManager;
    }
    
    /**
     * setup a microscheduler
     *
     * @return a new microscheduler
     */
    private MicroScheduler createMicroscheduler() {
        // Temporarily require all walkers to have a reference, even if that reference is not conceptually necessary.
        if ((walker instanceof ReadWalker || walker instanceof DuplicateWalker || walker instanceof ReadPairWalker) &&
                this.getArguments().referenceFile == null) {
            throw new UserException.CommandLineException("Read-based traversals require a reference file but none was given");
        }

        return MicroScheduler.create(this,walker,this.getReadsDataSource(),this.getReferenceDataSource().getReference(),this.getRodDataSources(),threadAllocation);
    }

    protected DownsamplingMethod getDownsamplingMethod() {
        GATKArgumentCollection argCollection = this.getArguments();

        // Legacy downsampler can only be selected via the command line, not via walker annotations
        boolean useLegacyDownsampler = argCollection.useLegacyDownsampler;

        DownsamplingMethod commandLineMethod = argCollection.getDownsamplingMethod();
        DownsamplingMethod walkerMethod = WalkerManager.getDownsamplingMethod(walker, useLegacyDownsampler);
        DownsamplingMethod defaultMethod = DownsamplingMethod.getDefaultDownsamplingMethod(walker, useLegacyDownsampler);

        DownsamplingMethod method = commandLineMethod != null ? commandLineMethod : (walkerMethod != null ? walkerMethod : defaultMethod);
        method.checkCompatibilityWithWalker(walker);
        return method;
    }

    protected void setDownsamplingMethod(DownsamplingMethod method) {
        argCollection.setDownsamplingMethod(method);
    }

    protected boolean includeReadsWithDeletionAtLoci() {
        return walker.includeReadsWithDeletionAtLoci();
    }

    /**
     * Verifies that the supplied set of reads files mesh with what the walker says it requires,
     * and also makes sure that there were no duplicate SAM files specified on the command line.
     */
    protected void validateSuppliedReads() {
        GATKArgumentCollection arguments = this.getArguments();
        // Check what the walker says is required against what was provided on the command line.
        if (WalkerManager.isRequired(walker, DataSource.READS) && (arguments.samFiles == null || arguments.samFiles.size() == 0))
            throw new ArgumentException("Walker requires reads but none were provided.");

        // Check what the walker says is allowed against what was provided on the command line.
        if ((arguments.samFiles != null && arguments.samFiles.size() > 0) && !WalkerManager.isAllowed(walker, DataSource.READS))
            throw new ArgumentException("Walker does not allow reads but reads were provided.");

        // Make sure no SAM files were specified multiple times by the user.
        checkForDuplicateSamFiles();
    }

    /**
     * Checks whether there are SAM files that appear multiple times in the fully unpacked list of
     * SAM files (samReaderIDs). If there are, throws an ArgumentException listing the files in question.
     */
    protected void checkForDuplicateSamFiles() {
        Set<SAMReaderID> encounteredSamFiles = new HashSet<SAMReaderID>();
        Set<String> duplicateSamFiles = new LinkedHashSet<String>();

        for ( SAMReaderID samFile : samReaderIDs ) {
            if ( encounteredSamFiles.contains(samFile) ) {
                duplicateSamFiles.add(samFile.getSamFilePath());
            }
            else {
                encounteredSamFiles.add(samFile);
            }
        }

        if ( duplicateSamFiles.size() > 0 ) {
            throw new ArgumentException("The following BAM files appear multiple times in the list of input files: " +
                                        duplicateSamFiles + " BAM files may be specified at most once.");
        }
    }

    /**
     * Verifies that the supplied reference file mesh with what the walker says it requires.
     */
    protected void validateSuppliedReference() {
        GATKArgumentCollection arguments = this.getArguments();
        // Check what the walker says is required against what was provided on the command line.
        // TODO: Temporarily disabling WalkerManager.isRequired check on the reference because the reference is always required.
        if (/*WalkerManager.isRequired(walker, DataSource.REFERENCE) &&*/ arguments.referenceFile == null)
            throw new ArgumentException("Walker requires a reference but none was provided.");

        // Check what the walker says is allowed against what was provided on the command line.
        if (arguments.referenceFile != null && !WalkerManager.isAllowed(walker, DataSource.REFERENCE))
            throw new ArgumentException("Walker does not allow a reference but one was provided.");
    }

    protected void validateSuppliedIntervals() {
        // Only read walkers support '-L unmapped' intervals.  Trap and validate any other instances of -L unmapped.
        if(!(walker instanceof ReadWalker)) {
            GenomeLocSortedSet intervals = getIntervals();
            if(intervals != null && getIntervals().contains(GenomeLoc.UNMAPPED))
                throw new ArgumentException("Interval list specifies unmapped region.  Only read walkers may include the unmapped region.");
        }

        // If intervals is non-null and empty at this point, it means that the list of intervals to process
        // was filtered down to an empty set (eg., the user specified something like -L chr1 -XL chr1). Since
        // this was very likely unintentional, the user should be informed of this. Note that this is different
        // from the case where intervals == null, which indicates that there were no interval arguments.
        if ( intervals != null && intervals.isEmpty() ) {
            logger.warn("The given combination of -L and -XL options results in an empty set.  No intervals to process.");
        }
    }

    /**
     * Get the sharding strategy given a driving data source.
     *
     * @param readsDataSource readsDataSource
     * @param drivingDataSource Data on which to shard.
     * @param intervals intervals
     * @return the sharding strategy
     */
    protected Iterable<Shard> getShardStrategy(SAMDataSource readsDataSource, ReferenceSequenceFile drivingDataSource, GenomeLocSortedSet intervals) {
        ValidationExclusion exclusions = (readsDataSource != null ? readsDataSource.getReadsInfo().getValidationExclusionList() : null);
        DownsamplingMethod downsamplingMethod = readsDataSource != null ? readsDataSource.getReadsInfo().getDownsamplingMethod() : null;
        ReferenceDataSource referenceDataSource = this.getReferenceDataSource();

        // If reads are present, assume that accessing the reads is always the dominant factor and shard based on that supposition.
        if(!readsDataSource.isEmpty()) {
            if(!readsDataSource.hasIndex() && !exclusions.contains(ValidationExclusion.TYPE.ALLOW_UNINDEXED_BAM))
                throw new UserException.CommandLineException("Cannot process the provided BAM file(s) because they were not indexed.  The GATK does offer limited processing of unindexed BAMs in --unsafe mode, but this GATK feature is currently unsupported.");
            if(!readsDataSource.hasIndex() && intervals != null && !argCollection.allowIntervalsWithUnindexedBAM)
                throw new UserException.CommandLineException("Cannot perform interval processing when reads are present but no index is available.");

            if(walker instanceof LocusWalker) {
                if (readsDataSource.getSortOrder() != SAMFileHeader.SortOrder.coordinate)
                    throw new UserException.MissortedBAM(SAMFileHeader.SortOrder.coordinate, "Locus walkers can only traverse coordinate-sorted data.  Please resort your input BAM file(s) or set the Sort Order tag in the header appropriately.");
                if(intervals == null)
                    return readsDataSource.createShardIteratorOverMappedReads(referenceDataSource.getReference().getSequenceDictionary(),new LocusShardBalancer());
                else
                    return readsDataSource.createShardIteratorOverIntervals(intervals,new LocusShardBalancer());
            } 
            else if(walker instanceof ActiveRegionWalker) {
                if (readsDataSource.getSortOrder() != SAMFileHeader.SortOrder.coordinate)
                    throw new UserException.MissortedBAM(SAMFileHeader.SortOrder.coordinate, "Active region walkers can only traverse coordinate-sorted data.  Please resort your input BAM file(s) or set the Sort Order tag in the header appropriately.");

                switch(argCollection.activeRegionShardType) {
                    case LOCUSSHARD:
                        if(intervals == null)
                            return readsDataSource.createShardIteratorOverMappedReads(referenceDataSource.getReference().getSequenceDictionary(),new LocusShardBalancer());
                        else
                            return readsDataSource.createShardIteratorOverIntervals(((ActiveRegionWalker)walker).extendIntervals(intervals, this.genomeLocParser, this.getReferenceDataSource().getReference()), new LocusShardBalancer());
                    case READSHARD:
                        // Use the legacy ReadShardBalancer if legacy downsampling is enabled
                        ShardBalancer readShardBalancer = downsamplingMethod != null && downsamplingMethod.useLegacyDownsampler ?
                                new LegacyReadShardBalancer() :
                                new ReadShardBalancer();

                        if(intervals == null)
                            return readsDataSource.createShardIteratorOverMappedReads(referenceDataSource.getReference().getSequenceDictionary(), readShardBalancer);
                        else
                            return readsDataSource.createShardIteratorOverIntervals(((ActiveRegionWalker)walker).extendIntervals(intervals, this.genomeLocParser, this.getReferenceDataSource().getReference()), readShardBalancer);
                    case ACTIVEREGIONSHARD:
                        if(intervals == null)
                            return readsDataSource.createShardIteratorOverMappedReads(referenceDataSource.getReference().getSequenceDictionary(),new ActiveRegionShardBalancer());
                        else
                            return readsDataSource.createShardIteratorOverIntervals(((ActiveRegionWalker)walker).extendIntervals(intervals, this.genomeLocParser, this.getReferenceDataSource().getReference()), new ActiveRegionShardBalancer());
                    default:
                        throw new UserException.CommandLineException("Invalid active region shard type.");
                }
            }
            else if(walker instanceof ReadWalker || walker instanceof ReadPairWalker || walker instanceof DuplicateWalker) {
                // Apply special validation to read pair walkers.
                if(walker instanceof ReadPairWalker) {
                    if(readsDataSource.getSortOrder() != SAMFileHeader.SortOrder.queryname)
                        throw new UserException.MissortedBAM(SAMFileHeader.SortOrder.queryname, "Read pair walkers are exceptions in that they cannot be run on coordinate-sorted BAMs but instead require query name-sorted files.  You will need to resort your input BAM file in query name order to use this walker.");
                    if(intervals != null && !intervals.isEmpty())
                        throw new UserException.CommandLineException("Pairs traversal cannot be used in conjunction with intervals.");
                }

                // Use the legacy ReadShardBalancer if legacy downsampling is enabled
                ShardBalancer readShardBalancer = downsamplingMethod != null && downsamplingMethod.useLegacyDownsampler ?
                                                  new LegacyReadShardBalancer() :
                                                  new ReadShardBalancer();

                if(intervals == null)
                    return readsDataSource.createShardIteratorOverAllReads(readShardBalancer);
                else
                    return readsDataSource.createShardIteratorOverIntervals(intervals, readShardBalancer);
            }
            else
                throw new ReviewedStingException("Unable to determine walker type for walker " + walker.getClass().getName());
        }
        else {
            // TODO -- Determine what the ideal shard size should be here.  Matt suggested that a multiple of 16K might work well
            // TODO --  (because of how VCF indexes work), but my empirical experience has been simply that the larger the shard
            // TODO --  size the more efficient the traversal (at least for RODWalkers).  Keeping the previous values for now.  [EB]
            final int SHARD_SIZE = walker instanceof RodWalker ? 1000000 : 100000;
            if(intervals == null)
                return referenceDataSource.createShardsOverEntireReference(readsDataSource,genomeLocParser,SHARD_SIZE);
            else
                return referenceDataSource.createShardsOverIntervals(readsDataSource,intervals,SHARD_SIZE);
        }
    }

    protected boolean flashbackData() {
        return walker instanceof ReadWalker;
    }

    /**
     * Create the temp directory if it doesn't exist.
     */
    private void initializeTempDirectory() {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        if (!tempDir.exists() && !tempDir.mkdirs())
            throw new UserException.BadTmpDir("Unable to create directory");
    }

    /**
     * Initialize the output streams as specified by the user.
     *
     * @param outputTracker the tracker supplying the initialization data.
     */
    private void initializeOutputStreams(OutputTracker outputTracker) {
        for (Map.Entry<ArgumentSource, Object> input : getInputs().entrySet())
            outputTracker.addInput(input.getKey(), input.getValue());
        for (Stub<?> stub : getOutputs())
            outputTracker.addOutput(stub);

        outputTracker.prepareWalker(walker, getArguments().strictnessLevel);
    }

    public ReferenceDataSource getReferenceDataSource() {
        return referenceDataSource;
    }

    public GenomeLocParser getGenomeLocParser() {
        return genomeLocParser;
    }

    /**
     * Manage lists of filters.
     */
    private final FilterManager filterManager = new FilterManager();

    private Date startTime = null; // the start time for execution

    public void setParser(ParsingEngine parsingEngine) {
        this.parsingEngine = parsingEngine;
    }

    /**
     * Explicitly set the GenomeLocParser, for unit testing.
     * @param genomeLocParser GenomeLocParser to use.
     */
    public void setGenomeLocParser(GenomeLocParser genomeLocParser) {
        this.genomeLocParser = genomeLocParser;
    }

    /**
     * Sets the start time when the execute() function was last called
     * @param startTime the start time when the execute() function was last called
     */
    protected void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the start time when the execute() function was last called
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Setup the intervals to be processed
     */
    protected void initializeIntervals() {
        // return if no interval arguments at all
        if ( argCollection.intervals == null && argCollection.excludeIntervals == null )
            return;

        // Note that the use of '-L all' is no longer supported.

        // if include argument isn't given, create new set of all possible intervals

        final Pair<GenomeLocSortedSet, GenomeLocSortedSet> includeExcludePair = IntervalUtils.parseIntervalBindingsPair(
                this.referenceDataSource,
                argCollection.intervals,
                argCollection.intervalSetRule, argCollection.intervalMerging, argCollection.intervalPadding,
                argCollection.excludeIntervals);

        final GenomeLocSortedSet includeSortedSet = includeExcludePair.getFirst();
        final GenomeLocSortedSet excludeSortedSet = includeExcludePair.getSecond();

        // if no exclude arguments, can return parseIntervalArguments directly
        if ( excludeSortedSet == null )
            intervals = includeSortedSet;

        // otherwise there are exclude arguments => must merge include and exclude GenomeLocSortedSets
        else {
            intervals = includeSortedSet.subtractRegions(excludeSortedSet);

            // logging messages only printed when exclude (-XL) arguments are given
            final long toPruneSize = includeSortedSet.coveredSize();
            final long toExcludeSize = excludeSortedSet.coveredSize();
            final long intervalSize = intervals.coveredSize();
            logger.info(String.format("Initial include intervals span %d loci; exclude intervals span %d loci", toPruneSize, toExcludeSize));
            logger.info(String.format("Excluding %d loci from original intervals (%.2f%% reduction)",
                    toPruneSize - intervalSize, (toPruneSize - intervalSize) / (0.01 * toPruneSize)));
        }

        logger.info(String.format("Processing %d bp from intervals", intervals.coveredSize()));
    }

    /**
     * Add additional, externally managed IO streams for inputs.
     *
     * @param argumentSource Field into which to inject the value.
     * @param value          Instance to inject.
     */
    public void addInput(ArgumentSource argumentSource, Object value) {
        inputs.put(argumentSource, value);
    }

    /**
     * Add additional, externally managed IO streams for output.
     *
     * @param stub Instance to inject.
     */
    public void addOutput(Stub<?> stub) {
        outputs.add(stub);
    }

    /**
     * Returns the tag associated with a given command-line argument.
     * @param key Object for which to inspect the tag.
     * @return Tags object associated with the given key, or an empty Tag structure if none are present. 
     */
    public Tags getTags(Object key)  {
        return parsingEngine.getTags(key);
    }

    protected void initializeDataSources() {
        logger.info("Strictness is " + argCollection.strictnessLevel);

        validateSuppliedReference();
        setReferenceDataSource(argCollection.referenceFile);

        validateSuppliedReads();
        initializeReadTransformers(walker);

        readsDataSource = createReadsDataSource(argCollection,genomeLocParser,referenceDataSource.getReference());

        for (ReadFilter filter : filters)
            filter.initialize(this);

        // set the sequence dictionary of all of Tribble tracks to the sequence dictionary of our reference
        rodDataSources = getReferenceOrderedDataSources(referenceMetaDataFiles,referenceDataSource.getReference().getSequenceDictionary(),genomeLocParser,argCollection.unsafe);
    }

    /**
     * Entry-point function to initialize the samples database from input data and pedigree arguments
     */
    private void initializeSampleDB() {
        SampleDBBuilder sampleDBBuilder = new SampleDBBuilder(this, argCollection.pedigreeValidationType);
        sampleDBBuilder.addSamplesFromSAMHeader(getSAMFileHeader());
        sampleDBBuilder.addSamplesFromSampleNames(SampleUtils.getUniqueSamplesFromRods(this));
        sampleDBBuilder.addSamplesFromPedigreeFiles(argCollection.pedigreeFiles);
        sampleDBBuilder.addSamplesFromPedigreeStrings(argCollection.pedigreeStrings);
        sampleDB = sampleDBBuilder.getFinalSampleDB();
    }

    /**
     * Gets a unique identifier for the reader sourcing this read.
     * @param read Read to examine.
     * @return A unique identifier for the source file of this read.  Exception if not found.
     */
    public SAMReaderID getReaderIDForRead(final SAMRecord read) {
        return getReadsDataSource().getReaderID(read);
    }

    /**
     * Gets the source file for this read.
     * @param id Unique identifier determining which input file to use.
     * @return The source filename for this read.
     */
    public File getSourceFileForReaderID(final SAMReaderID id) {
        return getReadsDataSource().getSAMFile(id);
    }

    /**
     * Now that all files are open, validate the sequence dictionaries of the reads vs. the reference vrs the reference ordered data (if available).
     *
     * @param reads     Reads data source.
     * @param reference Reference data source.
     * @param rods    a collection of the reference ordered data tracks
     * @param manager manager
     */
    private void validateSourcesAgainstReference(SAMDataSource reads, ReferenceSequenceFile reference, Collection<ReferenceOrderedDataSource> rods, RMDTrackBuilder manager) {
        if ((reads.isEmpty() && (rods == null || rods.isEmpty())) || reference == null )
            return;

        // Compile a set of sequence names that exist in the reference file.
        SAMSequenceDictionary referenceDictionary = reference.getSequenceDictionary();

        if (!reads.isEmpty()) {
            // Compile a set of sequence names that exist in the BAM files.
            SAMSequenceDictionary readsDictionary = reads.getHeader().getSequenceDictionary();

            if (readsDictionary.size() == 0) {
                logger.info("Reads file is unmapped.  Skipping validation against reference.");
                return;
            }

            // compare the reads to the reference
            SequenceDictionaryUtils.validateDictionaries(logger, getArguments().unsafe, "reads", readsDictionary, "reference", referenceDictionary);
        }

        for (ReferenceOrderedDataSource rod : rods)
            manager.validateTrackSequenceDictionary(rod.getName(),rod.getSequenceDictionary(),referenceDictionary);
    }

    /**
     * Gets a data source for the given set of reads.
     *
     * @param argCollection arguments
     * @param genomeLocParser parser
     * @param refReader reader
     * @return A data source for the given set of reads.
     */
    private SAMDataSource createReadsDataSource(GATKArgumentCollection argCollection, GenomeLocParser genomeLocParser, IndexedFastaSequenceFile refReader) {
        DownsamplingMethod downsamplingMethod = getDownsamplingMethod();

        // Synchronize the method back into the collection so that it shows up when
        // interrogating for the downsample method during command line recreation.
        setDownsamplingMethod(downsamplingMethod);

        logger.info(downsamplingMethod);

        if (argCollection.removeProgramRecords && argCollection.keepProgramRecords)
            throw new UserException.BadArgumentValue("rpr / kpr", "Cannot enable both options");

        boolean removeProgramRecords = argCollection.removeProgramRecords || walker.getClass().isAnnotationPresent(RemoveProgramRecords.class);

        if (argCollection.keepProgramRecords)
            removeProgramRecords = false;

        return new SAMDataSource(
                samReaderIDs,
                threadAllocation,
                argCollection.numberOfBAMFileHandles,
                genomeLocParser,
                argCollection.useOriginalBaseQualities,
                argCollection.strictnessLevel,
                argCollection.readBufferSize,
                downsamplingMethod,
                new ValidationExclusion(Arrays.asList(argCollection.unsafe)),
                filters,
                readTransformers,
                includeReadsWithDeletionAtLoci(),
                argCollection.defaultBaseQualities,
                removeProgramRecords);
    }

    /**
     * Opens a reference sequence file paired with an index.  Only public for testing purposes
     *
     * @param refFile Handle to a reference sequence file.  Non-null.
     */
    public void setReferenceDataSource(File refFile) {
        this.referenceDataSource = new ReferenceDataSource(refFile);
        genomeLocParser = new GenomeLocParser(referenceDataSource.getReference());
    }

    /**
     * Open the reference-ordered data sources.
     *
     * @param referenceMetaDataFiles collection of RMD descriptors to load and validate.
     * @param sequenceDictionary GATK-wide sequnce dictionary to use for validation.
     * @param genomeLocParser to use when creating and validating GenomeLocs.
     * @param validationExclusionType potentially indicate which validations to include / exclude.
     *
     * @return A list of reference-ordered data sources.
     */
    private List<ReferenceOrderedDataSource> getReferenceOrderedDataSources(Collection<RMDTriplet> referenceMetaDataFiles,
                                                                            SAMSequenceDictionary sequenceDictionary,
                                                                            GenomeLocParser genomeLocParser,
                                                                            ValidationExclusion.TYPE validationExclusionType) {
        final RMDTrackBuilder builder = new RMDTrackBuilder(sequenceDictionary,genomeLocParser, validationExclusionType);

        final List<ReferenceOrderedDataSource> dataSources = new ArrayList<ReferenceOrderedDataSource>();
        for (RMDTriplet fileDescriptor : referenceMetaDataFiles)
            dataSources.add(new ReferenceOrderedDataSource(fileDescriptor,
                                                           builder,
                                                           sequenceDictionary,
                                                           genomeLocParser,
                                                           flashbackData()));

        // validation: check to make sure everything the walker needs is present, and that all sequence dictionaries match.
        validateSourcesAgainstReference(readsDataSource, referenceDataSource.getReference(), dataSources, builder);

        return dataSources;
    }

    /**
     * Returns the SAM File Header from the input reads' data source file
     * @return the SAM File Header from the input reads' data source file
     */
    public SAMFileHeader getSAMFileHeader() {
        return readsDataSource.getHeader();
    }

    public boolean lenientVCFProcessing() {
        return lenientVCFProcessing(argCollection.unsafe);
    }

    public static boolean lenientVCFProcessing(final ValidationExclusion.TYPE val) {
        return val == ValidationExclusion.TYPE.ALL
                || val == ValidationExclusion.TYPE.LENIENT_VCF_PROCESSING;
    }

    /**
     * Returns the unmerged SAM file header for an individual reader.
     * @param reader The reader.
     * @return Header for that reader.
     */
    public SAMFileHeader getSAMFileHeader(SAMReaderID reader) {
        return readsDataSource.getHeader(reader);
    }

    /**
     * Returns an ordered list of the unmerged SAM file headers known to this engine.
     * @return list of header for each input SAM file, in command line order
     */
    public List<SAMFileHeader> getSAMFileHeaders() {
        final List<SAMFileHeader> headers = new ArrayList<SAMFileHeader>();
        for ( final SAMReaderID id : getReadsDataSource().getReaderIDs() ) {
            headers.add(getReadsDataSource().getHeader(id));
        }
        return headers;
    }

    /**
     * Gets the master sequence dictionary for this GATK engine instance
     * @return a never-null dictionary listing all of the contigs known to this engine instance
     */
    public SAMSequenceDictionary getMasterSequenceDictionary() {
        return getReferenceDataSource().getReference().getSequenceDictionary();
    }

    /**
     * Returns data source object encapsulating all essential info and handlers used to traverse
     * reads; header merger, individual file readers etc can be accessed through the returned data source object.
     *
     * @return the reads data source
     */
    public SAMDataSource getReadsDataSource() {
        return this.readsDataSource;
    }

    /**
     * Sets the collection of GATK main application arguments.
     *
     * @param argCollection the GATK argument collection
     */
    public void setArguments(GATKArgumentCollection argCollection) {
        this.argCollection = argCollection;
    }

    /**
     * Gets the collection of GATK main application arguments.
     *
     * @return the GATK argument collection
     */
    public GATKArgumentCollection getArguments() {
        return this.argCollection;
    }

    /**
     * Get the list of intervals passed to the engine.
     * @return List of intervals, or null if no intervals are in use
     */
    public GenomeLocSortedSet getIntervals() {
        return this.intervals;
    }

    /**
     * Get the list of regions of the genome being processed.  If the user
     * requested specific intervals, return those, otherwise return regions
     * corresponding to the entire genome.  Never returns null.
     *
     * @return a non-null set of intervals being processed
     */
    @Ensures("result != null")
    public GenomeLocSortedSet getRegionsOfGenomeBeingProcessed() {
        if ( getIntervals() == null )
            // if we don't have any intervals defined, create intervals from the reference itself
            return GenomeLocSortedSet.createSetFromSequenceDictionary(getReferenceDataSource().getReference().getSequenceDictionary());
        else
            return getIntervals();
    }

    /**
     * Gets the list of filters employed by this engine.
     * @return Collection of filters (actual instances) used by this engine.
     */
    public Collection<ReadFilter> getFilters() {
        return this.filters;
    }

    /**
     * Sets the list of filters employed by this engine.
     * @param filters Collection of filters (actual instances) used by this engine.
     */
    public void setFilters(Collection<ReadFilter> filters) {
        this.filters = filters;
    }

    /**
     * Gets the filter manager for this engine.
     * @return filter manager for this engine.
     */
    protected FilterManager getFilterManager() {
        return filterManager;
    }

    /**
     * Gets the input sources for this engine.
     * @return input sources for this engine.
     */
    protected Map<ArgumentSource, Object> getInputs() {
        return inputs;
    }

    /**
     * Gets the output stubs for this engine.
     * @return output stubs for this engine.
     */
    protected Collection<Stub<?>> getOutputs() {
        return outputs;
    }

    /**
     * Returns data source objects encapsulating all rod data;
     * individual rods can be accessed through the returned data source objects.
     *
     * @return the rods data sources
     */
    public List<ReferenceOrderedDataSource> getRodDataSources() {
        return this.rodDataSources;
    }

    /**
     * Gets cumulative metrics about the entire run to this point.
     * Returns a clone of this snapshot in time.
     * @return cumulative metrics about the entire run at this point.  ReadMetrics object is a unique instance and is
     *         owned by the caller; the caller can do with the object what they wish.
     */
    public ReadMetrics getCumulativeMetrics() {
        // todo -- probably shouldn't be lazy
        if ( cumulativeMetrics == null )
            cumulativeMetrics = readsDataSource == null ? new ReadMetrics() : readsDataSource.getCumulativeReadMetrics();
        return cumulativeMetrics;
    }

    /**
     * Return the global ThreadEfficiencyMonitor, if there is one
     *
     * @return the monitor, or null if none is active
     */
    public ThreadEfficiencyMonitor getThreadEfficiencyMonitor() {
        return threadEfficiencyMonitor;
    }

    // -------------------------------------------------------------------------------------
    //
    // code for working with Samples database
    //
    // -------------------------------------------------------------------------------------

    public SampleDB getSampleDB() {
        return this.sampleDB;
    }

    public Map<String,String> getApproximateCommandLineArguments(Object... argumentProviders) {
        return CommandLineUtils.getApproximateCommandLineArguments(parsingEngine,argumentProviders);
    }

    public String createApproximateCommandLineArgumentString(Object... argumentProviders) {
        return CommandLineUtils.createApproximateCommandLineArgumentString(parsingEngine,argumentProviders);
    }

    /**
     * Does the current runtime in unit exceed the runtime limit, if one has been provided?
     *
     * @param runtime the runtime of this GATK instance in minutes
     * @param unit the time unit of runtime
     * @return false if not limit was requested or if runtime <= the limit, true otherwise
     */
    public boolean exceedsRuntimeLimit(final long runtime, final TimeUnit unit) {
        if ( runtime < 0 ) throw new IllegalArgumentException("runtime must be >= 0 but got " + runtime);

        if ( getArguments().maxRuntime == NO_RUNTIME_LIMIT )
            return false;
        else {
            final long actualRuntimeNano = TimeUnit.NANOSECONDS.convert(runtime, unit);
            final long maxRuntimeNano = getRuntimeLimitInNanoseconds();
            return actualRuntimeNano > maxRuntimeNano;
        }
    }

    /**
     * @return the runtime limit in nanoseconds, or -1 if no limit was specified
     */
    public long getRuntimeLimitInNanoseconds() {
        if ( getArguments().maxRuntime == NO_RUNTIME_LIMIT )
            return -1;
        else
            return TimeUnit.NANOSECONDS.convert(getArguments().maxRuntime, getArguments().maxRuntimeUnits);
    }
}