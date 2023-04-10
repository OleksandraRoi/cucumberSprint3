package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SummaryPage {
    public SummaryPage(){
        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(xpath = "//div[@class='PreApprovalDetails']//a")
    private WebElement PreApprovalEdit;
    @FindBy(xpath = "//div[@class='Personalnformation']//a")
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
    @FindBy(linkText = "Submit")
    private WebElement submit;

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
    public void goToSummarypage(){
        linkToSummaryPage.click();
    }
    public void clickOnSubmit(){
        submit.click();
    }
}
