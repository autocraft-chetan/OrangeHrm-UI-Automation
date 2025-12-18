package OrangeHrm.runners;


import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"OrangeHrm.stepdef","OrangeHrm.core"},
        tags = "@PIM",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        dryRun = false
)

public class TestRunner
{
}
