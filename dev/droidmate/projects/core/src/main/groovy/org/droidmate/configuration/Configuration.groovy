// DroidMate, an automated execution generator for Android apps.
// Copyright (C) 2012-2016 Konrad Jamrozik
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
// email: jamrozik@st.cs.uni-saarland.de
// web: www.droidmate.org
package org.droidmate.configuration

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import org.droidmate.exceptions.ConfigurationException
import org.droidmate.misc.BuildConstants
import org.droidmate.uiautomator_daemon.UiautomatorDaemonConstants

import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.nio.file.Path

/**
 * <p>
 *
 * This class holds all the configuration data of DroidMate. The configuration is obtained from command line arguments by
 * a call to {@code n ew ConfigurationBuilder().build(args)}. This happens in {@code DroidmateFrontend},
 * just before DroidMate constructs a {@code DroidmateCommand} and thus, its object graph of dependencies.
 *
 * </p><p>
 * This class relies heavily on the {@code jCommander} library, http://jcommander.org
 *
 * </p>
 *
 * @see ConfigurationBuilder
 */
// Explanation of @SuppressWarnings("UnnecessaryQualifiedReference"):
// This is a workaround for https://issues.apache.org/jira/browse/GROOVY-3278, which appears in @Parameter "names" argument declaration.
// Solution adapted from: http://stackoverflow.com/a/29042946/986533
@SuppressWarnings("UnnecessaryQualifiedReference")
@Parameters(separators = " =")
public class Configuration implements IConfiguration
{
  //region Instance construction logic

  /** The raw args (as given to {@code public static void main(String[] args)}) from which this configuration was obtained. */
  private String[] args

  public static Configuration getDefault() throws ConfigurationException
  {
    return getDefault(FileSystems.getDefault())
  }

  public static Configuration getDefault(FileSystem fs) throws ConfigurationException
  {
    return new ConfigurationBuilder().build(new String[0], fs)
  }

  public String[] getArgs()
  {
    return args
  }

  public Configuration(String[] args)
  {
    this.args = args
  }
  //endregion

  //region Cmd line parameters names and defaults
  
  // @formatter:off
  // "pn" stands for "parameter name"
  public static final String pn_actionsLimit                                 = "-actionsLimit"
  public static final String pn_alwaysClickFirstWidget                       = "-alwaysClickFirstWidget"
  public static final String pn_androidApi                                   = "-androidApi"
  public static final String pn_apksNames                                    = "-apksNames"
  public static final String pn_apksDir                                      = "-apksDir"
  public static final String pn_apksLimit                                    = "-apksLimit"
  public static final String pn_checkAppIsRunningRetryAttempts               = "-checkAppIsRunningRetryAttempts"
  public static final String pn_checkAppIsRunningRetryDelay                  = "-checkAppIsRunningRetryDelay"
  public static final String pn_checkDeviceAvailableAfterRebootAttempts      = "-checkDeviceAvailableAfterRebootAttempts"
  public static final String pn_checkDeviceAvailableAfterRebootFirstDelay    = "-checkDeviceAvailableAfterRebootFirstDelay"
  public static final String pn_checkDeviceAvailableAfterRebootLaterDelays   = "-checkDeviceAvailableAfterRebootLaterDelays"
  public static final String pn_clearPackageRetryAttempts                    = "-clearPackageRetryAttempts"
  public static final String pn_clearPackageRetryDelay                       = "-clearPackageRetryDelay"
  public static final String pn_closeANRAttempts                             = "-closeANRAttempts"
  public static final String pn_closeANRDelay                                = "-closeANRDelay"
  public static final String pn_deployRawApks                                = "-deployRawApks"
  public static final String pn_device                                       = "-device"
  public static final String pn_droidmateOutputDir                           = "-droidmateOutputDirPath"
  public static final String pn_exploreInteractively                         = "-exploreInteractively"
  public static final String pn_getValidGuiSnapshotRetryAttempts             = "-getValidGuiSnapshotRetryAttempts"
  public static final String pn_getValidGuiSnapshotRetryDelay                = "-getValidGuiSnapshotRetryDelay"
  public static final String pn_inline                                       = "-inline"
  public static final String pn_launchActivityDelay                          = "-launchActivityDelay"
  public static final String pn_launchActivityTimeout                        = "-launchActivityTimeout"
  public static final String pn_monitorServerStartQueryDelay                 = "-monitorServerStartQueryDelay"
  public static final String pn_monitorServerStartTimeout                    = "-monitorServerStartTimeout"
  public static final String pn_randomSeed                                   = "-randomSeed"
  public static final String pn_reportIncludePlots                           = "-reportIncludePlots"
  public static final String pn_reportInputDir                               = "-reportInputDir"
  public static final String pn_reportOutputDir                              = "-reportOutputDir"
  public static final String pn_resetEveryNthExplorationForward              = "-resetEvery"
  public static final String pn_runOnNotInlined                              = "-runOnNotInlined"
  public static final String pn_socketTimeout                                = "-socketTimeout"
  public static final String pn_timeLimit                                    = "-timeLimit"
  public static final String pn_uiautomatorDaemonServerStartTimeout          = "-uiautomatorDaemonServerStartTimeout"
  public static final String pn_uiautomatorDaemonServerStartQueryDelay       = "-uiautomatorDaemonServerStartQueryDelay"
  public static final String pn_uiautomatorDaemonTcpPort                     = "-tcpPort"
  public static final String pn_uiautomatorDaemonWaitForGuiToStabilize       = "-waitForGuiToStabilize"
  public static final String pn_uiautomatorDaemonWaitForWindowUpdateTimeout  = "-waitForWindowUpdateTimeout"
  public static final String pn_uninstallApk                                 = "-uninstallApk"
  public static final String pn_useApkFixturesDir                            = "-useApkFixturesDir"
  public static final String pn_report                                       = "-report"
  public static final String pn_stopAppRetryAttempts                         = "-stopAppRetryAttempts"
  public static final String pn_stopAppSuccessCheckDelay                     = "-stopAppSuccessCheckDelay"
  public static final String pn_waitForCanRebootDelay                        = "-waitForCanRebootDelay"
  public static final String pn_widgetIndexes                                = "-widgetIndexes"
  // @formatter:on
  //endregion

