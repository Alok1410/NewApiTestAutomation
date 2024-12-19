package org.myCompany.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Path to feature files
        glue = "org.myCompany.stepDefinations", // Path to step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json" // JSON report
        }
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}

