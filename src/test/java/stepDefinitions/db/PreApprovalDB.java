package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.DBUtils;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Then("check if an id is unique")
    public void checkIfAnInIsUnique() {
        List<List<Object>> id = DBUtils.getListOfLists("Select count(*) from loan.tbl_mortagage group by id");
        for(Object one :id.get(0)){
            Assert.assertEquals(String.valueOf(one),"1");
        }
    }

    @Then("check all Yes column in realtor_info")
    public void checkAllYesColumnInRealtor_info() {
        List<List<Object>> name = DBUtils.getListOfLists("select realtor_info from loan.tbl_mortagage where realtor_status=1");
        System.out.println(name);
        for (List<Object> one: name){
        Assert.assertTrue(!String.valueOf(one).isEmpty());
        }
    }

    @Then("purpose_loan column should contains {string} or {string} or {string}")
    public void purpose_loanColumnShouldContainsOrOr(String First, String Second, String Third) {
        for (String one:DBUtils.getSingleColumnValues("purpose_loan","loan.tbl_mortagage ")){
            Assert.assertTrue(one.equals(First)||one.equals(Second)||one.equals(Third));
        }
    }
}