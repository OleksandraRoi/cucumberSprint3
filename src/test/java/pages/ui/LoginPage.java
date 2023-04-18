package pages.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;

    public WebElement getLoginButton() {return loginButton; }

    @FindBy(id = "signin")
    private WebElement loginButton;

    public void login(){
    email.sendKeys("teamd6@gmail.com");
    password.sendKeys("teamd");
    loginButton.click();
    }

    @FindBy(xpath = "//a[@href=\"register.php\"]")
    private WebElement signUpLink;
    @FindBy(id = "first-name")
    public WebElement firstName;
    @FindBy(id = "last-name")
    public WebElement lastName;
    @FindBy(id = "email")
    public WebElement emailReg;
    @FindBy(id = "exampleInputPassword1")
    public WebElement passwordReg;
    @FindBy(id = "sign-up-button")
    public WebElement signUpButton;

    public void signUpAndLogin(){
        Faker faker = new Faker();
        signUpLink.click();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email1 = faker.internet().emailAddress();
        emailReg.sendKeys(email1);
        String password1 = faker.internet().password();
        passwordReg.sendKeys(password1);
        signUpButton.click();
        SeleniumUtils.waitFor(3);
        email.sendKeys(email1);
        password.sendKeys(password1);
        loginButton.click();
    }

}
