package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjectPages.PersonalInfoForm;
import pageObjectPages.RegistrationPage;
import utils.ConfigReader;

public class RegistrationTest extends BaseClass {

	public static Logger log;
	RegistrationPage regPage;

	@BeforeMethod
	void launchApp() {
		setUp(null);
		log = (Logger) LogManager.getLogger(this.getClass());
		
	}

	@Test(enabled = false)
	void validSignupTest() throws InterruptedException {

		regPage.clickOnSignBtn();
		log.info("Clicked on Signin Button...!");
		regPage.enterEmail(ConfigReader.getKey("username"));
		log.info("Enterd Email from COnfig File...!");
		regPage.clickOnSubmit();
		log.info("Clicked on Submit Button...!");

	}

	@AfterMethod
	public void closeApp() {
		log.warn("Driver Closed...!");
		tearDown();
		
	}

}
