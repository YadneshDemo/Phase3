package RestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	@Test
	public void test()
	{
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.delete("/37a5");
		
		System.out.println("The response code is :" +response.getStatusCode());
		System.out.println("The response body is :" +response.body().asString());
	}

}
