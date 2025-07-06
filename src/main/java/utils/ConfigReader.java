package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties prop;
	
	static {
		try {
			prop = new Properties();
			InputStream src = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(src);
			
		} catch (Exception e) {
			System.out.println("Failed to load config: " + e.getMessage());	
		}
	}

	
	public static String getKey(String key) {
		return prop.getProperty(key);
	}
}
