package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.EmploymentPage;
import pages.ExpensesPage;
import pages.PathPage;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class EmploymentSteps {

    @Then("User is locating employment page")
    public void user_is_locating_employment_page() {
        new PathPage().pathToEmployment();
    }
    @Given("The user is on Employment page")
    public void the_user_is_on_employment_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new ExpensesPage().getTextAfterNextButtonEmployment().getText()));
    }
    @Then("User should see fields for")
    public void user_should_see_fields_for(List<String> dataTable) {
        new EmploymentPage().checkBoxClick();
        Assert.assertEquals(new EmploymentPage().pageInfo(), dataTable);
    }
    @Then("EMPLOYER NAME should be a required input field")
    public void employer_name_should_be_a_required_input_field() {
      new EmploymentPage().nextButtonClick();
        //SeleniumUtils.waitForVisibility(new EmploymentPage().getErrorNameMessage(), 3);
      Assert.assertEquals(new EmploymentPage().getErrorNameMessage().getText(), "THIS FIELD IS REQUIRED.");
    }
    @Then("STATE should be as dropdown list with all {int} US states and their two letter abbreviations.")
    public void state_should_be_as_dropdown_list_with_all_us_states_and_their_two_letter_abbreviations(Integer int1) {
    Assert.assertEquals(new EmploymentPage().expectedStates(), new EmploymentPage().actualStates());
    }
    @Then("The checkbox labeled This is my current job should be unchecked by default.")
    public void the_checkbox_labeled_this_is_my_current_job_should_be_unchecked_by_default() {

    }
    @Then("The section should have a Clear option that displays a warning popup about clearing the information.")
    public void the_section_should_have_a_clear_option_that_displays_a_warning_popup_about_clearing_the_information(String string) {

    }
    @Then("The Clear option should only clear the information in that section, not any other sections.")
    public void the_clear_option_should_only_clear_the_information_in_that_section_not_any_other_sections() {

    }
    @Then("The user should be able to enter only valid information in each field")
    public void the_user_should_be_able_to_enter_only_valid_information_in_each_field() {

    }
    @Then("The Add another employer button should let the user add a new section for another employer's information.")
    public void the_add_another_mployer_button_should_let_the_user_add_a_new_section_for_another_employer_s_information() {

    }
    @Then("Each new section should contain the same fields as the first section.")
    public void each_new_section_should_contain_the_same_fields_as_the_first_section() {

    }
    @Then("The section should have a Clear option that displays a warning popup about clearing the information")
    public void the_section_should_have_a_clear_option_that_displays_a_warning_popup_about_clearing_the_information() {

    }
    @Then("The user should be able to remove a section using the Remove option.")
    public void the_user_should_be_able_to_remove_a_section_using_the_remove_option() {

    }
}
