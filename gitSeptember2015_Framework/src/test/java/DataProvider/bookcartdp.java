package DataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import GenericLibraries.Xls_Reader;

public class bookcartdp {

	
	@DataProvider(name = "bookcartdptest")
	
	public static Object[][] bookcartdptest(){
		
		
		
		
		bookcartdp read = new bookcartdp();
		
		List<String> list = read.excelreader("A");
		Object[][] obj = new Object[list.size()][6];
		for(int i = 0 ; i<list.size();i++){
			
			
			
			 obj[i][0] = list.get(i).split(";")[0];
			 obj[i][1] = list.get(i).split(";")[1];
			 obj[i][2] = list.get(i).split(";")[2];
			 obj[i][3] = list.get(i).split(";")[3];
			 obj[i][4] = list.get(i).split(";")[4];
			 obj[i][5] = list.get(i).split(";")[5];
					
					
		
		}
		
		return obj;
		
		
		
		
	}
			
			
	
@DataProvider(name = "updatecart")
	
	public static Object[][] updatecart(){
		
		
		
		
		bookcartdp read = new bookcartdp();
		
		List<String> list = read.excelreader("U");
		Object[][] obj = new Object[list.size()][6];
		for(int i = 0 ; i<list.size();i++){
			
			
			
			 obj[i][0] = list.get(i).split(";")[0];
			 obj[i][1] = list.get(i).split(";")[1];
			 obj[i][2] = list.get(i).split(";")[2];
			 obj[i][3] = list.get(i).split(";")[3];
			 obj[i][4] = list.get(i).split(";")[4];
			 obj[i][5] = list.get(i).split(";")[5];
					
					
		
		}
		
		return obj;
}
		public List<String> excelreader(String key){
		
		//get excel
		Xls_Reader read = new Xls_Reader("C:\\Users\\RE041943\\Desktop\\information\\Training\\Framework\\Test_Data.xlsx");
		//read data and count
		
		int rowCount = read.getRowCount("Scenario_BookCart");
//		//get data and str in list later so create list
		
		List<String> arr = new ArrayList<String>();
		for(int i=2;i<=rowCount;i++){
			
			
			
			String status = read.getCellData("Scenario_BookCart", "Status", i);
			
			if(status.equals(key)){
				
				String TC_ID = read.getCellData("Scenario_BookCart", "TC_ID", i);
				String Uname = read.getCellData("Scenario_BookCart", "Uname", i);
				String Pwd = read.getCellData("Scenario_BookCart", "Pwd", i);
				String searchbook = read.getCellData("Scenario_BookCart", "Search_Book", i);
				String quantity = read.getCellData("Scenario_BookCart", "Quantity", i);
				String Exp_Res = read.getCellData("Scenario_BookCart", "Exp_Res", i);
				
				arr.add(TC_ID+";"+Uname+";"+Pwd+";"+searchbook+";"+quantity+";"+Exp_Res);
				
				
			}
			
					
			
		}
		
		return arr;
		
	
	
		}
}
