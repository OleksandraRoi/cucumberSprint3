package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ExpensesPage;
import pages.LoginPage;
import pages.PathPage;
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
    @Then("User is locating expenses page")
    public void user_is_locating_expenses_page() {
    new PathPage().path();
    }
    @Given("The user is on Expenses page")
    public void the_user_is_on_expenses_page() {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertTrue(expensesPage.getExpenses().isSelected());
    }
    @When("User selects Rent")
    public void user_selects_rent() {
        new ExpensesPage().rentCheckBoxClick();
    }
    @Then("Own should not be selected")
    public void own_should_not_be_selected(String string) {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertFalse(expensesPage.getOwnCheckBox().isSelected());
    }
    @When("User selects Own")
    public void user_selects_own() {
        new ExpensesPage().ownCheckBoxClick();
    }
    @Then("Rent should not be selected")
    public void rent_should_not_be_selected(String string) {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertFalse(expensesPage.getRentCheckBox().isSelected());
    }

    @When("User selecting Rent check box")
    public void user_selecting_rent_check_box() {
        new ExpensesPage().rentCheckBoxClick();
    }
    @Then("User entering numeric Monthly Rental Payment")
    public void user_entering_numeric_monthly_rental_payment() {
        new ExpensesPage().monthlyRentalPaymentCorrectInput();
    }
    @Then("Clicks on Save button")
    public void clicks_on_save_button() {
    new ExpensesPage().saveClick();
    }

    @When("User selecting Own check box")
    public void user_selecting_own_check_box() {
       new ExpensesPage().ownCheckBoxClick();
    }
    @Then("User entering numeric Monthly Mortgage Payment")
    public void user_entering_numeric_monthly_mortgage_payment() {
        new ExpensesPage().monthlyMortgagePaymentCorrectInput();
    }

    @When("User is entering numeric value less than one in Rent")
    public void user_is_entering_numeric_value_less_than_one_in_rent() {
    new ExpensesPage().monthlyRentalPaymentIncorrectInput();
    }
    @Then("User should get error message Please enter a value greater than or equal to one in Rent")
    public void user_should_get_error_message_please_enter_a_value_greater_than_or_equal_to_one_in_rent() {
    ExpensesPage expensesPage = new ExpensesPage();
    Assert.assertEquals(expensesPage.getErrorMessageRent().getText(), "Please enter a value greater than or equal to 1.");
    }
    @When("User is entering non numeric value in Rent")
    public void user_is_entering_non_numeric_value_in_rent() {
    new ExpensesPage().monthlyRentalPaymentNonNumericInput();
    }
    @Then("User should get error message Please enter a valid number in Rent")
    public void user_should_get_error_message_please_enter_a_valid_number_in_rent() {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertEquals(expensesPage.getErrorMessageRent().getText(),"Please enter a valid number.");
    }

    @When("User is entering numeric value less than one in Own")
    public void user_is_entering_numeric_value_less_than_one_in_own() {
        new ExpensesPage().monthlyMortgagePaymentIncorrectInput();
    }
    @Then("User should get error message Please enter a value greater than or equal to one in Own")
    public void user_should_get_error_message_please_enter_a_value_greater_than_or_equal_to_one_in_own() {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertEquals(expensesPage.getErrorMessageOwn().getText(), "Please enter a value greater than or equal to 1.");
    }
    @When("User is entering non numeric value in Own")
    public void user_is_entering_non_numeric_value_in_own() {
        new ExpensesPage().monthlyMortgagePaymentNonNumericInput();
    }
    @Then("User should get error message Please enter a valid number in Own")
    public void user_should_get_error_message_please_enter_a_valid_number_in_own() {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertEquals(expensesPage.getErrorMessageOwn().getText(),"Please enter a valid number.");
    }

    @Then("User should see THIS FIELD IS REQUIRED message displayed under the empty field in Rent.")
    public void user_should_see_this_field_is_required_message_displayed_under_the_empty_field_in_rent() {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertEquals(expensesPage.getErrorMessageRent().getText(),"This field is required.");
    }
    @Then("User should see THIS FIELD IS REQUIRED message displayed under the empty field in Own.")
    public void user_should_see_this_field_is_required_message_displayed_under_the_empty_field_in_own() {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertEquals(expensesPage.getErrorMessageOwn().getText(),"This field is required.");
    }

    @When("User click on Previous button")
    public void user_click_on_previous_button() {
        new ExpensesPage().previousButtonClick();
    }
    @Then("User is returned to Personal Information page")
    public void user_is_returned_to_personal_information_page() {
        ExpensesPage expensesPage = new ExpensesPage();
        Assert.assertFalse(expensesPage.getPersonalInfo().isSelected());
    }
}
