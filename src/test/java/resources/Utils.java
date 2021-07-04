package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	//Add Logging of request and response through RequestLoggingFilter and ResponseLoggingFilter
	//added static so that req variable do not initialize again to null
	public RequestSpecification requestSpecification() throws IOException {
		if(req==null) {
		PrintStream ps = new PrintStream(new FileOutputStream("logging.txt"));
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUri"))
				.addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps))
				.addQueryParam("key", "qaclick123").build();
			return req;
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\globals.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public static String extractValueFromJson(Response resp,String key) {
		String resp1=resp.asString();
		JsonPath js = new JsonPath(resp1);
		String value=js.get(key).toString();
		return value;
	}

}
