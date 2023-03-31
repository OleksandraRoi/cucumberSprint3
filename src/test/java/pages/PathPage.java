package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.Random;

public class PathPage {
    public PathPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Mortgage Application")
    private WebElement mortgageButton;
    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy(name = "est_purchase_price")
    private WebElement purchasePrice;
    @FindBy(id = "downpayment")
    private WebElement downpaymant;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;
    @FindBy(id = "b_firstName")
    private WebElement firstName;
    @FindBy(id = "b_lastName")
    private WebElement lastName;
    @FindBy(id = "b_email")
    private WebElement email;
    @FindBy(id = "b_ssn")
    private WebElement ssn;
    @FindBy(id = "select2-b_marital-container")
    private  WebElement maritalStatus;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchBar;
    @FindBy(id = "b_cell")
    private WebElement phoneNumber;


    public void path(){
        Faker faker = new Faker();
        Random random =  new Random();
        mortgageButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(500001) + 500000;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downpaymantPrice = random.nextInt(50001) + 50000;
        downpaymant.sendKeys(String.valueOf(downpaymantPrice));
        nextButton.click();

        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
    }


}
