package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get_Balance {
	
	
	@Test
	
	public void getBalance() {
		
		RestAssured.baseURI ="https://ptjava.qapfgames.com";
		RestAssured.basePath ="/JavaDynamo";
		
		given().contentType("application/json;charset=UTF-8")
		       .body("{\r\n"
		       		+ "  \"id\": \"sage407546\"\r\n"
		       		+ "}")
		.when()
		      .get("/getBal")
		 .then()
		       .log().all()
		       .statusCode(200);
		
		
	}
	

}
