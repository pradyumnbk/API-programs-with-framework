package parameter_and_authentication;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProjectAndAllocateUserRequestChainingTest 
{
	@Test
	public void createProjectAndAllocateUser()
	{
		baseURI="http://localhost";
		port=8084;

		//precondition to create the project
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "harshii");
		jobj.put("projectName", "hamster9");
		jobj.put("status", "completed");
		jobj.put("teamSize", 47);

		//create one project
		Response response=given()
				.contentType(ContentType.JSON)
				.body(jobj)

				//capture the project name
				.when()
				.post("/addProject");
		String createProject = response.jsonPath().get("projectName");
		System.out.println(createProject);

		//allocate user

		//precondition for post method of allocate user
		/*JSONObject jobj1 = new JSONObject();
		jobj1.put("designation", "sdet engineer2");
		jobj1.put("dob", "29/08/1995");
		jobj1.put("email", "barik.pradyum4n0@gmail.com");
		jobj1.put("empName", "ganesh87");
		jobj1.put("experience", 3);
		jobj1.put("mobileNo", 9007573260l);
		jobj1.put("project", createProject);
		jobj1.put("role", "ROLE_ADMIN");
		jobj1.put("username", "pradyumna");*/
		
		ProjectLibrary1 projectLibrary=new ProjectLibrary1("senior development engineer1", "8/4/1997", "anna@gmail.com", "anna1", 3, 8956321459l,createProject, "pradyumnar", createProject);

		//create one user
		given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)

		.when()
		.post("/employees")

		.then()
		.log().all()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.assertThat().time(Matchers.lessThan(600L), TimeUnit.MILLISECONDS);

	}
}
