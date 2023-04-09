package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class Hooks {

    @Before () // runs before each scenario tagged with @UI
    public void setup() {

        String environment = System.getProperty("env");

        if (environment != null) {
            switch (environment) {
                case "QA":
                    Driver.getDriver().get(ConfigReader.getProperty("QA"));
                    break;
                case "STAGING":
                    Driver.getDriver().get(ConfigReader.getProperty("STAGING"));
                    break;
                case "DEV":
                    Driver.getDriver().get(ConfigReader.getProperty("DEV"));
                    break;
                default:
                    throw new RuntimeException("Not a valid environment.");

            }
        } else {
            Driver.getDriver().get(ConfigReader.getProperty("QA"));
            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Driver.getDriver().manage().window().maximize();
        }
    }

        @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
           byte[] screenshotFile =  ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshotFile, "image/png", "screenshot");
        }
        Driver.quitDriver();
    }
}
