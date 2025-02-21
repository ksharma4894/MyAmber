package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/Feature/2_AfterLoginFlow.feature" }, glue = "StepDefination", dryRun = false, monochrome = true,

		plugin = { "pretty", "html:target/cucumber-reports/reports1.html" })

public class TestRun extends AbstractTestNGCucumberTests {
	// No data should be there
}

//  "src/test/java/Feature/1_GuestUser.feature",