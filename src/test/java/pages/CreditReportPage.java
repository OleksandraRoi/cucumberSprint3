package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditReportPage {

    public WebElement getCreditReportPage() {
        return CreditReportPage;
    }

    @FindBy (xpath = "(//label[@for='firstName12'])[3]")
    private WebElement CreditReportPage;

    public WebElement getYesCheckBox() {
        return YesCheckBox;
    }

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
