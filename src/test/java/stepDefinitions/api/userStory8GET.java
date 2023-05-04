package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ApiUtils;

public class userStory8GET {

    @Given("the {string} header is set to JWT token generated from login endpoint")
    public void the_header_is_set_to_jwt_token_generated_from_login_endpoint(String key) {
        String jwtToken = ApiUtils.getJWTToken();
        ApiUtils.setRequestHeader(key, jwtToken );
    }
    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer status) {
        ApiUtils.verifyResponseStatusCode(status);
    }
    @Then("the list of mortgage applications must be ordered by creation date newest to oldest")
    public void the_list_of_mortgage_applications_must_be_ordered_by_creation_date_newest_to_oldest() {

    }

    @When("the user making the request as an administrator, as type {int} user")
    public void the_user_making_the_request_as_an_administrator_as_type_user(Integer admin) {

    }
    @Then("all mortgage applications in the system must be returned")
    public void all_mortgage_applications_in_the_system_must_be_returned() {

    }

    @When("the user making the request as not an administrator")
    public void the_user_making_the_request_as_not_an_administrator() {

    }
    @Then("only mortgage applications associated with the user's user ID must be returned")
    public void only_mortgage_applications_associated_with_the_user_s_user_id_must_be_returned() {

    }

    @When("there are no mortgage applications associated with the user ID")
    public void there_are_no_mortgage_applications_associated_with_the_user_id() {

    }
    @Then("an empty list must be returned")
    public void an_empty_list_must_be_returned() {

    }
}
