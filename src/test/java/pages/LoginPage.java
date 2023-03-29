package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "exampleInputEmail1")
    private WebElement email;
    @FindBy(id = "exampleInputPassword1")
    private WebElement password;

    public void login(){
    email.sendKeys("teamd6@gmail.com");
    password.sendKeys("teamd");
    }
}
