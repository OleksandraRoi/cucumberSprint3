package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage {
    @FindBy(id = "PreApprovalEdit")
    private WebElement PreApprovalEdit;
    @FindBy(id = "PersonalnformationEdit")
    private WebElement PersonalnformationEdit;
    @FindBy(id = "ExpenseEdit")
    private WebElement ExpenseEdit;
    @FindBy(id = "EmploymentIncomeEdit")
    private WebElement EmploymentIncomeEdit;
    @FindBy(id = "OrderCreditEdit")
    private WebElement OrderCreditEdit;
    @FindBy(id = "eConsentEdit")
    private WebElement eConsentEdit;
    @FindBy(id = "steps-uid-0-t-6")
    private WebElement linkToSummaryPage;

    public void clickOnPreApprovalEdit(){
        PreApprovalEdit.click();
        linkToSummaryPage.click();
    }
    public void clickOnPersonalnformationEdit(){
        PersonalnformationEdit.click();
        linkToSummaryPage.click();
    }
    public void clickOnExpenseEdit(){
        ExpenseEdit.click();
        linkToSummaryPage.click();
    }
    public void clickOnEmploymentIncomeEdit(){
        EmploymentIncomeEdit.click();
        linkToSummaryPage.click();
    }
    public void clickOnOrderCreditEdit(){
        OrderCreditEdit.click();
        linkToSummaryPage.click();
    }
    public void clickOneConsentEdit(){
        eConsentEdit.click();
        linkToSummaryPage.click();
    }
}
