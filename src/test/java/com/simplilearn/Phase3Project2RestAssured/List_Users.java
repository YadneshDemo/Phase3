package com.simplilearn.Phase3Project2RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class List_Users {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification  request = RestAssured.given();
		Response response = request.get();
		
		String responseBody = response.body().asString();
		
		System.out.println(responseBody);
		
		System.out.println("Response code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
	}

}
