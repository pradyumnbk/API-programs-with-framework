package crudoperation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
		
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobject);
		Response resp = reqspec.post("http://localhost:8084/addProject");
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.getStatusCode(), 201);
		
	}
}
