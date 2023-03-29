package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@details",
        features = "src/test/resources",
        glue = "stepDefinitions"
)
public class CucumberRunner {
}
