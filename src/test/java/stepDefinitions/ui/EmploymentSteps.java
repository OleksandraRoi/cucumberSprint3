package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ui.EmploymentPage;
import pages.ui.ExpensesPage;
import pages.ui.PathPage;
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
    @Then("STATE should be as dropdown list with all {int} US states and their two letter abbreviations.")
    public void state_should_be_as_dropdown_list_with_all_us_states_and_their_two_letter_abbreviations(Integer int1) {
    Assert.assertEquals(new EmploymentPage().expectedStates(), new EmploymentPage().actualStates());
    }
    @Then("The checkbox labeled This is my current job should be unchecked by default.")
    public void the_checkbox_labeled_this_is_my_current_job_should_be_unchecked_by_default() {
    Assert.assertFalse(new EmploymentPage().getCurrentJobCheckBox().isSelected());
    }
    @Then("The section should have a Clear option that displays a warning popup about clearing the information.")
    public void the_section_should_have_a_clear_option_that_displays_a_warning_popup_about_clearing_the_information() {
        Assert.assertTrue(new EmploymentPage().getClear().isDisplayed());
    }
    @Then("The Clear option should only clear the information in that section, not any other sections.")
    public void the_clear_option_should_only_clear_the_information_in_that_section_not_any_other_sections() {
        new EmploymentPage().fillOutEmploymentInfo();
        new EmploymentPage().scrollToClear();
        new EmploymentPage().clearClick();
        new EmploymentPage().popUpClickYes();
        String fieldName = new EmploymentPage().getEmpName().getAttribute("value");
        Assert.assertTrue(fieldName.isEmpty());
        String fieldPosition = new EmploymentPage().getPosition().getAttribute("value");
        Assert.assertTrue(fieldPosition.isEmpty());
        String fieldCity = new EmploymentPage().getCity().getAttribute("value");
        Assert.assertTrue(fieldCity.isEmpty());
        String fieldState = new EmploymentPage().getState().getAttribute("value");
        Assert.assertTrue(fieldState.isEmpty());
        String fieldStartDate = new EmploymentPage().getStartDate().getAttribute("value");
        Assert.assertTrue(fieldStartDate.isEmpty());
        String fieldEndDate = new EmploymentPage().getEndDate().getAttribute("value");
        Assert.assertTrue(fieldEndDate.isEmpty());

//    String fieldValue = new EmploymentPage().getIncome().getAttribute("value");
//    Assert.assertFalse(fieldValue.isEmpty());
    }
