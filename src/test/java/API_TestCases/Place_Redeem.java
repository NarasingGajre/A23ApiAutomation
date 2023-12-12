package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Place_Redeem {
	Login_With_OTP otp;
	
	@Test
	
	public void placeredeem()
	{
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="/redeem";
		String token = otp.dataToken; /* System.getProperty("dataToken"); */
		System.out.println("token..."+token);
		
		
        given().header("ContentType", "application/json").header("Authorization", token)
               .body("{\r\n"
               		+ "  \"amount\":50,\r\n"
               		+ "  \"withdrawType\": \"upi\",\r\n"
               		+ "  \"channel\": \"A23APS\",\r\n"
               		+ "  \"bankAccountNumber\": \"64106469251\",\r\n"
               		+ "  \"name\": \"NARASING\"\r\n"
               		+ "}")
        .when()
              .post("/withdrawal_request\r\n")
        .then()
              .log().all()
              .statusCode(200);
	}
	

}
