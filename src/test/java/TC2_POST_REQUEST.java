import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_POST_REQUEST {

	@Test
	void createNewUser()
	{
		//Specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload sending along with POST request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name","morpheus");
		requestParams.put("job","leader");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString()); // attach data to the request
		
		// Response Object
		Response response = httpRequest.request(Method.POST);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is:"+statusCode);
		Assert.assertEquals(statusCode, 201);		
		
		String id = response.jsonPath().get("id");
		System.out.println(id);
	}
}
