package methods;

import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;


public class Post_using_JSON_object {
		
	
	// here we need to use a JSON object creation dependency that is JSON from MVN repo
	/*
	 * <!-- https://mvnrepository.com/artifact/org.json/json --> 
	 * <dependency>
	 * <groupId>org.json</groupId> <artifactId>json</artifactId>
	 * <version>20240303</version> 
	 * </dependency>
	 */
	
	@Test
	public void BDDtest() {
		// we need to create a new JSON object 
		JSONObject object = new JSONObject();
		
		object.put("name", "test");
		object.put("job", "test 101");
		System.out.println(object.toString());
		
		ValidatableResponse response = RestAssured.given().body(object.toString()).when().post("https://reqres.in/api/users").then().assertThat().
		statusCode(201);
		
		System.out.println(response.extract().asPrettyString());
	
	}
}
