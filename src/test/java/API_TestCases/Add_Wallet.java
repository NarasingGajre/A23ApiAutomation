package API_TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Add_Wallet {
	
	@Test
	public  void addwallet() {
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="/a23user";
		
		
        given().header("ContentType", "application/json").header("Authorization", "token")
               .body("{\r\n"
               		+ "  \"walletType\": \"paytm\",\r\n"
               		+ "  \"otp\": \"123456\",\r\n"
               		+ "  \"channel\": \"A23APS\"\r\n"
               		+ "}")
		
		.when()
		      .post("/add_wallet")
		
		.then()
		      .log().all()
		      .statusCode(200);
	}

}
