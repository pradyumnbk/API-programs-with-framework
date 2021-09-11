package crudoperationbdd;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Delete_OneProjectRequest 
{
	@Test
	public void deleteAllProjects()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_804")
		.then()
		.log().all()
		.and()
		.assertThat().statusCode(204)
		.and()
		.assertThat().contentType(ContentType.JSON);
	}
}
