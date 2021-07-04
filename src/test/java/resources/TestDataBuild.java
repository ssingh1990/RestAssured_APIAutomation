package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.DeletePlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name, String address, String language) {
		AddPlace ap = new AddPlace();
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress(address);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ap.setTypes(myList);
		ap.setWebsite("http://google.com");
		ap.setLanguage(language);
		
		return ap;
	}
	
	public DeletePlace deletePlacePayload(String place_id) {
		DeletePlace dp = new DeletePlace();
		dp.setPlace_id(place_id);
		return dp;
	}

}
