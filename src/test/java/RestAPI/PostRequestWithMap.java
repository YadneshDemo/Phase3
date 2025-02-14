package RestAPI;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {

	@Test
	public void test()
	{	
		HashMap<String, String> obj = new HashMap<String, String>();
		
		obj.put("name", "Shreya");
		obj.put("salary", "9000");
	
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(obj)
									.post();
		
		System.out.println("The response code is :" +response.getStatusCode());
		System.out.println("The response body is :" +response.body().asString());
	}
	
}
