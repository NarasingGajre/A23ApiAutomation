package API_TestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import API_Endpoints.Routes;
import io.restassured.response.Response;

public class Login_With_Password {
	
	Response request;
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
		 .when().post(Routes.Login_OTP);
		
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
	
	@Test(description="Validate that user is able to set the password",groups="Sanity",priority=2)
	
	 void SetPassword() {
		given().contentType("application/json;charset=UTF-8")
	       .body("{\n"
	       		+ "  \"newPassword\": \"nar@1234\",\n"
	       		+ "  \"confirmPassword\": \"nar@1234\",\n"
	       		+ "  \"otp\": \"123456\",\n"
	       		+ "  \"channel\": \"A23APS\"\n"
	       		+ "}")
	       .when().post("https://api.qapfgames.com/a23user/set_password");
	
		
	}
	
	
	
	@Test(description="Validate that user is able to login with password", groups="Sanity",priority=3)
	
	void LoginbyPassword(){
		
		given().contentType("application/json;charset=UTF-8")
	       .body("{\n"
	       		+ "  \"identity\": \"sage407546\",\n"
	       		+ "  \"password\": \"nar@1234\",\n"
	       		+ "  \"device_id\": \"9c6ef1aeeacbabb4\",\n"
	       		+ "  \"model\": \"Google,Pixel 2,11\",\n"
	       		+ "  \"channel\": \"A23APS\",\n"
	       		+ "  \"version\": \"3.0.0\"\n"
	       		+ "}")
	 .when()
	       .post(Routes.Login_Password);
	 
	       
	

	}
		
		
	}


