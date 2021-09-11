package crudoperation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_AllProjectRequest 
{
	@Test
	public void getAllProjects()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		String respbody = resp.asString();
		System.out.println(respbody);
		String prettyrespbody = resp.prettyPrint();
		System.out.println(prettyrespbody);
		int actstatuscode = resp.getStatusCode();
		System.out.println(actstatuscode);
		Assert.assertEquals(actstatuscode, 200);
		
		String actcontenttype = resp.getContentType();
		System.out.println(actcontenttype);
		Assert.assertEquals(actcontenttype, "application/json");
	}
}
