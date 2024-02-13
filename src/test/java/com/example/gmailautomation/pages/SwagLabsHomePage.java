package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabsHomePage {

	private WebDriver driver;
	private WebElement requiredElement = null;

	// Page Class Locators
	public By homePageTitle = By.xpath("//span[@class='title']");
	public By backpackAddButton = By
			.xpath("//div[@id='inventory_container']//button[@id='add-to-cart-sauce-labs-backpack']");
	public By bikeLightButton = By
			.xpath("//div[@id='inventory_container']//button[@id='add-to-cart-sauce-labs-bike-light']");
	public By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
	public By homePageFilter = By.xpath("//select[@class='product_sort_container']");
	public By item_prices = By.xpath("(//div[@class='inventory_item_price'])");
	public By item_names = By.xpath("(//div[contains(@class,'inventory_item_name')])");
	
	public SwagLabsHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		requiredElement = driver.findElement(homePageTitle);
		return requiredElement.getText();
	}

	public void clickBackpackAddButton() {
		requiredElement = driver.findElement(backpackAddButton);
		requiredElement.click();
	}

	public void clickBikeLightAddButton() {
		requiredElement = driver.findElement(bikeLightButton);
		requiredElement.click();
	}

	public void clickShoppingCart() {
		requiredElement = driver.findElement(shoppingCart);
		requiredElement.click();
	}

}
