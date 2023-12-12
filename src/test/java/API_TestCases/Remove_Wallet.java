package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Remove_Wallet {
	
	Login_With_OTP otp;
	@Test
	
	 public void removewallet() {
		
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/redeem";
		String token = otp.dataToken; /* System.getProperty("dataToken"); */
//		System.out.println("token..."+token);
		
		given().contentType("application/json;charset=UTF-8").header("Authorizations", token)
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
