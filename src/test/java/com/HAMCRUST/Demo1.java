package com.HAMCRUST;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Demo1 {

	public static void main(String[] args) {
		
		//specify the baseuri
		RestAssured.baseURI="http://localhost:3000/employees";
		
		// get requestspecification object so we can add http request
		RequestSpecification  obj =RestAssured.given();
		
		// get http request from request Specification object
		Response resp = obj.get();
		
		int code = resp.getStatusCode();
		System.out.println(code);
		
		String line = resp.getStatusLine();
		System.out.println(line);
		
		long time = resp.getTime();
		System.out.println(time);
		
		Headers header = resp.getHeaders();
		System.out.println(header);
		
		ResponseBody body =resp.getBody();
		System.out.println(body);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

















