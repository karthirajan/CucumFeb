package com.flipkart.stepdinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features",
                     glue = "com.flipkart.stepdinition",
                   plugin = {"html:target","json:target/reports.json"},
               monochrome = true,
                   dryRun = false,
                     tags = {"@smoke3"}) 

public class TestRunner {

}
