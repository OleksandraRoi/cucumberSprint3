package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ApiUtils;
import utils.ConfigReader;

public class loginPOST {
    @Given("the body input has the existing admin username and password")
    public void the_body_input_has_the_existing_admin_username_and_password() {
        String body ="{\n" +
                "  \"email\": \""+ ConfigReader.getProperty("admin_email") +"\",\n" +
                "  \"password\": \""+ConfigReader.getProperty("admin_password")+"\"\n" +
                "}" ;

        ApiUtils.setRequestBody(body);
    }
    @Then("the response body key {string} must return be true")
    public void the_response_body_key_must_return_be_true(String string) {

    }
    @Then("the JW token is generated")
    public void the_jw_token_is_generated() {
    ApiUtils.setJWTToken();
    }

    @Given("the body input has the existing username and password with application")
    public void the_body_input_has_the_existing_username_and_password_with_application() {
        String body ="{\n" +
                "  \"emai\": \""+ ConfigReader.getProperty("user_email_application") +"\",\n" +
                "  \"password\": \""+ConfigReader.getProperty("user_password_application")+"\"\n" +
                "}" ;

        ApiUtils.setRequestBody(body);
    }
    @Given("the body input has the existing username and password")
    public void the_body_input_has_the_existing_username_and_password() {
        String body ="{\n" +
                "  \"emai\": \""+ ConfigReader.getProperty("new_user_email") +"\",\n" +
                "  \"password\": \""+ConfigReader.getProperty("new_user_password")+"\"\n" +
                "}" ;

        ApiUtils.setRequestBody(body);
    }
}
