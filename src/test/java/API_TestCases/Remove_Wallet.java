package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Remove_Wallet {
	
	
	@Test
	
	 public void removewallet() {
		
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/a23user";
		
		given().contentType("application/json;charset=UTF-8").header("Authorizations", "")
		       .body("{\r\n"
		       		+ "  \"walletType\": \"paytm\",\r\n"
		       		+ "  \"channel\": \"A23APS\"\r\n"
		       		+ "}")
		.when()
		      .post("/remove_wallet")
		 .then()
		       .log().all()
		       .statusCode(200);
	}

}
