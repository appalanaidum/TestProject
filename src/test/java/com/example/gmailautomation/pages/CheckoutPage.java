package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	private WebDriver driver;
	private WebElement requiredElement = null;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Class Locators
	public By checkoutPageTitle = By.xpath("//span[text()='Checkout: Your Information']");
	public By firstNameElement = By.id("first-name");
	public By lastNameElement = By.id("last-name");
	public By postalCodeElement = By.id("postal-code");
	public By continueButton = By.id("continue");	
	public By checkoutOverviewPageTitle = By.xpath("//span[text()='Checkout: Overview']");
	public By finishButton = By.id("finish");
	public By checkoutCompletedPageTitle = By.xpath("//span[text()='Checkout: Complete!']");
	
	public String getCheckoutPageTitle() {
		requiredElement = driver.findElement(checkoutPageTitle);
		return requiredElement.getText();
	}
 
	public void enterFirstNameOnCheckoutPage(String firstName) {
		requiredElement = driver.findElement(firstNameElement);
		requiredElement.sendKeys(firstName);
	}
	
	public void enterLastNameOnCheckoutPage(String lastName) {
		requiredElement = driver.findElement(lastNameElement);
		requiredElement.sendKeys(lastName);
	}
	
	public void enterPostalCodeOnCheckoutPage(String postalCode) {
		requiredElement = driver.findElement(postalCodeElement);
		requiredElement.sendKeys(postalCode);
	}
	
	public void clickContinueButton() {
		requiredElement = driver.findElement(continueButton);
		requiredElement.click();
	}
	
	public String getCheckoutOverviewPageTitle() {
		requiredElement = driver.findElement(checkoutOverviewPageTitle);
		return requiredElement.getText();
	}
	
	public void clickFinishButton() {
		requiredElement = driver.findElement(finishButton);
		requiredElement.click();
	}
	
	public String getCheckoutCompletedPageTitle() {
		requiredElement = driver.findElement(checkoutCompletedPageTitle);
		return requiredElement.getText();
	}

}
