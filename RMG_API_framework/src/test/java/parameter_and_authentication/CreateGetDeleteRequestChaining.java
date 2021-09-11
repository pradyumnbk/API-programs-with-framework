package parameter_and_authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

public class CreateGetDeleteRequestChaining 
{
	@Test
	public void createGetDelete()
	{
		baseURI="http://localhost";
		port=8084;
		String singleProject=null;
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("createdBy", "rohit12");
		map.put("projectName", "quantum15");
		map.put("status", "completed");
		map.put("teamSize", 455);
		//precondition for project creation
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(map)
		//create a project
		.when()
		.post("/addProject");
		//capture the project id for created project
		String createProject = resp.jsonPath().get("projectId");
		System.out.println(createProject);
		//get all project along with created project
		Response resp1 = when()
		 .get("/projects");
		 //capture all the project id
		  List<String> list = resp1.jsonPath().get("projectId");
		  
		 for ( String  data: list) 
		 {
			 
			 if (data.equals(createProject))
			 {
				 singleProject=data;
				 break;
			 }
		 }
		//delete the created project with project id
		 given()
		 .pathParam("projectid", singleProject)
		 .when()
		 .delete("/projects/{projectid}")
		 .then()
		 .log().all()
		 .assertThat().statusCode(204);
		 
	}
}
