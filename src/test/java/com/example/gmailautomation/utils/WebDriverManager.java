package com.example.gmailautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

	private static WebDriver driver;

	private WebDriverManager() {
		// Private constructor to prevent instantiation
	}

	public static WebDriver getWebDriver() {
		if (driver == null) {
			initializeWebDriver();
		}
		return driver;
	}

	private static void initializeWebDriver() {
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\appal\\eclipse-workspace\\TestProject\\src\\test\\resources\\drivers\\chromedriver.exe");
		System.out.println("*************Chrome Driver launched *****************");
		// Configure Chrome options if needed
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless"); // Uncomment if running headless

		// Initialize the ChromeDriver
		// driver = new ChromeDriver(options);
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();
		System.out.println("*************Chrome Driver Maximized *****************");

	}

	public static WebElement waitForElementVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void quitWebDriver() {
		if (driver != null) {
			driver.quit();
			driver = null; // Set to null after quitting to avoid reuse
		}
	}

	public static Select getSelectDropdownOptions(WebElement element) {
		// Wait for the selectDropdown to be visible
		//WebElement element = WebDriverManager.waitForElementVisible(locator);
		Select selectDropdownOptions = new Select(element);
		return selectDropdownOptions;
	}
}