  public static final int    defaultActionsLimit                    = 10
  public static final String defaultApksDir                         = "apks"
  // !!! DUPLICATION WARNING !!! org.droidmate.logging.LogbackConstants.getLogsDirPath
  // !!! DUPLICATION WARNING !!! repo\dev\droidmate\.gitignore
  public static final String defaultDroidmateOutputDir              = "output_device1"
  public static final int    defaultResetEveryNthExplorationForward = 0
  
  public static final String api19 = "api19"
  public static final String api23 = "api23"

  //region Cmd line parameters

  @Parameter(names = [Configuration.pn_actionsLimit, "-actions", "-clicks"], description =
    "How many actions the GUI exploration strategy can conduct before terminating.")
  public Integer actionsLimit = defaultActionsLimit

  @Parameter(names = [Configuration.pn_alwaysClickFirstWidget, "-clickFirst"], description =
    "Should the exploration strategy always click the first widget instead of its default more complex behavior")
  public boolean alwaysClickFirstWidget = false

  @Parameter(names = [Configuration.pn_androidApi, "-api", "-apiLevel"],
    description = "Has to be set to the Android API version corresponding to the (virtual) devices on which DroidMate will run. Currently supported values: api19, api23")
  public String androidApi = api23
  
  @Parameter(names = [Configuration.pn_apksLimit, "-limit"],
    description = "Limits the number of apks on which DroidMate will run. 0 means no limit.")
  public int apksLimit = 0

  @Parameter(names = [Configuration.pn_apksNames, "-apks", "-apps"], listConverter = ListOfStringsConverter.class,
    description = "Filters apps on which DroidMate will be run. Supply full file names, separated by commas, surrounded by square brackets. If the list is empty, it will run on all the apps in the apks dir. Example value: [app1.apk, app2.apk]")
  public List<String> apksNames = new ArrayList<>()

  @Parameter(names = [Configuration.pn_apksDir],
    description = "Directory containing the apks to be processed by DroidMate.")
  public String apksDirName = defaultApksDir

  @Parameter(names = [Configuration.pn_checkAppIsRunningRetryAttempts])
  public int checkAppIsRunningRetryAttempts = 4

  @Parameter(names = [Configuration.pn_checkAppIsRunningRetryDelay])
  public int checkAppIsRunningRetryDelay = 5000

  @Parameter(names = [Configuration.pn_checkDeviceAvailableAfterRebootAttempts])
  public int checkDeviceAvailableAfterRebootAttempts = 12

  @Parameter(names = [Configuration.pn_checkDeviceAvailableAfterRebootFirstDelay])
  public int checkDeviceAvailableAfterRebootFirstDelay = 60 * 1000

