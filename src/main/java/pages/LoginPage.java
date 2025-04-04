package pages;

import baseClass.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriverWait wait;
    private WebDriver driver;


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //username text box locater
    private  By UserNameTextBox = By.name("username");

    //Password text box locater
    private  By PasswordTextBox = By.name("password");

    //Submit button locater
    private  By SubmitButton=By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

    private By ExceptionMessage=By.xpath("//p[text()='Invalid credentials']");


    public boolean UsernameIsDisplayed( )
    {
        WebDriverWait dwait=new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameTextBox)).isDisplayed();

    }

    public void sendUsername(String username)
    {
        WebDriverWait dwait=new WebDriverWait(driver,10);
        WebElement Dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
        WebElement UserNameInput= driver.findElement(UserNameTextBox);
        UserNameInput.sendKeys(username);
    }

    public boolean PasswordIsDisplayed(){
        return driver.findElement(PasswordTextBox).isDisplayed();
    }

    public void sendPassword(String password){
        WebDriverWait dwait=new WebDriverWait(driver,10);
        WebElement Dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(PasswordTextBox));
        WebElement PasswordInput= driver.findElement(PasswordTextBox);
        PasswordInput.sendKeys(password);
    }

    public boolean SubmitButtonIsDisplayed(){
        return driver.findElement(SubmitButton).isDisplayed();
    }
    public  void ClickSubmitButton(){
        WebDriverWait dwait=new WebDriverWait(driver,10);
        WebElement Dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
        WebElement ClickSubmit= driver.findElement(SubmitButton);
        ClickSubmit.click();
    }

    public String LoginException(){
        WebDriverWait dwait=new WebDriverWait(driver,10);
        WebElement Dwaiter=dwait.until(ExpectedConditions.visibilityOfElementLocated(ExceptionMessage));
        return driver.findElement(ExceptionMessage).getText();
    }


}
