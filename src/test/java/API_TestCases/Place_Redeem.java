package API_TestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Place_Redeem {
	
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
	
	
	@Test(description="Validate that user is displayed with Email verify to place redeem",priority=2)
	
	public void placeredeem()
	{
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="/redeem";
//		String token = otp.dataToken; /* System.getProperty("dataToken"); */
//		System.out.println("token..."+token);
		
		
        Response response1=given().contentType("application/json; charset=UTF-8").header("Authorization", dataToken)
               .body("{\n"
               		+ "  \"amount\":50,\n"
               		+ "  \"withdrawType\": \"bankAccount\",\n"
               		+ "  \"channel\": \"A23APS\",\r\n"
               		+ "  \"bankAccountNumber\": \"64106469251\",\n"
               		+ "  \"name\": \"NARASING\"\n"
               		+ "}")
               .log().all()
        .when().post("/withdrawal_request\r\n");
        String m = response1.asString();
		 System.out.println(m);
		 response1.then().body("error.statusCode",equalTo(1236));
             response1.then().body("error.message",equalTo("Please verify your email before redeeming."));
              
	}
	
	@Test(dependsOnMethods= {"placeredeem"})
	
	public void emialverification() {
		
		RestAssured.baseURI="https://api.qapfgames.com";
		RestAssured.basePath="/a23kyc";
		Response response1=given().contentType("application/json;charset=UTF-8")
	       .body("{\n"
	       		+ "  \"email\": \"dudububu@gmail.com\",\n"
	       		+ "  \"otp\": \"123456\",\n"
	       		+ "  \"verify\": true\n"
	       		+ "}")
	       .log().all()
	       .when().post("/verify_email");
		String m = response1.asString();
		 System.out.println(m);
		
		
		
		
		
	}
	

}
