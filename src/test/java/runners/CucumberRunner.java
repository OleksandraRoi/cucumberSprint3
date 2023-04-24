package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
//        @DB and @db_only1
//        @DB and @uiSide
//        @DB and @mapping

        tags = "@DB and @db_only1",
//        tags = "@DB and @db_only2",
//        tags = "@DB and @uiSide1",
//        tags = "@DB and @uiSide2",
//        tags = "@DB and @mapping1",
//        tags = "@DB and @mapping2",
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
