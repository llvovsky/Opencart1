package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
//import utilities.DataProviders; 




/*Data is valid   - login success - test pass   - logout
Data is valid   -- login failed  - test fail

Data is invalid - login success - test fail   - logout
Data is invalid -- login failed  - test pass
*/


public class TC003_Login_DDT extends BaseClass{
	
	@Test (dataProvider = "LoginData"  /*, dataProviderClass = DataProviders.class */, groups = "Datadriven") //getting data provider
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		    logger.info("***Starting DDT***");
	        //home page
		    try
		    {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogIn();
			
			//log in page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//My Account Page 
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();
					
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if (targetpage == true)
				{
					Assert.assertTrue(true); //Data is valid   - login success - test pass   - logout
					macc.ClickLogout();
				}
				else
				{
					Assert.assertTrue(false); //Data is valid   -- login failed  - test fail
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			   {
				if (targetpage == true)
			     {
					macc.ClickLogout(); //Data is invalid - login success - test fail   - logout
			    	Assert.assertTrue(false); 
			     }
		     	else
		    	{
				   Assert.assertTrue(true); //Data is invalid -- login failed  - test pass
			    }
		     }
		    }
			catch (Exception e)
			{
				Assert.fail();
			}
			logger.info("***Finished DDT***");
	}

}
