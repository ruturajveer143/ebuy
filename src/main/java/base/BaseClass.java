package base;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class BaseClass {
	public static Logger log;
	public long startTime;
	public long endTime;
	public long duration = endTime - startTime;

	public WebDriver driver;

	public void setUp(String getbrowser) {
		String browser = getbrowser != null ? getbrowser : ConfigReader.getKey("browser");

		log = (Logger) LogManager.getLogger(this.getClass());

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			log.info("Opening Chrome Browser...!");
			break;
		case "edge":
			driver = new EdgeDriver();
			log.info("Opening Edge Browser...!");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			log.info("Opening FireFoxDriver...!");
			break;

		default:
			log.warn("Browser not supported " + browser);

			throw new RuntimeException("Browser not supported: " + browser);

		}

		driver.manage().window().maximize();
		log.info("Maximize Window...!");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(ConfigReader.getKey("url"));
		log.info("Opening URL: " + ConfigReader.getKey("url"));

	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
			log.info("Browser Closed...!");

		} else {
			log.error("Error driver is Null...!");
		}
	}

	public String getFormattedTime(long millis) {
		return new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss.a").format(new Date(millis));
	}

	public String formatDuration(long millis) {
		long seconds = (millis / 1000) % 60;
		long minutes = (millis / (1000 * 60)) % 60;
		long hours = millis / (1000 * 60 * 60);
		long ms = millis % 1000;

		return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, ms);
	}

}
