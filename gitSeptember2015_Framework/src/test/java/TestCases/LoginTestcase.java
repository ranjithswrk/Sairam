package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.Login_POM;

public class LoginTestcase {
	
	@Test(dataProvider = "DP_validlogin",dataProviderClass =DataProvider.DP_Login.class )
	public void valid_login(String TC_ID, String Uname, String Pwd, String exp_result) throws Exception
	{
		System.out.println(TC_ID +"   "+Uname+"  "+Pwd+ "   "+exp_result);
		
		/*Login_POM valid_pom = new Login_POM();
		valid_pom.setBrowser();
		valid_pom.setURL();
		valid_pom.Click_link_SignIn();
		valid_pom.EnterText_Username(Uname);
		valid_pom.EnterText_Pwd(Pwd);
		valid_pom.Click_button_login();*/
		
		LoginTestcase login_pom = new LoginTestcase();
		Login_POM valid_pom = login_pom.comm_component_login(Uname, Pwd);
		String actual = valid_pom.gettext_myprofile();
		Assert.assertEquals(actual, exp_result);
		valid_pom.Click_link_SignOut();
		valid_pom.Close_browser();
	}
	
	//*********************************************************
	//Common Process Component
	
	public Login_POM comm_component_login(String Uname, String Pwd) throws Exception
	{
		Login_POM pom = new Login_POM();
		pom.IntializeBrowser();
		pom.setURL();
		pom.Click_link_SignIn();
		pom.EnterText_Username(Uname);
		pom.EnterText_Pwd(Pwd);
		pom.Click_button_login();
		return pom;
	}
	
	//**********************************************************
	
	//@Test(dataProvider = "Invalid_Login_DP",dataProviderClass =DataProvider.DP_Login.class) 
	public void Invalid_login_Test(String TC_ID, String Uname, String Pwd, String exp_result) throws Exception
	{
		System.out.println(TC_ID +"   "+Uname+"  "+Pwd+ "   "+exp_result);
		
		/*Login_POM invalid_pom = new Login_POM();
		invalid_pom.setBrowser();
		invalid_pom.setURL();
		invalid_pom.Click_link_SignIn();
		invalid_pom.EnterText_Username(Uname);
		invalid_pom.EnterText_Pwd(Pwd);
		invalid_pom.Click_button_login();*/
		
		LoginTestcase invalidlogin = new LoginTestcase();
		Login_POM invalid_pom = invalidlogin.comm_component_login(Uname, Pwd);
		String actual = invalid_pom.gettext_Invalid_loginmessage();
		Assert.assertEquals(actual, exp_result);
		invalid_pom.Close_browser();
	}
}
