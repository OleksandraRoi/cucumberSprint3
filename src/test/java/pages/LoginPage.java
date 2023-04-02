package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

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

}
