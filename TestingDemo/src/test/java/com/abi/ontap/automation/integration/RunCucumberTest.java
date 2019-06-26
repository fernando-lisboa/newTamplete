package com.abi.ontap.automation.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "junit:target/cucumber-junit-report.xml"},
                 //features = "test-classes/features") //run on app center
                 features = "src/test/resources/features") //run local
                 //TODO make this configuration dynamic
public class RunCucumberTest {
    //should be empty
}