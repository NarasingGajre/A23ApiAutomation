package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Add_Cash_Process {
	
	@Test(priority=3)
	  void add_cash_process() {
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/a23pg";
		given().contentType("application/json;charset=UTF-8")
		       .header("Authorization", "token")
		       .body("{\r\n"
		       		+ "  \"amount\": 2000,\r\n"
		       		+ "  \"bonusCode\": \"MONDAY3PPR_TARGE_X2R2\",\r\n"
		       		+ "  \"isAcePoints\": false,\r\n"
		       		+ "  \"apRedeemRequested\": 0,\r\n"
		       		+ "  \"PPR\": true,\r\n"
		       		+ "  \"pprMargin\": {\r\n"
		       		+ "    \"bonusCode\": \"MONDAY3PPR_TARGE_X2R2\",\r\n"
		       		+ "    \"bonusEndDate\": \"1667730600\",\r\n"
		       		+ "    \"bonusValue\": \"1580\",\r\n"
		       		+ "    \"claimValidity\": 1,\r\n"
		       		+ "    \"instantBonusPercent\": \"20\",\r\n"
		       		+ "    \"purchaseAmount\": \"7900\",\r\n"
		       		+ "    \"recomender\": \"R2\",\r\n"
		       		+ "    \"wagerBonusPercent\": \"80\",\r\n"
		       		+ "    \"wagerReleaseRatio\": {\r\n"
		       		+ "      \"carrom\": {\r\n"
		       		+ "        \"wagerRatio\": 10,\r\n"
		       		+ "        \"wagerReleaseRatio\": 1\r\n"
		       		+ "      },\r\n"
		       		+ "      \"fantasy\": {\r\n"
		       		+ "        \"wagerRatio\": 10,\r\n"
		       		+ "        \"wagerReleaseRatio\": 1\r\n"
		       		+ "      },\r\n"
		       		+ "      \"poker\": {\r\n"
		       		+ "        \"wagerRatio\": 10,\r\n"
		       		+ "        \"wagerReleaseRatio\": 1\r\n"
		       		+ "      },\r\n"
		       		+ "      \"pool\": {\r\n"
		       		+ "        \"wagerRatio\": 10,\r\n"
		       		+ "        \"wagerReleaseRatio\": 1\r\n"
		       		+ "      },\r\n"
		       		+ "      \"rummy\": {\r\n"
		       		+ "        \"wagerRatio\": 10,\r\n"
		       		+ "        \"wagerReleaseRatio\": 1\r\n"
		       		+ "      }\r\n"
		       		+ "    }\r\n"
		       		+ "  },\r\n"
		       		+ "  \"channel\": \"A23APS\",\r\n"
		       		+ "  \"gpsState\": \"Karnataka\"\r\n"
		       		+ "}")
		       
		.when()
		       .post("/process_payload_sign")
		.then().assertThat().statusCode(200);  
	}
		     

	
	
}
