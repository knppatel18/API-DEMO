package com.HAMCRUST;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Number_Methods {

	public static void main(String[] args) {
		
		//specify the base uri
		RestAssured.baseURI= "http://localhost:3000/employees/1";
		
		// get the Request Specification Object so we select HTTP request
		RequestSpecification httpreq= RestAssured.given();
		
		//select HTTP request from Request Specification Interface
		Response resp=httpreq.get();
		int code =resp.getStatusCode();
		System.out.println(code);
		System.out.println("======================");
		
        ValidatableResponse  vres= 		resp.then();
        
        vres.statusCode(200);
        
        vres.statusLine("HTTP/1.1 200 OK");
        
        vres.body("firstname", Matchers.equalTo("Kundan"));
        
        vres.body("firstname", Matchers.is("Kundan"));
        
        vres.body("firstname", Matchers.equalToIgnoringCase("Kundan"));
        
        vres.body("firstname", Matchers.equalToIgnoringWhiteSpace("Kundan"));
        
        vres.body("firstname", Matchers.containsString("Kundan"));
        
        vres.body("firstname", Matchers.startsWith("Ku"));
        
        vres.body("firstname", Matchers.endsWith("an"));
        
        System.out.println("++++++++++++++++++");
        
        
        
		
		
		
		
		

	}

}














