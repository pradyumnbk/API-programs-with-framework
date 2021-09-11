package crudoperationusinghashmap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUsingJsonFile 
{
	@Test
	public void createProjectUsingJsonFile()
	{
		File file = new File("./Sample.json");
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("http://localhost:8084/projects/TY_PROJ_1203")
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON);
		
	}
}
