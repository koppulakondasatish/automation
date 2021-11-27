package ExcelUtilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFWorkbook excel;
	public static XSSFSheet sheet;
	
	public ExcelUtils(String sheetPath,String sheetName){
		try{
			excel = new XSSFWorkbook(sheetPath);//"./data/testData.xlsx");
			sheet = excel.getSheet(sheetName); //"Sheet1");
		}catch(Exception e){
			
		}
	}
	
	public static String excelUtilFuncs(Integer row,Integer col){
		try{
			DataFormatter df = new DataFormatter();
			Object value = df.formatCellValue(sheet.getRow(row).getCell(col));
			return value.toString();
		}
		catch(Exception e){
			return "nothing";
		}
	} 
}
