package TEST_LAYER;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo_PUT {

	public static void main(String[] args) {
	
		RestAssured.baseURI="http://localhost:3000/employees/1";
	    
		RequestSpecification  httpreq = RestAssured.given();
		
		httpreq.header("Content-Type","application/json");
		
		JSONObject  json = new JSONObject();
		
		json.put("firstname", "Kundan");
		json.put("lastname", "Patel");
		json.put("address", "Pune");
		json.put("mobile", 4567865);
		json.put("emailID", "kunda@gmail.com");
		
		String  b =json.toString();
		
		httpreq.body(b);
		
		Response resp = httpreq.put();
		
		int  c = resp.getStatusCode();
		System.out.println(c);
		int  d = resp.statusCode();
		System.out.println(d);
		
		String e = resp.getStatusLine();
		System.out.println(e);
		
		long t = resp.time();
		System.out.println(t);
		
		long t2 = resp.time();
		System.out.println(t2);
		
		long t3 = resp.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println(t3);
		
	}

}
