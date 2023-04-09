package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PathPage;
import pages.LoginPage;
import utils.Driver;

public class EconsentStepDefinitions extends PathPage {

    //Background
    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        new LoginPage().login();
    }
    @Given("The user is on the Econsent page")
    public void the_user_is_on_the_econsent_page() {
        new PathPage().pathToEConsent();
    }
    //1st
    @Given("The user is on the electronic consent page")
    public void the_user_is_on_the_electronic_consent_page() {
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php", Driver.getDriver().getCurrentUrl());
    }
    @When("The user enters their first name, last name, and email address")
    public void the_user_enters_their_first_name_last_name_and_email_address() {

    }
    @When("The user clicks on the “Agree” radio button")
    public void the_user_clicks_on_the_agree_radio_button() {

    }
    @Then("The user should be able to proceed with the application")
    public void the_user_should_be_able_to_proceed_with_the_application() {

    }
    @Then("The user should see a confirmation message on the next page")
    public void the_user_should_see_a_confirmation_message_on_the_next_page() {

    }

    //2nd
    @When("The user leaves any required field empty")
    public void the_user_leaves_any_required_field_empty() {

    }

    @Then("The user should see an error message next to the empty field\\(s)")
    public void the_user_should_see_an_error_message_next_to_the_empty_field_s() {

    }

    @Then("The user should not be able to proceed with the application")
    public void the_user_should_not_be_able_to_proceed_with_the_application() {

    }

    //3rd

    @When("The user clicks on the link to view the disclosures")
    public void the_user_clicks_on_the_link_to_view_the_disclosures() {

    }

    @Then("The user should be taken to a page with the necessary disclosures related to the loan application")
    public void the_user_should_be_taken_to_a_page_with_the_necessary_disclosures_related_to_the_loan_application() {

    }

    @Then("The user should be able to read and review the disclosures before providing consent")
    public void the_user_should_be_able_to_read_and_review_the_disclosures_before_providing_consent() {

    }


    @Then("The user should be able to navigate back to the electronic consent page")
    public void the_user_should_be_able_to_navigate_back_to_the_electronic_consent_page() {

    }

    //4th

    @When("The user clicks on the “Don’t Agree” radio button")
    public void the_user_clicks_on_the_don_t_agree_radio_button() {

    }

    @Then("The user should be redirected back to the main application flow")
    public void the_user_should_be_redirected_back_to_the_main_application_flow() {

    }

    @Then("The user should see a message explaining that they cannot proceed without providing electronic consent.")
    public void the_user_should_see_a_message_explaining_that_they_cannot_proceed_without_providing_electronic_consent() {

    }




}
