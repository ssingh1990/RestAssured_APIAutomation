package cucumber.Options;
/**
${Satendra Singh}
*/
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features="src/test/java/features",
				glue= {"stepDefinations"},
				tags = "@booktest",
				plugin= {"json:target/jsonReports/cucumber-report.json"},
				monochrome = true)

public class TestRunner {
	//mvn test verify -Dcucumber.filter.tags="@AddPlace or @DeletePlace"
	//mvn test verify -Dcucumber.filter.tags="@DeletePlace"
}
