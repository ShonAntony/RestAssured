package methods;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class BasicAuth {
	
	@Test
	public void basicAuth() {
		Response response = RestAssured.given().auth().basic("rmgyantra","rmgy@9999").when().get("http://49.249.29.6:8084/login");
		String stringRespose = response.asString();
		JsonPath jsonPath = new JsonPath(stringRespose);
		String jsonPathString = jsonPath.getString("jwtToken");
		System.out.println("JwtToken :"+jsonPathString);		
	}

}
