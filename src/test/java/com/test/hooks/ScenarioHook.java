package com.test.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.formatter.model.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScenarioHook {

    private final Logger LOG = LoggerFactory.getLogger(ScenarioHook.class);

    private static Scenario scenario;
    private Step step;

    @Before(order = 1)
    public void KeepScenario(Scenario scenario) {
        ScenarioHook.scenario = scenario;
        this.setScenario(scenario);
    }

    public void setScenario(Scenario scenario) {
        ScenarioHook.scenario = scenario;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    @After(order = 101)
    public void updateScreenShot(Scenario scenario) {
//        try {
//            if (scenario.isFailed()) {
//                scenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
//            } else {
//                scenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
//            }
//        } catch (Throwable e) {
//            LOG.info("Error in taking the screen shot", scenario);
//        }
    }
}

