package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ADDPOM  {

WebDriver driver = null;
	
	public void Setbrowservalue( WebDriver driver)
	{
		this.driver = driver;
	}
	public void Entertext_Searchbox(String Search_Book)
	{
		driver.findElement(By.id("srchword")).sendKeys(Search_Book);
	}
	
	public void  Click_button_Searchbook()
	{
		driver.findElement(By.className("newsrchbtn")).click();
	}
	
	public void Click_img_firstbooksearch()
	{
		driver.findElement(By.className("imgheight")).click();
	}
	
	public void Click_button_BuyNow()
	{
		driver.findElement(By.xpath(".//*[@id='myDataDiv']/div/div[1]/div[5]/a/div")).click();
	}
	
	public String gettext_cartresult()
	{
		return driver.findElement(By.cssSelector(".text_height > span:nth-child(2)")).getText();
	}
	
	public String getcartresult()
	{
		return driver.findElement(By.xpath(".//*[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]/input")).getText();
	}
	
	
	public void setcart()
	{
		 driver.findElement(By.xpath(".//*[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]/input")).sendKeys("4.0");;
	}
	
	public void Click_linktext_rediffcom()
	{
		driver.findElement(By.linkText("rediff.com")).click();
	}
	
	public void Window_popup_handler()
	{
		String parent = driver.getWindowHandle();
		if(driver.getWindowHandles().size()>1)
		{
			for(String x : driver.getWindowHandles())
			{
				if(!x.equalsIgnoreCase(parent))
				{
					driver.switchTo().window(x);
					driver.close();
				}
			}
		}
		driver.switchTo().window(parent);
	}
	
	public void Click_linktext_SignOut()
	{
		driver.findElement(By.linkText("Sign out")).click();
	}
	
	public void Close_browser()
	{
		driver.close();
	}
	
	
}



