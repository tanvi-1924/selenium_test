package com.gcrapp.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gcrapp.selenium.framework.DriverProvider;
import com.gcrapp.selenium.tests.utils.AppLogger;

public class LoginTest {

	private static AppLogger logger = new AppLogger(LoginTest.class);

	WebDriver driver;

	@BeforeTest
	public void getDriver() {
		driver = DriverProvider.createFirefoxDriver();
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
		driver.findElement(By.name("password")).sendKeys("admin@123");
		driver.findElement(By.xpath(".//*[@id='tdb1']")).click();
		logger.debug("verifyLogin - Exit");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
