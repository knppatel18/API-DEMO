package jsonparse_Prectice;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="http://localhost:3000/data";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.get();
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		
		//capture the response body by using response Object name
		String respbody = response.getBody().asString();
		
		//System.out.println(respbody);
		
		//parse JSON response body into the JsonPath by passing the JSON response body String variable name
		JsonPath json = new JsonPath(respbody);
		System.out.println("==================");
		String   a = json.getString("locations[0].country");
		System.out.println(a);
		
      		
		
		

	}

}









