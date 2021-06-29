package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/rerun/rerun.txt"},
        features = "src\\test\\resources\\AmazonValidationEmptyGold.feature",
        glue = "stepDefinitions",
        dryRun = false

)
public class AmazonRunner {


}
