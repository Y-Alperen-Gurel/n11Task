package com.n11.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {

                "html:target/cucumber-report.html",

                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",

                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",
        glue = "com/n11/step_definitions",
        dryRun = false,

        tags = "@N11",


        publish=true


)
public class CukesRunner {

}
