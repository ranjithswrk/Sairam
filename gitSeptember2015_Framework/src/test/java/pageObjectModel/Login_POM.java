package pageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import GenericLibraries.BrowserHandler;



public class Login_POM extends BrowserHandler{
		
	
	
	public void Click_link_SignIn()
	{
		driver.findElement(By.linkText("Sign In")).click();
	}
	public void EnterText_Username(String Uname)
	{
		driver.findElement(By.name("logid")).sendKeys(Uname);
	}
	
	public void EnterText_Pwd(String Pwd)
	{
		driver.findElement(By.name("pswd")).sendKeys(Pwd);
	}
	
	public void Click_button_login()
	{
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[6]/td[2]/input")).click();
	}
	
	public String gettext_myprofile()
	{
		return driver.findElement(By.xpath("//a[@href='http://mypage.rediff.com/profile/myprofile']")).getText();
	}
	
	public void Click_link_SignOut()
	{
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	
	public String gettext_Invalid_loginmessage()
	{
		return driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table[1]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/font/b")).getText();
	}
	public void Close_browser()
	{		
		driver.close();
	}
	
	public WebDriver getbrowser()
	{
		return driver;
	}
	

}
