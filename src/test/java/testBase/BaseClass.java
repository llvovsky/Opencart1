// keep all reusable methods 
package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//import com.beust.jcommander.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters; // ✅ Add this

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass (groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//Loading config.properties file
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equals("remote"))
		{
			    DesiredCapabilities cap = new DesiredCapabilities();

			    //os
			    if(os.equalsIgnoreCase("windows"))
			    {
			    	 cap.setPlatform(Platform.WIN11); 
				     		    	
			    }
			    else if (os.equalsIgnoreCase("linux"))
			    {
			    	cap.setPlatform(Platform.LINUX);
			    }
			    else if (os.equalsIgnoreCase("mac"))
			    {
			    	cap.setPlatform(Platform.MAC);
			    }
			    else
			    {
			    	System.out.println("No matching os");
			    	return;
			    }
			    
			    //browser
			    switch (br.toLowerCase())
			    {
			    case "chrome": cap.setBrowserName("chrome"); break;
			    case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			    case "firefox": cap.setBrowserName("firefox"); break;
			    default: System.out.println("No matching browser"); return;
			    }
			    
			    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}
		
		if(p.getProperty("execution_env").equals("local"))
		{
			switch(br.toLowerCase())
			{
			   case "chrome":
				   WebDriverManager.chromedriver().setup();
				   driver = new ChromeDriver();
				   break;
			   
			   case "edge":
				   WebDriverManager.edgedriver().setup();
				   driver = new EdgeDriver();
				   break;
			   default:
				   logger.error("Invalid browser name provided: " + br);
			       throw new IllegalArgumentException("Unsupported browser: " + br);
			}
		        
		}
		
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get(p.getProperty("appURL")); // reading from properties file 
		//driver.get("https://tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
		
	}
	
	@AfterClass (groups = {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	//for email generation 
		public String randomString()
		{
			String generatedstring = RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
		}


}
