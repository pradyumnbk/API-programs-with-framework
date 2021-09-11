package parameter_and_authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class QueryParameterTest
{
	@Test
	public void queryParam()
	{
		baseURI="https://reqres.in";
		
		given()
		.queryParam("page", 2)
		.when()
		.get("/api/users")
		.then()
		
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(1000L),TimeUnit.SECONDS)
		.log().all();
	}
}
