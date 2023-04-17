package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.db.EEPage;
import pages.ui.LoginPage;
import utils.DBUtils;

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
    @Then("On the database the rent_own_status should have only {string} or {string} values")
    public void on_the_database_the_rent_own_status_should_have_only_or_values(String rent, String own){
        List<List<Object>> result = DBUtils.getListOfLists("select rent_own_status from loan.tbl_mortagage");
        System.out.println(result);

    Assert.assertTrue(result.contains(rent) || result.contains(own));
    }
    @Then("The monthly_rental_payment field should have only positive numeric values")
    public void the_monthly_rental_payment_field_should_have_only_positive_numeric_values() {
        List<List<Object>> rowRent = DBUtils.getListOfLists("select monthly_rental_payment from loan.tbl_mortagage");
        List<String> intRowRent = new ArrayList<>();
        for (int i =0;i<rowRent.size();i++) {
            for (int g =0;g<rowRent.get(i).size();g++){
                intRowRent.add((String) (rowRent.get(i).get(g)));
            }
        }
        System.out.println(intRowRent);
    }
    @Then("The first_mortgage_total_payment field should have only positive numeric values")
    public void the_first_mortgage_total_payment_field_should_have_only_positive_numeric_values(){
        List<List<Object>> rowOwn = DBUtils.getListOfLists("select first_mortagage_total_payment from loan.tbl_mortagage");
        List<String> intRowOwn = new ArrayList<>();
        for (int i =0;i<rowOwn.size();i++) {
            for (int g =0;g<rowOwn.get(i).size();g++){
                intRowOwn.add((String) (rowOwn.get(i).get(g)));
            }
        }
        System.out.println(intRowOwn);
    }

    @Given("The user is filling out the form with the next input")
    public void the_user_is_filling_out_the_form_with_the_next_input(List<Map<String,String>> dataTable) {
//        new EEPage().own5000();
    }
    @Given("The input information should be mapped in database correctly")
    public void he_input_information_should_be_mapped_in_database_correctly(List<Map<String,String>> dataTable) {

        String expectedText = dataTable.get(0).get("rent_own_status");
        String expectedPayment = dataTable.get(0).get("first_mortgage_total_payment");

        List<Map<String, Object>> actual = DBUtils.getListOfMaps("select * from loan.tbl_mortagage where b_email='star@gmail.com'");
        String actualText = (String) (actual.get(0).get("rent_own_status"));
        String actualPayment = (String) (actual.get(0).get("first_mortgage_total_payment"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualText).isEqualTo(expectedText);
        softAssertions.assertThat(actualPayment).isEqualTo(expectedPayment);

        softAssertions.assertAll();

    }




}
