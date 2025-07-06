package pageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SetAddressPage {

	public SetAddressPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add my first address']")
	WebElement addressBtn;

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "lastname")
	WebElement lastname;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement id_state;

	@FindBy(id = "postcode")
	WebElement postcode;

	@FindBy(id = "id_country")
	WebElement id_country;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "phone_mobile")
	WebElement phone_mobile;

	@FindBy(id = "other")
	WebElement other;

	@FindBy(id = "alias")
	WebElement alias;

	@FindBy(id = "submitAddress")
	WebElement submitAddress;

	public void clickOnAddressBtn() {
		addressBtn.click();
		;
	}

	public void setFirstname(String fname) {
		firstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void setCompany(String companyName) {
		company.sendKeys(companyName);
		;
	}

	public void setAddress1(String getaddress1) {
		address1.sendKeys(getaddress1);
	}

	public void setAddress2(String getaddress2) {
		address2.sendKeys(getaddress2);
	}

	public void setCity(String getcity) {
		city.sendKeys(getcity);
	}

	public void setId_state(String getid_state) {
		Select select = new Select(id_state);
		select.selectByVisibleText(getid_state);

	}

	public void setPostcode(String getpostcode) {
		postcode.sendKeys(getpostcode);
	}

	public void setId_country(String getid_country) {
		Select select = new Select(id_country);
		select.selectByVisibleText(getid_country);
	}

	public void setPhone(String getphone) {
		phone.sendKeys(getphone);
	}

	public void setPhone_mobile(String getphone_mobile) {
		phone_mobile.sendKeys(getphone_mobile);
	}

	public void setOther(String getother) {
		other.sendKeys(getother);
	}

	public void setAlias(String getalias) {
		this.alias.sendKeys(getalias);
	}

	public void clickOnSubmit() {
		submitAddress.click();
	}

}
