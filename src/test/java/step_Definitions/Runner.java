package step_Definitions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/sample.feature", glue="step_Definitions",
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true)

public class Runner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("/JavaForTesters_Synechron_11thJuly2018/Cucumber/src/test/resources/config/extent-config.xml"));
	}
	
}
