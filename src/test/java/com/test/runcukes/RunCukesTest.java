package com.test.runcukes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(tags = {"~@Ignore", "~@Pending"},
        format = {"pretty", "html:target/html_report/RunnerTest/",
                "json:target/cucumber-report/RunnerTest.json"},
        features = {"src/test/resources/features/"},
        glue = {"com.test"}
)
public class RunCukesTest{
}
