package com.example.gmailautomation.stepdefinitions;

import com.example.gmailautomation.pages.GmailLoginPage;
import com.example.gmailautomation.utils.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class GmailLoginStepDefinitions {

    private WebDriver driver = WebDriverManager.getWebDriver();

    
    @Given("User navigates to the Gmail login page")
    public void user_navigates_to_the_gmail_login_page() {
    	driver.get("https://mail.google.com/");    	
    }
    @When("User enters a valid username and password")
    public void user_enters_a_valid_username_and_password() {
    	
    	GmailLoginPage gmailLoginPage=new GmailLoginPage(driver);
    	
    	// Wait for the password input to be visible
        WebElement usernameInput = WebDriverManager.waitForElementVisible(gmailLoginPage.usernameInput);
     	gmailLoginPage.enterUsername("test@gmail.com");
     	
     	WebElement usernameNext = WebDriverManager.waitForElementVisible(gmailLoginPage.nextButton);
     	gmailLoginPage.clickNextAfterUsername();
     	
     	WebElement passwordInput = WebDriverManager.waitForElementVisible(gmailLoginPage.passwordInput);
     	gmailLoginPage.enterPassword("xxxx838954");
     	
     	WebElement passwordNext = WebDriverManager.waitForElementVisible(gmailLoginPage.passwordNextButton);
     	gmailLoginPage.clickNextAfterPassword();
     	
      	
    	/*WebElement usernameInput = driver.findElement(By.id("identifierId"));
         usernameInput.sendKeys("your_username@gmail.com");

         WebElement nextButton = driver.findElement(By.id("identifierNext"));
         nextButton.click();

         // Wait for the password input to be visible
         WebElement passwordInput = WebDriverManager.waitForElementVisible(By.name("password"));
         passwordInput.sendKeys("your_password");

         WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
         passwordNextButton.click();*/
    }
    
    /*   
     
      @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User should be logged in to the Gmail account")
    public void user_should_be_logged_in_to_the_gmail_account() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    
    
   
    
    @Given("User navigates to the Gmail login page")
    public void userNavigatesToGmailLoginPage() {
        driver.get("https://mail.google.com/");
    }

    @When("User enters a valid username and password")
    public void userEntersValidUsernameAndPassword() {
        WebElement usernameInput = driver.findElement(By.id("identifierId"));
        usernameInput.sendKeys("your_username@gmail.com");

        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();

        // Wait for the password input to be visible
        WebElement passwordInput = WebDriverManager.waitForElementVisible(By.name("password"));
        passwordInput.sendKeys("your_password");

        WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
        passwordNextButton.click();
    }

    @Then("User should be logged in to the Gmail account")
    public void userShouldBeLoggedIn() {
        // Assuming there is an element on the Gmail dashboard that indicates successful login
        WebElement inboxHeader = WebDriverManager.waitForElementVisible(By.xpath("//div[contains(text(),'Inbox')]"));
        assertTrue("User is not logged in successfully", inboxHeader.isDisplayed());
    }
    */
}

