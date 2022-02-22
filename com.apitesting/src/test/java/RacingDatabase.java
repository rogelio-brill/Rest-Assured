import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RacingDatabase {
	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
	    // Checks if f1 2017 has 20 circuits in the api using hamcrest for checking the body size being equal to 20    
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
	
	@Test
	public void test_Headers() {
		// Checks if api is a valid site with statusCode 200 and if headers of api have a content length equalTo given number 
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        statusCode(200).
	    and().
	        contentType(ContentType.JSON).
	    and().
	        header("Content-Length",equalTo("4551")); // Correct content-length is updated to 4567 not 4551
	}
	
	// Makes a response specification set to status code 200
	ResponseSpecification checkStatusCodeAndContentType = 
		    new ResponseSpecBuilder().
		        expectStatusCode(200).
		        expectContentType(ContentType.JSON).
		        build();
	
	@Test
	public void test_NumberOfCircuits_ShouldBe20_UsingResponseSpec() {
	    // Makes use of ResponseSpecification that is set at status code 200    
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        spec(checkStatusCodeAndContentType).
	    and().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
	
}
