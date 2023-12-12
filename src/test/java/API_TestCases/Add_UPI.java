package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Add_UPI {
	Login_With_OTP otp;
	
	
	@Test
	public void addupi() {
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="/redeem";
		String token = otp.dataToken; /* System.getProperty("dataToken"); */
		System.out.println("token..."+token);
		
		
        given().header("ContentType", "application/json").header("Authorization", token)
               .body("{\r\n"
               		+ "  \"upi\": \"success@upi\",\r\n"
               		+ "  \"confirmUpi\": \"success@upi\",\r\n"
               		+ "  \"channel\": \"A23APS\",\r\n"
               		+ " \token\"token:"
               		+ "  \"submit\": true,\r\n"
               		+ "  \"otp\": \"123456\"\r\n"
               		+ "}")
               .when()
               .post("/add_upi")
               .then()
               .log().all()
               .statusCode(200);
	}
	

}
