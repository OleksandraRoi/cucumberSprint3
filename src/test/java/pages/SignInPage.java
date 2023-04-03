package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;



public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h4[.='Welcome Back!']")
    private WebElement welcomeMessage;

    public WebElement getWelcomeMessage() {
        return welcomeMessage;

    }

    @FindBy (xpath ="//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]" )
    private WebElement loginFailedElement;
    public WebElement getLoginFailedElement() {
        return loginFailedElement;
    }

    @FindBy(xpath = "//input")
    private List<WebElement> twoInputs;

    public List<WebElement> getTwoInputs() {
        return twoInputs;
    }

    @FindBy(name = "email")
    private WebElement email;

    public WebElement Email() {
        return email;
    }

    public void emailInput(String input) {
        email.sendKeys(input);

    }

    public void incorrectEmail() {
        String email2 = "bhgff@nvhjfh.mnbjhg";
        emailInput(email2);
    }

    @FindBy(name = "password")
    private WebElement password;

    public WebElement Password() {
        return password;

    }

    public void passwordInput(String input) {
        password.sendKeys(input);
    }

    public void incorrectPassword() {
        String password2 = "aaa";

        passwordInput(password2);
    }

    public WebElement getSignInButton() {

        return SignInButton;
    }

    @FindBy(name = "login")
    private WebElement SignInButton;

    public void clickOnSignInButton() {
        SignInButton.click();

    }

    }



