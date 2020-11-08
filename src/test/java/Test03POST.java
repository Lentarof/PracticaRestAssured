import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;

public class Test03POST {

	@Test
	public void Test01forPost() {
		//key es el string y Object es el valor cualquier tipo de dato
//		Map<String, Object> map = new HashMap<String, Object>();
		//todavia no es un Json para hacer el post como requiere el API
//		map.put("name", "Efel");
//		map.put("job", "Teacher");
		
//		System.out.println(map);
		
//		JSONObject request= new JSONObject(map);

		JSONObject request= new JSONObject();
		request.put("name", "Efel");
		request.put("job", "Teacher");
		
		System.out.println(request);
		//en caso de que no serialice
		//System.out.println(request.toJSONString());
		
		given()
			.header("Content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
		//.statusCode(200);
			.statusCode(201)
			.log().all();
	//System.out.println(given().header("Content-type", "application/json"));
	//System.out.println(given().body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201));
	}
	@Test
	public void test02forPost() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName","Kal");
		request.put("lastName", "Sol");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-type", "application/json")
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
}
