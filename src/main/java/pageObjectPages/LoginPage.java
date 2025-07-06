package pageObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement LoginBtn;
	
	public void sendEmail(String useremail) {
		email.sendKeys(useremail);
	}
	
	public void sendPass(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		LoginBtn.click();
	}
	

}
