package TEST_LAYER;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;



  
public class Demo1 {
	@Test
	                           //https://fakestoreapi.com/products/9
	public void abc() {
	RestAssured
	.given()
	   .baseUri("https://fakestoreapi.com")
	   .basePath("/products")
	   .when()
	   .get("/1")
	   .then()
	   .assertThat()
	   .body("title", Matchers.anyOf(Matchers.startsWith("Fjallraven "), Matchers.endsWith("Laptops")));

}
}
