package com.HEADER;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class _LOG_ALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="http://localhost:3000/employees";
		RequestSpecification  obj =RestAssured.given();
		
		Response resp = obj.when().get();
		
		ValidatableResponse  l= resp.then();
		
		l.log().all();

	}

}
