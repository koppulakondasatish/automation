package SatishProjects.RestAssuredProject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import ExcelUtilities.ExcelUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class Tests_GET {
	@Test
	public void test_1(){
		/*given().get("https://reqres.in/api/users?page=2").
			then().statusCode(200).body("data.first_name", hasItems("Michael","Lindsay"));*/
			
		HashMap<String,String> hp = new HashMap<String,String>(); 
	
		hp.put("name", "satish");
		hp.put("job", "tester");
		
		JSONObject object = new JSONObject(hp);
		System.out.println(object.toJSONString());
		
		given().
			body(object.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().statusCode(201).log().all();
			
		
		ExcelUtils el = new ExcelUtils("./data/testData.xlsx","Sheet1");
		String value =  el.excelUtilFuncs(1, 1);
		System.out.println(value);
		
		try {
			el.excel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
