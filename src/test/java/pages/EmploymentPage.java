package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.SeleniumUtils;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class EmploymentPage {

    public EmploymentPage(){ PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//fieldset[@id='steps-uid-0-p-3']//div[@id='employer1']//div[@class='form-group']//label")
    private List<WebElement> sixRowsText;
    @FindBy(xpath = "//div[@id='employer2']//div[@class='form-group']//label")
    private List<WebElement> sixRowsText2;
    @FindBy(xpath = "//label[@for='currentjob1']")
    private WebElement currentCheckBox;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;
    @FindBy(id = "employername1-error")
    private WebElement errorNameMessage;
    @FindBy(name = "state[]")
    private WebElement states;
    @FindBy(xpath = "//label[@for='currentjob1']")
    private WebElement currentJobCheckBox;
    @FindBy(id = "clear1")
    private WebElement clear;
    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-warning']")
    private WebElement popUpYes;
    @FindBy(id = "grossmonthlyincome")
    private WebElement income;
    @FindBy(id = "addemployer")
    private WebElement addEmployerButton;
    @FindBy(xpath ="(//a[@href='#employer2'])[2]")
    private WebElement employer2;
    @FindBy(id = "clear2")
    private WebElement clear2;
    @FindBy(id = "remove2")
    private WebElement remove;
    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-warning']")
    private WebElement removerPopUpYes;
    @FindBy(id = "employername1")
    private WebElement empName;
    @FindBy(id = "position1")
    private WebElement position;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "state1")
    private WebElement state;
    @FindBy(id = "start_date1")
    private WebElement startDate;
    @FindBy(id = "end_date1")
    private WebElement endDate;
    @FindBy(xpath = "//div[@id='employer1']//input[@class='form-control']")
    private List <WebElement> fieldsToFillOut;
    @FindBy(xpath = "//label[@for='grossmonthlyincome']")
    private WebElement monthlyIncomeText;
    @FindBy(xpath = "//label[@for='monthlyovertime']")
    private WebElement monthlyOvertimeText;
    @FindBy(xpath = "//label[@for='monthlybonuses']")
    private WebElement monthlyBonusText;
    @FindBy(xpath = "//label[@for='monthlycommission']")
    private WebElement monthlyCommissionText;
    @FindBy(xpath = "//label[@for='monthlydividents']")
    private WebElement monthlyInterestText;
    @FindBy(id = "grossmonthlyincome")
    private WebElement monthlyIncome;
    @FindBy(id = "monthlyovertime")
    private WebElement monthlyOvertime;
    @FindBy(id = "monthlybonuses")
    private WebElement monthlyBonus;
    @FindBy(id = "monthlycommission")
    private WebElement monthlyCommission;
    @FindBy(id = "monthlydividents")
    private WebElement monthlyInterest;
    @FindBy(id = "grossmonthlyincome-error")
    private  WebElement incomeError;
    @FindBy(id = "monthlyovertime-error")
    private WebElement overtimeError;
    @FindBy(id = "monthlybonuses-error")
    private WebElement bonusError;
    @FindBy(id = "monthlycommission-error")
    private WebElement commisionError;
    @FindBy(id = "monthlydividents-error")
    private WebElement interestError;
    @FindBy(xpath = "//div[@class='borrowertotalmonthlyincome'] //span")
    private WebElement calculatedNum;
    @FindBy(name = "income_source[]")
    private WebElement incomeSourceDropDown;
    @FindBy(xpath = "//a[@href='#previous']")
    private WebElement previousButton;
    @FindBy(xpath = "(//h6[@class='pb-50'])[2]")
    private WebElement nextPageText;
    @FindBy(xpath = "(//a[@href='#employer2'])[2]")
    private WebElement employer2Text;

    public WebElement getErrorNameMessage() {return errorNameMessage;}
    public WebElement getCurrentJobCheckBox() {return currentJobCheckBox;}
    public WebElement getClear() {return clear;}
    public WebElement getIncome() {return income;}
    public WebElement getEmployer2() {return employer2;}
    public WebElement getClear2() {return clear2;}
    public WebElement getRemove() {return remove;}
    public List<WebElement> getFieldsToFillOut() {return fieldsToFillOut;}
    public WebElement getEmpName() {return empName;}
    public WebElement getPosition() {return position;}
    public WebElement getCity() {return city;}
    public WebElement getState() {return state;}
    public WebElement getStartDate() {return startDate;}
    public WebElement getEndDate() {return endDate;}
    public WebElement getIncomeError() {return incomeError;}
    public WebElement getOvertimeError() {return overtimeError;}
    public WebElement getBonusError() {return bonusError;}
    public WebElement getCommisionError() {return commisionError;}
    public WebElement getInterestError() {return interestError;}
    public WebElement getCalculatedNum() {return calculatedNum;}
    public WebElement getNextPageText() {return nextPageText;}
    public WebElement getEmployer2Text() {return employer2Text;}
    public WebElement getPreviousButton() {return previousButton;}

    public String fieldName(){
        String value = getEmpName().getAttribute("value");
        return value;
    }

    public void checkBoxClick(){currentCheckBox.click();}
    public List<String> pageInfo(){
        List<String> text = SeleniumUtils.getElementsText(sixRowsText);
        return text;
    }
    public List<String> pageInfo2(){
        List<String> text = SeleniumUtils.getElementsText(sixRowsText2);
        return text;
    }
    public List<String> incomeInfo(){
        List<String> text = new ArrayList<>();
        String originalString = monthlyIncomeText.getText();
        String newString = originalString.substring(0, originalString.length() - 1);
        text.add(newString);
        text.add(monthlyOvertimeText.getText());
        text.add(monthlyBonusText.getText());
        text.add(monthlyCommissionText.getText());
        text.add(monthlyInterestText.getText());
        return text;
    }
    public void nextButtonClick(){nextButton.click();}
    public List<String> expectedStates(){
        List<String>  statesCount = List.of("--Select--","Alabama (AL)","Alaska (AK)","Arizona (AZ)","Arkansas (AR)",
                "California (CA)","Colorado (CO)","Connecticut (CT)","Delaware (DE)","Florida (FL)","Georgia (GA)","Hawaii (HI)","Idaho (ID)",
                "Illinois (IL)","Indiana (IN)","Iowa (IA)","Kansas (KS)","Kentucky (KY)","Louisiana (LA)","Maine (ME)","Maryland (MD)",
                "Massachusetts (MA)","Michigan (MI)","Minnesota (MN)","Mississippi (MS)","Missouri (MO)","Montana (MT)","Nebraska (NE)",
                "Nevada (NV)","New Hampshire (NH)","New Jersey (NJ)","New Mexico (NM)","New York (NY)","North Carolina (NC)",
                "North Dakota (ND)","Ohio (OH)","Oklahoma (OK)","Oregon (OR)","Pennsylvania (PA)","Rhode Island (RI)","South Carolina (SC)",
                "South Dakota (SD)","Tennessee (TN)","Texas (TX)","Utah (UT)","Vermont (VT)","Virginia (VA)","Washington (WA)",
                "West Virginia (WV)","Wisconsin (WI)","Wyoming (WY)" );
        return statesCount;
    }
//    public List<String> expectedIncomeSource() {
//        List<String> income = List.of("Select One", "Alimony/Child Support", "Social Security/Disability Income",
//                "Unemployment Benefits", "Interest and Dividends", "VA Compensation", "Royalty Payments",
//                "Other Types of Income");
//        return income;
//    }
    public List <String > actualStates(){
        List <WebElement> statesDropDown = new Select(states).getOptions();
        int optionsCount = new Select(states).getOptions().size();
        List <String> states = new ArrayList<>();

        for(WebElement state : statesDropDown){
            states.add(state.getText());
        }
        return states;
    }
    public List<String> actualIncomeSource(){
        List <WebElement> dropDown = new Select(incomeSourceDropDown).getOptions();
        int optionsCount = new Select(incomeSourceDropDown).getOptions().size();
        List <String> actualSource = new ArrayList<>();

        for(WebElement source : dropDown){
            actualSource.add(source.getText());
        }
        return actualSource;
    }
    public void clearClick(){clear.click();}
    public void popUpClickYes(){popUpYes.click();}
    public void addEmployerButtonClick(){ addEmployerButton.click();}
    public void removeClick(){remove.click();}
    public void removeYesClcik(){ removerPopUpYes.click();}
    public void scrollToClear(){SeleniumUtils.scroll(-50, -50);}

    public void fillOutEmploymentInfo(){
        Faker faker = new Faker();
        empName.sendKeys(faker.name().fullName());
        position.sendKeys(faker.company().profession());
        city.sendKeys(faker.address().city());
        state.click();
        state.sendKeys("I", Keys.ENTER);
        startDate.sendKeys(faker.backToTheFuture().date());
        endDate.sendKeys(faker.backToTheFuture().date());
        //int salary = faker.number().numberBetween(4000, 15000);
        //income.sendKeys(String.valueOf(salary));
    }
    public void incomeDot(){
        monthlyIncome.sendKeys(".");
        monthlyInterest.click();
    }
    public void overtimeDot(){
        monthlyOvertime.sendKeys(".");
        monthlyInterest.click();
    }
    public void bonusDot(){
        monthlyBonus.sendKeys(".");
        monthlyInterest.click();
    }
    public void commissionDot(){
        monthlyCommission.sendKeys(".");
        monthlyInterest.click();
    }
    public void interestDot(){
        monthlyInterest.sendKeys(".");
        monthlyCommission.click();
    }

    public void incomeDecimal(){
        monthlyIncome.sendKeys("111");
    }
    public void overtimeDecimal(){
        monthlyOvertime.sendKeys("111");
    }
    public void bonusDecimal(){
        monthlyBonus.sendKeys("111");
    }
    public void commissionDecimal(){
        monthlyCommission.sendKeys("111");
    }
    public void interestDecimal(){
        monthlyInterest.sendKeys("111");
    }

    public void incomeLargeNum(){
        monthlyIncome.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyIncome.sendKeys("1111111111111");

    }
    public void overtimeLargeNum(){
        monthlyOvertime.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyOvertime.sendKeys("1111111111111");
    }
    public void bonusLargeNum(){
        monthlyBonus.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyBonus.sendKeys("1111111111111");
    }
    public void commissionLargeNum(){
        monthlyCommission.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyCommission.sendKeys("1111111111111");
    }
    public void interestLargeNum(){
        monthlyInterest.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyInterest.sendKeys("1111111111111");
    }
    public void clearIncome(){
        monthlyIncome.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE);
    }

    public void calculator(){
        monthlyIncome.sendKeys("1000");
        monthlyOvertime.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyOvertime.sendKeys("1000");
        monthlyBonus.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyBonus.sendKeys("1000");
        monthlyCommission.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyCommission.sendKeys("1000");
        monthlyInterest.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE);
        monthlyInterest.sendKeys("1000");
    }
    public void previousButtonClick(){previousButton.click();}
    public void cleanNameAndIncome(){
        clearClick();
        monthlyIncome.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);}
    public void fillInNameAndIncome(){
        Faker faker = new Faker();
        empName.sendKeys(faker.name().fullName());
        monthlyIncome.sendKeys("5000");
    }

}
