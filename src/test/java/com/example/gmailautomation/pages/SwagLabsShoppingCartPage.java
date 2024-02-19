package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabsShoppingCartPage {

	private WebDriver driver;
	private WebElement requiredElement = null;

	// Page Class Locators
	public By shoppingCartTitle = By.xpath("//span[text()='Your Cart']");
	public By checkoutButton = By.id("checkout");

	public SwagLabsShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getShoppingCartTitle() {
		requiredElement = driver.findElement(shoppingCartTitle);
		return requiredElement.getText();
	}
	
	public void clickCheckoutButton() {
		requiredElement = driver.findElement(checkoutButton);
		requiredElement.click();
	}
}
