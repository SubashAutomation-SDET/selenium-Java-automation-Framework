package pages;

import baseClass.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminPage {
    private WebDriver driver= BrowserFactory.getDriver();
    private WebDriverWait driverWait;

    private String Uname;

    private By AdminBtn=By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[1]");
    private By AdminUserName=By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
    private By AdminUserRole=By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By AdminEmployee= By.xpath("//div[@class='oxd-autocomplete-text-input--before']//following-sibling::input");
    private By AdminStatus=By.xpath("(//div[@class='oxd-select-text-input'])[2]");

    private By AdminSearch=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private By AdminRecordsFound=By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");

    private By ResetBtn=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']");

    private By AdminRecords=By.xpath("//*[@class='oxd-table-row oxd-table-row--with-border']");

    private By RoleAdmin=By.xpath("(//div[@class='oxd-select-option']//following-sibling::span)[1]");
    private By RoleESS=By.xpath("(//div[@class='oxd-select-option']//following-sibling::span)[2]");
    private By StatusEnabled=By.xpath("//span[text()='Enabled']");
    private By StatusDisabled=By.xpath("//span[text()='Enabled']");

    private By CheckBox=By.xpath("//*[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']");
    private By DeleteMultipleRecord=By.xpath("//Button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']");
    private By DeleteSingleRecord=By.xpath("//*[@class='oxd-icon bi-trash']");

    private By DeleteConfirm=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");


    public String ClickAdminBtn()
    {
        driverWait=new WebDriverWait(driver,20);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(AdminBtn));
        WebElement clickadminBtn=driver.findElement(AdminBtn);
        clickadminBtn.click();
       return driver.getTitle();
    }

    public void EnterSystemUsersDetails(String Username,String UserRole,String EmployeeName,String status)
    {
        driverWait=new WebDriverWait(driver,10);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(AdminUserName));

        WebElement EnterUsername=driver.findElement(AdminUserName);
        EnterUsername.sendKeys(Username);

        WebElement userRole=driver.findElement(AdminUserRole);
        userRole.click();

        if(UserRole.equals("Admin")){
            Actions actions =new Actions(driver);
            actions.moveToElement(driver.findElement(RoleAdmin)).click().perform();
        }else if(UserRole.equals("ESS")){
            Actions actions =new Actions(driver);
            actions.moveToElement(driver.findElement(RoleESS)).click().perform();
        }else{
            System.out.println("User role is incorrect");
        }


        /*WebElement EnterEmployeeName=driver.findElement(AdminEmployee);
        EnterEmployeeName.sendKeys(EmployeeName);*/

        WebElement Astatus=driver.findElement(AdminStatus);
        Astatus.click();

        if(status.equals("Enabled")){
            Actions actions =new Actions(driver);
            actions.moveToElement(driver.findElement(StatusEnabled)).click().perform();
        }else if(UserRole.equals("Disabled")){
            Actions actions =new Actions(driver);
            actions.moveToElement(driver.findElement(StatusDisabled)).click().perform();
        }else{
            System.out.println("employee status is incorrect");
        }

        Uname=Username;
    }

    public void SearchAdminDetails()
    {
        WebElement searchbtn = driver.findElement(AdminSearch);
        searchbtn.click();

        System.out.println(Uname);

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        String NoRecordsFound = driver.findElement(AdminRecordsFound).getText();


        if (NoRecordsFound.equals("(0) Records Found")) {
            WebElement ClickResetBtn = driver.findElement(ResetBtn);
            ClickResetBtn.click();
        } else {
            System.out.println(NoRecordsFound);
        }

        List<WebElement> ListOfRecords = driver.findElements(AdminRecords);
        List<WebElement> ListofCheckBoxs = driver.findElements(CheckBox);

        int count = 0;
        for (WebElement value : ListOfRecords) {
            String records = value.getText();
            if (records.contains(Uname)) {
                count = 1;
                System.out.println("Records :" + records + "\n");
            } else {
                count = 0;
                System.out.println("\n"+ "---Failed---");
            }
            for (WebElement checkBox : ListofCheckBoxs) {
                if (count == 1) {
                    checkBox.click();
                    System.out.println("---Done---");
                    count = 0;
                } else {
                    continue;
                }
            }
        }
    }

    public void DeleteRecords(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String NoRecordsFound = driver.findElement(AdminRecordsFound).getText();
        if(NoRecordsFound.equals("(0) Record Found"))
        {
            System.out.println("No records are available");
        }
        else if(NoRecordsFound.equals("(1) Record Found"))
        {
            WebElement deleteRecord=driver.findElement(DeleteSingleRecord);
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            deleteRecord.click();
            System.out.println("1 record is found and deleted");

            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

         /*   Actions actions=new Actions(driver);
            WebElement DelBtnConfirm=driver.findElement(DeleteConfirm);
            actions.moveToElement(DelBtnConfirm).click().perform();*/

        }
        else
        {
            WebElement deleteRecord=driver.findElement(DeleteMultipleRecord);
            deleteRecord.click();
            System.out.println("multiple records are found and deleted");

        }
    }

}
