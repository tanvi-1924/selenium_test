package com.gcrapp.selenium.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gcrapp.selenium.framework.DriverProvider;
import com.gcrapp.selenium.framework.utils.ScreenshotUtil;
import com.gcrapp.selenium.tests.utils.AppLogger;

public class LoginTest {

	private static AppLogger logger = new AppLogger(LoginTest.class);
	WebDriver driver;
	public String methodName;
	public static ITestResult iTestResult;

	@BeforeTest
	public void getDriver() {
		driver = DriverProvider.createFirefoxDriver();

	}

	@BeforeMethod
	public void getMethodName(Method method) {
		this.methodName = method.getName();

	}

	@Test(priority = 1)
	public void openBrowser() {
		logger.debug("openBrowser - Enter");
		driver.get("http://www.gcrit.com/build3/admin/login.php");
		logger.debug("openBrowser - Exit");
	}

	@Test(dependsOnMethods = { "openBrowser" })
	public void verifyLogin() {
		logger.debug("verifyLogin - Enter");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin@1234");
		driver.findElement(By.xpath(".//*[@id='tdb1']")).click();
		logger.debug("verifyLogin - Exit");
		Assert.assertEquals(driver.getCurrentUrl(),
				"http://www.gcrit.com/build3/admin/index.php");
	}

	@AfterMethod
	public void takeScreenShot(ITestResult iTestResult) {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("----------------------RESULT-----------------"
					+ iTestResult.getStatus());
			try {
				ScreenshotUtil.captureScreenshot(driver, methodName, "FAILURE");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			try {
				ScreenshotUtil.captureScreenshot(driver, methodName, "SUCCESS");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}

}
