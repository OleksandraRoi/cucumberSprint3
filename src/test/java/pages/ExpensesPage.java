package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.Random;

public class ExpensesPage {

    public ExpensesPage(){PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath = "(//h6[@class='py-50'])[4]")
    private WebElement textOnExpensesPage;
    @FindBy(xpath = "//label[@for='expense1']")
    private WebElement rentCheckBox;
    @FindBy(xpath = "//label[@for='expense2']")
    private WebElement ownCheckBox;
    @FindBy(id = "monthlyrentalpayment")
    private WebElement monthlyRentalPayment;
    @FindBy(id = "firtmortagagetotalpayment")
    private WebElement monthlyMortgagePayment;
    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement saveButton;

    public WebElement getTextOnExpensesPage() { return textOnExpensesPage; }
    public WebElement getRentCheckBox() {return rentCheckBox;}

    public WebElement getOwnCheckBox() {return ownCheckBox;}

    public void rentCheckBoxClick(){rentCheckBox.click();}
    public void ownCheckBoxClick(){ownCheckBox.click();}
    public void monthlyRentalPaymentCorrectInput(){
        Random random =  new Random();
        monthlyRentalPayment.click();
        int rent = random.nextInt(2501) + 2500;
        monthlyRentalPayment.sendKeys(String.valueOf(rent));
    }
    public void monthlyMortgagePaymentCorrectInput(){
        Random random =  new Random();
        monthlyMortgagePayment.click();
        int rent = random.nextInt(3501) + 2500;
        monthlyMortgagePayment.sendKeys(String.valueOf(rent));
    }
    public void saveClick(){saveButton.click();}

    public void monthlyRentalPaymentIncorrectInput(){
        Random random =  new Random();
        monthlyRentalPayment.click();
        int rent = random.nextInt(0) + -10;
        monthlyRentalPayment.sendKeys(String.valueOf(rent));
    }
    public void monthlyMortgagePaymentIncorrectInput(){
        Random random =  new Random();
        monthlyMortgagePayment.click();
        int rent = random.nextInt(0) + -10;
        monthlyMortgagePayment.sendKeys(String.valueOf(rent));
    }

}
