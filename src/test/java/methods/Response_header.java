package methods;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Response_header {
	
	@Test
	public void headerTest() {
		RestAssured.given().when().baseUri("https://reqres.in/api").get("/users?page=2").then().statusCode(200).header("Content-Type" , "application/json; charset=utf-8")
        .header("Content-Encoding" , "gzip");

	}

}
