package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	ResponseSpecification res;
	RequestSpecification rs;
	Response response;
	String status;
	static String place_id_value; //make static so that we can use in 2nd scenario, if we don't use static then we will get null pointer exception
	TestDataBuild tdb = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with_something_something_something(String name, String address, String language) throws Throwable {
		tdb = new TestDataBuild();
		
		rs = given().spec(requestSpecification()).header("Content-Type","application/json")
		.body(tdb.addPlacePayLoad(name,address,language));
    }
	@When("User Calls {string} API with {string} http request")
	public void user_calls_api_with_method_http_request(String resource,String method) {
		//constructor will be called with value of resource which you pass
		APIResources res = APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("post")) {
			
			response=rs.when().post(res.getResource());
		}
		else if(method.equalsIgnoreCase("get")) {
			
			response=rs.when().get(res.getResource());
		}
		
	}
	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int code) {
	    assertEquals(response.getStatusCode(),code);
	}
	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		String jsonkey = extractValueFromJson(response, key);
		assertEquals(jsonkey,value);
	}
	@And("verify {string} created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String param, String expectedValue, String resource) throws IOException {
		place_id_value = extractValueFromJson(response, param);
		rs = given().spec(requestSpecification()).queryParam(param, place_id_value);
		//reuse the methods
		user_calls_api_with_method_http_request(resource,"get");
		the_api_call_got_success_with_status_code(200);
		String actualNameValue = extractValueFromJson(response, "name");
		assertEquals(actualNameValue,expectedValue);
	}
	@Given("Delete Place Payload")
	public void delete_place_payload() throws IOException {
		rs=given().spec(requestSpecification()).header("Content-Type","application/json")
		.body(tdb.deletePlacePayload(place_id_value));
	}
	
}
