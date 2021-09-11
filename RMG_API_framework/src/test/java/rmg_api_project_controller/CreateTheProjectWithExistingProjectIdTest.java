package rmg_api_project_controller;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateTheProjectWithExistingProjectIdTest 
{
	@Test
	public void createDuplicateProject()
	{
		baseURI="http://localhost";
		port=8084;

		//precondition to create the project
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "jishu");
		jobj.put("projectName", "uppit");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 42);

		given()
		.contentType(ContentType.JSON)
		.body(jobj)

		//action performed to create object
		.when()
		.post("/addProject")

		//post condition to create project
		.then()
		.log().all()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.assertThat().time(Matchers.lessThan(89L),TimeUnit.MILLISECONDS);
	}
}
