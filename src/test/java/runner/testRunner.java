package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/Feature"},
                 glue={"com.OrangeHrm.stepDefs","HooksApplication"} ,
                 plugin={"pretty","html:target/cucumber-reports","json:target/cucumber.json"},
                 monochrome = true)

public class testRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
