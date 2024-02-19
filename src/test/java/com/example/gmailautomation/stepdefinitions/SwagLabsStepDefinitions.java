package com.example.gmailautomation.stepdefinitions;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.gmailautomation.pages.CheckoutPage;
import com.example.gmailautomation.pages.SwagLabsHomePage;
import com.example.gmailautomation.pages.SwagLabsLoginPage;
import com.example.gmailautomation.pages.SwagLabsShoppingCartPage;
import com.example.gmailautomation.utils.ReadProperties;
import com.example.gmailautomation.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SwagLabsStepDefinitions {

	private WebDriver driver = WebDriverManager.getWebDriver();

	// Initiate page class objects
	SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
	SwagLabsHomePage swagLabsHomePage = new SwagLabsHomePage(driver);
	SwagLabsShoppingCartPage swagLabsShoppingCartPage = new SwagLabsShoppingCartPage(driver);
	CheckoutPage checkoutPage = new CheckoutPage(driver);

	// Read properties by using Properties class
	Properties properties = ReadProperties.getProperties();

	@Given("^User navigates to the Swag Labs login page$")
	public void user_navigates_to_the_swag_labs_login_page() {
		driver.get(properties.getProperty("url"));
	}

	@When("User enters a valid username")
	public void user_enters_a_valid_username() {
		// Wait for the Username input to be visible
		WebDriverManager.waitForElementVisible(swagLabsLoginPage.usernameInput);
		swagLabsLoginPage.enterUsername(properties.getProperty("userName"));
	}

	@When("User enters a valid password")
	public void user_enters_a_valid_password() {
		// Wait for the password input to be visible
		WebDriverManager.waitForElementVisible(swagLabsLoginPage.passwordInput);
		swagLabsLoginPage.enterPassword(properties.getProperty("password"));
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		// Wait for the loginbutton to be visible
		WebDriverManager.waitForElementVisible(swagLabsLoginPage.loginButton);
		swagLabsLoginPage.clickLoginButton();
	}

	@Then("User should be logged in to the Swag Labs account")
	public void user_should_be_logged_in_to_the_swag_labs_account() {
		// Wait for the loginbutton to be visible
		WebDriverManager.waitForElementVisible(swagLabsHomePage.homePageTitle);
		String title = swagLabsHomePage.getPageTitle();
		Assert.assertEquals("Products", title);
	}

	@When("User added few items into shopping cart")
	public void user_added_few_items_into_shopping_cart() {
		// Wait for the Items to be visible for adding into shopping cart
		WebDriverManager.waitForElementVisible(swagLabsHomePage.backpackAddButton);
		swagLabsHomePage.clickBackpackAddButton();
		WebDriverManager.waitForElementVisible(swagLabsHomePage.bikeLightButton);
		swagLabsHomePage.clickBikeLightAddButton();
	}

	@When("User clicks on shopping cart icon")
	public void user_clicks_on_shopping_cart_icon() {
		// Wait for the shopping cart icon to be visible
		WebDriverManager.waitForElementVisible(swagLabsHomePage.shoppingCart);
		swagLabsHomePage.clickShoppingCart();
	}

	@Then("User should be on shopping cart page")
	public void user_should_be_on_shopping_cart_page() {
		// Wait for the shoppingCartTitle to be visible
		WebDriverManager.waitForElementVisible(swagLabsShoppingCartPage.shoppingCartTitle);
		String title = swagLabsShoppingCartPage.getShoppingCartTitle();
		Assert.assertEquals("Your Cart", title);
	}

	@When("^User select filter (.+)$")
	public void user_select_filter(String filterValue) {
		WebElement element = WebDriverManager.waitForElementVisible(swagLabsHomePage.homePageFilter);
		Select dropdownOptions = WebDriverManager.getSelectDropdownOptions(element);
		dropdownOptions.selectByValue(filterValue);
	}

	@Then("^User should be able to see the displayed items as per the filter (.+)$")
	public void user_should_be_able_to_see_the_displayed_items_as_per_the_filter(String filterValue) {
		ArrayList<WebElement> items = (ArrayList<WebElement>) driver.findElements(swagLabsHomePage.item_prices);
		float temp1 = (float) 0.0, temp2 = (float) 0.0;
		boolean flag = true;
		if (filterValue.equals("lohi")) {

			for (int i = 0; i < items.size() - 1; i++) {
				System.out.println(Float.parseFloat(items.get(i).getText().substring(1)));
				temp1 = Float.parseFloat(items.get(i).getText().substring(1));
				temp2 = Float.parseFloat(items.get(i + 1).getText().substring(1));
				if (!(temp1 <= temp2)) {
					flag = false;
				}
			}
		} else if (filterValue.equals("hilo")) {
			for (int i = 0; i < items.size() - 1; i++) {
				// System.out.println(items.get(i).getText());
				System.out.println(Float.parseFloat(items.get(i).getText().substring(1)));
				temp1 = Float.parseFloat(items.get(i).getText().substring(1));
				temp2 = Float.parseFloat(items.get(i + 1).getText().substring(1));
				if (!(temp1 >= temp2)) {
					flag = false;
				}
			}
		} else {
			System.out.println("Items price is wrong");
		}
		Assert.assertTrue(flag);
	}

	@When("^User sort the items by selecting a filter (.+)$")
	public void user_sort_the_items_by_selecting_a_filter(String filterValue) {
		WebElement element = WebDriverManager.waitForElementVisible(swagLabsHomePage.homePageFilter);
		Select dropdownOptions = WebDriverManager.getSelectDropdownOptions(element);
		dropdownOptions.selectByValue(filterValue);
	}

	@Then("^User should be able to see items alphabetical order as per the filter (.+)$")
	public void user_should_be_able_to_see_items_alphabetical_order_as_per_the_filter(String filterValue) {
		ArrayList<WebElement> items = (ArrayList<WebElement>) driver.findElements(swagLabsHomePage.item_names);
		String tempString1 = null, tempString2 = null;
		boolean flag = true;
		if (filterValue.equals("az")) {
			for (int i = 0; i < items.size() - 1; i++) {
				System.out.println(items.get(i).getText());
				tempString1 = items.get(i).getText();
				tempString2 = items.get(i + 1).getText();
				if (tempString1.compareTo(tempString2) > 0) {
					flag = false;
				}
			}
		} else if (filterValue.equals("za")) {
			for (int i = 0; i < items.size() - 1; i++) {
				System.out.println(items.get(i).getText());
				tempString1 = items.get(i).getText();
				tempString2 = items.get(i + 1).getText();
				if (tempString1.compareTo(tempString2) < 0) {
					flag = false;
				}
			}
		} else {
			System.out.println("Items price is wrong");
		}
		Assert.assertTrue(flag);
	}

	@When("User clicks Checkout button")
	public void user_clicks_checkout_button() {
		// Wait for the Checkout button to be visible
		WebDriverManager.waitForElementVisible(swagLabsShoppingCartPage.checkoutButton);
		swagLabsShoppingCartPage.clickCheckoutButton();
	}

	@Then("User should be on Checkout page")
	public void user_should_be_on_checkout_page() {
		// Wait for the Checkout page title to be visible
		WebDriverManager.waitForElementVisible(checkoutPage.checkoutPageTitle);
		String title = checkoutPage.getCheckoutPageTitle();
		Assert.assertEquals("Checkout: Your Information", title);
	}

	@When("User fill required details and clicks continue button")
	public void user_fill_required_details_and_clicks_continue_button() {
		// Wait for the Checkout page title to be visible
		WebDriverManager.waitForElementVisible(checkoutPage.firstNameElement);
		checkoutPage.enterFirstNameOnCheckoutPage(properties.getProperty("firstName"));
		checkoutPage.enterLastNameOnCheckoutPage(properties.getProperty("lastName"));
		checkoutPage.enterPostalCodeOnCheckoutPage(properties.getProperty("postalCode"));
		WebDriverManager.waitForElementVisible(checkoutPage.continueButton);
		checkoutPage.clickContinueButton();

	}

	@Then("User should be on Checkout Overview details page")
	public void user_should_be_on_checkout_overview_details_page() {
		// Wait for the Checkout Overview title to be visible
				WebDriverManager.waitForElementVisible(checkoutPage.checkoutOverviewPageTitle);
				String title = checkoutPage.getCheckoutOverviewPageTitle();
				Assert.assertEquals("Checkout: Overview", title);
	}

	@When("User clicks finish button")
	public void user_clicks_finish_button() {
		// Wait for the Checkout button to be visible
				WebDriverManager.waitForElementVisible(checkoutPage.finishButton);
				checkoutPage.clickFinishButton();
	}

	@Then("User should be on Checkout completed page")
	public void user_should_be_on_checkout_completed_page() {
		// Wait for the Checkout Completed page title to be visible
		WebDriverManager.waitForElementVisible(checkoutPage.checkoutCompletedPageTitle);
		String title = checkoutPage.getCheckoutCompletedPageTitle();
		Assert.assertEquals("Checkout: Complete!", title);
	}

}
