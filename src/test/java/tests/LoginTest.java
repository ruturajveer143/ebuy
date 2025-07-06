package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjectPages.LoginPage;
import pageObjectPages.RegistrationPage;
import utils.ConfigReader;

public class LoginTest extends BaseClass {

	RegistrationPage regPage;
	LoginPage login;

	@BeforeMethod
	void launchApp() {
		setUp(null);
		regPage = new RegistrationPage(driver);
		login = new LoginPage(driver);
		log = (Logger) LogManager.getLogger(this.getClass());
	}

	@Test
	void login() throws InterruptedException {
		regPage.clickOnSignBtn();
		
		login.sendEmail(ConfigReader.getKey("username"));
		log.info("Enterd Gmail...!");
		login.sendPass(ConfigReader.getKey("password"));
		log.info("Enterd Password...!");
		login.clickLogin();
		log.info("Clicked On Login Button...!");
		Thread.sleep(5000);
	}

}
