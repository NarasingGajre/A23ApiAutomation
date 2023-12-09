package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Add_UPI {
	
	
	@Test
	public void addupi() {
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="/a23user";
		
		
        given().header("ContentType", "application/json").header("Authorization", "token")
               .body("{\r\n"
               		+ "  \"upi\": \"success@upi\",\r\n"
               		+ "  \"confirmUpi\": \"success@upi\",\r\n"
               		+ "  \"channel\": \"A23APS\",\r\n"
               		+ " \token\":"
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