//    @Then("The user should be able to enter only valid information in each field")
//    public void the_user_should_be_able_to_enter_only_valid_information_in_each_field() {
//
//    }
    @Then("The Add another employer button should let the user add a new section for another employer's information.")
    public void the_add_another_employer_button_should_let_the_user_add_a_new_section_for_another_employer_s_information() {
    new EmploymentPage().addEmployerButtonClick();
    Assert.assertTrue(new EmploymentPage().getEmployer2().isDisplayed());
    }
    @Then("Each new section should contain the same fields as the first section.")
    public void each_new_section_should_contain_the_same_fields_as_the_first_section() {
    Assert.assertEquals(new EmploymentPage().pageInfo(), new EmploymentPage().pageInfo2());
    }
    @Then("EMPLOYER NAME should be a required input field")
    public void employer_name_should_be_a_required_input_field() {
        new EmploymentPage().nextButtonClick();
        Assert.assertEquals(new EmploymentPage().getErrorNameMessage().getText(), "THIS FIELD IS REQUIRED.");
    }
    @Then("The next section should have a Clear option that displays a warning popup about clearing the information.")
    public void the_next_section_should_have_a_clear_option_that_displays_a_warning_popup_about_clearing_the_information() {
    Assert.assertTrue(new EmploymentPage().getClear2().isDisplayed());
    }
    @Then("The user should be able to remove a section using the Remove option.")
    public void the_user_should_be_able_to_remove_a_section_using_the_remove_option() {
    Assert.assertTrue(new EmploymentPage().getRemove().isDisplayed());
    String text = new EmploymentPage().getEmployer2Text().getText();
    new EmploymentPage().removeClick();
    new EmploymentPage().removeYesClick();
    SeleniumUtils.waitFor(3);
    Assert.assertFalse(Driver.getDriver().getPageSource().contains(text));
    }

    @Then("User should see fields for income")
    public void user_should_see_fields_for_income(List<String> dataTable) {
        SeleniumUtils.scroll(350,350);
    Assert.assertEquals(new EmploymentPage().incomeInfo(), dataTable);
    }

    @Then("All fields in this section should only accept numeric input \\(digits and decimal points) with a maximum of two decimal places. The maximum character limit for the fields should be {int} characters.")
    public void all_fields_in_this_section_should_only_accept_numeric_input_digits_and_decimal_points_with_a_maximum_of_two_decimal_places_the_maximum_character_limit_for_the_fields_should_be_characters(Integer int1) {
    new EmploymentPage().incomeDot();
    Assert.assertEquals(new EmploymentPage().getIncomeError().getText(), "PLEASE ENTER A VALID NUMBER.");
    new EmploymentPage().overtimeDot();
    Assert.assertEquals(new EmploymentPage().getOvertimeError().getText(), "PLEASE ENTER A VALID NUMBER.");
    new EmploymentPage().bonusDot();
    Assert.assertEquals(new EmploymentPage().getBonusError().getText(), "PLEASE ENTER A VALID NUMBER.");
    new EmploymentPage().commissionDot();
    Assert.assertEquals(new EmploymentPage().getCommisionError().getText(), "PLEASE ENTER A VALID NUMBER.");
    new EmploymentPage().interestDot();
    Assert.assertEquals(new EmploymentPage().getInterestError().getText(), "PLEASE ENTER A VALID NUMBER.");

    new EmploymentPage().incomeDecimal();
    Assert.assertEquals(new EmploymentPage().getIncomeError().getText(), "PLEASE ENTER A MULTIPLE OF 0.01.");
    new EmploymentPage().overtimeDecimal();
    Assert.assertEquals(new EmploymentPage().getOvertimeError().getText(), "PLEASE ENTER A MULTIPLE OF 0.01.");
    new EmploymentPage().bonusDecimal();
    Assert.assertEquals(new EmploymentPage().getBonusError().getText(), "PLEASE ENTER A MULTIPLE OF 0.01.");
    new EmploymentPage().commissionDecimal();
    Assert.assertEquals(new EmploymentPage().getCommisionError().getText(), "PLEASE ENTER A MULTIPLE OF 0.01.");
    new EmploymentPage().interestDecimal();
    Assert.assertEquals(new EmploymentPage().getInterestError().getText(), "PLEASE ENTER A MULTIPLE OF 0.01.");

    new EmploymentPage().incomeLargeNum();
    Assert.assertEquals(new EmploymentPage().getIncomeError().getText(), "PLEASE ENTER A VALUE LESS THAN OR EQUAL TO 999999999999.99.");
    new EmploymentPage().overtimeLargeNum();
    Assert.assertEquals(new EmploymentPage().getOvertimeError().getText(), "PLEASE ENTER A VALUE LESS THAN OR EQUAL TO 999999999999.99.");
    new EmploymentPage().bonusLargeNum();
    Assert.assertEquals(new EmploymentPage().getBonusError().getText(), "PLEASE ENTER A VALUE LESS THAN OR EQUAL TO 999999999999.99.");
    new EmploymentPage().commissionLargeNum();
    Assert.assertEquals(new EmploymentPage().getCommisionError().getText(), "PLEASE ENTER A VALUE LESS THAN OR EQUAL TO 999999999999.99.");
    new EmploymentPage().interestLargeNum();
    Assert.assertEquals(new EmploymentPage().getInterestError().getText(), "PLEASE ENTER A VALUE LESS THAN OR EQUAL TO 999999999999.99.");
    }

    @Then("GROSS MONTHLY INCOME should be a required input field.")
    public void gross_monthly_income_should_be_a_required_input_field() {
        new EmploymentPage().clearIncome();
        Assert.assertEquals(new EmploymentPage().getIncomeError().getText(), "THIS FIELD IS REQUIRED.");
    }
    @Then("The Borrower Total Monthly Income field should be automatically calculated based on the other fields.")
    public void the_borrower_total_monthly_income_field_should_be_automatically_calculated_based_on_the_other_fields() {
    new EmploymentPage().calculator();
    Assert.assertEquals(new EmploymentPage().getCalculatedNum().getText(), "5000 $");
    }

    @Then("The user should see three sets of INCOME SOURCE dropdowns and Amount fields")
    public void the_user_should_see_three_sets_of_income_source_dropdowns_and_amount_fields() {
    SeleniumUtils.scroll(600, 600);
    }

    @Then("INCOME SOURCE dropdown should have")
    public void income_source_dropdown_should_have(List<String> dataTable) {
    Assert.assertEquals(new EmploymentPage().actualIncomeSource(), dataTable);
    }
    @Then("The Previous button should take the user to the previous section.")
    public void the_previous_button_should_take_the_user_to_the_previous_section() {
        SeleniumUtils.scrollToElement(new EmploymentPage().getPreviousButton());
    new EmploymentPage().previousButtonClick();
    Assert.assertTrue(Driver.getDriver().getPageSource().contains(new ExpensesPage().getExpenses().getText()));
    }
    @Then("The Next button should take the user to the next section only if all required fields are filled in.")
    public void the_next_button_should_take_the_user_to_the_next_section_only_if_all_required_fields_are_filled_in() {
    new EmploymentPage().nextButtonClick();
    new EmploymentPage().fillInNameAndIncome();
    new EmploymentPage().nextButtonClick();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new EmploymentPage().getNextPageText().getText()));
    }
    @Then("If a required field is not filled in, the Next button should not navigate to the next section and display an error message indicating which field needs to be filled in.")
    public void if_a_required_field_is_not_filled_in_the_next_button_should_not_navigate_to_the_next_section_and_display_an_error_message_indicating_which_field_needs_to_be_filled_in() {
        SeleniumUtils.scroll(-300, -300);
        new EmploymentPage().previousButtonClick();
        new EmploymentPage().cleanNameAndIncome();
        new EmploymentPage().nextButtonClick();
        Assert.assertEquals(new EmploymentPage().getErrorNameMessage().getText(), "THIS FIELD IS REQUIRED.");
        Assert.assertEquals(new EmploymentPage().getIncomeError().getText(), "THIS FIELD IS REQUIRED.");
    }

}
