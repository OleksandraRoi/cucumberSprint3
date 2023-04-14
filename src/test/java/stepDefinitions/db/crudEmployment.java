package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.db.EEPage;
import utils.DBUtils;

import java.util.List;

public class crudEmployment {

    @Given("Database should contain the columns for Employments page")
    public void database_should_contain_the_columns_for_employments_page(List<String> expected) {
        List<String> result = DBUtils.getColumnNames(" select * from tbl_mortagage");
        Assert.assertTrue(result.contains(expected));
    }
    @Given("The database should have name and income values and not be null")
    public void the_database_should_have_name_and_income_values_and_not_be_null() {

    }
    @Given("Database should contain states abbreviations")
    public void database_should_contain_states_abbreviations() {

    }
    @Then("User fills out the form with different income sources")
    public void user_fills_out_the_form_with_different_income_sources() {
        new EEPage().applicationWithRentCheckBox();
        new EEPage().applicationWithOwnCheckBox();
        new EEPage().applicationWithOtherTypesOfIncome();
    }
    @Then("Database income source table should have one the following")
    public void database_income_source_table_should_have_one_the_following(List<String> expected) {
        List<String> result = DBUtils.getColumnNames("select income_source from tbl_mortagage");
        Assert.assertTrue(result.contains(expected));
    }
    @Given("Database should have the entered by user information mapped accordingly")
    public void database_should_have_the_entered_by_user_information_mapped_accordingly() {

    }
}
