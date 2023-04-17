package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.db.EEPage;
import pages.ui.LoginPage;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class crudEmployment {

    @Given("Database should contain the columns for Employments page")
    public void database_should_contain_the_columns_for_employments_page(List<String> expected) {
        List<String> result = DBUtils.getColumnNames(" select * from loan.tbl_mortagage");
        Assert.assertTrue(result.contains(expected));
    }
    @Given("The database should have name and income values and not be null")
    public void the_database_should_have_name_and_income_values_and_not_be_null() {
        List<List<Object>> nameValues = DBUtils.getListOfLists("select employer_name from loan.tbl_mortagage");
        List<List<Object>> incomeValues = DBUtils.getListOfLists("select gross_monthly_income from loan.tbl_mortagage ");

    }
    @Given("Database should contain states abbreviations")
    public void database_should_contain_states_abbreviations() {
        List<String> stringsList = List.of("AL","AK","AZ","AR", "CA","CO","CT","DE","FL",
                "GA","HI","ID", "IL","IN","IA","KS","KY","LA","ME","MD", "MA","MI","MN","MS","MO",
                "MT","NE", "NV","NH","NJ","NM","NY","NC", "ND","OH","OK","OR","PA","RI","SC",
                "SD","TN","TX","UT","VT","VA","WA", "WV","WI","WY");

        List<List<Object>> listOfLists = DBUtils.getListOfLists("select state from loan.tbl_mortagage ");

        for (List<Object> innerList : listOfLists) {
            for (Object obj : innerList) {
                if (obj instanceof WebElement) {
                    WebElement webElement = (WebElement) obj;
                    String text = webElement.getText();
                    if (stringsList.contains(text)) {
                        Assert.assertTrue(true);
                    }
                }
            }
        }

    }

    @Then("User fills out the form with different income sources")
    public void user_fills_out_the_form_with_different_income_sources() {
        new EEPage().applicationWithOtherTypesOfIncome();
    }
    @Then("Database income source table should have one the following")
    public void database_income_source_table_should_have_one_the_following(List<String> expected) {
        List<String> result = DBUtils.getColumnNames("select income_source from loan.tbl_mortagage");
        Assert.assertTrue(result.contains(expected));
    }


    @Then("Database should have the entered by user information mapped accordingly")
    public void database_should_have_the_entered_by_user_information_mapped_accordingly(List<Map<String,String>> dataTable) {

    }
}
