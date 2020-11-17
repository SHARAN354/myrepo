package step_Definitions;

import org.testng.annotations.AfterClass;
import java.io.File;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/sample.feature", glue="step_Definitions",
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true)

public class Runner extends AbstractTestNGCucumberTests{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("/JavaForTesters_Synechron_11thJuly2018/Cucumber/src/test/resources/config/extent-config.xml"));
	}
	
}
