package crudoperationbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Post_CreateProject 
{
	@Test
	public void createProject()
	{
		JSONObject jobject=new JSONObject();
		jobject.put("createdBy", "barik");
		jobject.put("projectName", "sprinster");
		jobject.put("status", "going on");
		jobject.put("teamSize", 220);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobject)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
	}
}
