package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SignUpPage;
import utils.Driver;


public class SignUpStepDefinitions {
    @Given("the user is on the registration page of the mortgage application website")
    public void the_user_is_on_the_registration_page_of_the_mortgage_application_website() {

        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php", Driver.getDriver().getCurrentUrl());

    }

    @When("the user enters their First Name, Last Name, Email Address, and Password")
    public void the_user_enters_their_first_name_last_name_email_address_and_password() {

        new SignUpPage().fillTheFormWithRandomData();

    }

    @When("all input fields have been filled out correctly")
    public void all_input_fields_have_been_filled_out_correctly() {

        SignUpPage homePage = new SignUpPage();
        Assert.assertTrue(homePage.firstName.isDisplayed());//firstName inputBoxElement.getValue().
        Assert.assertTrue(homePage.lastName.isDisplayed());
        Assert.assertTrue(homePage.email.isDisplayed());
        Assert.assertTrue(homePage.password.isDisplayed());

    }

    @When("the Sign Up is clickable")
    public void the_sign_up_button_should_be_clickable() throws InterruptedException {

        SignUpPage homePage = new SignUpPage();
        homePage.clickSignUpButton();
        WebElement signUpButton = homePage.signUpButton;
//        Assert.assertEquals("hhttp://qa-duobank.us-east-2.elasticbeanstalk.com/register.php", Driver.getDriver().getCurrentUrl());
        Assert.assertTrue("The Sign Up button is not clickable", signUpButton.isEnabled());
        Thread.sleep(10000);

    }

    @Then("the new account is created and the user is redirected to the Sign In page")
    public void the_user_is_redirected_to_the_sign_in_page() {

        WebDriver driver = Driver.getDriver();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php", driver.getCurrentUrl());

    }

    @Then("the message {string} is displayed")
    public void the_message_is_displayed(String string) {
        String expectedMessage = "Welcome Back!";
        WebElement messageElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]/div/h4"));
        String welcomeBackMessage = messageElement.getText();
        Assert.assertEquals(expectedMessage, welcomeBackMessage);

    }


}
