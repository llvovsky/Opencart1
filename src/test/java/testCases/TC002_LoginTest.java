package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;


//extend because the base class contains reusable methods
public class TC002_LoginTest extends BaseClass {  
	
	@Test (groups = {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("***Starting Login***");
		try
		{
		//home page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogIn();
		
		//log in page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Account Page 
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
				
		//Assert.assertEquals(targetpage, true, "Login failed");
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished LoginTest***");
	}

}
