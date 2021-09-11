package com.comcast.CreateUsingPOJOClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateDynamicResponseTest 
{
	@Test
	public void dynamicResponse()
	{
		baseURI="http://localhost";
		port=8084;
		String expectedData="pradyumn";
		String actualData=null;
		//getting the resource from the server
		Response response = when()
				.get("/projects");

		//verification of status code
		response.then().log().all().statusCode(200);

		//capture the specific data from response body
		List<String> list = response.jsonPath().get("createdBy");
		boolean flag=false;

		//Iterate the list collection 
		for (String data : list) 
		{
			if (data.equals(expectedData))
			{
				actualData=data;
				flag=true;
				break;
			}
		}

		//testng assertion for actual and expected response
		Assert.assertEquals(flag, true);
		System.out.println("actual data is : "+actualData);
		System.out.println("expected data is :"+expectedData);
		Assert.assertEquals(actualData, expectedData);		
	}
}
