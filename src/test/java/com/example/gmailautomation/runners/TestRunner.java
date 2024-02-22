package com.example.gmailautomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

//import org.junit.runner.RunWith;
import com.example.gmailautomation.utils.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/SwagLabs.feature", glue = "com/example/gmailautomation/stepdefinitions",
tags = "@Smoke or @Sanity",
plugin = {"pretty",
          "junit:target/cucumber.xml",
          "html:target/cucumber.html",
          "json:target/cucumber.json"})
public class TestRunner {

	 @BeforeClass
	    public static void setUp() {
	        WebDriverManager.getWebDriver();
	    }

	    @AfterClass
	    public static void tearDown() {
	        WebDriverManager.quitWebDriver();
	    }
}
