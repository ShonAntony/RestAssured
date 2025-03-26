package methods;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Response_Time_validation {
	//get time we have a method getTime()
	//get the time in specific time unit getTimeIn()
	//to compare the time we have time()
	//to compare the time in timeIn()
	
	@Test
	public void timeTest() {
		//less than using the matchers
		RestAssured.given().when().get("https://reqres.in/api/users/2").then().statusCode(200).time(Matchers.lessThan(3000L));
		//greater than using matchers
		RestAssured.given().when().get("https://reqres.in/api/users/2").then().statusCode(200).time(Matchers.greaterThan(50L));
		//if we want to compare the range of values to be noted 
		RestAssured.given().when().get("https://reqres.in/api/users/2").then().statusCode(200).time(Matchers.both(Matchers.greaterThanOrEqualTo(100L)).and(Matchers.lessThanOrEqualTo(3000L)));
		
	}

}
