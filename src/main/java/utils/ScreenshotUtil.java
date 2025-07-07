package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	public static String takeScreenShot(WebDriver driver,String path) {
		// String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(src.toPath(), new File(path).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

}
