package com.comcast.GenericUtils;

import io.restassured.response.Response;

/**
 * rest assured specific generic methods
 * @author PRADYUMN
 *
 */
public class RestAssuredUtility 
{
	/**
	 * returns json data with respect to json path
	 * @param response
	 * @param jsonXpath
	 */
	public String jsonPataConstant(Response response, String jsonXpath)
	{
		String jsonData = response.jsonPath().get(jsonXpath);
		return jsonData;
	}
}
