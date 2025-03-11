package methods;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class Post_method_using_Map {
	
	@Test
	public void BDDTest() {
		
		//Here i am just creating a simple map with the Key and value pairs kept as string

		
		Map< String, String> map = new HashMap<String, String>();
		map.put("name", "Shon");
		map.put("job", "tester");
		
		// here we are going to convert the map into string using toString() method 
		// before passing any object value into body we need to convert that JSON object into string
		ValidatableResponse response = RestAssured.given().
					                   body(map.toString()).
					                   when().
					                   post("https://reqres.in/api/users").
					                   then().assertThat().statusCode(201);
		
		System.out.println(response.extract().asPrettyString());
	
	
	
	}

}
