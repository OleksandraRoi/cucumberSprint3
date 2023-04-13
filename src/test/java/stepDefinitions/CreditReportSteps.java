package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreditReportPage;
import pages.PathPage;
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

    @When("The User selects Yes in checkbox")
    public void the_user_selects_yes_in_checkbox() {
        new CreditReportPage().YesCheckBoxClick();
    }
    @Then("The User is transferred to a new window with secure third-party website where they can order their Credit Report")
    public void the_user_is_transferred_to_a_new_window_with_secure_third_party_website_where_they_can_order_their_credit_report() {
    SeleniumUtils.waitFor(3);
    SeleniumUtils.switchToWindow("Order Credit Report");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/order-credit-report.html");
    }

    @When("The User selects No in checkbox")
    public void the_user_selects_no_in_checkbox() {
        new CreditReportPage().NoCheckBoxClick();

    }
    @Then("The User is not transferred to a new window third-party website and Credit Report is not ordered")
    public void the_user_is_not_transferred_to_a_new_window_third_party_website_and_credit_report_is_not_ordered() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php", Driver.getDriver().getCurrentUrl());
    }

}
