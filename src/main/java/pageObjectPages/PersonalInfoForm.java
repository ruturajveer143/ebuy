package pageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoForm {
	
	public PersonalInfoForm(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "id_gender1")
	WebElement gender;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

//	@FindBy(id="")
//	WebElement birthDate;

	@FindBy(id = "submitAccount")
	WebElement registerBtn;

	public void setGender() {
		gender.click();
	}

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setEmail(String email ) {
		this.email.sendKeys(email);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void setRegisterBtn() {
		registerBtn.click();
	}

}
