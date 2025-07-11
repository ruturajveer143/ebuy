package pageObjectPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static Logger log;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		log = (Logger) LogManager.getLogger(this.getClass());
	}

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement title;

	public void sendEmail(String useremail) {
		log.info("Entered Email: " + useremail);
		email.sendKeys(useremail);
	}

	public void sendPass(String pass) {
		log.info("Entered Password: " + pass);
		password.sendKeys(pass);
	}

	public void clickLogin() {
		log.info("Clicked on Login Button...!");
		LoginBtn.click();
	}

	public String getTitleText() {
		log.info("Checking title is present!");
		return title.getText();

	}

}
