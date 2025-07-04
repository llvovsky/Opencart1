package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	
	
	@FindBy(xpath = "//button[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy (linkText = "Login")
	WebElement linkLogin;
	
	//define action elements 
	
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	public void clickRegister()
	{
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
		    System.out.println("Register is Displayed: " + lnkRegister.isDisplayed());
		    System.out.println("Register is Enabled: " + lnkRegister.isEnabled());
	}

	
	public void clickLogIn()
	{
		linkLogin.click();
	}
	

}
