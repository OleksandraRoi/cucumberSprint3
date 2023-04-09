package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import javax.swing.*;

public class DashboardPage {


    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@alt='Bank Logo']")
    private WebElement bankLogo;


    @FindBy(xpath = "Mortgage Application")
    private WebElement mortgageApplication;


    @FindBy(xpath = "Application List")
    private WebElement applicationList;

    @FindBy(xpath = "Logout Link")
    private WebElement logoutLink;


    public boolean isBankLogoDisplayed() {
        return bankLogo.isDisplayed();
    }

    public void clickMortgageApplication() {
        MortgageApplication().click();
    }

    private WebElement MortgageApplication() {
        return null;
    }

    public void clickApplicationList() {
        applicationList.click();
    }


    public void clickLogoutLink() {
        logoutLink.click();

    }

   // public AbstractButton dashboard() {

     //   return null;
    }










