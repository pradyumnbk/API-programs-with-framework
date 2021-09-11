package com.ty.rmg.projectsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.GenericUtils.BaseCls;
import com.comcast.GenericUtils.DatabaseUtilities;
import com.comcast.GenericUtils.EndPoint;
import com.comcast.GenericUtils.JavaUtility;
import com.comcast.GenericUtils.RestAssuredUtility;
import com.comcast.POJOClass.ProjectLibrary;
import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithCreatedStatusUsingDbValidationTest extends BaseCls
{
	@Test
	public void createProjectWithCreatedStatusUsingDbValidationTest()  throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		RestAssuredUtility rLib = new RestAssuredUtility();
		DatabaseUtilities dLib = new DatabaseUtilities();
		
		//create project with created status using pojo class
		ProjectLibrary projectLibrary = new ProjectLibrary("neha", "pentagon"+jLib.randomNumber(), "created", 20);
		
		Response response=given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)
		
		.when()
		.post(EndPoint.addProject);
		
		//capture the project id
		String firstProjectId = rLib.jsonPataConstant(response, "projectId");
		System.out.println(firstProjectId);
		//capture the project status
		String actStatus = rLib.jsonPataConstant(response, "status");
		System.out.println(actStatus);
		//verify the project id in the database
		String query = "select * from project";
		String expData = dLib.executeQueryAndGetData(query, 1, firstProjectId);
		String expStatus = dLib.executeQueryAndGetData(query, 5, actStatus);
	
		//validation
		Assert.assertEquals(firstProjectId, expData);
		Assert.assertEquals(actStatus, expStatus);
	}
}
