package com.gcrapp.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
	
	public static final String GECKO_DRIVER_LOCATION = ConfigReaderWriter.getProperty("GECKO_DRIVER_LOCATION");
	public static final String GECKO_DRIVER_FILE_NAME = ConfigReaderWriter.getProperty("GECKO_DRIVER_FILE_NAME");
	
	public static WebDriver createFirefoxDriver(){
		WebDriver driver;
//		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION+GECKO_DRIVER_FILE_NAME);
		
		System.setProperty("webdriver.gecko.driver","C:/Users/Tanvi/Downloads/geckodriver-v0.17.0-win64/geckodriver.exe");
		driver=new FirefoxDriver();
		return driver;
	}
}

