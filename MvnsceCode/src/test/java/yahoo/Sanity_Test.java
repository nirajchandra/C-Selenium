package yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Sanity_Test 
{
	{
		 System.setProperty("atu.reporter.config", "C:\\Selenium\\workspace\\first\\atu.properties");
	}
    WebDriver driver;
	@Test
	@Parameters({"browser"})
	public void sanitytest(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
			driver=new FirefoxDriver();			
		}
		if(br.matches("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		Home h=new Home(driver);
		h.validate_links();
		h.createacc();
		h.login();
			
		Compose c=new Compose(driver);
		c.signout();
		
	}
}
