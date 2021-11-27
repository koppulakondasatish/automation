package ExcelUtilities;

public class ExcelUtilsTests {

	public static void main(String[] args){
		ExcelUtils utils = new ExcelUtils("./data/testData.xlsx","Sheet1");
		String finalValue = utils.excelUtilFuncs(2,1);
		System.out.println(finalValue);
	}
}
