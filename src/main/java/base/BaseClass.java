package base;

import java.time.Duration;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class BaseClass {

	public WebDriver driver;
	public Logger log;

	public void setUp(String getbrowser) {
		String browser = getbrowser != null ? getbrowser : ConfigReader.getKey("browser");

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Browser not supported: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ConfigReader.getKey("url"));

	}
	
	public void tearDown() {
		  if (driver != null) {
	            driver.quit();
	        }
	}

}
