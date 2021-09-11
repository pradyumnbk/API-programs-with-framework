package com.comcast.GenericUtils;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeSuite;

public class BaseCls 
{
		DatabaseUtilities dbUtils = new DatabaseUtilities();
		@BeforeSuite
		public void bsConfig()
		{
			baseURI="http://localhost";
			port=8084;
			
			dbUtils.connectToDb();
		}
		
		public void asConfig() throws Throwable
		{
			dbUtils.closeDB();
		}
	
}
