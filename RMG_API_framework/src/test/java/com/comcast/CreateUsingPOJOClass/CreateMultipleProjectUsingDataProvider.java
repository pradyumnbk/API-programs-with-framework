package com.comcast.CreateUsingPOJOClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateMultipleProjectUsingDataProvider 
{
	@Test(dataProvider = "getData")
	public void createMultipleProjects(String createdBy, String projectName, int teamSize)
	{
		baseURI="http://localhost";
		port=8084;
		ProjectLibrary projectLibrary = new ProjectLibrary(createdBy, projectName, "completed", teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)
		.when()
		.post("/addProject")
		.then()
		.log().all()
		.contentType(ContentType.JSON)
		.statusCode(201);
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[4][3];
		
		obj[0][0]="pradyumn";
		obj[0][1]="gstuff";
		obj[0][2]=20;
		
		obj[1][0]="guru";
		obj[1][1]="photon";
		obj[1][2]=27;
		
		obj[2][0]="rini";
		obj[2][1]="amdocs";
		obj[2][2]=28;
		
		obj[3][0]="payal";
		obj[3][1]="byjus";
		obj[3][2]=29;
		
		return obj;
		
	}
	
}
