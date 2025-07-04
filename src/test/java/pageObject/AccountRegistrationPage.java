//lesson 48

package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class AccountRegistrationPage extends BasePage {
		
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80000));
	}
	
	

	
	//define components 
	@FindBy(xpath="//input[@id='username']")
	WebElement txtUserName;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement txtFirstName;

		
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement txtLastName;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement txtCountry;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='registerBtn']")
	WebElement btnRegisterBtn;
	
	
	

	//confirmation message
	@FindBy(xpath = "//div[@id='confirmation']")
	WebElement msgConfirmation;


	
	//add action method for every component
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setCountry(String country)
	{
		txtCountry.sendKeys(country);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickRegister()
	{
		btnRegisterBtn.click();
	}
	
	 public void checkConfirmationMessage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(msgConfirmation));

	        System.out.println("Element found: " + msgConfirmation.isDisplayed());
	        String actualMsg = msgConfirmation.getText().trim();
	        System.out.println("Confirmation message received: " + actualMsg);
	    }
	
	// will capture value of the message and return it 
	public String getConfirmationMsg()
	{
		try {
			return msgConfirmation.getText().trim();
		    } catch (Exception e)
		{
		    	return(e.getMessage());
			
		}
	}

	 

}
