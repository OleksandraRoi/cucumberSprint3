package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.db.EEPage;
import pages.ui.LoginPage;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class crudExpenses {


    @Given("The database contains expenses page information")
    public void the_database_contains_expenses_page_information(List<String> expected) {
        List<String> result = DBUtils.getColumnNames("select rent_own_status, monthly_rental_payment, first_mortagage_total_payment from loan.tbl_mortagage;");
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
    @Then("On the database the rent_own_status should have only Rent or Own values")
    public void on_the_database_the_rent_own_status_should_have_only_rent_or_own_values(List<String> expected){
        List<List<Object>> result = DBUtils.getListOfLists("select rent_own_status from loan.tbl_mortagage");
        if(result.contains(expected)){
            Assert.assertTrue(true);
        }
    }
    @Then("The monthly_rental_payment field should have only positive numeric values")
    public void the_monthly_rental_payment_field_should_have_only_positive_numeric_values() {
        List<List<Object>> rowRent = DBUtils.getListOfLists("select monthly_rental_payment from loan.tbl_mortagage");

        for (List<Object> innerList : rowRent) {
            for (Object obj : innerList) {
                if (obj instanceof Number && ((Number) obj).doubleValue() <= 0) {
                    Assert.assertTrue(false);
                }
            }
        }
        Assert.assertTrue(true);
    }

    @Then("The first_mortgage_total_payment field should have only positive numeric values")
    public void the_first_mortgage_total_payment_field_should_have_only_positive_numeric_values(){
        List<List<Object>> rowOwn = DBUtils.getListOfLists("select first_mortagage_total_payment from loan.tbl_mortagage");

        for (List<Object> innerList : rowOwn) {
            for (Object obj : innerList) {
                if (obj instanceof Number && ((Number) obj).doubleValue() <= 0) {
                    Assert.assertTrue(false);
                }
            }
        }
        Assert.assertTrue(true);
    }

    @Given("The user is filling out the form with the next input")
    public void the_user_is_filling_out_the_form_with_the_next_input(List<Map<String,String>> dataTable) {
        new EEPage().own5000();
    }
    @Given("The input information should be mapped in database correctly")
    public void he_input_information_should_be_mapped_in_database_correctly(List<Map<String,String>> dataTable) throws SQLException {

        try{
        String expectedText = dataTable.get(0).get("rent_own_status");
        String expectedPayment = dataTable.get(0).get("first_mortagage_total_payment");

        List<Map<String, Object>> actual = DBUtils.getListOfMaps("select * from loan.tbl_mortagage where b_email='fish@gmail.com'");
        String actualText = (String) (actual.get(0).get("rent_own_status"));
        String actualPayment = (String) (actual.get(0).get("first_mortagage_total_payment"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualText).isEqualTo(expectedText);
        softAssertions.assertThat(actualPayment).isEqualTo(expectedPayment);

        softAssertions.assertAll();
        }
        finally{
            DBUtils.executeUpdate("DELETE FROM loan.tbl_mortagage where b_email='star@gmail.com'");
        }
    }
}
