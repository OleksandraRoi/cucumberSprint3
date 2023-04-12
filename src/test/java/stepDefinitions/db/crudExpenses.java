package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ExpensesPage;
import stepDefinitions.ui.ExpensesSteps;

public class crudExpenses {

    @Given("The database contains expenses page information")
    public void the_database_contains_expenses_page_information(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("User should be able to select Rent or Own")
    public void user_should_be_able_to_select_rent_or_own() {

    }

    @Then("On the database Rent or Own should have a value")
    public void on_the_database_rent_or_own_should_have_a_value() {

    }

    @Then("Rent should not be displayed on database")
    public void rent_should_not_be_displayed_on_database() {
        new ExpensesPage().getMonthlyRentalPayment().clear();
    }

    @Then("Rent should have entered value")
    public void rent_should_have_entered_value() {

    }

    @Then("Own should not be displayed on database")
    public void own_should_not_be_displayed_on_database() {

    }

    @Then("Own should have entered value")
    public void own_should_have_entered_value() {
        new ExpensesPage().getMonthlyMortgagePayment().clear();
    }

    @Then("The input information should be mapped in database correctly")
    public void the_input_information_should_be_mapped_in_database_correctly() {

    }


}
