package com.HAMCRUST;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ALL_RIVISION {

	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification httpreq = RestAssured.given();
		
		httpreq.headers("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
        //String req= json.toString();
		
		//httpReq.body(req);
		
		//Response response=httpReq.post();
		 
		json.put("firstname","Kundan");
		json.put("lastname","Patel");
		json.put("address","Pune");
		json.put("emailId","kundan@gmail.com");
		json.put("sallery",85000);
		json.put("price", 56.87f);
		json.put("topics", "Automation Testing");
		
		String postBody = json.toString();
		
		httpreq.body(postBody);
		
		
		Response response = httpreq.post();
		
	    ValidatableResponse vres = 	response.then();
	    
	    vres.statusCode(201);
	    vres.statusLine(Matchers.containsString("201 Created"));
	    vres.time(Matchers.lessThan(50000l));
	    vres.body("firstname", Matchers.is("Kundan"));
	    vres.body("lastname", Matchers.is("Patel"));
	    vres.body("sallery", Matchers.lessThan(95000) );
	    vres.body("price", Matchers.greaterThan(50f));
	    vres.body("address", Matchers.equalTo("Pune"));
	    vres.body("topics", Matchers.startsWith("Automation"));
	    vres.body("emailId",Matchers.containsString("kundan@gmail.com"));
	    vres.log().all();
	    
	    String responseBody = response.getBody().asString();
	    
	    JsonPath path = new JsonPath(responseBody);
	    
	    String b = path.getString("id");
	    System.out.println(b);
	    
	   // ======================================================
	   //  Retrive the entity By using getRequest
	    
	    Response response1 = httpreq.get(b);
	    
	    ValidatableResponse vres1 = response1.then();
	    
	    vres1.statusCode(200);
	    vres1.statusLine(Matchers.containsString("200 OK"));
	    vres1.time(Matchers.lessThan(50000l));
	    vres1.body("firstname", Matchers.equalTo("Kundan"));
	    vres1.body("lastname", Matchers.equalTo("Patel"));
	    vres1.body("sallery", Matchers.lessThan(95000) );
	    vres1.body("price", Matchers.greaterThan(50f));
	    vres1.body("address", Matchers.equalTo("Pune"));
	    vres1.body("topics", Matchers.startsWith("Automation"));
	    vres1.body("emailId",Matchers.containsString("kundan@gmail.com"));
	    vres1.log().all();
	    
	    //===============================================================
	    // Update The Hole Entity By using Put request
	    
	    


	    
	  	json.put("firstname","Jay");
		json.put("lastname","Patil");
		json.put("address","Pune");
		json.put("emailId","jay@gmail.com");
		json.put("sallery",85000);
		json.put("price", 56.87f);
		json.put("topics", "Automation Testing");
		
		String putBody = json.toString();
		
		httpreq.body(putBody);
		
		Response response2 = httpreq.put(b);
		    
		ValidatableResponse vres2 = response2.then();
		
	    vres2.statusCode(200);
	    vres2.statusLine(Matchers.containsString("200 OK"));
	    vres2.time(Matchers.lessThan(50000l));
	    vres2.body("firstname", Matchers.is("Jay"));
	    vres2.body("lastname", Matchers.is("Patil"));
	    vres2.body("sallery", Matchers.lessThanOrEqualTo(85000) );
	    vres2.body("price", Matchers.greaterThan(50f));
	    vres2.body("address", Matchers.equalTo("Pune"));
	    vres2.body("topics", Matchers.startsWith("Automation"));
	    vres2.body("emailId",Matchers.containsString("jay@gmail.com"));
	    vres2.log().all();
	    
		//===========================================
	    //get the updated entity
	    
	    Response response3 = httpreq.get(b);
	    
	    ValidatableResponse vres3 = response3.then();
	    
	    vres3.statusCode(200);
	    vres3.statusLine(Matchers.containsString("200 OK"));
	    vres3.time(Matchers.lessThan(50000l));
	    vres3.body("firstname", Matchers.is("Jay"));
	    vres3.body("lastname", Matchers.is("Patil"));
	    vres3.body("sallery", Matchers.lessThan(95000) );
	    vres3.body("price", Matchers.greaterThan(50f));
	    vres3.body("address", Matchers.equalTo("Pune"));
	    vres3.body("topics", Matchers.startsWith("Automation"));
	    vres3.body("emailId",Matchers.containsString("jay@gmail.com"));
	    vres3.log().all();
	    
	    //=====================================================
	    //  Delete the entity
	    
	    Response response4 = httpreq.delete(b);
	    
	    ValidatableResponse vres4 = response4.then();
	    
	    vres4.statusCode(200);
	    vres4.time(Matchers.lessThan(50000l));
	    vres4.statusLine(Matchers.containsString("200 OK"));
	    vres4.headers("Content-Type",Matchers.containsString("application/json"));
	    vres4.log().all();
	    
	    //===========================================================
	    // get the deleted entity
	    
	    Response response5 = httpreq.get(b);
	    
	    ValidatableResponse vres5 = response5.then();
	    
	    vres5.statusCode(404)
	    .and()
	    .statusLine(Matchers.containsString("404 Not Found"))
	    .and()
	    .log().all();
	    
	    
	    System.out.println("TC Complete");
	    
		    

	    
	    
	    
	    
	    
		
		
		
		
		
		
		
		
		
		
		

	}

}
















