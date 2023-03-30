package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.Driver;

public class ExpensesSteps {

    @Given("The user is on the logging page")
    public void the_user_is_on_the_logging_page() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(loginPage.getLoginButton().getText()));
    }

    @When("User entering email and password")
    public void user_entering_email_and_password() {
        new LoginPage().login();
    }

}
