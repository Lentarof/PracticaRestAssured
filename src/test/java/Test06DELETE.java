
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Test06DELETE {
	//Test usando una Fake API de Internet
	@Test
	public void Test01forDelete() {
	
		when()
			.delete("https://reqres.in/api/users/2")
		.then()
		//.statusCode(200);
			.statusCode(204)
			.log().all();
	}
	//Test de una API Dummy local del archivo db 
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
