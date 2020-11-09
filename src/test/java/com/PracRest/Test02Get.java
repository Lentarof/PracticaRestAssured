package com.PracRest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Test02Get {
	//Test usando una Fake API de Internet
	@Test
	public void test01forGet() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.body("data.first_name", hasItems("Michael", "Lindsay"))
			.body("data.email[1]", equalTo("lindsay.ferguson@reqres.in"));
		//log all sirve para ver todo el contenido de como llega el JSON
		//.log().all();
	}
	//Test de una API Dummy local del archivo db.json
	@Test
	public void test02forGet() {
		
		baseURI = "http://localhost:3000/";
		
		given()
			.get("/users")
		.then()
			.statusCode(200)
			.log().all();
	}
	//Test de una API Dummy local del archivo db.json
	@Test
	public void test03forGet() {
		
		baseURI = "http://localhost:3000/";
		
		given()
			.param("name", "Cybersecurity")
			.get("/subjects")
		.then()
			.statusCode(200)
			.log().all();
	}
}
