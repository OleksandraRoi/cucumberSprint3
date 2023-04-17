package pages.ui;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

public class EconsentPage {

    public EconsentPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@id='steps-uid-0-t-5']")
    private WebElement econsentButton;

    @FindBy(id = "eConsentdeclarerFirstName")
    private WebElement firstName;

    @FindBy(id = "eConsentdeclarerLastName")
    private WebElement lastName;


    @FindBy(id = "eConsentdeclarerEmail")
    private WebElement email;


    @FindBy(xpath = "(//label[normalize-space()='Agree'])[1]")
    private WebElement agreeButton;


    @FindBy(xpath = "(//label[normalize-space()=\"Don't Agree\"])[1]")
    public WebElement dontAgreeButton;

    @FindBy(xpath = "//*[@id=\"steps-uid-0\"]/div[3]/ul/li[2]/a")
    private WebElement nextButton;

    @FindBy(id = "consentagree-error")
    private WebElement fieldRequiredMessage;


    public boolean agreeClick() {
        agreeButton.click();
        return true;
    }

    public void UserDontAgree(){
        if (!agreeButton.isSelected()){
        }dontAgreeButton.click();
        System.out.println("User Don't agree");

    }
    public void dontAgreeClick() {
        SeleniumUtils.waitFor(5);
        firstName.sendKeys(new Faker().name().firstName());
        lastName.sendKeys(new Faker().name().lastName());
        email.sendKeys(new Faker().internet().emailAddress());
        dontAgreeButton.click();

    }

    public boolean dontAgreeSelected(){
        dontAgreeButton.isSelected();
        return true;
    }
    public boolean AgreeSelected() {
        agreeButton.isSelected();
        return true;
    }

    public WebElement getFieldRequiredMessage() {
        return fieldRequiredMessage;
    }
    public void clickEconsentButton() {
        econsentButton.click();
    }

    public void clickAgreeButton() {
        agreeButton.click();
    }

    public void clickDontAgreeButton() {
        dontAgreeButton.click();
    }


    public void clickNextButton() {
        nextButton.click();
    }

    public void clickAgreeButtonAndNext() {
        agreeButton.click();
        nextButton.click();
    }

    public void clickDontAgreeButtonAndNext() {
        dontAgreeButton.click();
        nextButton.click();
    }
    public String getFirstNameValue() {
        return firstName.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastName.getAttribute("value");
    }


    public void clearTheForm() {
        firstName.clear();
        lastName.clear();
        email.clear();
    }
    public void fillTheFormWithRandomData() {
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
    }
}




