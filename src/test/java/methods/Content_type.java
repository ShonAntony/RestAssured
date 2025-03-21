package methods;

import java.io.File;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class Content_type {
	
	@Test
	public void contentTypeTest() {
		JSONObject data = new JSONObject();
        data.put("name", "William");
        data.put("job", "Manager");
		ValidatableResponse response = RestAssured.given().baseUri("https://reqres.in/").contentType(ContentType.JSON).body(data.toString()).when().post("api/users").then().assertThat().statusCode(201);
		System.out.println(response.extract().asPrettyString());
		
		JSONObject data1 = new JSONObject();
        data.put("name", "Shon");
        data.put("job", "Manager");
        ValidatableResponse response2 = RestAssured.given().header("Content-Type","application/json;charset=utf-8").baseUri("https://reqres.in/").body(data.toString()).when().post("api/users").then().assertThat().statusCode(201);
        System.out.println(response2.extract().asPrettyString());
	}

}
