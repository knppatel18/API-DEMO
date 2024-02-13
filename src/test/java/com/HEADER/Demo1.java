package com.HEADER;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1 {

	public static void main(String[] args) {
       
		//Specify the base uri in rest assured
		RestAssured.baseURI ="http://localhost:3000/employees";
		
		// Get requestspecifikation object so we can select the HTTP request
		RequestSpecification  obj = RestAssured.given();
		
		//select the HTTP request from RequestSpecification object
		Response resp = obj.get();
		
		//get response header 
		Headers allheader = resp.getHeaders();
		//System.out.println(allheaders);

		for(Header abc : allheader)
		{
			System.out.println(abc.getName()+"  : "+abc.getValue());
		}
			
	}

}
