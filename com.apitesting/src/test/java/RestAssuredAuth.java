import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RestAssuredAuth {
	@Test
	public void test_APIWithBasicAuthentication_ShouldBeGivenAccess() {
	    // Checks if the given username and password are valid in the given path by asserting a status code of 200    
	    given().
	        auth().
	        preemptive().
	        basic("username", "password").
	    when().
	        get("http://path.to/basic/secured/api").
	    then().
	        assertThat().
	        statusCode(200);
	}
	
//	@Test
//	public void test_APIWithOAuth2Authentication_ShouldBeGivenAccess() {
//	    // Checks if the given auth token is valid by asserting a status code of 200
//	    given().
//	        auth().
//	        oauth2(YOUR_AUTHENTICATION_TOKEN_GOES_HERE). // Api doesn't allow me to create a auth token
//	    when().
//	        get("http://path.to/oath2/secured/api").
//	    then().
//	        assertThat().
//	        statusCode(200);
//	}
	
}
