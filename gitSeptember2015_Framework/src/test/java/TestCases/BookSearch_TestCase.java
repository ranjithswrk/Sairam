package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.BookSearch_POM;

public class BookSearch_TestCase {
	
	@Test(dataProvider = "Valid_booksearch_DP" ,dataProviderClass =DataProvider.DP_BookSearch.class)
	public void valid_booksearch(String TC_ID ,String Search_Book , String Exp_Count) throws Exception
	{
		System.out.println(TC_ID+ "   "+Search_Book+"   "+Exp_Count);
		/*BookSearch_POM validbook = new BookSearch_POM();
		validbook.IntializeBrowser();
		validbook.setURL();
		validbook.Entertext_Searchbox(Search_Book);
		validbook.Click_button_Searchbook();*/
		BookSearch_TestCase validbook =  new BookSearch_TestCase();
		BookSearch_POM valid_book_pom = validbook.common_comp_booksearch(Search_Book);
		String actual = valid_book_pom.gettext_searchresult();
		Assert.assertEquals(actual, Exp_Count.replace(".0", ""));
		valid_book_pom.Close_broswer();
		
	}
	//*************************************************
	//Common process component
	
	public BookSearch_POM common_comp_booksearch(String Search_Book ) throws Exception
	{
		BookSearch_POM book_pom = new BookSearch_POM();
		book_pom.IntializeBrowser();
		book_pom.setURL();
		book_pom.Entertext_Searchbox(Search_Book);
		book_pom.Click_button_Searchbook();
		return book_pom;
	}
	
	//**********************************************
	@Test(dataProvider = "Invalid_booksearch_DP",dataProviderClass = DataProvider.DP_BookSearch.class)
	public void Invalid_booksearch(String TC_ID ,String Search_Book , String Exp_Count) throws Exception
		{
		System.out.println(TC_ID+ "   "+Search_Book+"   "+Exp_Count);
		/*BookSearch_POM invalidbook = new BookSearch_POM();
		invalidbook.IntializeBrowser();
		invalidbook.setURL();
		invalidbook.Entertext_Searchbox(Search_Book);
		invalidbook.Click_button_Searchbook();*/
		BookSearch_TestCase invalidbook =  new BookSearch_TestCase();
		BookSearch_POM invalid_book_pom = invalidbook.common_comp_booksearch(Search_Book);
		String actual = invalid_book_pom.gettext_Invalidsearchresult();
		Assert.assertEquals(actual, Exp_Count);
		invalid_book_pom.Close_broswer();
		}
}
