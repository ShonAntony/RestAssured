package methods;

import java.io.File;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class JsonOrXmlFilePayload {
	
	@Test
	public void jsonPayload() {
		File jsonFile = new File("./test data/test_json.json");
		ValidatableResponse response = RestAssured.given().baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonFile).post("api/users").then().body("job", equalTo("Sike"));
		System.out.println(response.extract().asPrettyString());
	}

}
