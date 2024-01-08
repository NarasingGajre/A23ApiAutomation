package API_TestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import API_Endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Add_UPI {
	
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
	
	@Test(description="Validate that user is able to add upi", groups="Sanity", priority=2)
	
	public void addupi() {
	
	Response response1 =given().contentType("application/json; charset=UTF-8").header("Authorization", dataToken)
			.body("{\n"
					+ "  \"upi\": \"success@upi\",\n"
					+ "  \"confirmUpi\": \"success@upi\",\n"
					+ "  \"channel\": \"A23APS\",\n"
					+ "  \"token\": \"\",\n"
					+ "  \"submit\": true,\n"
					+ "  \"otp\": \"\"\n"
					+ "}")
            .when().post(Routes.add_upi);
	 String m = response1.asString();
	 System.out.println(m);
	 //response1.then().body("message", equalTo("Wallet removed."));
	 
	 Response response2 =given().contentType("application/json; charset=UTF-8").header("Authorization", dataToken)
				.body("{\n"
						+ "  \"upi\": \"success@upi\",\n"
						+ "  \"confirmUpi\": \"success@upi\",\n"
						+ "  \"channel\": \"A23APS\",\n"
						+ "  \"token\": \"\",\n"
						+ "  \"submit\": true,\n"
						+ "  \"otp\": \"123456\"\n"
						+ "}")
	            .when().post(Routes.add_upi);
	 String m1 = response2.asString();
	 System.out.println(m1);
	 
	 Response response3 =given().contentType("application/json; charset=UTF-8").header("Authorization", dataToken).accept("*/*")
				.body("{\n"
						+ "  \"upi\": \"success@upi\",\n"
						+ "  \"confirmUpi\": \"success@upi\",\n"
						+ "  \"channel\": \"A23APS\",\n"
						+ "  \"token\": "+dataToken+",\n"
						+ "  \"submit\": true,\n"
						+ "  \"otp\": \"123456\"\n"
						+ "}")
				.log().all()
	            .when().post(Routes.add_upi);
	 String m2 = response3.asString();
	 System.out.println(m2);
	 
	 
	 
	}
		  
}
