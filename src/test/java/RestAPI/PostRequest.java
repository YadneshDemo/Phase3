package RestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
 import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void test()
	{	
	
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body("{\r\n"
											+ "    \"firstName\": \"Jasmin\",\r\n"
											+ "    \"lastName\": \"Hill\",\r\n"
											+ "    \"salary\": 10000,\r\n"
											+ "    \"email\": \"Jasmin@gmail.com\"\r\n"
											+ "}")
									.post();
		
		System.out.println("The response code is :" +response.getStatusCode());
		System.out.println("The response body is :" +response.body().asString());
	}

}
