package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;


public class BrowserFactory
{
    public WebDriver driver;
    public static ThreadLocal <WebDriver> tdriver=new ThreadLocal<>();

    public WebDriver initBrowser(String browser)
    {
        switch (browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
            tdriver.set(new ChromeDriver());
                break;
            case "firefox":
            WebDriverManager.firefoxdriver().setup();
            tdriver.set(new FirefoxDriver());
                break;
            case "edge":
            WebDriverManager.edgedriver().setup();
            tdriver.set(new EdgeDriver());
                break;
            default:
            tdriver.set(null);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
        return tdriver.get();
    }

}


