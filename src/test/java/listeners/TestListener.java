package listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class TestListener extends BaseClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public static Logger log;

	public void onStart(ITestContext context) {

		report = ExtentReportManager.createInstance(context.getName());
		log = (Logger) LogManager.getLogger(this.getClass());

	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.INFO, " TEST CASE STARTED: " + result.getName());

		startTime = System.currentTimeMillis();
		log.info(result.getClass() + " TEST CASE STARTED: " + getFormattedTime(startTime));
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, " TEST CASE PASSED");
		log.info(result.getClass() + " TEST CASE PASSED");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, " TEST CASE FAILED: " + result.getThrowable());
		WebDriver driver = ((BaseClass) result.getInstance()).driver;
		String path = System.getProperty("user.dir") + "/screenshots/" + getFormattedTime(System.currentTimeMillis()) + ".png";

		try {
			ScreenshotUtil.takeScreenShot(driver, path);
			test.addScreenCaptureFromPath(path);
			String shortMessage = result.getThrowable().getClass().getSimpleName();

			log.error(result.getName() + " TEST CASE FAILED: " + shortMessage);
			log.info(result.getName() + " Captured Screen Shot URL: " + path);
		} catch (Exception e) {
			log.error(result.getName() + " Failed to Captured Screen Shot...!");
			e.printStackTrace();

		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, " TEST CASE SKIPPED");
		log.info(result.getClass() + " TEST CASE SKIPPED...!");
	}

	public void onFinish(ITestContext context) {
		endTime = System.currentTimeMillis();
		log.info(context.getName() + " TEST FINISHED AT: " + getFormattedTime(endTime));
		duration = endTime - startTime;
		log.info(context.getName() + " TEST DURATION: " + formatDuration(duration));
		report.flush();
	}
}
