package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	//this is constructor of all PO classes
	WebDriver driver;
	
	public BasePage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
