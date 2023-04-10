package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CreditReportPage {
    public CreditReportPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    public WebElement getCreditReportPage() {
        return CreditReportPage;
    }

    @FindBy (xpath = "(//label[@for='firstName12'])[3]")
    private WebElement CreditReportPage;
    public WebElement getYesCheckBox() {
        return YesCheckBox;
    }

    public WebElement getCreditReportText() {
        return CreditReportText;
    }

    @FindBy (xpath = "(//h6[@class='pb-50'])[2]")
    private WebElement CreditReportText;

    @FindBy (xpath = "//label[@for='creditreport1']")
    private WebElement YesCheckBox;

    public WebElement getNoCheckBox() {
        return NoCheckBox;
    }

    @FindBy (xpath = "//label[@for='creditreport2']")
    private WebElement NoCheckBox;

    public void YesCheckBoxClick(){
    YesCheckBox.click();
    }

    public void NoCheckBoxClick(){
        NoCheckBox.click();
    }
}
