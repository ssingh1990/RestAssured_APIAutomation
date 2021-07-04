package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeDeletePlaceAPI() throws Throwable {
		
		StepDefination sd = new StepDefination();
		
		if(StepDefination.place_id_value==null) {
			sd.add_place_payload_with_something_something_something("Saurabh", "B11301", "English");
			sd.user_calls_api_with_method_http_request("addPlaceAPI", "post");
			sd.verify_place_id_created_maps_to_using("place_id","Saurabh", "getPlaceAPI");
		}
	}

}
