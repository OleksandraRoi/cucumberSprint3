package stepDefinitions.api;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ApiUtils;
import utils.ConfigReader;

import java.util.Map;

public class userStory3POST {

    @Given("the correct key provided and the user is authenticated")
    public void the_correct_key_provided_and_the_user_is_authenticated() {
        ApiUtils.setRequestQueryParameter("key", ConfigReader.getProperty("key"));
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
    @Then("the following information should be displayed")
    public void the_following_information_should_be_displayed(String body) {


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
    ApiUtils.setRequestQueryParameter("key", "");
    }
    @Then("{int} Unauthorized status code with error {string} {string} should be displayed")
    public void unauthorized_status_code_with_error_should_be_displayed(Integer error, String message, String text) {
    ApiUtils.verifyResponseStatusCode(error);
    ApiUtils.verifyBasicResponseBody(message, text);

    }
    @When("the following fields are missing or empty:")
    public void the_following_fields_are_missing_or_empty(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("API should return a {int} Unprocessable Entity error with a {string} {string}")
    public void api_should_return_a_unprocessable_entity_error_with_a(Integer error, String message, String text) {
        ApiUtils.verifyResponseStatusCode(error);
        ApiUtils.verifyBasicResponseBody(message, text);
    }

    @When("the email address is invalid")
    public void the_email_address_is_invalid() {
      ApiUtils.setRequestBody("{\n" +
              "  \"username\": \"rockstar\",\n" +
              "  \"firstName\": \"Eva\",\n" +
              "  \"lastName\": \"Adamova\",\n" +
              "  \"email\": \"123dd\",\n" +
              "  \"password\": \"Pass123!\"\n" +
              "}");
    }
    @When("the password is invalid")
    public void the_password_is_invalid() {
        ApiUtils.setRequestBody("{\n" +
                "  \"username\": \"rockstar\",\n" +
                "  \"firstName\": \"Eva\",\n" +
                "  \"lastName\": \"Adamova\",\n" +
                "  \"email\": \"123eva@gmail.com\",\n" +
                "  \"password\": \"123\"\n" +
                "}");
    }
    @When("the first name is invalid")
    public void the_first_name_is_invalid() {
        ApiUtils.setRequestBody("{\n" +
                "  \"username\": \"rockstar\",\n" +
                "  \"firstName\": \"E\",\n" +
                "  \"lastName\": \"Adamova\",\n" +
                "  \"email\": \"123eva@gmail.com\",\n" +
                "  \"password\": \"Pass123!\"\n" +
                "}");
    }
    @When("the last name is invalid")
    public void the_last_name_is_invalid() {
        ApiUtils.setRequestBody("{\n" +
                "  \"username\": \"rockstar\",\n" +
                "  \"firstName\": \"Eva\",\n" +
                "  \"lastName\": \"A\",\n" +
                "  \"email\": \"123eva@gmail.com\",\n" +
                "  \"password\": \"Pass123!\"\n" +
                "}");
    }
    @When("the email address is already in use")
    public void the_email_address_is_already_in_use() {
        ApiUtils.setRequestBody("{\n" +
                "  \"username\": \"rockstar\",\n" +
                "  \"firstName\": \"Eva\",\n" +
                "  \"lastName\": \"Adamova\",\n" +
                "  \"email\": \"shella.ferry@yahoo.com\",\n" +
                "  \"password\": \"Pass123!\"\n" +
                "}");
    }
}
