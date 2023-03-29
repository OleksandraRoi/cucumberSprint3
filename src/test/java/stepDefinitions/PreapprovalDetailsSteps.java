package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class PreapprovalDetailsSteps {

    @Given("User logging in")
    public void user_login_in() {
        new LoginPage().login();
    }

//    @Then("the user is redirected to the home page")
//    public void the_user_is_redirected_to_the_home_page() {
//
//    }
}