  @Parameter(names = [Configuration.pn_checkDeviceAvailableAfterRebootLaterDelays])
  public int checkDeviceAvailableAfterRebootLaterDelays = 10 * 1000

  @Parameter(names = [Configuration.pn_clearPackageRetryAttempts], arity = 1)
  public int clearPackageRetryAttempts = 3

  @Parameter(names = [Configuration.pn_clearPackageRetryDelay], arity = 1)
  public int clearPackageRetryDelay = 1000

  @Parameter(names = [Configuration.pn_closeANRAttempts])
  public int closeANRAttempts = 4

  @Parameter(names = [Configuration.pn_closeANRDelay])
  public int closeANRDelay = 1000

  @Parameter(names = [Configuration.pn_droidmateOutputDir, "-outputDir"], description =
    "Path to the directory that will contain DroidMate exploration output.")
  public String droidmateOutputDir = defaultDroidmateOutputDir

  @Parameter(names = [Configuration.pn_deployRawApks], arity = 1,
    description = "Deploys apks to device in 'raw' form, that is, without instrumenting them. Will deploy them raw even if instrumented version is available from last run.")
  public boolean deployRawApks = false

  @Parameter(names = [Configuration.pn_device])
  public int deviceIndex = 0

  @Parameter(names = ["-displayHelp", "-help", "-h", "-?"], help = true, description =
    "Displays command line parameters description.")
  public boolean displayHelp

  @Parameter(names = [Configuration.pn_exploreInteractively], description =
    "Determines if the user should be asked for confirmation before the exploration driver conducts next action on the Android device. If yes, the information about the action about to be taken will be also displayed.")
  public boolean exploreInteractively = false

  @Parameter(names = ["-extractSaturationCharts", "-esc"], arity = 1)
  public boolean extractSaturationCharts = false

  @Parameter(names = ["-extractSummaries"], arity = 1)
  public boolean extractSummaries = true

  @Parameter(names = [Configuration.pn_getValidGuiSnapshotRetryAttempts])
  public int getValidGuiSnapshotRetryAttempts = 10

  @Parameter(names = [Configuration.pn_getValidGuiSnapshotRetryDelay])
  public int getValidGuiSnapshotRetryDelay = 2000

  @Parameter(names = [Configuration.pn_inline], description =
    "If present, instead of normal run, DroidMate will inline all non-inlined apks. Before inlining backup copies of the apks will be created and put into a sub-directory of the directory containing the apks.")
  public Boolean inline = false

  @Parameter(names = [Configuration.pn_launchActivityDelay])
  public int launchActivityDelay = 5000

  @Parameter(names = [Configuration.pn_launchActivityTimeout])
  public int launchActivityTimeout = 1000 * 60 * 2

  @Parameter(names = ["-logLevel"], description =
    "Logging level of the entirety of application. Possible values, comma separated: trace, debug, info.")
  String logLevel = "trace"

  @Parameter(names = [Configuration.pn_monitorServerStartQueryDelay])
  public int monitorServerStartQueryDelay = 2000

  @Parameter(names = [Configuration.pn_monitorServerStartTimeout])
  public int monitorServerStartTimeout = 20000

  @Parameter(names = [Configuration.pn_uninstallApk], arity = 1)
  public boolean uninstallApk = true

  @Parameter(names = [Configuration.pn_randomSeed, "-seed"], description =
    "The seed for a random generator used by a random-clicking GUI exploration strategy. If null, a seed will be randomized.")
  public Long randomSeed = null

  @Parameter(names = [Configuration.pn_reportIncludePlots], arity = 1)
  public Boolean reportIncludePlots = true

  @Parameter(names = [Configuration.pn_reportInputDir], description =
    "Path to the directory containing report input. The input is to be DroidMate exploration output.")
  public String reportInputDir = "reportInput"

  @Parameter(names = [Configuration.pn_reportOutputDir], description =
    "Path to the directory that will contain the report files.")
  public String reportOutputDir = "reportOutput"

  @Parameter(names = [Configuration.pn_resetEveryNthExplorationForward])
  public int resetEveryNthExplorationForward = defaultResetEveryNthExplorationForward

  @Parameter(names = [Configuration.pn_runOnNotInlined], description =
    "Allow DroidMate to run on non-inlined apks.")
  public Boolean runOnNotInlined = false

