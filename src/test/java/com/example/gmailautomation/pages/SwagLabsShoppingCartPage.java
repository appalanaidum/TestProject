package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabsShoppingCartPage {

	private WebDriver driver;
	private WebElement requiredElement = null;

	// Page Class Locators
	public By shoppingCartTitle = By.xpath("//span[text()='Your Cart']");
	public By removeSauceLabsBackpack = By.id("remove-sauce-labs-backpack");
	public By removeSauceLabsBikeLight = By.id("remove-sauce-labs-bike-light");
	public By checkoutButton = By.id("checkout");
	public By shoppingCartItemsCount = By.xpath("(//span[@class='shopping_cart_badge'])");
	public By continueShoppingButton = By.id("continue-shopping");

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
	
	public void removeAddedItemsFromCart() {
		requiredElement = driver.findElement(removeSauceLabsBackpack);
		requiredElement.click();
		//requiredElement = driver.findElement(removeSauceLabsBikeLight);
		//requiredElement.click();
	}
	
	public String getShoppingCartItemsCount() {
		requiredElement = driver.findElement(shoppingCartItemsCount);
		//return Integer.parseInt(requiredElement.getText());
		return requiredElement.getText();
	}
	
	public void clickContinueShoppingButton() {
		requiredElement = driver.findElement(continueShoppingButton);
		requiredElement.click();
	}
}
