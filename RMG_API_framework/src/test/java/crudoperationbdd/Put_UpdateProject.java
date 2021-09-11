package crudoperationbdd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Put_UpdateProject 
{
	@Test
	public void createProject()
	{
		JSONObject jobject=new JSONObject();
		jobject.put("createdBy", "barik");
		jobject.put("projectName", "sprinster963");
		jobject.put("status", "going on");
		jobject.put("teamSize", 220);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobject)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_804")
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
		
	}
}
