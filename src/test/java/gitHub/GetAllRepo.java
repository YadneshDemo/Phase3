package gitHub;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllRepo {
	
	
	@Test
	public void test()
	{
		RestAssured.baseURI = "https://api.github.com/users/YadneshDemo/repos";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		System.out.println("All the repos are " +response.body().asString());
		
	}

}
