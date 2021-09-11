package com.comcast.CreateUsingPOJOClass;

import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojoTest 
{
	
	@Test
	public void createProject()
	{
		ProjectLibrary projectLibrary = new ProjectLibrary("pradyumn barik", "grind", "ongoing", 26);
		given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201);
		
		
	}
}
