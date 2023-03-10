package com.phase3restassured;
import static io.restassured.RestAssured.given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class testAPIS {
	protected static Logger Resultlog = LogManager.getLogger(testAPIS.class.getName());


	@Test(priority=2)
    void testGETApi() {
		Resultlog.info("All the info show");
		
		Response res=given()
		.when().get("https://reqres.in/api/users?page=2");
		Resultlog.debug(res.getStatusCode());
		
	}
	@Test(priority=1)
	 void testPOSTApiusingPOGO() {
		
		pojoPostRequest data=new pojoPostRequest();
		data.setFirst_name("manasa");
		data.setLast_name("gowda");
		data.setEmail("manasagowda024@gmail.com");
		
		
		Response res = given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users?page=2");
		
		Resultlog.debug(res.getStatusCode());

		Resultlog.debug(res.getTime());
		
	}

}
