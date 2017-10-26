package auto.framework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigProvider {
	
	public static String getDriverPath() throws Exception{
		
		return TestManager.getChromeDriverPath();

	}

}
