package methods;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Patch_method {
	
	@Test
	public void BDDTest() {
		String json ="{\r\n"
				+ "    \"name\": \"king kong\",\r\n"
				+ "    \"job\": \"sike\"\r\n"
				+ "}";
		ValidatableResponse response = given().baseUri("https://reqres.in/api").contentType(ContentType.JSON).body(json).when().patch("/users/2").then().assertThat().
		statusCode(200);
		
		System.out.println(response.extract().asPrettyString());
		
	}

}
