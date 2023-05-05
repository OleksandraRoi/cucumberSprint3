package stepDefinitions.api;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ApiUtils;
import utils.ConfigReader;

import java.util.*;

public class userStory3POST {

    Integer usersId;
    @Given("the correct key provided and the user is authenticated")
    public void the_correct_key_provided_and_the_user_is_authenticated() {
        ApiUtils.setRequestQueryParameter("api_key", ConfigReader.getProperty("key"));
    }
    @Then("the header {string} is {string}")
    public void the_header_is(String key, String value) {
        ApiUtils.setRequestHeader(key, value);
    }
    @When("the new user was created")
    public void the_new_user_was_created(Map<String, String> body) {
        ApiUtils.setRequestBody(body);
    }
    @When("the {string} request is sent to {string}")
    public void the_request_is_sent_to(String request, String endPoint) {
      ApiUtils.sendRequest(request,endPoint);
    }
    @Then("the response log is shown")
    public void the_response_log_is_shown() {
     ApiUtils.displayResponseLog();
    }
    @Given("the user id is extracted")
    public void the_user_id_is_extracted() {
        usersId = ApiUtils.getResponse().path("user_id");
    }
    @Then("the following key value information should be displayed")
    public void the_following_key_value_information_should_be_displayed(List<String> expectedKeys) {
        Response response = ApiUtils.getResponse();
        Map<String, Object> map = response.jsonPath().getMap("$");
        Set<String> strings = map.keySet();
        List<String> actualKeys = new ArrayList<>(strings);
        Assert.assertEquals(expectedKeys,actualKeys);

        Collection<Object> stringV = map.values();
        List<Object> actualV = new ArrayList<>(stringV);
        Object value1 = actualV.get(0);
        Object value2 = actualV.get(1);
        Object value3 = actualV.get(2);
        Object value4 = actualV.get(3);
        Assert.assertEquals(value1, "1");
        Assert.assertEquals(value2, "201");
        Assert.assertEquals(value3, "The user has been created");
        Assert.assertEquals(value4, usersId);

    }

    @Then("the {string} query parameter is set to new user's id")
    public void the_query_parameter_is_set_to_new_user_s_id(String key) {
     ApiUtils.setRequestQueryParameter(key,usersId);
    }
    @Then("the response body key {string} must return {string}")
    public void the_response_body_key_must_return(String key, String value) {
        ApiUtils.verifyBasicResponseBody(key,value);
    }
    @Then("JSON response and {string} header as {string}")
    public void json_response_and_header_as(String key, String value) {
      ApiUtils.verifyResponseHeader(key, value);
    }
    @Then("the response must be less than {int} ms")
    public void the_response_must_be_less_than_ms(Integer ms) {
    ApiUtils.verifyResponseTime(ms);
    }

    @When("API key is not provided")
    public void api_key_is_not_provided() {
    ApiUtils.setRequestQueryParameter("api_key", ConfigReader.getProperty("key"+"123"));
    }
    @Then("{int} Unauthorized status code with error {string} {string} should be displayed")
    public void unauthorized_status_code_with_error_should_be_displayed(Integer error, String message, String text) {
    ApiUtils.verifyResponseStatusCode(error);
    ApiUtils.verifyBasicResponseBody(message, text);
    }
    @When("the following fields are missing or empty:")
    public void the_following_fields_are_missing_or_empty(String body) {
    ApiUtils.setRequestBody(body);
    }
    @Then("API should return a {int} Unprocessable Entity error with a {string} {string}")
    public void api_should_return_a_unprocessable_entity_error_with_a(Integer error, String message, String text) {
        ApiUtils.verifyResponseStatusCode(error);
        ApiUtils.verifyBasicResponseBody(message, text);
    }

    @When("the {string} is invalid")
    public void the_is_invalid(String text, String body) {
      ApiUtils.setRequestBody(body);
    }

    @When("the email address is already in use")
    public void the_email_address_is_already_in_use(String body) {
        ApiUtils.setRequestBody(body);
    }
}
