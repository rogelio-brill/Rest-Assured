import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class secondRestAssured {
	@Test
	void test_01()
	{
		Response response= given().relaxedHTTPSValidation().when().post("https://reqres.in/api/users?page=2");

		System.out.println(response.asString());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
	}

}
