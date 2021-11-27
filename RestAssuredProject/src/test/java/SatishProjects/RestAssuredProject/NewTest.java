package SatishProjects.RestAssuredProject;

import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class NewTest {
  @Test
  public void f() {
	  
	  
	  Response response = get("https://reqres.in/api/users?page=2");
	  
	  int statusCode = response.getStatusCode();
	  
	  Assert.assertEquals(statusCode, 200);
	  
	  System.out.println("Status Code : " + statusCode);
  }
  
  @Test
  void test_02(){
	  given().get("https://reqres.in/api/users?page=2")
  		.then().
  			statusCode(200).
  			body("data.id[0]", equalTo(7));
  }
}
