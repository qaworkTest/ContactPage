package qaworksTest;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(format =
	{"pretty", "html:target/surefire-reports/cucumber",
		"json:target/cucumber.json"},tags={"@ContactPage"},
				features="src/test/resources")
public class RunCukesTest extends AbstractTestNGCucumberTests {

}