package TestCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.ADDPOM;
import pageObjectModel.Login_POM;




public class Testcases {
	
	
	@Test(dataProvider = "bookcartdptest" , dataProviderClass = DataProvider.bookcartdp.class)
	
	public void Add(String TC_ID, String Uname, String Pwd,String Search_Book , String Quantity,  String exp_result) throws Exception
	
	{
		
		
		System.out.println("data from excel :" + TC_ID+";"+Uname+";"+Pwd+";"+Search_Book+";"+Quantity+";"+exp_result);
		
		
		// CPM execute till click and see login pom there again gping browserhandler
		LoginTestcase login_component = new LoginTestcase();
		Login_POM loginpom = login_component.comm_component_login(Uname, Pwd);
		
		
		//browser is with loginpom but we are performing steps whih are in bookpom seeeee
	WebDriver driver = loginpom.getbrowser(); // browser given to driver , so write method in loginpom getbrowser
		ADDPOM book_pom = new ADDPOM();
		book_pom.Setbrowservalue(driver);
		book_pom.Entertext_Searchbox(Search_Book);
		System.out.println("book_pom");
		book_pom.Click_button_Searchbook();
		System.out.println("book_pomafter");
		book_pom.Click_img_firstbooksearch();
		
		book_pom.Click_button_BuyNow();
		
		String actual = book_pom.gettext_cartresult();
		AssertJUnit.assertEquals(actual, exp_result);
		System.out.println(actual);
		book_pom.Click_linktext_rediffcom();
		book_pom.Window_popup_handler();
		book_pom.Click_linktext_SignOut();
		      
		
		book_pom.Close_browser();
		 
		
		
		
	}
		
//@Test(dataProvider = "updatecart" , dataProviderClass = DataProvider.bookcartdp.class)
	
	public void Update(String TC_ID, String Uname, String Pwd,String Search_Book , String Quantity,  String exp_result) throws Exception
	
	{
		
		
		System.out.println("data from excel :" + TC_ID+";"+Uname+";"+Pwd+";"+Search_Book+";"+Quantity+";"+exp_result);
		
		
		// CPM execute till click and see login pom there again gping browserhandler
		LoginTestcase login_component = new LoginTestcase();
		Login_POM loginpom = login_component.comm_component_login(Uname, Pwd);
		
		
		//browser is with loginpom but we are performing steps whih are in bookpom seeeee
	WebDriver driver = loginpom.getbrowser(); // browser given to driver , so write method in loginpom getbrowser
		ADDPOM book_pom = new ADDPOM();
		book_pom.Setbrowservalue(driver);
		book_pom.Entertext_Searchbox(Search_Book);
		//System.out.println("book_pom");
		book_pom.Click_button_Searchbook();
		//System.out.println("book_pomafter");
		book_pom.Click_img_firstbooksearch();
		
		book_pom.Click_button_BuyNow();
		book_pom.setcart();
		
		String actual = book_pom.getcartresult();
		System.out.println(actual);
		AssertJUnit.assertEquals(actual, exp_result);
		book_pom.Click_linktext_rediffcom();
		book_pom.Window_popup_handler();
		book_pom.Click_linktext_SignOut();
		   book_pom.Close_browser();
		
		
		
		
	}
		
		
		
		
	}
	
	
	
	
	


