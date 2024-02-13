package com.example.gmailautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadProperties {
	public static Properties properties = null;

	public static Properties getProperties() {
		if (properties == null) {
			loadPropertiesFile();
		}
		return properties;
	}

	public static void loadPropertiesFile() {
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"..\\TestProject\\src\\test\\resources\\PropertiesFiles\\config.properties");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
