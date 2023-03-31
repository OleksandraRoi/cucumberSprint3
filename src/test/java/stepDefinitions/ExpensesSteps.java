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
        String pageSource = Driver.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains(expensesPage.getTextOnExpensesPage().getText()));
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

    @When("User is entering numeric value less than one")
    public void user_is_entering_numeric_value_less_than_one() {
    new ExpensesPage().monthlyRentalPaymentIncorrectInput();
    }
    @Then("User should get error message Please enter a value greater than or equal to one")
    public void user_should_get_error_message_please_enter_a_value_greater_than_or_equal_to_one() {

    }
    @When("User is entering non numeric value")
    public void user_is_entering_non_numeric_value() {

    }
    @Then("User should get error message Please enter a valid number")
    public void user_should_get_error_message_please_enter_a_valid_number() {

    }




}
