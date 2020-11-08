
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Test06DELETE {

	@Test
	public void Test01forDelete() {
	
/*		JSONObject request= new JSONObject();
		request.put("name", "Abel");
		request.put("job", "Content Manager");
		
		System.out.println(request);

		
		given()
			.header("Content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.*/
		when()
			.delete("https://reqres.in/api/users/2")
		.then()
		//.statusCode(200);
			.statusCode(204)
			.log().all();
	}
	@Test
	public void  Test02forDelete() {
		
		baseURI = "http://localhost:3000/";
		
		when()
			.delete("/users/4")
		.then()
			.statusCode(200);
			//.statusCode(204)
			//.log().all();
	}
}
