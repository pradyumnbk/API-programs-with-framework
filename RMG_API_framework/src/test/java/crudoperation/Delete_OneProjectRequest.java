package crudoperation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_OneProjectRequest 
{
	@Test
	public void deleteAllProjects()
	{
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_425");
		String respbody = resp.asString();
		System.out.println(respbody);
		String prettyrespbody = resp.prettyPrint();
		System.out.println(prettyrespbody);
		int actstatuscode = resp.getStatusCode();
		System.out.println(actstatuscode);
		Assert.assertEquals(actstatuscode, 204);
		
		String actcontenttype = resp.getContentType();
		System.out.println(actcontenttype);
		Assert.assertEquals(actcontenttype, "application/json");
	}
}
