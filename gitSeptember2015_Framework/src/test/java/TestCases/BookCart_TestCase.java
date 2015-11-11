package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.BookCart_POM;
import pageObjectModel.Login_POM;

public class BookCart_TestCase {
	
	@Test(dataProvider = "add_cart_DP",dataProviderClass=DataProvider.DP_BookCart.class)
	public void add2Cart(String TC_ID, String Uname,String Pwd, String Search_Book, String Quantity, String Exp_Res) throws Exception
	{
		System.out.println(TC_ID+";"+Uname+";"+Pwd+";"+Search_Book+";"+Quantity+";"+Exp_Res);
		LoginTestcase login_component = new LoginTestcase();
		Login_POM login_pom = login_component.comm_component_login(Uname, Pwd);
		WebDriver driver = login_pom.getbrowser();
		BookCart_POM book_pom = new BookCart_POM();
		book_pom.Setbrowservalue(driver);
		book_pom.Entertext_Searchbox(Search_Book);
		book_pom.Click_button_Searchbook();
		book_pom.Click_img_firstbooksearch();
		book_pom.Click_button_BuyNow();
		String actual = book_pom.gettext_cartresult();
		Assert.assertEquals(actual, Exp_Res);
		book_pom.Click_linktext_rediffcom();
		book_pom.Window_popup_handler();
		book_pom.Click_linktext_SignOut();
		book_pom.Close_browser();
	}
	@Test(dataProvider = "updatecart",dataProviderClass=DataProvider.DP_BookCart.class)
	public void updatecart(String TC_ID, String Uname,String Pwd, String Search_Book, String Quantity, String Exp_Res) throws Exception
	{
		System.out.println(TC_ID+";"+Uname+";"+Pwd+";"+Search_Book+";"+Quantity+";"+Exp_Res);
		LoginTestcase login_component = new LoginTestcase();
		Login_POM login_pom = login_component.comm_component_login(Uname, Pwd);
		WebDriver driver = login_pom.getbrowser();
		BookCart_POM book_pom = new BookCart_POM();
		book_pom.Setbrowservalue(driver);
		book_pom.Entertext_Searchbox(Search_Book);
		book_pom.Click_button_Searchbook();
		book_pom.Click_img_firstbooksearch();
		book_pom.Click_button_BuyNow();
		String actual = book_pom.gettext_cartresult();
		Assert.assertEquals(actual, Exp_Res);
		book_pom.Click_linktext_rediffcom();
		book_pom.Window_popup_handler();
		book_pom.Click_linktext_SignOut();
		book_pom.Close_browser();
	}

}
