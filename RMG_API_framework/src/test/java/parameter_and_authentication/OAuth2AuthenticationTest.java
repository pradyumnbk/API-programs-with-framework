package parameter_and_authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class OAuth2AuthenticationTest 
{
	@Test
	public void oauth2()
	{
		//provide the client id and client secret to generate the token
		  Response resp = given()
		.formParam("client_id", "SDET18")
		.formParam("client_secret", "0cb5b5e3ef6c2287f3248e3fc6dfd599")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "client_credentials")
		
		//generate the token
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp.prettyPrint());
		 String myToken = resp.jsonPath().get("access_token");
		 System.out.println(myToken);
		/* 
		 //use this token in any API
		 given()
		 .auth()
		 .oauth2(myToken)
		 .pathParam("USER_ID", "2099")
		 .when()
		 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		 .then()
		 .log().all()
		 .assertThat().statusCode(200);
		 
		 
		 
		 given()
		 .auth()
		 .oauth2(myToken)
		 .pathParam("USER_ID", "2099")
		 .when()
		 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		 
		 .then()
		 .log().all()
		 .assertThat().contentType(ContentType.JSON)
		 .assertThat().statusCode(200);
		 */
		 
	
		 
		
		
	}
	
}
