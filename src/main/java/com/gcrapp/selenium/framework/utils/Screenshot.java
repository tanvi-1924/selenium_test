package com.gcrapp.selenium.framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.gcrapp.selenium.framework.ConfigReaderWriter;

public class Screenshot {

	public static final String SCREENSHOT_LOCATION = ConfigReaderWriter
			.getProperty("SCREENSHOT_LOCATION");

	public static void captureScreenshot(WebDriver driver, String methodName,
			String testResultOutCome) throws IOException {

		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(SCREENSHOT_LOCATION
				+ File.separator + methodName + "_" + testResultOutCome + "_"
				+ new Date().getTime() + ".png"));
	}

}
