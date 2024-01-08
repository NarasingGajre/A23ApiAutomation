package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import API_Endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Remove_UPI {
	
	Response reqeust;
	public static String dataToken;
	
	
	@Test(description="This is to get token",groups= {"Sanity"},priority=1)
	 public void generateOTP(){
		
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
		       .post(Routes.Login_OTP);
		 
		       
		
       Response response1 =given().contentType("application/json;charset=UTF-8")
				.body("{\r\n"
			       		+ "  \"channel\": \"A23APS\",\r\n"
			       		+ "  \"device_id\": \"9c6ef1aeeacbabb4\",\r\n"
			       		+ "  \"model\": \"Google,Pixel 2,11\",\r\n"
			       		+ "  \"otp\": \"123456\",\r\n"
			       		+ "  \"screenName\": \"sage407546\",\r\n"
			       		+ "  \"version\": \"3.0.0\"\r\n"
			       		+ "}")
		        .when().post(Routes.Login_OTP);
		 
		 dataToken = response1.path("token");
	   	 System.out.println("data token.. "+dataToken);
	   	 System.setProperty(dataToken, dataToken);
	
	}
	
	
	@Test(description="Validate that user is able to delete the UPI id", groups="Sanity",priority=2)
	 
	 public void removeupi() {
		      
		Response response1=given().contentType("application/json;charset=UTF-8").header("Authorizations", dataToken)
		       .body("{\n"
		       		+ "  \"upiId\": \"success@upi\",\n"
		       		+ "  \"channel\": \"A23APS\"\n"
		       		+ "}")
		.when()
		      .post(Routes.remove_upi);
		response1.then().body("statusCode",equalTo(200));
		
		
		
	}

}
