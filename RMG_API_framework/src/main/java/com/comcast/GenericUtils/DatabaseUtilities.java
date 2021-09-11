package com.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtilities 
{
	static Connection conn=null;
	/**
	 * this method will establish the connection with the database
	 * 
	 */
	public void connectToDb()
	{
		
		Driver driverRef;
		try
		{
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(IConstants.dbUrl, IConstants.dbUsername, IConstants.dbPassword);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * this method will close db connection
	 * @throws Throwable 
	 * 
	 */
	public void closeDB() throws Throwable
	{
		conn.close();
	}
	/**
	 * this method will help to verify the data in the database
	 * @throws Throwable 
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		Statement statement = conn.createStatement();
		 ResultSet result = statement.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			if (result.getString(columnIndex).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if (flag)
		{
			System.out.println(expData+" data verified in database");
			return expData;
		}
		else
		{
			System.out.println(expData+" data not verified");
			return expData;
		}
	}
}
