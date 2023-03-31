package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.Random;

public class ExpensesPage {

    public ExpensesPage(){PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(linkText = "Expenses")
    private WebElement expenses;
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
    @FindBy(id = "monthlyrentalpayment-error")
    private WebElement errorMessageRent;
    @FindBy(id = "firtmortagagetotalpayment-error")
    private WebElement errorMessageOwn;
    @FindBy(xpath = "//a[@href='#previous']")
    private WebElement previousButton;
    @FindBy(linkText = "Personal Information")
    private WebElement personalInfo;


    public WebElement getExpenses() {return expenses;}
    public WebElement getRentCheckBox() {return rentCheckBox;}
    public WebElement getOwnCheckBox() {return ownCheckBox;}
    public WebElement getErrorMessageRent() {return errorMessageRent;}
    public WebElement getErrorMessageOwn() {return errorMessageOwn;}
    public WebElement getPersonalInfo() {return personalInfo;}

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
        int own = random.nextInt(3501) + 2500;
        monthlyMortgagePayment.sendKeys(String.valueOf(own));
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
        int own = random.nextInt(0) + -10;
        monthlyMortgagePayment.sendKeys(String.valueOf(own));
    }

    public void monthlyRentalPaymentNonNumericInput(){
        Random random =  new Random();
        monthlyRentalPayment.click();
        char rent = (char) (random.nextInt(58) + 68);
        monthlyRentalPayment.sendKeys(String.valueOf(rent));
    }
    public void monthlyMortgagePaymentNonNumericInput(){
        Random random =  new Random();
        monthlyMortgagePayment.click();
        char own = (char) (random.nextInt(58) + 68);
        monthlyMortgagePayment.sendKeys(String.valueOf(own));
    }

    public void previousButtonClick(){previousButton.click();}

}
