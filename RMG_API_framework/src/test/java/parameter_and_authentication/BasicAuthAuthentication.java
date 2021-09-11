package parameter_and_authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthAuthentication 
{
	@Test
	public void basicAuth()
	{
		baseURI="http://localhost";
		port=8084;
		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then()
		.log().all()
		.assertThat().statusCode(202);
	}
}
