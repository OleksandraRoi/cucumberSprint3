package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.DBUtils;

import java.util.List;

public class crudEmployment {

    @Given("Database should contain the columns for Employments page")
    public void database_should_contain_the_columns_for_employments_page(List<String> expected) {
        List<String> result = DBUtils.getColumnNames("");
        Assert.assertTrue(result.contains(expected));
    }
    @Given("The database should have name and income values and not be null")
    public void the_database_should_have_name_and_income_values_and_not_be_null() {

    }
    @Given("Database should contain states abbreviations")
    public void database_should_contain_states_abbreviations() {

    }
    @Then("User selecting Alimony\\/Child Support from income source")
    public void user_selecting_alimony_child_support_from_income_source() {

    }
    @Then("User selecting Social Security\\/Disability Income from income source")
    public void user_selecting_social_security_disability_income_from_income_source() {

    }
    @Then("User selecting Unemployment Benefits from income source")
    public void user_selecting_unemployment_benefits_from_income_source() {

    }
    @Then("User selecting Interest and Dividends from income source")
    public void user_selecting_interest_and_dividends_from_income_source() {

    }
    @Then("User selecting VA Compensation from income source")
    public void user_selecting_va_compensation_from_income_source() {

    }
    @Then("User selecting Royalty Payments from income source")
    public void user_selecting_royalty_payments_from_income_source() {

    }
    @Then("User selecting Other Types of Income from income source")
    public void user_selecting_other_types_of_income_from_income_source() {

    }
    @Then("Database income source table should have one the following")
    public void database_income_source_table_should_have_one_the_following(io.cucumber.datatable.DataTable dataTable) {

    }
    @Given("Database should have the entered by user information mapped accordingly")
    public void database_should_have_the_entered_by_user_information_mapped_accordingly() {

    }
}
