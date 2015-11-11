package GenericLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserHandler {
	
	public WebDriver driver = null;
	public void IntializeBrowser() throws Exception
	{
		String browsertype =ConfigfileHandler.Handle_configfile("browser");
		if(browsertype.equals("Firefox"))
		{
			driver  = new FirefoxDriver();
		}
		else if(browsertype.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ConfigfileHandler.Handle_configfile("ChromeDriverpath"));
			driver  = new ChromeDriver();
		}
		
		else if(browsertype.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", ConfigfileHandler.Handle_configfile("IEDriverpath"));
			driver  = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}	
	public void setURL()
	{
		driver.get("http://books.rediff.com/");	
	}

}
