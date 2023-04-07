package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.PreApprovalDetailsPage;
import utils.SeleniumUtils;

import java.util.Arrays;
import java.util.List;

public class PreApprovalDetailsSteps {
    @Then("User going to PreApproval Details page")
    public void user_going_to_pre_approval_details_page() {
        new PreApprovalDetailsPage().goToMortgagePage();
    }

    @When("I got to the page ,I should be able to choose yes option in ARE YOU WORKING WITH A REALTOR?")
    public void i_got_to_the_page_i_should_be_able_to_choose_yes_option_in_are_you_working_with_a_realtor() {
        new PreApprovalDetailsPage().getRealtorClickBoxYes().click();

    }

    @When("I chose yes and I must to PROVIDE REALTOR`S NAME AND PHONE NUMBER OR EMAIL ADDRESS.")
    public void i_chose_yes_and_i_must_to_provide_realtor_s_name_and_phone_number_or_email_address() {
        Faker faker = new Faker();
        String nameAndPhoneNum = faker.name().fullName() + "" + faker.phoneNumber().cellPhone();
        new PreApprovalDetailsPage().sendInfo(nameAndPhoneNum);
    }

    @Then("I must be able to choose yes in Are you currently working with a loan officer")
    public void i_must_be_able_to_choose_yes_in_are_you_currently_working_with_a_loan_officer() {
        new PreApprovalDetailsPage().getLoanOfficerClickBoxYes().click();
    }

    @When("I chose yes The Purpose of Loan field should have a drop-down menu with options such as {string}, {string}, and {string}.")
    public void i_chose_yes_the_purpose_of_loan_field_should_have_a_drop_down_menu_with_options_such_as_and(String string, String string2, String string3) {
        Assert.assertEquals(new PreApprovalDetailsPage().drop_down_menu(), List.of(string, string2, string3));
    }

    @When("I got to the page ,I should be able to choose no option in ARE YOU WORKING WITH A REALTOR?")
    public void i_got_to_the_page_i_should_be_able_to_choose_no_option_in_are_you_working_with_a_realtor() {
        new PreApprovalDetailsPage().getRealtorClickBoxNo().click();

    }

    @Then("I must be able to choose no in Are you currently working with a loan officer")
    public void i_must_be_able_to_choose_no_in_are_you_currently_working_with_a_loan_officer() {
        new PreApprovalDetailsPage().getLoanOfficerClickBoxNo().click();
    }
    int price = 650000;
    @Then("The Estimated Purchase Price field should be a text input that allows the user to enter a dollar amount with up to two decimal places. This field should be required.")
    public void theEstimatedPurchasePriceFieldShouldBeATextInputThatAllowsTheUserToEnterADollarAmountWithUpToTwoDecimalPlacesThisFieldShouldBeRequired() {
    new PreApprovalDetailsPage().enterESTIMATED_PURCHASE_PRICE(price);
    }
    int down_payment=100000;
    @When("I filled Estimated Purchas I should be able to field Down Payment Amount")
    public void iFilledEstimatedPurchasIShouldBeAbleToFieldDownPaymentAmount() {
        new PreApprovalDetailsPage().enterDOWN_PAYMENT_AMOUNT(down_payment);
    }
    @Then("Down Payment percentage should automatically be calculated as the user enters the down payment amount")
    public void downPaymentPercentageShouldAutomaticallyBeCalculatedAsTheUserEntersTheDownPaymentAmount() {

    }

    @When("I filled all information Your Loan Amount field should automatically update based on the purchase price minus the down payment amount")
    public void iFilledAllInformationYourLoanAmountFieldShouldAutomaticallyUpdateBasedOnThePurchasePriceMinusTheDownPaymentAmount() {
    Assert.assertTrue(new PreApprovalDetailsPage().getLoanamount().getText().contains(String.valueOf(price-down_payment)));
    }



    @Then("The Source of Down Payment field should have a drop-down menu with options such as {string}, {string}, and {string}.")
    public void theSourceOfDownPaymentFieldShouldHaveADropDownMenuWithOptionsSuchAsAnd(String arg0, String arg1, String arg2) {
        System.out.println();
    Assert.assertEquals(new PreApprovalDetailsPage().drop_down_menu_2(),List.of(arg0,arg1,arg2));
    }
}