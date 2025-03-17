package methods;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;


//we are using the Jayway dependency to help write the json path 

// we have got multiple types of filters that can be used by writing the Json expression
// Link  - https://qaautomation.expert/2021/06/16/extraction-from-json-in-rest-assured/

public class JsonPathUtility {
	
	@Test
	public void jsonPath() {
		Response response = RestAssured.given().baseUri("https://reqres.in/api").when().get("/users?page=2");
		System.out.println("=================================================");
		System.out.println(response.asPrettyString());
		String stringResponse = response.asPrettyString();
		
		// using jsonpath expression handling to capture the required elements  
		String micID = JsonPath.read(stringResponse, "$.data[?(@.first_name=='Michael')].id").toString();
		System.out.println("=================================================");
		System.out.println(micID);
		
		// this is just the regex model to identify the correct value with the key 
		System.out.println("=================================================");
		String test= JsonPath.read(stringResponse, "$.data[?(@.first_name=~/.*ael/i)].email").toString();
		System.out.println(test);
	}
	

}
