package stepDefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ui.LoginPage;
import pages.ui.SignInPage;
import utils.Driver;

public class SignInStepDefs {


    @Given("User navigates to Sign in page")
    public void user_navigates_to_sign_in_page() {

    }

    @When("User is on Sign in page")
    public void user_is_on_sign_in_page() {

        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new LoginPage().getLoginButton().getText()));
    }

    @Then("User should be greeted with a Welcome message")
    public void user_should_be_greeted_with_a_welcome_message() {
        SignInPage signInPage = new SignInPage();
        Assert.assertTrue(new SignInPage().getWelcomeMessage().isDisplayed());
    }



    @And("sign in page should have 2 inputs email and password")
    public void sign_in_page_should_have_2_inputs_email_and_password() {
        Assert.assertEquals(2, new SignInPage().getTwoInputs().size());
        Assert.assertEquals("Email address", new SignInPage().Email().getAttribute("placeholder"));
        Assert.assertEquals("Password", new SignInPage().Password().getAttribute("placeholder"));
    }



    @When("User enters incorrect email and password")
    public void user_enters_incorrect_email_and_password() {
     SignInPage signInPage= new SignInPage();
     signInPage.incorrectEmail();
     signInPage.incorrectPassword();
    }

    @Then("clicks on Sign In button")
    public void clicks_on_sign_in_button() {
     new SignInPage().clickOnSignInButton();
    }

    @Then("User should not be able to proceed")
    public void user_should_be_not_able_to_proceed() {

        SignInPage signInPage = new SignInPage();
        Assert.assertFalse(new SignInPage().getLoginFailedElement().isDisplayed());

    }

    @When("User leaves email blank")
    public void user_is_living_email_blank() {

        new SignInPage().Password().sendKeys("teamd");
        new SignInPage().clickOnSignInButton();

    }

    @Then("user should not be able to click on submit and proceed")
    public void user_should_not_be_able_to_click_on_submit_and_proceed() {

    SignInPage signInPage = new SignInPage();
        new SignInPage().emailInput(" ");
        new SignInPage().Password().sendKeys("teamd");
Assert.assertFalse(new SignInPage().getSignInButton().isEnabled(),"The sign-in button is not enabled when the email field is blank and the password field is filled up.");
    }
    @When("User enters correct email and password")
    public void user_enters_correct_email_and_password() {
        new SignInPage().Email().sendKeys("teamd6@gmail.com");
        new SignInPage().Password().sendKeys("teamd");
    }
        @Then("user should  be able to click on submit and proceed")
        public void user_should_be_able_to_click_on_submit_and_proceed() {
        new SignInPage().clickOnSignInButton();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php",Driver.getDriver().getCurrentUrl());
    }

}