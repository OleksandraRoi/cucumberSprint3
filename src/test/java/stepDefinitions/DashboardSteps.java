package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.Driver;
public class DashboardSteps {

    @Given("The user is on the logging page")
    public void the_user_is_on_the_logging_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new LoginPage().getLoginButton().getText()));
    }

    @When("User entering email and password")
    public void user_entering_email_and_password() {
        new LoginPage().login();
    }




    @Then("The user should be redirected to the mortgage account dashboard")
    public void the_user_should_be_redirected_to_the_mortgage_account_dashboard() {
        new DashboardPage().isBankLogoDisplayed();
    }

    @Given("The user is on Dashboard page")
    public void the_user_is_on_dashboard_page() { new DashboardPage().isBankLogoDisplayed();
    }


    @When("User should see the Mortgage Application")
    public void user_should_see_the_mortgage_application() {
        new DashboardPage().clickMortgageApplication();
    }

    @Then("User clicks the Mortgage Application")
    public void user_clicks_the_mortgage_application(){ new DashboardPage().clickMortgageApplication(); }


    @And("The user clicks the Application List links")
    public void the_user_clicks_the_application_list_links() {
        new DashboardPage().clickApplicationList();
    }

    @Then("User should see my account information in the top right corner")
    public void user_should_see_my_account_information_in_the_top_right_corner() {
        new DashboardPage().clickApplicationList();
    }

    @When("User click on my name or profile picture")
    public void user_click_on_my_name_or_profile_picture() {
        new DashboardPage().clickApplicationList();
    }

    @Then("User should see a dropdown menu with a Logout link")
    public void user_should_see_a_dropdown_menu_with_a_logout_link() {
        new DashboardPage().clickLogoutLink();
    }

    @And("User should be able to click on the Logout link to log out of the system")
    public void user_should_be_able_to_click_on_the_logout_link_to_log_out_of_the_system() { new DashboardPage().clickLogoutLink();

    }
}