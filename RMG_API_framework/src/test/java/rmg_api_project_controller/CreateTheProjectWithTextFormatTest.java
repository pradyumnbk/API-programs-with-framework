package rmg_api_project_controller;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateTheProjectWithTextFormatTest 
{
	@Test
	public void createProjectWithTextFormat()
	{
		baseURI="http://localhost";
		port=8084;

		//precondition to create the project
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "jishu1");
		jobj.put("projectName", "uppit2");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 42);

		given()
		.contentType("application/x-www-form-urlencoded;charset=UTF-8")
		.accept("application/json, text/plain, */*")
		.body(jobj)

		//action performed to create object
		.when()
		.post("/addProject")

		//post condition to create project
		.then()
		.log().all()
		.assertThat().contentType(ContentType.TEXT)
		.assertThat().statusCode(201)
		.assertThat().time(Matchers.lessThan(20L),TimeUnit.MILLISECONDS);
	}
}
