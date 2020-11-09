package com.PracRest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test04PUT {
	//Test usando una Fake API de Internet
	@Test
	public void Test01forPut() {
	
		JSONObject request= new JSONObject();
		request.put("name", "Efel");
		request.put("job", "Teacher");
		
		System.out.println(request);
		
		given()
			.header("Content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
		//.statusCode(201);
			.statusCode(200)
			.log().all();
	}
	//Test de una API Dummy local del archivo db.json 
	@Test
	public void test02forPut() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName","Sheff");
		request.put("lastName", "Hani");
		request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000/";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-type", "application/json")
			.body(request.toJSONString())
		.when()
			.put("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
}
