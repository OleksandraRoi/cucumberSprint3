package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class EmploymentPage {

    public EmploymentPage(){ PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "(//div[@class='row'])[9]")
    private WebElement row1;
    @FindBy(xpath = "(//div[@class='row'])[10]")
    private WebElement row2;
    @FindBy(xpath = "(//div[@class='row'])[11]")
    private WebElement row3;
}
