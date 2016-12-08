package soselab.easylearn;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:build/cucumber", "json:build/cucumber/cucumber.json"})
public class Runner {
}
