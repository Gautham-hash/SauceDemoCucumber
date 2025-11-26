package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepdefinition",
    plugin = {"pretty", "html:target/CucumberReport.html"},
    monochrome = true,
    tags = "@Smoke"   // Only runs scenarios with @Smoke tag
)
public class Testrunner extends AbstractTestNGCucumberTests {
}