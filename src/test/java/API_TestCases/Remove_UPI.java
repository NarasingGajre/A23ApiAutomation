package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Remove_UPI {
	
	Login_With_OTP otp;
	@Test
	 
	 public void removeupi() {
		

		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/redeem";
		String token = otp.dataToken; /* System.getProperty("dataToken"); */
		System.out.println("token..."+token);
		
		given().contentType("application/json;charset=UTF-8").header("Authorizations", token)
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
