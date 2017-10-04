package com.gcrapp.selenium.automation.businessflows;

import org.openqa.selenium.WebDriver;

import com.gcrapp.selenium.automation.pageobjects.LoginPage;
import com.gcrapp.selenium.tests.utils.AppLogger;

public class LoginFlow {

private static AppLogger logger = new AppLogger(LoginFlow.class);

public static void login(WebDriver driver, String username, String password){
	logger.debug("--------------------Entering login method-------------");
	LoginPage.fillUserName(driver, "admin");
	logger.debug("--------------------Filled Username-------------------");
	LoginPage.fillPassword(driver, "admin@123");
	logger.debug("--------------------Filled Password-------------------");
	LoginPage.clickLoginButton(driver);
	logger.debug("--------------------Clicked Login Button---------------");
}
}
