package stepDefinitions.db;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.DBUtils;

import java.util.List;

public class PreApprovalDB {

    @Then("tbl_mortagage should be stored in the following order")
    public void tbl_mortagage_should_be_stored_in_the_following_order(List<String>exp) {
        List<String>Actual = DBUtils.getColumnNames("Select id, realtor_status, realtor_info, loan_officer_status, purpose_loan, est_purchase_price,down_payment, down_payment_percent, total_loan_amount, src_down_payment ,add_fund_available from tbl_mortagage");
        System.out.println(exp);
        Assert.assertEquals(Actual,exp);
    }
}
