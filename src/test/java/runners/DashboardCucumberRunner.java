package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//public class DashboardCucumberRunner {

    @RunWith(Cucumber.class)
    @CucumberOptions(
            tags = "@Scenario1",
            features = "src/test/resources",
            glue = "stepDefinitions",
            stepNotifications = true,
            plugin = {
                    "pretty",
                    "html:target/basic-report/report.html"
            }
    )

    public class DashboardCucumberRunner {

}

