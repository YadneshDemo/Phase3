package RestAPIBDD;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIOperationsTest {
	@Test
	public void getOperation()
	{
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200);
		
	}
	
	@Test
	public void getOperationWithParams()
	{
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get("/d141")
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("firstName", Matchers.equalTo("Jasmin"))
		.body("salary", Matchers.equalTo(10000));
		
	}

	@Test
	public void getOperationWithQueryParams()
	{
		RestAssured.given()
		.queryParam("CUSTOMER_ID", 68195)
		.queryParam("PASSWORD", "1234!")
		.queryParam("Account_No", 1)
		.baseUri("https://demo.guru99.com/V4/sinkministatement.php")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200);
		
	}
	
	@Test
	public void PostOperationWithHashMap()
	{
		HashMap<String, String> obj = new HashMap<String, String>();
		
		obj.put("name", "Samuel");
		obj.put("salary", "7600");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(obj)
		.baseUri("http://localhost:3000/employees")
		.when()
		.post()
		.then()
		.log()
		.body()
		.statusCode(201);
		
	}
	
	@Test
	public void PutOperationWithQueryParameters()
	{
		HashMap<String, String> obj = new HashMap<String, String>();
		
		obj.put("name", "Samu");
		obj.put("salary", "7000");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(obj)
		.baseUri("http://localhost:3000/employees")
		.when()
		.put("/de12")
		.then()
		.log()
		.body()
		.statusCode(200);
		
	}
	
	@Test
	public void DeleteOperationWithQueryParameters()
	{
		
		RestAssured.given()
		.queryParam("id", "cc0c")
		.baseUri("http://localhost:3000/employees")
		.when()
		.delete()
		.then()
		.log()
		.body()
		.statusCode(404);
		
	}
}

