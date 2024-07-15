package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public abstract class Utilities {

	public static String getProperties(String env, String keyValue) 
	{
		String value = "";
		try 
		{
			Properties properties = new Properties();
			properties.load(new FileInputStream(env));
			value = properties.getProperty(keyValue);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static String getExcelData(String path, String sh, int r, int c) {
		
		String getExcelValue = "";
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			getExcelValue = wb.getSheet(sh).getRow(r).getCell(c).toString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return getExcelValue;	
	}
}
