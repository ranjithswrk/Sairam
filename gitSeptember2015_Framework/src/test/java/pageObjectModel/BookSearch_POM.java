package pageObjectModel;

import org.openqa.selenium.By;


import GenericLibraries.BrowserHandler;

public class BookSearch_POM extends BrowserHandler{	
		
				
		public void Entertext_Searchbox(String Search_Book)
		{
			driver.findElement(By.id("srchword")).sendKeys(Search_Book);
		}
		
		public void  Click_button_Searchbook()
		{
			driver.findElement(By.className("newsrchbtn")).click();
		}
		
		
		public String gettext_searchresult()
		{
			return driver.findElement(By.xpath(".//*[@id='find']")).getText();
		}
		
		public void Close_broswer()
		{
			driver.close();
		}
		
		public String gettext_Invalidsearchresult()
		{
			 return driver.findElement(By.xpath(".//*[@id='notify']/p")).getText();
		}
		
	

}
