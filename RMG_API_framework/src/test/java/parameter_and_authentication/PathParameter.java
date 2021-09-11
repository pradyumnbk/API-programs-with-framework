package parameter_and_authentication;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathParameter 
{
	@Test
	public void pathParam()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("projId", "TY_PROJ_426")
		.when()
		.delete("/projects/{projId}")
		.then()
		.log().all()
		.assertThat().statusCode(204)
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS);
	}
}
