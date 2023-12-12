package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Cancel_Redeem {
	Login_With_OTP otp;
	
	@Test
	 
	 public void cancelredeem() {
		
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/redeem";
		String token = otp.dataToken; /* System.getProperty("dataToken"); */
		System.out.println("token..."+token);
		given().contentType("application/json;charset=UTF-8").header("Authorizations", token)
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
