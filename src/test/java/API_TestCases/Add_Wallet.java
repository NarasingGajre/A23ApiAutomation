package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;



public class Add_Wallet {
	
	Response reqeust;
	public static String dataToken;
	

	@Test(description="This is to get token",groups= {"Sanity"},priority=1)
	 public void generateOTP(){
		
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/a23user";
		given().contentType("application/json;charset=UTF-8")
		       .body("{\r\n"
		       		+ "  \"channel\": \"A23APS\",\r\n"
		       		+ "  \"device_id\": \"9c6ef1aeeacbabb4\",\r\n"
		       		+ "  \"model\": \"Google,Pixel 2,11\",\r\n"
		       		+ "  \"otp\": \"\",\r\n"
		       		+ "  \"screenName\": \"sage407546\",\r\n"
		       		+ "  \"version\": \"3.0.0\"\r\n"
		       		+ "}")
		 .when().post("/login_by_scrname_otp");
		
        Response response1 =given().contentType("application/json;charset=UTF-8")
				.body("{\r\n"
			       		+ "  \"channel\": \"A23APS\",\r\n"
			       		+ "  \"device_id\": \"9c6ef1aeeacbabb4\",\r\n"
			       		+ "  \"model\": \"Google,Pixel 2,11\",\r\n"
			       		+ "  \"otp\": \"123456\",\r\n"
			       		+ "  \"screenName\": \"sage407546\",\r\n"
			       		+ "  \"version\": \"3.0.0\"\r\n"
			       		+ "}")
		        .when().post("/login_by_scrname_otp");
		 
		 dataToken = response1.path("token");
	   	 System.out.println("data token.. "+dataToken);
	   	 System.setProperty(dataToken, dataToken);
	
}
	

	@Test(description="Validate that user is able to the add paytm wallet",groups="Sanity",priority=2)
        public void paytmwallet(){
		
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/redeem";
		
		 Response response1 =given().contentType("application/json; charset=UTF-8").header("Authorization", dataToken)
				.body("{\n"
			       		+ "\"walletType\": \"paytm\",\n"
			       		+ "\"otp\": \"\",\n"
			       		+ "\"channel\": \"A23APS\"\n"
			       		+ "}")
				.log().all()
		        .when().post("/add_wallet");
		 
		 
		 String m = response1.asString();
		 System.out.println(m);
		 
		 Response response2 =given().contentType("application/json; charset=UTF-8").header("Authorization", dataToken)
					.body("{\n"
				       		+ "\"walletType\": \"paytm\",\n"
				       		+ "\"otp\": \"123456\",\n"
				       		+ "\"channel\": \"A23APS\"\n"
				       		+ "}")
					.log().all()
			        .when().post("/add_wallet");
		 String m2 = response2.asString();
		 System.out.println(m2);
		 Assert.assertEquals(response2.statusCode(), 200);
		 response2.then().body("message", equalTo("Wallet has been added."));
		 response2.then().body("statusCode",equalTo( 1210));
	}
	
	
	
	@Test(description="Validate that user is able to add same paytm wallet again", groups="Sanity", priority=3)
 public void paytmwalletsame(){
		
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/redeem";
		
		 Response response1 =given().contentType("application/json;charset=UTF-8").header("Authorization", dataToken)
				.body("{\n"
			       		+ "\"walletType\": \"amazon\",\n"
			       		+ "\"otp\": \"\",\n"
			       		+ "\"channel\": \"A23APS\"\n"
			       		+ "}")
				.log().all()
		        .when().post("/add_wallet");
		 
		 
		 String m = response1.asString();
		 System.out.println(m);
		 
		 Response response2 =given().contentType("application/json;charset=UTF-8").header("Authorization", dataToken)
					.body("{\n"
				       		+ "\"walletType\": \"amazon\",\n"
				       		+ "\"otp\": \"123456\",\n"
				       		+ "\"channel\": \"A23APS\"\n"
				       		+ "}")
					.log().all()
			        .when().post("/add_wallet");
		 String m2 = response2.asString();
		 System.out.println(m2);
		 //Assert.assertEquals(response2.statusCode(), 200);
		 //Assert.assertEquals(response2.contentType(), "application/json; charset=UTF-8");
		//response2.then().body("message", equalTo("Wallet already exist."));
	}
	

}

