import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;*/
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import static io.restassured.RestAssured.given;


public class fourthRestAssured {

    private static String requestBody = "{\n" +
            "  \"title\": \"I am checking title\",\n" +
            "  \"body\": \"I am checking body\",\n" +
            "  \"userId\": \"301\" \n}";
    
    @BeforeSuite
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void postRequest() {
//        Response response = given()
//                .header("Content-type", "application/json")
//                .and()
//                .body(requestBody)
//                .when()
//                .post("/posts")
//                .then()
//                .extract().response();
		Response response= given().relaxedHTTPSValidation().header("Content-type", "application/json").and().body(requestBody).when().post("/posts").then().extract().response();


        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("I am checking title", response.jsonPath().getString("title"));
        Assert.assertEquals("I am checking body", response.jsonPath().getString("body"));
        Assert.assertEquals("301", response.jsonPath().getString("userId"));
        Assert.assertEquals("101", response.jsonPath().getString("id"));
    }
}