  @Parameter(names = [Configuration.pn_socketTimeout], arity = 1)
  // Has to be hefty as "turn_wifi_on" device action can take 20+ seconds.
  // Also, starting activity might take some times.
  public int socketTimeout = 3 * 60 * 1000 // ms

  @Parameter(names = [Configuration.pn_uiautomatorDaemonServerStartTimeout], description =
    "How long DroidMate should wait, in milliseconds, for message on logcat confirming that UiAutomatorDaemonServer has started on android (virtual) device.")
  public int uiautomatorDaemonServerStartTimeout = 20000

  @Parameter(names = [Configuration.pn_uiautomatorDaemonServerStartQueryDelay], description =
    "How often DroidMate should query, in milliseconds, for message on logcat confirming that UiDaemonServer has started on android (virtual) device.")
  public int uiautomatorDaemonServerStartQueryDelay = 2000

  @Parameter(names = [Configuration.pn_uiautomatorDaemonWaitForGuiToStabilize], arity = 1, description =
    "Should the uiautomator-daemon wait for GUI state to stabilize after each click performed on the android device. Setting this to false will drastically speedup the clicking process, but will probably result in new clicks being sent while the results of previous one are still being processed.")
  public boolean uiautomatorDaemonWaitForGuiToStabilize = true

  /* Empirical evaluation shows that setting this to 600 will sometimes cause DroidMate to consider GUI stable while it
     actually isn't, yet.
     For more, see: org.droidmate.uiautomator_daemon.UiAutomatorDaemonDriver.waitForGuiToStabilize
   */
  @Parameter(names = [Configuration.pn_uiautomatorDaemonWaitForWindowUpdateTimeout], arity = 1)
  public int uiautomatorDaemonWaitForWindowUpdateTimeout = 1200 // ms

  @Parameter(names = [Configuration.pn_uiautomatorDaemonTcpPort], description =
    "TCP port used by DroidMate to communicate with the android (virtual) device.")
  public int uiautomatorDaemonTcpPort = UiautomatorDaemonConstants.UIADAEMON_SERVER_PORT

  @Parameter(names = [Configuration.pn_useApkFixturesDir], arity = 1)
  public boolean useApkFixturesDir = false

  @Parameter(names = [Configuration.pn_report], description =
    "If present, instead of normal run, DroidMate will generate reports from previously serialized data.")
  public Boolean report = false

  @Parameter(names = [Configuration.pn_timeLimit], description = "How long the exploration of any given apk should take, in seconds. If set to 0, instead actionsLimit will be used.")
  public int timeLimit = 0

  @Parameter(names = [Configuration.pn_widgetIndexes], listConverter = ListOfIntegersConverter.class,
    description = "Makes the exploration strategy to choose widgets to click that have the indexes as provided by this parameter, in sequence. The format is: [<first widget index>,<second widget index>,...<nth widget index>], starting indexing at 0. Example: [0,7,3]")
  public List<Integer> widgetIndexes = new ArrayList<>()

  @Parameter(names = [Configuration.pn_stopAppRetryAttempts])
  public int stopAppRetryAttempts = 4

  @Parameter(names = [Configuration.pn_stopAppSuccessCheckDelay])
  public int stopAppSuccessCheckDelay = 5000

  @Parameter(names = [Configuration.pn_waitForCanRebootDelay])
  public int waitForCanRebootDelay = 30 * 1000

  //endregion

  //region Values set by ConfigurationBuilder

  public Path droidmateOutputDirPath

  public Path reportInputDirPath

  public Path reportOutputDirPath

  public Path apksDirPath

  public Path monitorApkApi19
  public Path monitorApkApi23

  public String aaptCommandApi19 = BuildConstants.aapt_command_api19
  public String aaptCommandApi23 = BuildConstants.aapt_command_api23

  public String adbCommand = BuildConstants.adb_command

  public List<String> appGuardApisList

  /**
   * Jar with uiautomator-daemon location on the file system. The jar is to be deployed on the android (virtual) device
   * to enable GUI actions execution.
   */
  public Path uiautomatorDaemonJar

  /**
   * Apk with uiautomator-daemon. This is a dummy package required only by instrumentation command (instrumentation target property)
   * More information about th property in: http://developer.android.com/guide/topics/manifest/instrumentation-element.html
   */
  public Path uiautomator2DaemonApk

  /**
   * Apk with "real" uiautomator-daemon. This apk will be deployed be on the android (virtual) device
   * to enable GUI actions execution.
   */
  public Path uiautomator2DaemonTestApk

  //endregion
}
