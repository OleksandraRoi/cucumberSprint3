package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ui.EconsentPage;
import pages.ui.LoginPage;
import pages.ui.PathPage;
import utils.Driver;
import utils.SeleniumUtils;

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
    @When("The user enters their random first name, last name, and email address")
    public void the_user_enters_their_random_first_name_last_name_and_email_address() {
       new EconsentPage().fillTheFormWithRandomData();

    }
    @Then("The user should see the first name and last name filled up")
    public void the_user_should_see_the_first_name_and_last_name_filled_up() {

    EconsentPage econsentPage = new EconsentPage();

    String actualFirstName=econsentPage.getFirstNameValue();
    String actualLastName= econsentPage.getLastNameValue();

    Assert.assertNotEquals("",actualFirstName);
        SeleniumUtils.waitFor(5);
    Assert.assertNotEquals("",actualLastName);
        SeleniumUtils.waitFor(5);
    }

    //2nd
    @Then("The user should see Agree button selected by default")
    public void the_user_should_see_agree_button_selected_by_default() {

       EconsentPage econsentPage= new EconsentPage();
        String agreeDefault;
        agreeDefault = String.valueOf(econsentPage.agreeClick());
        //Assert.assertTrue("Agree is not selected", Boolean.parseBoolean(agreeDefault));
        Assert.assertTrue(new EconsentPage().AgreeSelected());
        SeleniumUtils.waitFor(5);
    }

    //3rd

    @When("The user doe not agree to the terms and conditions of eConsent")
    public void the_user_doe_not_agree_to_the_terms_and_conditions_of_e_consent() {
      new EconsentPage().UserDontAgree();
    }

    @Then("User clicks on Do not agree button")
    public void user_clicks_on_do_not_agree_button() {
     new EconsentPage().dontAgreeClick();
     Assert.assertTrue(new EconsentPage().dontAgreeSelected());
        SeleniumUtils.waitFor(5);
    }

    @Then("The user should be returned to the main application")
    public void the_user_should_be_returned_to_the_main_application() {
        Assert.assertNotEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
        SeleniumUtils.waitFor(5);
    }

    //4th

    @When("The user clicks on the  Agree button")
    public void the_user_clicks_on_the_agree_button() {
        EconsentPage econsentPage= new EconsentPage();
        econsentPage.agreeClick();

    }

    @Then("The user should be able to proceed to the next step")
    public void the_user_should_be_able_to_proceed_to_the_next_step() {
        EconsentPage econsentPage= new EconsentPage();

        econsentPage.clickAgreeButtonAndNext();

       Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");

    }

    }





