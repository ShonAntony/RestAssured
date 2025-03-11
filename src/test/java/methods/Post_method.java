package methods;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

// these are the most important static imports that needs to be given to work with the BDD style of scripting 
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Post_method {

	@Test
	public void BDDtest() {
		
		String json = "{\r\n"
				+ "    \"name\": \"Shon\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		given().baseUri("https://reqres.in/api").contentType(ContentType.JSON).body(json).when().post("/users").then().assertThat().statusCode(201)
		.body("name",  equalTo("Shon"),"job",equalTo("leader"));
		
		Response response = given().baseUri("https://reqres.in/api").contentType(ContentType.JSON).body(json).when().post("/users");
		System.out.println(response.prettyPrint());
	}
	
}
