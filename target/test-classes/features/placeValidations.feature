Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if Place is being succcessfully added using ADD API's
	Given Add Place Payload with "<name>" "<address>" "<language>"
	When User Calls "addPlaceAPI" API with "post" http request
	Then The API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify "place_id" created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name		    |address				  |language	|
	|Frontline house|29, side layout, cohen 09|French-IN|
#	|Saurabh		|Faridabad				  |English	|

@DeletePlace @Regression	
Scenario: Verify if Delete Place API is working correctly or not
	Given Delete Place Payload
	When User Calls "deletePlaceAPI" API with "post" http request
	Then The API call got success with status code 200
	And "status" in response body is "OK"