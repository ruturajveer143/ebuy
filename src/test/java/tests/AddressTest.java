package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import listeners.TestListener;
import pageObjectPages.LoginPage;
import pageObjectPages.RegistrationPage;
import pageObjectPages.SetAddressPage;
import utils.ConfigReader;

@Listeners({ TestListener.class })
public class AddressTest extends BaseClass {

	RegistrationPage regpage;
	LoginPage login;
	SetAddressPage address;
	public static Logger log;

	@BeforeMethod
	void addressSetup() {
		setUp(null);

		regpage = new RegistrationPage(driver);
		login = new LoginPage(driver);
		address = new SetAddressPage(driver);

		log = (Logger) LogManager.getLogger(this.getClass());

	}
	
	
	@Test(enabled = false)
	void setAddress() throws InterruptedException {
		regpage.clickOnSignBtn();

		//login.clickLogin();
		login.sendEmail(ConfigReader.getKey("username"));
		login.sendPass(ConfigReader.getKey("password"));
		login.clickLogin();

		address.clickOnAddressBtn();
		log.info("Clicked on Address Button...!");
		// address.setFirstname("Rohit");
		// address.setLastname("Patil");
		address.setCompany("XYZ Pvt.ltd");
		log.info("Enterd Compnay Name...!");
		address.setAddress1("Mohan Nagar");
		log.info("Enterd Address Line1...!");
		address.setAddress2("PCMC");
		log.info("Enterd Address Line2...!");
		address.setCity("Pune");
		log.info("Enterd City...!");
		address.setId_state("Arizona");
		log.info("Enterd State...!");
		address.setPostcode("41101");
		log.info("Enterd Pincode...!");
		address.setId_country("United States");
		log.info("Enterd Country...!");
		address.setPhone("9764152114");
		log.info("Enterd Phone Number...!");
		address.setPhone_mobile("8530341716");
		log.info("Enterd Mobile Number...!");
		address.setOther("Nothing");
		log.info("Enterd the other details...!");
		address.setAlias("-Home");
		log.info("Enter the address Name...!");
		address.clickOnSubmit();
		log.info("Clicked on Submit Button...!");
		
	//	Assert.fail();
		

	}

	@AfterMethod
	public void closeApp() {
		tearDown();
	}

}
