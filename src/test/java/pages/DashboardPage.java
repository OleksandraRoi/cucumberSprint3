package pages;

import
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import utils.Driver;

import static utils.Driver.driver; ...

  public class DashboardPage {

      public DashboardPage() {
          PageFactory.initElements(Driver.getDriver(), this);
      }
        @FindBy(xpath = "BankLogo")
        private WebElement BankLogo;

      @FindBy(xpath = "MortgageApplication")
      private WebElement MortgageApplication;

      @FindBy(xpath = "ApplicationList" )
      private WebElement ApplicationList;

      @FindBy(xpath = "accountInfo")
      private WebElement accountInfo;

      @FindBy(xpath = "userDropdown")
      private WebElement userDropdown;

      @FindBy(xpath = "logoutLink")
      private WebElement logoutLink;



      public boolean isBankLogoDisplayed() {
          WebElement bankLogo = driver.findElement(By.xpath("//img[@alt='Bank Logo']"));
          return bankLogo.isDisplayed();

      }

      public MortgageApplicationPage clickMortgageApplicationLink() {
          WebElement mortgageApplicationLink = driver.findElement(By.xpath("//a[text()='Mortgage Application']"));
          mortgageApplicationLink.click();
          return new MortgageApplicationPage();
      }

      public ApplicationListPage clickApplicationListLink() {
          WebElement applicationListLink = driver.findElement(By.xpath("//a[text()='Application List']"));
          applicationListLink.click();
          return new ApplicationListPage();
      }

      public boolean isAccountInfoDisplayed(String firstName, String lastName) {
          WebElement accountInfo = driver.findElement(By.xpath("//div[@class='account-info']"));
          String expectedText = "Welcome, " + firstName + " " + lastName;
          return accountInfo.getText().equals(expectedText);
      }

      public void clickUserDropdown() {
          WebElement userDropdown = driver.findElement(By.xpath("//div[@class='user-dropdown']"));
          userDropdown.click();
      }

      public void clickLogoutLink() {
          WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
          logoutLink.click();
      }
  }