package methods;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_method {

	@Test
	public void test() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.get();
		ValidatableResponse validatableResponse = response.then();
		System.out.println(response.prettyPrint());
		validatableResponse.statusCode(200);

	}

	
	@Test
	// when it comes to rest assured we need to static import 2 packages 
	// import static io.restassured.RestAssured.given;
	// import static org.hamcrest.Matchers.equalTo;
	
	public void BDDTest()  {
		
		
	// here when we write the JSON path we don't use "x.data[0].email" we don't start with "." below we have started from "data[0].email"
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data[0].email", equalTo("michael.lawson@reqres.in"));
		
	//	Response response = given().when().get("https://reqres.in/api/users?page=2");
	//	System.out.println(response.jsonPath().get("$.page").toString());
	//	System.out.println(response.prettyPrint());
	}

}
