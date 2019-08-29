
package properties;

public class Properties {

    public static final String language = null == System.getProperty("language") ? "en-US" : System.getProperty("language");
    public static final String reportToTestRail = null == System.getProperty("reportToTestRail") ? "" : System.getProperty("reportToTestRail");
    public static final String testRailPlanName = null == System.getProperty("testRailPlanName") ? "" : System.getProperty("testRailPlanName");
    public static final String slackNotification = null == System.getProperty("slackNotif") ? "" : System.getProperty("slackNotif");
    public static final String env = null == System.getProperty("env") ? "" : System.getProperty("env");

}
