
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test05PATCH {

	@Test
	public void Test01forPatch() {
	
		JSONObject request= new JSONObject();
		request.put("name", "Abel");
		request.put("job", "Content Manager");
		
		System.out.println(request);

		
		given()
			.header("Content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("https://reqres.in/api/users/2")
		.then()
		//.statusCode(201);
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test02forPatch() {
		
		JSONObject request = new JSONObject();
		
	//	request.put("firstName","Sheff");
		request.put("lastName", "Rit");
	//	request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-type", "application/json")
			.body(request.toJSONString())
		.when()
			.patch("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}
}
