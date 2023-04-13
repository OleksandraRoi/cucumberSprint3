package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ExpensesPage;
import stepDefinitions.ui.ExpensesSteps;
import utils.DBUtils;

import java.sql.SQLOutput;
import java.util.List;

public class crudExpenses {


    @Given("The database contains expenses page information")
    public void the_database_contains_expenses_page_information(List<String> expected) {
        List<String> result = DBUtils.getColumnNames("select rent_own_status, monthly_rental_payment, first_mortagage_total_payment from tbl_mortagage;");
        Assert.assertEquals(expected, result);
    }
    @Given("The user filling out form with Rent check box")
    public void the_user_filling_out_form_with_rent_check_box() {

    }
    @Given("The user filling out form with Own check box")
    public void the_user_filling_out_form_with_own_check_box() {

    }
    @Then("On the database the rent_own_status should have only Rent or Own values")
    public void on_the_database_the_rent_own_status_should_have_only_rent_or_own_values() {

    }
    @Given("The payment fields should have only positive numeric values")
    public void the_payment_fields_should_have_only_positive_numeric_values() {

    }
    @Given("The input information should be mapped in database correctly")
    public void the_input_information_should_be_mapped_in_database_correctly() {

    }


}
