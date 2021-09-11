package crudoperationbdd;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.http.ContentType;

public class Get_AllProjectRequest 
{
	@Test
	public void getAllProjects()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.log().all()
		.and()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(500L), TimeUnit.SECONDS);
	}
}
