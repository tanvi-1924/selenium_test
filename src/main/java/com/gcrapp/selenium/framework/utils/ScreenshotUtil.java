package com.gcrapp.selenium.framework.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.gcrapp.selenium.framework.ConfigReaderWriter;
import com.gcrapp.selenium.tests.utils.AppLogger;

public class ScreenshotUtil {

	public static final String SCREENSHOT_LOCATION = ConfigReaderWriter
			.getProperty("SCREENSHOT_LOCATION");
	
	private static AppLogger logger = new AppLogger(ScreenshotUtil.class);

	public static void captureScreenshot(WebDriver driver, String methodName,
			String testOutcome) throws IOException {

		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(getScreenshotFilename(methodName, testOutcome)));
	}
	
	private static String getScreenshotFilename(String methodName, String testOutcome) {
		logger.info("getScreenshotFilename - Enter with arguments -");
		final long millis = System.currentTimeMillis();
		final Date date = new Date(millis);
		
		
		final StringBuilder fileNameBuilder = new StringBuilder();
		fileNameBuilder.append(SCREENSHOT_LOCATION);
		fileNameBuilder.append(File.separator);
		fileNameBuilder.append(methodName);
		fileNameBuilder.append("_");
		fileNameBuilder.append(testOutcome);
		fileNameBuilder.append("_");
		fileNameBuilder.append(date);
		fileNameBuilder.append("_");
		fileNameBuilder.append(getTimeFromMillis(millis));
		fileNameBuilder.append(".png");
		return fileNameBuilder.toString();
	}
	private static String getTimeFromMillis(long millis){
		return String.format("%1$tH_%1$tM_%1$tS", millis);
	}
}
