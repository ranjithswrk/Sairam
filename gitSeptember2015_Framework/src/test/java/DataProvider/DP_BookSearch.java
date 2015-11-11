package DataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import GenericLibraries.ConfigfileHandler;
import GenericLibraries.Xls_Reader;

public class DP_BookSearch {
	
	@DataProvider(name ="Valid_booksearch_DP")
	public static Object[][] DP_validbooksearch() throws Exception
	{
		DP_BookSearch valid_booksearch= new DP_BookSearch();
		List<String> list = valid_booksearch.excel_reader("P");
		Object[][] obj  = new Object[list.size()][3];
		for(int i=0; i<list.size();i++)
		{
			obj[i][0] = list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2] = list.get(i).split(";")[2];
		}
		
		return obj;
	}
	
	@DataProvider(name ="Invalid_booksearch_DP")
	public static Object[][] DP_invalidbooksearch() throws Exception
	{
		DP_BookSearch invalid_booksearch= new DP_BookSearch();
		List<String> list = invalid_booksearch.excel_reader("N");
		Object[][] obj  = new Object[list.size()][3];
		for(int i=0; i<list.size();i++)
		{
			obj[i][0] = list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2] = list.get(i).split(";")[2];
		}
		
		return obj;
	}
	
	public List<String> excel_reader(String key) throws Exception
	{
		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")+"\\"+ConfigfileHandler.Handle_configfile("xl_path"));
		int rowCount = xl.getRowCount("Scenario_BookSearch");
		//Object[][] obj = new Object[rowCount][];
		
		List<String> list = new ArrayList<String>();
		for(int i =2;i<=rowCount;i++)
		{
			String status = xl.getCellData("Scenario_BookSearch", "Status", i);
			if (status.equals(key))
			{
				
				
				String TC_ID = xl.getCellData("Scenario_BookSearch", "TC_ID", i);
				String Search_Book = xl.getCellData("Scenario_BookSearch", "Search_Book", i);
				String Exp_Count = xl.getCellData("Scenario_BookSearch", "Exp_Count", i);
				
				
				list.add(TC_ID+";"+Search_Book+";"+Exp_Count);
			}
		}
		return list;
	}

}
