package pages;

import baseClass.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TimeSheetPage {

    private WebDriver Tdriver= BrowserFactory.getDriver();
    private By TimeBtn =By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[4]");

    private By EmployeeName=By.xpath("//div[@class=\"oxd-autocomplete-text-input--before\"]//following-sibling::input");
    private By ViewBtn=By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");

    private By RecordsField= By.xpath("//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]");
    private By TableRecords=By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border\"]");

    private By InputException=By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");

    private By SuggestedName=By.xpath("//div[@class=\"oxd-autocomplete-option\"]");
    //username text box locater
    private  By UserNameTextBox = By.name("username");

    //Password text box locater
    private  By PasswordTextBox = By.name("password");

    //Submit button locater
    private  By SubmitButton=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

    public void OpenUrl(){
        BrowserFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    public void sendUsername(String username)
    {
        WebDriverWait dwait=new WebDriverWait(Tdriver,10);
        WebElement Dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(UserNameTextBox));
        WebElement UserNameInput= Tdriver.findElement(UserNameTextBox);
        UserNameInput.sendKeys(username);
    }

    public void sendPassword(String password)
    {
        WebDriverWait dwait=new WebDriverWait(Tdriver,10);
        WebElement Dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(PasswordTextBox));
        WebElement PasswordInput= Tdriver.findElement(PasswordTextBox);
        PasswordInput.sendKeys(password);
    }

    public  void ClickSubmitButton()
    {
        WebDriverWait dwait=new WebDriverWait(Tdriver,10);
        WebElement Dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
        WebElement ClickSubmit= Tdriver.findElement(SubmitButton);
        ClickSubmit.click();
    }

    public void ClickTimeBtn()
    {
        Tdriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement ClickTime=Tdriver.findElement(TimeBtn);
        ClickTime.click();
    }

    public void EnterEmployeeName()
    {
        Tdriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Tdriver.findElement(EmployeeName).sendKeys("Test");
    }

    public void ClickViewBtn()
    {
        List <WebElement> SuggestedNames=Tdriver.findElements(SuggestedName);

        for(WebElement values : SuggestedNames){
            String ExpValue=values.getText();
            if(ExpValue.equals("sww test")){
                Tdriver.findElement(SuggestedName);
                Tdriver.findElement(ViewBtn).click();
            }else{
                System.out.println("The Employee is not available in the list");
            }
        }

        Tdriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        if(Tdriver.findElement(InputException).isDisplayed())
        {
            Tdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Tdriver.findElement(EmployeeName).clear();
            System.out.println("Employee name is not visible");
        }
    }

    public void RecordsTable()
    {
        if(!(Tdriver.findElement(RecordsField).getText()).equals("(0) Records Found"))
        {
            int count=1;
            List<WebElement> RecordsTable = Tdriver.findElements(TableRecords);
            for (WebElement values : RecordsTable)
            {
                if(count==1)
                {
                    count++;
                    continue;
                }else {
                    String RowValues = values.getText();
                    System.out.println(RowValues);
                }
            }
        }
    }


}
