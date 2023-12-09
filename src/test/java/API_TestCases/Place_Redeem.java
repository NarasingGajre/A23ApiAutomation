package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Place_Redeem {
	
	
	@Test
	
	public void placeredeem()
	{
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="/a23user";
		
		
        given().header("ContentType", "application/json").header("Authorization", "token")
               .body("{\r\n"
               		+ "  \"amount\": 1,\r\n"
               		+ "  \"withdrawType\": \"upi\",\r\n"
               		+ "  \"channel\": \"A23APS\",\r\n"
               		+ "  \"bankAccountNumber\": \"2222222222222222\",\r\n"
               		+ "  \"name\": \"ISHAN\"\r\n"
               		+ "}")
        .when()
              .post("/withdrawal_request\r\n")
        .then()
              .log().all()
              .statusCode(200);
	}
	

}
