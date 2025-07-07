package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	long startTime;
	long finishTime;

	public void onStart(ITestContext context) {
		startTime = System.currentTimeMillis();
		System.out.println("Test Execution Started");
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		Object obj = result.getInstance();
		WebDriver driver = ((BaseClass) obj).driver;

		try {
			ScreenshotUtil.takeScreenShot(driver, result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onFinish(ITestContext context) {
		finishTime = System.currentTimeMillis();
		long duration = finishTime - startTime;
		System.out.println("Test Execution Finished in: " + duration + " ms");
	}

}
