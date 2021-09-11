package com.ty.rmg.projectsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class GetAllProjectAndDeleteUsingDbValidationTest 
{
	@Test
	public void getAllProjectAndDeleteUsingDbValidationTest() throws Throwable
	{
		
	
		baseURI="http://localhost";
		port=8084;
		
		Response response=when()
		.get("/projects");
		
		//capture the project id
		String singleProjectId = response.jsonPath().get("[2].projectId");
		System.out.println(singleProjectId);
		
		//capture the project status
		String projectstatus = response.jsonPath().get("[2].status");
		System.out.println(projectstatus);
		
		//verify the project id in the db
		
		//step 1: register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//step 2: get db connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		//step 3: issue create statement
		Statement statement = conn.createStatement();
		
		//step 4: execute query
		ResultSet result = statement.executeQuery("select * from project");
		String expData=null;
		String expStatus=null;
		while (result.next())
		{
			if (result.getString(1).equals(singleProjectId))
			{
				 expData = result.getString(1);
				 expStatus=result.getString(5);
				System.out.println("project id is successfully verified in the database");
				break;
			}
			
		}
		Assert.assertEquals(singleProjectId, expData);
		Assert.assertEquals(projectstatus, expStatus);
		
		//delete the project 
		given()
		.pathParam("projectid", singleProjectId)
		
		.when()
		.delete("/projects/{projectid}");
		
				while (result.next())
				{
					if (!(result.getString(1).equals(singleProjectId)))
					{
						 
						System.out.println("project is successfully deleted in the database");
						break;
					}	
					Assert.assertEquals(singleProjectId, expData);
		
				}
				//close the db connection
				conn.close();
	
}
}
