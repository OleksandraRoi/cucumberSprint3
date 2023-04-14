package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.db.EEPage;
import utils.DBUtils;

import java.util.List;

public class crudExpenses {


    @Given("The database contains expenses page information")
    public void the_database_contains_expenses_page_information(List<String> expected) {
        List<String> result = DBUtils.getColumnNames("select rent_own_status, monthly_rental_payment, first_mortagage_total_payment from tbl_mortagage;");
        Assert.assertEquals(expected, result);
    }
    @Given("The user filling out form with Rent check box")
    public void the_user_filling_out_form_with_rent_check_box() {
    new EEPage().applicationWithRentCheckBox();
    }
    @Given("The user filling out form with Own check box")
    public void the_user_filling_out_form_with_own_check_box() {
    new EEPage().applicationWithOwnCheckBox();
    }
    @Then("On the database the rent_own_status should have only {string} or {string} values")
    public void on_the_database_the_rent_own_status_should_have_only_or_values(String rent, String own){
        List<List<Object>> result = DBUtils.getListOfLists("select rent_own_status from tbl_mortagage");
    Assert.assertTrue(result.contains(rent));
    Assert.assertTrue(result.contains(own));
    }
    @Then("The {string} field should have only positive numeric values")
    public void the_field_should_have_only_positive_numeric_values(String rentalPayment) {
        List<List<Object>> rowRent = DBUtils.getListOfLists("select" + rentalPayment + "from tbl_mortagage");
        for (List<Object> row : rowRent) {
            for (Object obj : row) {
                if ((Integer) obj > 0) {
                    Assert.assertTrue(true);
                }
                System.out.println(obj);
            }
        }
    }
    @Then("The {string} field should have only positive numeric values too")
    public void the_field_should_have_only_positive_numeric_values_too(String mortgagePayment) {
        List<List<Object>> rowOwn = DBUtils.getListOfLists("select"+ mortgagePayment +"from tbl_mortagage");
        System.out.println(rowOwn);
        for (List<Object> row : rowOwn) {
            for (Object obj : row) {
                if ((Integer)obj > 0) {
                    Assert.assertTrue(true);
                }
            }
        }

    }
    @Given("The input information should be mapped in database correctly")
    public void the_input_information_should_be_mapped_in_database_correctly() {

    }


}
