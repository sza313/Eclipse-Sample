package rbi.RBI_Project;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		//format = { "pretty", "html:target/html/"},
		format = { "html:target/html/RBI-Reports", "json:target/html/cucumber/cucumber.json"},
		features = {"src//test//"},
		tags = {"@BaseLine"}
)

public class RunnerTest {
	
 

	
}
