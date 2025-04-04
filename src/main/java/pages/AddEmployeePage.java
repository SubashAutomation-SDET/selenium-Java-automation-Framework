package pages;

import baseClass.BrowserFactory;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {
    private WebDriver driver=BrowserFactory.getDriver();



    private By PIM=By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]");

    private By AddEmployeeBtn=By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[3]");
    private By EmployeeFirstName=By.xpath("//input[@name='firstName']");
    private By EmployeeLastName=By.xpath("//input[@name='lastName']");
    private By EmployeeId=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By CreateLoginDeatailBtn=By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");

    private By EmployeeUserName=By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private By StatusEnabled=By.xpath("(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]");
    private By StatusDisabled=By.xpath("(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]");
    private By EmployeeNewPassword=By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]");
    private By EmployeeConfirmPassword=By.xpath("(//input[@class='oxd-input oxd-input--active'])[last()]");

    private By SaveBtn=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    public String ClickPIMbtn(){
        WebDriverWait dwait=new WebDriverWait(driver,30);
        WebElement ewait=dwait.until(ExpectedConditions.visibilityOfElementLocated(PIM));
        WebElement clickPim=driver.findElement(PIM);
        clickPim.click();
        String PimUrl=driver.getCurrentUrl();
        return PimUrl;
    }

    public String ClickAddEmployeebtn(){
        WebDriverWait dwait=new WebDriverWait(driver,10);
        WebElement dwaiter= dwait.until(ExpectedConditions.visibilityOfElementLocated(AddEmployeeBtn));
        WebElement AddEmpBtn= driver.findElement(AddEmployeeBtn);
        AddEmpBtn.click();
        return driver.getCurrentUrl();
    }

    public void AddEmpDetails(String Firstname,String Lastname, String EmpId) {
        WebDriverWait dwait=new WebDriverWait(driver,10);
        WebElement dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeFirstName));
        driver.findElement(EmployeeFirstName).sendKeys(Firstname);
        driver.findElement(EmployeeLastName).sendKeys(Lastname);
        driver.findElement(EmployeeId).sendKeys(EmpId);

    }

    public void clickCreateLgnDetailsBtn()
    {
            driver.findElement(CreateLoginDeatailBtn).click();
        }

    public void CreateLoginDetails(String UserName,String status,String NewPassword,String ConfirmPassword)
    {
        WebDriverWait dwait=new WebDriverWait(driver,10);

        driver.findElement(EmployeeUserName).sendKeys(UserName);
        driver.findElement(EmployeeNewPassword).sendKeys(NewPassword);
        driver.findElement(EmployeeConfirmPassword).sendKeys(ConfirmPassword);

        if (status.equals("Enabled")) {
            driver.findElement(StatusEnabled).click();
        } else {
            driver.findElement(StatusDisabled).click();
        }
    }

    public void clickSaveBtn(){
        WebDriverWait dwait=new WebDriverWait(driver,10);
        driver.findElement(SaveBtn).click();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }


}
