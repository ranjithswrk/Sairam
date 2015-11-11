package DataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import GenericLibraries.ConfigfileHandler;
import GenericLibraries.Xls_Reader;

public class DP_Login {
	
	@DataProvider(name ="DP_validlogin")
	public static Object[][] validlogin_DP() throws Exception
	{	
		DP_Login login = new DP_Login();
		List<String> list = login.excel_reader("P");
		Object[][] obj = new Object[list.size()][4];
		for(int i= 0; i<list.size();i++)
		{
			obj[i][0] = list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2] = list.get(i).split(";")[2];
			obj[i][3] = list.get(i).split(";")[3];
		}
		
		
		return obj;
	}
	
	@DataProvider(name="Invalid_Login_DP")
	public static Object[][] DP_Invalidlogin() throws Exception
	{
		DP_Login invalidlogin = new DP_Login();
		List<String> list = invalidlogin.excel_reader("N");
		Object[][] obj = new Object[list.size()][4];
		for(int i=0;i<list.size();i++)
		{
			obj[i][0] = list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2] = list.get(i).split(";")[2];
			obj[i][3] = list.get(i).split(";")[3];
		}
		return obj;
		
	}
	
	public List<String> excel_reader(String key) throws Exception
	{
		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")+"\\"+ConfigfileHandler.Handle_configfile("xl_path"));
		int rowCount = xl.getRowCount("Scenario_Login");
		//Object[][] obj = new Object[rowCount][];
		
		List<String> list = new ArrayList<String>();
		for(int i =2;i<=rowCount;i++)
		{
			String status = xl.getCellData("Scenario_Login", "Status", i);
			if (status.equals(key))
			{
				
				
				String TC_ID = xl.getCellData("Scenario_Login", "TC_ID", i);
				String Uname = xl.getCellData("Scenario_Login", "Uname", i);
				String Pwd = xl.getCellData("Scenario_Login", "Pwd", i);
				String Exp_Res = xl.getCellData("Scenario_Login", "Exp_Res", i);
				
				list.add(TC_ID+";"+Uname+";"+Pwd+";"+Exp_Res);
			}
		}
		return list;
	}

}
