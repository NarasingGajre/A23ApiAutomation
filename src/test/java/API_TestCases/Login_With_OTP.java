package API_TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Login_With_OTP {
	
	
	
    
	//private static final String enterOTP = ;


	@Test
	 public void generateOTP() {
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
	       .post("/login_by_scrname_otp")
	 .then()
	       .log().all()
	       .assertThat().statusCode(200);
	}
	

	@Test(dependsOnMethods= {"generateOTP"})
	void enterOTP(){
		RestAssured.baseURI ="https://api.qapfgames.com";
		RestAssured.basePath ="/a23user";
		Response response1 = given().contentType("application/json;charset=UTF-8").header("Authorization",token);
		       body("{\r\n"
		       		+ "  \"channel\": \"A23APS\",\r\n"
		       		+ "  \"device_id\": \"9c6ef1aeeacbabb4\",\r\n"
		       		+ "  \"model\": \"Google,Pixel 2,11\",\r\n"
		       		+ "  \"otp\": \"123456\",\r\n"
		       		+ "  \"screenName\": \"sage407546\",\r\n"
		       		+ "  \"version\": \"3.0.0\"\r\n"
		       		+ "}")
		 .when()
		       .post("/login_by_scrname_otp")
		 .then()
		       .log().all()
		       .assertThat().statusCode(200);
		
		String res1 = response1.asString();
		JsonPath js = new JsonPath(res1);
		String token = js.getString("token");
		System.setProperty("token", token);
	}
	
		
		
	}
	       
	       

