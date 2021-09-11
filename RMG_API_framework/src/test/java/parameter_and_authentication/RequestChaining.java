package parameter_and_authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining 
{
	@Test
	public void requestChaining()
	{
		baseURI="http://localhost";
		port=8084;
		
		//get all the projects
		Response response=when()
		.get("/projects");
		
		//capture the project id
		String firstprojectid = response.jsonPath().get("[0].projectId");
		System.out.println(firstprojectid);
		
		//delete that project
		given()
		.pathParam("projectid", firstprojectid)
		.when()
		.delete("/projects/{projectid}")
		.then()
		.assertThat().statusCode(204)
		.log().all();

	}
}
