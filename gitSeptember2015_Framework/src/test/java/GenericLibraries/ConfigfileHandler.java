package GenericLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigfileHandler {
	
	public static void main(String[] args) throws Exception {
		String handle_configfile = Handle_configfile("browser");
		System.out.println(handle_configfile);
	}
	
	public static String Handle_configfile(String key) throws Exception
	{
		File f = new File("C:\\Users\\RE041943\\Desktop\\information\\Training\\Framework\\Config.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		//System.out.println(prop.getProperty("xl_path"));
		return prop.getProperty(key);
	}

}
