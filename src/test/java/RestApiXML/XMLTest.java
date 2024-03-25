package RestApiXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLTest {
	
	@Test
	public void test()

	{
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.get();
		
		System.out.println("Response is " +response.body().asString());
		
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		
		System.out.println("All the Books are: " +books.toString());
		
		NodeChildrenImpl booksTag = response.then().extract().path("bookstore.book");
		
		for(int i=0; i<booksTag.size();i++)
		{
			System.out.println(booksTag.get(i).getAttribute("category"));
		}
		
		NodeChildrenImpl TitleTag = response.then().extract().path("bookstore.book.title");
		
		for(int i=0; i<TitleTag.size();i++)
		{
			System.out.println("The Language is " +TitleTag.get(i).getAttribute("lang"));
		}
	}

}
