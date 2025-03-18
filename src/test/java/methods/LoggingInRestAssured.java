package methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class LoggingInRestAssured {
	
	
	// the following method is used to to log the Request 
	/*
	 * given().log().params(). .. // Log only the parameters of the request
	 * given().log().body(). .. // Log only the request body
	 * given().log().headers(). .. // Log only the request headers
	 * given().log().cookies(). .. // Log only the request cookies
	 * given().log().method(). .. // Log only the request method
	 * given().log().path(). .. // Log only the request path
	 */
	@Test
	public void requestLogging() {
		File jsonFile = new File("./test data/test_json.json");
					
					//given
		RestAssured.given().log().all().
		            baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonFile).
		            //When
		            when().post("api/users").
		            //then 
		            then().assertThat().statusCode(201);
	}
	
	
	// the following method is used to to log the Response
	@Test
	public void responseLogging() {
		File jsonFile = new File("./test data/test_json.json");
		//given
        RestAssured.given().
        baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonFile).
        //When
        when().post("api/users").
        //then 
        then().log().all().
        assertThat().statusCode(201);
	}
	
	// the following method is used to log the conditional situations 
	@Test
	public void conditionalLogging() {
		File jsonFile = new File("./test data/test_json.json");
		//given
        RestAssured.given().
        baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonFile).
        //When
        when().post("api/users").
        //then 
        then().log().ifStatusCodeIsEqualTo(201).
        assertThat().statusCode(201);
	}
	
	// the following method is used to log the requests and into a file 
	@Test
	public void logOnTextFile() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
		
		File jsonFile = new File("./test data/test_json.json");
		//given
        RestAssured.given().
        baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonFile).
        filter(RequestLoggingFilter.logRequestTo(log)).
        filter(ResponseLoggingFilter.logResponseTo(log)).
        //When
        when().post("api/users").
        //then 
        then().
        assertThat().statusCode(201);	
	}
	
	
	
	
}
