package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	private WebDriver driver;

    // Locators
   
    public By passwordNextButton = By.id("passwordNext");

    public By test1 = By.id("test1");
    public By test2 = By.name("test2");
    public By test3 = By.xpath("test");
    public By test4 = By.tagName("test");
    

   public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
//test
}
