package RestAPI;

import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification  request = RestAssured.given();
		Response response = request.get();
		
		String responseBody = response.body().asString();
		
		System.out.println(responseBody);
		
		System.out.println("Response code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		JsonPath json = response.jsonPath();
		List<String> actName = json.get("name");
		
		for(String name: actName)
		{
		System.out.println("Name is :" +name);
		}
		
		System.out.println("Second Name is :" +actName.get(1));
		System.out.println("Second Name is :" +actName.get(2));
		
		
	}

}
