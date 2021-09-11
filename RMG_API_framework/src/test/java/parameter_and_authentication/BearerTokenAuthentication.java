package parameter_and_authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerTokenAuthentication 
{
	@Test
	public void bearerToken()
	{
		HashMap<Object, Object> map = new HashMap<Object,Object>();
		map.put("name", "sdet18_restassured");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("https://api.github.com/user/repos")
		.then()
		.log().all()
		.assertThat().statusCode(201);
		
	}
}
