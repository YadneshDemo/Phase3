package gitHub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {
	
	@Test
	public void test() throws IOException
	{
		byte[] file = Files.readAllBytes(Paths.get("data.json"));
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.auth().oauth2("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")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(file)
				.post();
		
		System.out.println("THe response is " +response.body().asString());
		System.out.println("THe status code is " +response.statusCode());
	}

}
