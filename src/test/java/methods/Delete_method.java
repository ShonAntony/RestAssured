package methods;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Delete_method {
	
	@Test
	public void BDDTest() {
		ValidatableResponse response = given().baseUri("https://reqres.in/api").contentType(ContentType.JSON).when().delete("/users/2").then().assertThat().statusCode(204);
		
		System.out.println(response.extract().asPrettyString());
	}
	
}
