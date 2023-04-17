package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
//        @DB and @db_only
//        @DB and @uiSide
//        @DB and @mapping

        tags = "@DB and @db_only1",
        features = "src/test/resources",
        glue = "stepDefinitions",
        stepNotifications = true,
        plugin = {
                "pretty",
                "html:target/basic-report/report.html"
        }
//        ,dryRun = true
)
public class CucumberRunner {
}
