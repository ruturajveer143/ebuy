package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports report;

    public static ExtentReports createInstance(String contextName) {
        if (report == null) {
            String path = System.getProperty("user.dir") + "/reports/" + contextName + "_report.html";
            ExtentSparkReporter sparkreport = new ExtentSparkReporter(path);

            sparkreport.config().setDocumentTitle("ebuy-Automation Report");
            sparkreport.config().setReportName("Execution Report");
            sparkreport.config().setTheme(Theme.DARK);

            report = new ExtentReports();
            report.attachReporter(sparkreport);

            report.setSystemInfo("Computer Name", "Asus:localhost");
            report.setSystemInfo("Environment", "QA");
            report.setSystemInfo("Tester Name", "QA Lead");
            report.setSystemInfo("OS", "WINDOWS");
            report.setSystemInfo("Browser", "Chrome");
        }

        return report;
    }
}
