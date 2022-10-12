import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_GET_ReQUEST {

	@Test
	void getUserDetails()
	{
		//Specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response Object
		Response response = httpRequest.request(Method.GET,"?page=2");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
}
