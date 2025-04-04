package HooksApplication;

import Utilities.ConfigurationReader;
import baseClass.BrowserFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class HooksApp {
    private BrowserFactory browserFactory;
    private WebDriver driver;
    private ConfigurationReader configurationReader;
    Properties properties;

    @Before(order=0)
    public void setup()
    {
       configurationReader=new ConfigurationReader();

        try {
            properties=configurationReader.IntiProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before(order = 1)
    public void launchBrowser()
    {
        String browserName=properties.getProperty("browser");
        browserFactory=new BrowserFactory();
        driver=browserFactory.initBrowser(browserName);
    }

    @After(order=1)
    public void teardown(Scenario scenario){
        if(scenario.isFailed())
        {
            String screenshotName=scenario.getName().replaceAll(" ","_");
            byte[] sourepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourepath,"image/png",screenshotName);
        }
    }

    @After(order = 0)
    public void quitBrowser()
    {
        driver.quit();
    }

}
