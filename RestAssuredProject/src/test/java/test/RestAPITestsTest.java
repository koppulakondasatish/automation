package test;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class RestAPITestsTest {

//  @Test
  void tc_get() {
	Response res = RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println("test" + res.asString());
	
	given().get("https://reqres.in/api/users?page=2").then().assertThat().body("data.email", hasItem("michael.lawson@reqres.in")).and().body("data.first_name", hasItem("Michael"));
	
  }
  
//  @Test
  void tc_post(){
	  HashMap<String,String> map = new HashMap();
	  map.put("name", "satish");
	  map.put("job", "test");
	  
	  JSONObject object = new JSONObject(map);
	  
	  given().body(object.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).assertThat();
  }
  
//  @Test
  void tc_put() {
	  HashMap<String,String> map = new HashMap();
	  map.put("name", "satish");
	  map.put("job", "test");

	given().put("https://reqres.in/api/users/2", map).then().statusCode(200).log();
	
  }
  
  @Test
  void whenMeasureResponseTime_thenOK() {
      Response response = RestAssured.get("https://reqres.in/api/users?page=2");
      long timeInMS = response.time();
      long timeInS = response.timeIn(TimeUnit.SECONDS);
      
     System.out.println("Time" + timeInMS);
     System.out.println("Time" + timeInS);
     
     when().get("https://reqres.in/api/users?page=2").then().time(lessThan(2000L));
  }
  
}
