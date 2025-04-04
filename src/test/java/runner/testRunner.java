package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Feature"},
                 glue={"com.OrangeHrm.stepDefs"} ,
                 plugin={"pretty","html:target/cucumber-reports","json:target/cucumber.json"},
                 monochrome = true,
                 tags = ("@AddEmployees"))

public class testRunner extends AbstractTestNGCucumberTests {

}
