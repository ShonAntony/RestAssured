package methods;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

// to use the assertions we go about importing Hamcrest package with the Matchers class with multiple static methods like 
// example equals() etc ......

public class Assertion_Hamcrest {
	
	// to verify and assert on the string values in the JSON response
	// we have got 
	//equalTo(<value>)
	//equalToIgnoringCase(<value>)
	//equalToIgnoringWhiteSpace(<value>)
	//containsString(<values>)
	//startsWith(<values>)
	//endsWith(<value>)
	
	@Test
	public void testStrings() {
		// instead of having Matchers calls which is statically imported we have done a non static import and used the class names for using 
		// method for validation internally 
		ValidatableResponse response = RestAssured.given().baseUri("https://reqres.in/api").when().get("/users?page=2").then().body("data[0].first_name", Matchers.equalTo("Michael")).
															 body("data[0].first_name", Matchers.equalToIgnoringCase("michael")).
														//   body("", Matchers.equalToIgnoringWhiteSpace("")).
															 body("data[0].first_name", Matchers.containsString("Michael")).
															 body("data[0].first_name", Matchers.startsWith("M")).
															 body("data[0].first_name", Matchers.endsWith("l"));
		System.out.println(response.extract().asPrettyString());
	}
	
	// to verify and assert on the Numeric values in the JSON response
	// we have got 
	//equalTo()
	//greaterThan()
	//greaterThanOrEqualTo()
	//lessThan()
	//lessThanOrEqualTo()
	
	@Test
	public void testNumbers() {
		ValidatableResponse response = RestAssured.given().baseUri("https://reqres.in/api").when().get("/users?page=2").then().body("total", Matchers.equalTo(12)).
				 body("total", Matchers.greaterThan(6)).
				 body("total", Matchers.greaterThanOrEqualTo(5)).
				 body("total", Matchers.lessThan(15)).
				 body("total", Matchers.lessThanOrEqualTo(12));
	     System.out.println(response.extract().asPrettyString());
	}
	
	// to verify and assert that the JSON response is null or not 
	//is(nullValue())
	
	@Test
	public void testNull() {
			ValidatableResponse response = RestAssured.given().baseUri("https://reqres.in/api").when().get("/users?page=2").then().body("total", Matchers.is(Matchers.nullValue()));
	}
	
	// to verify and assert that if the JSON key has the same value 
	@Test
	public void testKeyValue() {
		RestAssured.given().baseUri("https://reqres.in/api").when().get("/users?page=2").then().body("total", Matchers.hasValue(12));
	}
	
	
	// to check the reverse of the things we are going to use not operator 
	@Test
	public void testNot() {
		RestAssured.given().baseUri("https://reqres.in/api").when().get("/users?page=2").then().body("total", not(Matchers.equalTo("13")));
	}
	
	
	// to combine more than one assertions under each API call
	@Test
	public void testCombinedAssertions() {
		RestAssured.given().baseUri("https://reqres.in/api").when().get("/users?page=2").then().body("data[0].id", Matchers.equalTo(7),
																"data[0].email",Matchers.equalTo("michael.lawson@reqres.in"),
																"data[0].first_name",Matchers.equalTo("Michael"),
																"data[0].last_name",Matchers.equalTo("Lawson"));
	}
	


	
}
