package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	ExtentSparkReporter sparkreport;
	ExtentReports report;
	ExtentTest test;

	long startTime;
	long finishTime;

	public void onStart(ITestContext context) {
		startTime = System.currentTimeMillis();
		System.out.println("Test Execution Started");

		String path = System.getProperty("user.dir") + "/reports/" + context.getName() + "_report.html";

		sparkreport = new ExtentSparkReporter(path);
		report = new ExtentReports();
		report.attachReporter(sparkreport);

		sparkreport.config().setDocumentTitle("ebuy-Automation Report");
		sparkreport.config().setReportName("Report1");
		sparkreport.config().setTheme(Theme.DARK);

		report.setSystemInfo("Computer  ame: ", "Asus:localhost");
		report.setSystemInfo("Enivoriment: ", "QA");
		report.setSystemInfo("Tester Name", "QA Lead");
		report.setSystemInfo("OS: ", "WINDOWS");
		report.setSystemInfo("Browser Name: ", "Chrome");

	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		 test.log(Status.INFO, "TEST CASE START "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"TEST CASE PASS");
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,"TEST CASE FAIL"+result.getThrowable());
		
		Object obj = result.getInstance();
		WebDriver driver = ((BaseClass) obj).driver;

		String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + "_"+ ".png";

		try {
			ScreenshotUtil.takeScreenShot(driver, path);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,"TEST CASE SKIP");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
		//test.log(Status.PASS,"TEST CASE PASS"+result.getStatus());
	}

	public void onFinish(ITestContext context) {
		
		
		finishTime = System.currentTimeMillis();
		long duration = finishTime - startTime;
		test.log(Status.INFO,"TEST CASE FINISH IN "+duration+ "ms");
		 
		report.flush();
		
		
	}

}
