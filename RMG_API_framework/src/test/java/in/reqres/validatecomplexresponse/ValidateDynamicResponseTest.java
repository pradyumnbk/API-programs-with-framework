package in.reqres.validatecomplexresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateDynamicResponseTest 
{
	@Test
	public void validateDynamicResponse()
	{
		baseURI="https://reqres.in";
		String expectedData = "Funke";
		String actualData=null;
		//GET THE RESOURCE FROM THE SERVER
		Response response=when()
				.get("/api/users?page=2");

		//VERIFICATION OF STATUS CODE
		response.then().log().all().statusCode(200);

		//CAPTURE THE RESPONSE FROM THE SERVER
		List<String> list=response.jsonPath().get("data.last_name");
		boolean flag=false;

		//ITTERATE THE LIST COLLECTION
		for (String data : list) 
		{
			if(data.equals(expectedData))
			{
				actualData=data;
				flag=true;
				break;
			}
		}

		//TESTNG ASSERTION TO VALIDATE ACTUAL AND EXPECTED DATA
		Assert.assertEquals(flag, true);
		System.out.println("actual data is : "+actualData);
		System.out.println("expected data is : "+expectedData);
		Assert.assertEquals(actualData, expectedData);
	}
}
