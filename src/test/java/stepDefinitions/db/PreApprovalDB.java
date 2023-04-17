package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class PreApprovalDB {
    @Then("tbl_mortagage should be stored in the following order")
    public void tbl_mortagage_should_be_stored_in_the_following_order(List<String>exp) {
        List<String>Actual = DBUtils.getColumnNames("Select id, realtor_status, realtor_info, loan_officer_status, purpose_loan, est_purchase_price,down_payment, down_payment_percent, total_loan_amount, src_down_payment ,add_fund_available from loan.tbl_mortagage");
        Assert.assertEquals(Actual,exp);
    }

    @Then("realtor_status and loan_officer_status column values be stored as integers 1 or 2")
    public void andColumnBeStoredAsIntegersOr() {
        List<List<Object>> YerOrNo = DBUtils.getListOfLists("Select realtor_status,loan_officer_status from loan.tbl_mortagage");
        List<Integer> allTogether = new ArrayList<>();
        for(int i =0;i<YerOrNo.size();i++){
            for (int g =0;g<YerOrNo.get(i).size();g++){
                allTogether.add((Integer)(YerOrNo.get(i).get(g)));
            }
        }
        for (int one:allTogether){
            Assert.assertTrue(one==1 || one==2);
        }

    }
}