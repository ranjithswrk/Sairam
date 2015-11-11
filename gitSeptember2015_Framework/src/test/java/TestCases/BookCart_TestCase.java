package TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookCart_TestCase {
	
	WebDriver driver ;
	
	String expected = null;
	
	
	@BeforeSuite
	
	public void suite(){
		System.setProperty("webdriver.chrome.driver", 
	            "C:\\Users\\RE041943\\Desktop\\information\\Training\\selenium\\Selenium Installers\\To_Work_with_chrome_broswer\\chromedriver.exe"); 
	 driver = new ChromeDriver();
	
		
		
	}
	
	
	@BeforeTest
	
	public void launch(){
	
	   
	 driver.get("http:\\www.newtours.demoaut.com/");
	 
	}
	
  @Test
  public void register() {
	  
	  
	  driver.findElement(By.linkText("REGISTER")).click();
	  
	  
	  expected = "Register: Mercury Tours";
	  
	 String actual =driver.getTitle();
	 
	 Assert.assertEquals(expected, actual);
	 
  }
  
  @Test
  
	 public void support() {
		 driver.findElement(By.linkText("SIGN-ON")).click();
		  expected = "Sign-on: Mercury Tours";
		  
		 String actual =driver.getTitle();
		 
		 Assert.assertEquals(expected, actual);
	 
	 
	 
	   }
  
  @BeforeMethod
	 
	 public void homepage() {
		 
		 expected = "Welcome: Mercury Tours";
		 
		 String actual =driver.getTitle();
		 
		 Assert.assertEquals(expected, actual);
		 
		 
		
	 }
  
  @AfterMethod
	 
	 public void gobackhomepage() {
		 
		 driver.findElement(By.linkText("Home")).click();
		 
	
		
	 }
  
  @AfterTest
  
  
  public void close(){
	  
	  driver.quit();
  }
}
