package com.gcrapp.selenium.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private static By userTextBox = By.name("username");
	private static By passwordTextBox = By.name("password");
	private static By loginButton = By.xpath(".//*[@id='tdb1']");

	public static void fillUserName(WebDriver driver, String username) {
		driver.findElement(userTextBox).sendKeys(username);
	}
	
	public static void fillPassword(WebDriver driver, String password){
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public static void clickLoginButton(WebDriver driver){
		driver.findElement(loginButton).click();
	}
}
