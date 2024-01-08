package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Redeem_Details {
	
	Response request;
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
		 .when()
		       .post("/login_by_scrname_otp");
		 
		       
		
       Response response1 =given().contentType("application/json;charset=UTF-8")
				.body("{\r\n"
			       		+ "  \"channel\": \"A23APS\",\r\n"
			       		+ "  \"device_id\": \"9c6ef1aeeacbabb4\",\r\n"
			       		+ "  \"model\": \"Google,Pixel 2,11\",\r\n"
			       		+ "  \"otp\": \"123456\",\r\n"
			       		+ "  \"screenName\": \"sage407546\",\r\n"
			       		+ "  \"version\": \"3.0.0\"\r\n"
			       		+ "}")
				.log().all()
		        .when().post("/login_by_scrname_otp");
		 
		 dataToken = response1.path("token");
	   	 System.out.println("data token.. "+dataToken);
	   	 System.setProperty(dataToken, dataToken);
	
	}
	
	
	@Test(priority=2)
	public void redeemdetails() {
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="redeem";
		Response response1=given().contentType("application/json;charset=UTF-8").header("Authorization", dataToken)
		       
		.when()
		      .get("/redeem_details");
		response1.then()
		      .log().all()
		      .statusCode(200);
		String m=response1.asString();
		System.out.println(m);
		
	}
	

}
