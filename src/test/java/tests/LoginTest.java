package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import listeners.TestListener;
import pageObjectPages.LoginPage;
import pageObjectPages.RegistrationPage;
import utils.ConfigReader;

@Listeners({ TestListener.class })
public class LoginTest extends BaseClass {

	RegistrationPage regPage;
	LoginPage login;
	public static Logger log;

	@BeforeMethod
	void launchApp() {
		setUp(null);
		regPage = new RegistrationPage(driver);
		login = new LoginPage(driver);

	}

	@Test
	void login() throws InterruptedException {
		log = (Logger) LogManager.getLogger(this.getClass());
		regPage.clickOnSignBtn();

		login.sendEmail(ConfigReader.getKey("username"));

		login.sendPass(ConfigReader.getKey("password"));

		login.clickLogin();

		String expectedTitle = "Rohit Patil";

		String actualTitle = login.getTitleText();

		log.info("Title - Expected: " + expectedTitle + ", Actual: " + actualTitle);
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			log.info("Title matched...!");

		} catch (AssertionError e) {
			log.error("Title mismatch...!");
			throw e;
		}

	}

	@AfterMethod
	public void closeApp() {

		tearDown();
	}

}
