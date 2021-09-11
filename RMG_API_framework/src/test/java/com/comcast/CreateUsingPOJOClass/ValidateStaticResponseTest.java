package com.comcast.CreateUsingPOJOClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ValidateStaticResponseTest 
{
	@Test
	public void validateStaticTesponse()
	{
		baseURI="http://localhost";
		port=8084;
		//expected data initialization
		String expectedData="photon";

		//getting the resource from the server
		Response response = when()
				.get("/projects");

		//verification of status code
		response.then().log().all().statusCode(200);

		//capture the specific data from response body
		String actualData = response.jsonPath().get("[17].projectName");


		System.out.println("actual data is : "+actualData);
		System.out.println("expected data is : "+expectedData);

		//testng assertion for actual and expected data
		Assert.assertEquals(actualData, expectedData);

	}
}
