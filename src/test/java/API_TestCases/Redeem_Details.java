package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Redeem_Details {
	
	Login_With_OTP otp;
	
	
	@Test
	public void redeemdetails() {
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="redeem";
		String token=otp.dataToken;
//		System.out.println();
		
		given().contentType("application/json;charset=UTF-8").header("Authorizations", token)
		       
		.when()
		      .post("/redeem_details")
		.then()
		      .log().all()
		      .statusCode(200);
		
	}
	

}
