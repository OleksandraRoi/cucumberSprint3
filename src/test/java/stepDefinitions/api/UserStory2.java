package stepDefinitions.api;
import io.restassured.RestAssured;
import org.junit.Test;
import utils.ConfigReader;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserStory2 {

    static {
        RestAssured.baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
    }
@Test
    public void testGetUser() {


        String id = "20";
        given().
                queryParam("id", id).
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                when().log().all().
                get("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("id", equalTo(id)).
                body("first_name", is("duotech")).
                header("Content-Type", "application/json").
                time(lessThan(1000L));


    }
}