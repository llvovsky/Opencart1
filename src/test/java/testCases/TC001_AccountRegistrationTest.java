package testCases;


import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC001_AccountRegistrationTest extends BaseClass{
	
		
	@Test (groups = {"Regression", "Master"})
	public void verify_account_reqistration() {
	    logger.info("***Starting Test Case***");
	    try {
	        HomePage hp = new HomePage(driver);

	        logger.info("Clicked Register button");
	        hp.clickRegister();

	        AccountRegistrationPage arp = new AccountRegistrationPage(driver);

	        logger.info("Providing customer details..");
	        arp.setUserName("Providing customer user name");
	        Thread.sleep(1000);
	        arp.setFirstName("Providing customer first name");
	        Thread.sleep(1000);
	        arp.setLastName("Providing customer last name");
	        Thread.sleep(1000);
	        arp.setEmail("test@gmail.com");
	        Thread.sleep(1000);
	        arp.setCountry("Israel");
	        Thread.sleep(1000);
	        arp.setPassword("test");
	        Thread.sleep(1000);
	        arp.clickRegister();
	        Thread.sleep(1000);

	        logger.info("Validating expected message");
	        String confmes = arp.getConfirmationMsg();
	        System.out.println("Confirmation message received: " + confmes);
	        logger.info("Confirmation message received: " + confmes);

	        if ("Registration successful!".equals(confmes)) {
	            Assert.assertTrue(true);
	        } else {
	            logger.error("Test failed: Message does not match expected.");
	            Assert.fail("Expected 'Registration successful!' but got: " + confmes);
	        }

	    } catch (Exception e) {
	        logger.error("Test failed due to exception: " + e.getMessage(), e);
	        Assert.fail();
	    }

	    logger.info("***Finished Test Case***");
	    logger.info("Launching URL: " + p.getProperty("appURL"));

	   

	    
	   
	}
}
