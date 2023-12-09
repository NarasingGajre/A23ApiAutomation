package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Add_Cash_Click {
	
	@Test(priority=2)
	 void add_cash_click() {
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/a23pg";
		given().contentType("application/json;charset=UTF-8")
		       .header("Authorization", "token")
		       
		.when()
		       .post("/initiate_payload_sign")
		.then().assertThat().statusCode(200);  
	}
	
	
    
}
	
	


