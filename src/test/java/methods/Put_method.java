package methods;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Put_method {

	@Test
	public void BDDTest() {
		String json = "{\r\n"
				+ "    \"name\": \"Shon\",\r\n"
				+ "    \"job\": \"doctor\"\r\n"
				+ "}";
		ValidatableResponse response = given().baseUri("https://reqres.in/api").contentType(ContentType.JSON).body(json).when().put("/users/2").then().assertThat().
										statusCode(200).body("job", equalTo("doctor"));
		
		System.out.println(response.extract().asPrettyString());
		
		
	}
}
