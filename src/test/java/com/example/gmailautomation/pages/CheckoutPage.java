package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	private WebDriver driver;

    // Locators
   
    public By passwordNextButton = By.id("passwordNext");
	public By test3 = By.xpath("test3");
    public By test4 = By.tagName("test5");

   public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
//test
}
