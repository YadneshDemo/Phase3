package gitHub;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {
	

	@Test
	public void test()
	{
		
		RestAssured.baseURI = "https://api.github.com/repos/YadneshDemo/RestAssuredRepo2024";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.auth().oauth2("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")
										.delete();
		
		System.out.println("The response code is :" +response.getStatusCode());
		System.out.println("The response body is :" +response.body().asString());
	}


}
