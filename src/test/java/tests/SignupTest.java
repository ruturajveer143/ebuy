package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjectPages.PersonalInfoForm;
import pageObjectPages.RegistrationPage;

public class SignupTest extends BaseClass {
	RegistrationPage regPage;
	PersonalInfoForm pinfo;
	public static Logger log;

	@BeforeMethod
	void launchApp() {
		setUp(null);
		regPage = new RegistrationPage(driver);
		pinfo = new PersonalInfoForm(driver);
		log = (Logger) LogManager.getLogger(this.getClass());
	}

	@Test(enabled = false)
	void validSignupTest() throws InterruptedException {

		regPage.clickOnSignBtn();
		log.info("Clicked on Signin Button...!");
		regPage.enterEmail("vruturaj655@gmail.com");
		log.info("Enterd Email...!");
		
		// regPage.enterEmail(ConfigReader.getKey("username"));
		regPage.clickOnSubmit();
		log.info("Clicked on Submit Button...!");
		

		pinfo.setGender();
		log.info("Gender Selected...!");
		pinfo.setFirstName("Rohit");
		log.info("Enterd First Name...!");
		pinfo.setLastName("Patil");
		log.info("Enterd Last Name...!");
		// pinfo.setEmail("vruturaj655@gmail.com");
		pinfo.setPassword("Pass@1234");
		log.info("Enterd Password...!");
		pinfo.setRegisterBtn();
		log.info("Clicked on Register Button...!");
		

	}

	@AfterMethod
	public void closeApp() {
		tearDown();
	}

}
