package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Cancel_Redeem {
	
	
	@Test
	 
	 public void cancelredeem() {
		
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/a23user";
		Object token;
		given().contentType("application/json;charset=UTF-8").header("Authorizations", getClass(), token)
		       .body("{\r\n"
		       		+ "  \"txnId\": \"f35d6529-f206-4166-96eb-550a6c501064\",\r\n"
		       		+ "  \"channel\": \"A23APS\"\r\n"
		       		+ "}")
		.when()
		       .post("/cancel_withdrawal_request")
		.then()
		       .log().all()
		       .statusCode(200);
		       
		       
	}

}
