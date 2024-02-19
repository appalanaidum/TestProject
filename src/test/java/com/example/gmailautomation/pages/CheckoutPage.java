package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	private WebDriver driver;

	// Locators

	public By passwordNextButton = By.id("passwordNext");

	public By test1 = By.id("test");
	public By test2 = By.name("test");
	public By test3 = By.xpath("test3");
	public By test4 = By.tagName("test4");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
//test
}
