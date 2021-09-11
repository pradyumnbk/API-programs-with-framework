package parameter_and_authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RequestChainingCreateDelete 
{
	@Test
	public void createDelete()
	{
		baseURI="http://localhost";
		port=8084;
		
		//precondition to create the project
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("createdBy", "pranay1");
		map.put("projectName", "sifflerind2");
		map.put("status", "completed");
		map.put("teamSize", 531);
		
		//create one project
		Response response=given()
		.contentType(ContentType.JSON)
		.body(map)
		
		//capture the project id
		.when()
		.post("/addProject");
		String createProject = response.jsonPath().get("projectId");
		System.out.println(createProject);
		
		//delete the project using project id
		given()
		.pathParam("projectid", createProject)
		.when()
		.delete("/projects/{projectid}")
		.then()
		.log().all()
		.assertThat().statusCode(204)
		.assertThat().time(Matchers.lessThan(600L),TimeUnit.SECONDS);
		
	}
}
