package pages;

import com.google.common.util.concurrent.ServiceManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;

@Data
public class PreApprovalDetailsPage {
    public PreApprovalDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Mortgage Application")
    private WebElement linkToMortgageApplication;
    @FindBy(xpath ="//label[@for=\"realtor1\"]")
    private WebElement realtorClickBoxYes;
    @FindBy(xpath = "//label[@for=\"realtor2\"]")
    private WebElement realtorClickBoxNo;
    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy(xpath = "//label[@for=\"loanofficer1\"]")
    private WebElement loanOfficerClickBoxYes;
    @FindBy(xpath="//label[@for=\"loanofficer2\"]")
    private WebElement loanOfficerClickBoxNo;
    @FindBy(xpath = "//select[@name='purpose_loan']")
    private WebElement selectorPurchaseHome;
    @FindBy(id = "estimatedprice")
    private WebElement estimatedPrice;
    @FindBy(id = "downpayment")
    private  WebElement downPayment;
    @FindBy(id = "downpaymentpercentage")
    private WebElement downPaymentPercentage;
    @FindBy(className = "loanamount")
    private WebElement loanamount;
    @FindBy(xpath = "//select[@name='src_down_payment']")
    private WebElement selectorTypeOfAccount;
    @FindBy(id = "additionalfunds")
    private WebElement additionalFunds;
    @FindBy(linkText = "Next")
    private WebElement next;
    public void goToMortgagePage(){
        linkToMortgageApplication.click();
    }
    public void sendInfo(String provideName) {
        realtorInfo.sendKeys(provideName);
    }

    public List<String> drop_down_menu() {
        List<WebElement> allOptions = new Select(selectorPurchaseHome).getOptions();
        List<String> castToString = new ArrayList<>();
        for(WebElement one: allOptions){
            castToString.add(String.valueOf(one.getText()));
        }
        return castToString;
    }
    public List<String> drop_down_menu_2(){
        List<WebElement> allOptions = new Select(selectorTypeOfAccount).getOptions();
        List<String> castToString = new ArrayList<>();
        for(WebElement one: allOptions){
            castToString.add(String.valueOf(one.getText()));
        }
        return castToString;
    }
    public void enterESTIMATED_PURCHASE_PRICE(double price){
        estimatedPrice.sendKeys(String.valueOf(price));
    }
    public void enterDOWN_PAYMENT_AMOUNT(double price){
        downPayment.sendKeys(String.valueOf(price));
    }
}