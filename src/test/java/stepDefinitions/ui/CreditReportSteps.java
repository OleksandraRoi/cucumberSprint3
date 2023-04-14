package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ui.CreditReportPage;
import pages.ui.PathPage;
import utils.Driver;
import utils.SeleniumUtils;

public class CreditReportSteps {
    @Then("User going to Credit Report page")
    public void user_going_to_credit_report_page() {
    new PathPage().pathToCreditReport();

    }
    @Given("The User is on Credit Report page")
    public void the_user_is_on_credit_report_page() {
        SeleniumUtils.scrollToElement(new CreditReportPage().getCreditReportText());
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new CreditReportPage().getCreditReportText().getText()));

    }
    @Then("The User should be able to see Yes and No select option in the Credit Report download checkbox")
    public void the_user_should_be_able_to_see_yes_and_no_select_option_in_the_credit_report_download_checkbox() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new CreditReportPage().getYesCheckBox().getText()));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new CreditReportPage().getNoCheckBox().getText()));
    }
    @Then("The User should be able to select Credit Report download by choosing Yes checkbox option")
    public void the_user_should_be_able_to_select_credit_report_download_by_choosing_yes_checkbox_option() {
new CreditReportPage().YesCheckBoxClick();
        Assert.assertTrue(new CreditReportPage().getYesCheckBox().isSelected());
    }
    @Then("The User should be able to reject Credit Report download by choosing No checkbox option")
    public void the_user_should_be_able_to_reject_credit_report_download_by_choosing_no_checkbox_option() {
        new CreditReportPage().NoCheckBoxClick();
        Assert.assertTrue(new CreditReportPage().getNoCheckBox().isSelected());
    }

    @When("The User selects Yes in checkbox")
    public void the_user_selects_yes_in_checkbox() {
        new CreditReportPage().YesCheckBoxClick();
    }
    @Then("The User is transferred to a new window with secure third-party website where they can order their Credit Report")
    public void the_user_is_transferred_to_a_new_window_with_secure_third_party_website_where_they_can_order_their_credit_report() {
    Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/order-credit-report.html",Driver.getDriver().getCurrentUrl());
    }

    @When("The User selects No in checkbox")
    public void the_user_selects_no_in_checkbox() {
        new CreditReportPage().NoCheckBoxClick();

    }
    @Then("The User is not transferred to a new window third-party website and Credit Report is not ordered")
    public void the_user_is_not_transferred_to_a_new_window_third_party_website_and_credit_report_is_not_ordered() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new CreditReportPage().getCreditReportPage().getText()));
    }

}
