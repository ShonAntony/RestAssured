package methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class LogMultipleTestsIntoOneFile {
	
	
	
	public PrintStream log;
	RequestLoggingFilter reqFil;
	ResponseLoggingFilter  resFil;
	
    //  the following method is used to log the requests and into a file for multiple tests
	@BeforeTest
	public void testFilter() throws FileNotFoundException {
		log = new PrintStream(new FileOutputStream("test.txt"));
		reqFil = new RequestLoggingFilter(log);
		resFil = new ResponseLoggingFilter(log);
	}

	@Test
	public void test1() {
		File jsonFile = new File("./test data/test_json.json");
		System.out.println("this is the first test");
		//given
        RestAssured.given().
        baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonFile).filters(reqFil,resFil).
        //When
        when().post("api/users").
        //then 
        then().
        assertThat().statusCode(201);
        System.out.println("===================================================================");
	}

	@Test
	public void test2() {
		String jsonPath = "{\r\n"
				+ "    \"name\": \"Anto\",\r\n"
				+ "    \"job\": \"Test\"\r\n"
				+ "}";
		System.out.println("this is the second test");
		//given
        RestAssured.given().
        filters(reqFil,resFil).
        baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonPath).
        //When
        when().post("api/users").
        //then 
        then().
        assertThat().statusCode(201);
        System.out.println("===================================================================");
        
	}

	@Test
	public void test3() {
		String jsonPath = "{\r\n"
				+ "    \"name\": \"King\",\r\n"
				+ "    \"job\": \"tester\"\r\n"
				+ "}";
		System.out.println("this is the third test");
		//given
        RestAssured.given().
        filters(reqFil,resFil).
        baseUri("https://reqres.in/").contentType(ContentType.JSON).body(jsonPath).
        //When
        when().post("api/users").
        //then 
        then().
        assertThat().statusCode(201);
        System.out.println("===================================================================");

	}
	
	
	

}
