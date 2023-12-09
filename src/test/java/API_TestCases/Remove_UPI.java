package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Remove_UPI {
	
	
	@Test
	 
	 public void removeupi() {
		

		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/a23user";
		
		given().contentType("application/json;charset=UTF-8").header("Authorizations", "")
		       .body("{\r\n"
		       		+ "  \"upiId\": \"success@upi\",\r\n"
		       		+ "  \"channel\": \"A23APS\"\r\n"
		       		+ "}")
		.when()
		      .post("/remove_upi")
		.then()
		      .log().all()
		      .statusCode(200);
		
		
	}

}
