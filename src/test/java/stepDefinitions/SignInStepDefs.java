package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;
import pages.SignInPage;
import utils.ConfigReader;
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

//    @Given("User is on Sign in page")
//    public void user_is_on_sign_in_page() {
//        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new LoginPage().getLoginButton().getText()));
//    }

    @And("sign in page should have 2 inputs email and password")
    public void sign_in_page_should_have_2_inputs_email_and_password() {
        Assert.assertEquals(2, new SignInPage().getTwoInputs().size());
        Assert.assertEquals("Email address", new SignInPage().Email().getAttribute("placeholder"));
        Assert.assertEquals("Password", new SignInPage().Password().getAttribute("placeholder"));
    }

//    @Given("User is on Sign in page")
//    public void user_is_on_sign_in_page() {
//        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new LoginPage().getLoginButton().getText()));
//    }

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

    @Then("User should be not able to proceed")
    public void user_should_be_not_able_to_proceed() {

        WebElement loginFailedElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]"));
                   Assert.assertTrue(loginFailedElement.isDisplayed());



//        Assert.assertTrue(new SignInPage().getLoginFailedMessage().isDisplayed());
    }

//    @Given("User is on Sign in page")
//    public void user_is_on_sign_in_page() {
//        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new LoginPage().getLoginButton().getText()));
//    }

    @When("User leaves email blank")
    public void user_is_living_email_blank() {
        new SignInPage().Password();
        new SignInPage().clickOnSignInButton();

    }

    @Then("user should not be able to click on submit")
    public void user_should_not_be_able_to_click_on_submit() {

       Assert.assertEquals(ConfigReader.getProperty("homepage"),Driver.getDriver().getCurrentUrl());

    }



}