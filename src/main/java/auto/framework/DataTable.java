package auto.framework;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataTable {
	
	public static String getDataTableValue(int sheetNo, int rowNo, int columnNo) throws Exception{
		
		File src = new File(TestManager.getDataPath());
		FileInputStream fis = new FileInputStream(src);
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(sheetNo);
		String cellValue = sheet.getRow(rowNo).getCell(columnNo).getStringCellValue();

		return cellValue;
	}
		
}