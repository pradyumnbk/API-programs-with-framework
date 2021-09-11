package crudoperationusinghashmap;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashmap 
{
	@Test
	public void createproject()
	{

		HashMap map = new HashMap();
		map.put("createdBy", "pradyumn barik");
		map.put("projectName", "thunderbolt");
		map.put("status", "created");
		map.put("teamSize", 20);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
	}
}
