package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Automation Training\\CucumberReporting\\src\\test\\resources\\Features",
glue="Steps",
monochrome=true,
plugin= {"pretty","html:target/cucumber.html"})
public class ReportingRunner {

}
