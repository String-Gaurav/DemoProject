/**
 * @author Gaurav.Singh
 * <p>
 * 07-Aug-2021
 * This Runner File is used to do Sequential Test Execution
 */

package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/parallel"},
        glue = {"parallel"}
        ,tags = "@positive"

        ,plugin = {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"


}


)
public class MyTestRunner {
}
