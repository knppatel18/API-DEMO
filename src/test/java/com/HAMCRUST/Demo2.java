package com.HAMCRUST;

import java.util.List;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:3000/stdio";
		
		RequestSpecification httpreq = RestAssured.given();
		
		Response response= httpreq.get();
		
		ValidatableResponse  vres = response.then();
		
		vres.body("id", Matchers.equalTo(1));
		
		vres.body("manual", Matchers.hasItem("Manual Testing"));
		
		vres.body("manual", Matchers.hasItems("Manual Testing","Postman","SQL"));
		
		vres.body("location.address",Matchers.hasValue("Pune"));
		
		vres.body("location.address", Matchers.hasEntry("city", "Pune"));
		
		vres.body("DOJ", Matchers.hasValue(10));
		
	
		
		List<Object> ls = response.jsonPath().getList("fees");

		ValidatableResponse validatableResponse = response.then();

		for (int i = 0; i < ls.size(); i++)
		{
			validatableResponse.body("fees[" + i + "]", Matchers.lessThanOrEqualTo(400));
		}

		// varify all arrays value is less than 400
		
		List<Object> ls1 = response.jsonPath().getList("manual");

		ValidatableResponse validatableResponse1 = response.then();

		for (int i = 0; i < ls1.size(); i++)
		{
			validatableResponse1.body("manual[" + i + "]", Matchers.hasItems("Manual Testing","Database Testing","API Testing","Unix OS","Postman","SQL"));
		}
		
		
		
		
		
		
		
		System.out.println("=============TC   PASS");

	}

}
