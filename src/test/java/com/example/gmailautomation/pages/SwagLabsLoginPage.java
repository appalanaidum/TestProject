package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabsLoginPage {

	private WebDriver driver;
	private WebElement requiredElement = null;
	
	//Page Class Locators 
	public By usernameInput = By.id("user-name");
	public By passwordInput = By.id("password");
	public By loginButton = By.id("login-button");

	public SwagLabsLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		requiredElement = driver.findElement(usernameInput);
		requiredElement.sendKeys(username);
	}

	public void enterPassword(String password) {
		requiredElement = driver.findElement(passwordInput);
		requiredElement.sendKeys(password);
	}

	public void clickLoginButton() {
		requiredElement = driver.findElement(loginButton);
		requiredElement.click();
	}

}
