package com.example.gmailautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailLoginPage {

    private WebDriver driver;

    // Locators
    public By usernameInput = By.id("identifierId");
    public By passwordInput = By.name("password");
    public By nextButton = By.id("identifierNext");
    public By passwordNextButton = By.id("passwordNext");

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(usernameInput);
        usernameField.sendKeys(username);
    }

    public void clickNextAfterUsername() {
        WebElement next = driver.findElement(nextButton);
        next.click();
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.sendKeys(password);
    }

    public void clickNextAfterPassword() {
        WebElement next = driver.findElement(passwordNextButton);
        next.click();
    }

    // Additional methods for other functionalities of the Gmail login page can be added here
}
