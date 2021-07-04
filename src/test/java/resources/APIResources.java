package resources;

public enum APIResources {
	//enum is a special class in java which has collection of constants or methods
	//Every method simply use this constructor to load and pass this variable to resource and we can use menthod value by using getResource() menthod
	
	addPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;

	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
