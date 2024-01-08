package API_TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import API_Endpoints.Routes;

public class Login_With_OTP {
	
	Response reqeust;
	public static String dataToken;
	


	@Test(priority=1)
	 public void generateOTP() {
	
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
	       .post(Routes.Login_OTP)
	 .then()
	       .log().all()
	       .assertThat().statusCode(200);
	}
	

	
	
	@Test(priority=2)
	public void enterOTP(){
		
		
		
		 Response response1 =given().contentType("application/json;charset=UTF-8")
				.body("{\r\n"
			       		+ "  \"channel\": \"A23APS\",\r\n"
			       		+ "  \"device_id\": \"9c6ef1aeeacbabb4\",\r\n"
			       		+ "  \"model\": \"Google,Pixel 2,11\",\r\n"
			       		+ "  \"otp\": \"123456\",\r\n"
			       		+ "  \"screenName\": \"sage407546\",\r\n"
			       		+ "  \"version\": \"3.0.0\"\r\n"
			       		+ "}").log().all()
		.when().post(Routes.Login_OTP);
	
		       
		 dataToken = response1.path("token");
	     System.out.println("data token.. "+dataToken);
		 System.setProperty(dataToken, dataToken);

}
	
		
	}
	       
	       

