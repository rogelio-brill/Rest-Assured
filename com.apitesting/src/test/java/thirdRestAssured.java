import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import static io.restassured.RestAssured.given;


public class thirdRestAssured {

    @BeforeSuite
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getRequest() {
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/posts")
//                .then()
//                .extract().response();
		Response response= given().relaxedHTTPSValidation().contentType(ContentType.JSON).when().get("/posts").then().extract().response();


        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("qui est esse", response.jsonPath().getString("[1][\"title\"]\r\n"));

    }
}

