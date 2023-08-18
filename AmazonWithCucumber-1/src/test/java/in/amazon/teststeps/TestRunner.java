package in.amazon.teststeps;

import io.cucumber.testng.AbstractTestNGCucumberTests;


	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features = "Features",
			glue = "in.amazon.teststeps"
			//tags = "@TC_101"
			)
	       
	public class TestRunner  extends AbstractTestNGCucumberTests{
	}

