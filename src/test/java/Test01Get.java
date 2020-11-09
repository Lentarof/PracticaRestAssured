import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.Matchers.*;
public class Test01Get {
	//Test usando una Fake API de Internet
	@Test
	void test_01() {
		
//		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("Content-type"));
		System.out.println(response.getTime());
		//hasta este punto funciona normal con la fake api
		
		int statuscode = response.getStatusCode();
		//Assert.assertEquals(statuscode, 201);
		Assert.assertEquals(statuscode, 200);

	}
	@Test
	void test_02() {
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		//si el equal se cambia a 9 u otro numero distinto de 7 deberia fallar
		.body("data.id[0]", equalTo(7));
	}
}
