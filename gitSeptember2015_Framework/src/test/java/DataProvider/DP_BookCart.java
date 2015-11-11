package DataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import GenericLibraries.ConfigfileHandler;
import GenericLibraries.Xls_Reader;

public class DP_BookCart {
	
	@DataProvider(name ="add_cart_DP")
	public static Object[][] DP_addcart() throws Exception
	{
		DP_BookCart addcart= new DP_BookCart();
		List<String> list = addcart.excel_reader("A");
		Object[][] obj  = new Object[list.size()][6];
		for(int i=0; i<list.size();i++)
		{
			obj[i][0] = list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2] = list.get(i).split(";")[2];
			obj[i][3] = list.get(i).split(";")[3];
			obj[i][4] = list.get(i).split(";")[4];
			obj[i][5] = list.get(i).split(";")[5];
		}
		
		return obj;
	}
	
	
	
	public List<String> excel_reader(String key) throws Exception
	{
		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")+"\\"+ConfigfileHandler.Handle_configfile("xl_path"));
		int rowCount = xl.getRowCount("Scenario_BookCart");
		//Object[][] obj = new Object[rowCount][];
		
		List<String> list = new ArrayList<String>();
		for(int i =2;i<=rowCount;i++)
		{
			String status = xl.getCellData("Scenario_BookCart", "Status", i);
			if (status.equals(key))
			{
				
				
				String TC_ID = xl.getCellData("Scenario_BookCart", "TC_ID", i);
				String Uname = xl.getCellData("Scenario_BookCart", "Uname", i);
				String Pwd = xl.getCellData("Scenario_BookCart", "Pwd", i);
				String Search_Book = xl.getCellData("Scenario_BookCart", "Search_Book", i);
				String Quantity = xl.getCellData("Scenario_BookCart", "Quantity", i);
				String Exp_Res = xl.getCellData("Scenario_BookCart", "Exp_Res", i);
				
				list.add(TC_ID+";"+Uname+";"+Pwd+";"+Search_Book+";"+Quantity+";"+Exp_Res);
			}
		}
		return list;
	}

}
