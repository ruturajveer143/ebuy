package pageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public RegistrationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign in")
	WebElement SignBtn;

	@FindBy(id = "email_create")
	WebElement emailBox;

	@FindBy(id = "SubmitCreate")
	WebElement SubmitBtn;

	public void clickOnSignBtn() {
		SignBtn.click();
	}

	public void enterEmail(String email) {
		emailBox.sendKeys(email);
	}

	public void clickOnSubmit() {
		SubmitBtn.click();
	}

}
