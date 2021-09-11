package in.reqres.validatecomplexresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ValidateStaticResponseTest 
{
	@Test
	public void validateStaticResponse()
	{
		String expectedData="Edwards";
		baseURI="http://reqres.in";

		//get the response from the server
		Response response = when()
				.get("/api/users?page=2");

		//verification of status code
		response.then().log().all().statusCode(200);

		//capture the actual response
		String actualData = response.jsonPath().get("data[4].last_name");

		//print the actual and expected response
		System.out.println("actual data is :"+actualData);
		System.out.println("expectedData is :"+expectedData);

		//testng assertion for actual and expected response
		Assert.assertEquals(actualData, expectedData);
	}
}
