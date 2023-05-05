package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import utils.ApiUtils;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.testng.Assert.assertTrue;


public class UserStory2GET {
    RequestSpecification requestSpecification;
    Response response;

    @Given("the correct API key provided")
    public void the_correct_api_key_provided() {

        requestSpecification = given().
                queryParam("api_key", ConfigReader.getProperty("api_key"));
    }

    @Given("the {string} parameter is {string}")
    public void the_parameter_is(String key, String value) {

        ApiUtils.setRequestQueryParameter(key,value);


    }

    @Then("I send a {string} request with a valid ID to the endpoint {string}")
    public void i_send_a_request_with_a_valid_id_to_the_endpoint(String requestMethod, String endpoint){

        if(requestMethod.equalsIgnoreCase("GET")) {
            response = requestSpecification.
                    when().log().all().get(endpoint);

        }}

        @Then("the response log should be displayed")
        public void the_response_log_should_be_displayed() {
        response.then().log().all();

        }

    @Then("response  should be displayed {int}")
    public void response_should_be_displayed(Integer StatusCode) {

response.then().
        statusCode(equalTo(get().getStatusCode()));

    }

    @Then("the response {string} header should be {string}")
    public void the_response_header_should_be(String expectedContentType) {

        assertTrue(response.getContentType().startsWith(expectedContentType));
    }

    @When("I send {string} request with invalid user ID as a query parameter")
    public void i_send_request_with_invalid_user_id_as_a_query_parameter(String endpoint) {


        requestSpecification = given().
                queryParam("api_key", ConfigReader.getProperty("api_key") + "abcd");

  }
        @Then("Then I should receive body key {string} should be {string}")
        public void then_i_should_receive_body_key_should_be (String key, String value){
        String responseBody = response.getBody().asString();
//
            response.then().body(key, equalTo(value));

        }

        @Then("response status code should be  {int}")
        public void response_status_code_should_be (Integer statusCode){

            response.then().
                    statusCode(equalTo(response.getStatusCode()));


        }
    }




