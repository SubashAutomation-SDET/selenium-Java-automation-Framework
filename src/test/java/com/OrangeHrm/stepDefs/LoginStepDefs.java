package com.OrangeHrm.stepDefs;

import baseClass.BrowserFactory;
import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import javax.security.auth.login.LoginException;

@Slf4j
public class LoginStepDefs {

    private LoginPage loginPage=new LoginPage(BrowserFactory.getDriver());
    public WebDriverWait waiter;
    public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    @Given("user on the login page")
    public void userOnTheLoginPage()
    {
        BrowserFactory.getDriver().get(url);
        waiter=new WebDriverWait(BrowserFactory.getDriver(), 10);
    }


    @Given("user have entered the valid username {string}")
    public void userHaveEnteredTheValidUsername(String UsernameValue) {
  //      Assert.assertTrue(loginPage.UsernameIsDisplayed());
        loginPage.sendUsername(UsernameValue);
    }

    @And("user have entered the valid password {string}")
    public void userHaveEnteredTheValidPassword(String PasswordValue) {
        Assert.assertTrue(loginPage.PasswordIsDisplayed());
        loginPage.sendPassword(PasswordValue);
    }

    @When("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        Assert.assertTrue(loginPage.SubmitButtonIsDisplayed());
        waiter=new WebDriverWait(BrowserFactory.getDriver(), 10);
        loginPage.ClickSubmitButton();

    }

    @Given("user have entered the invalid username {string}")
    public void userHaveEnteredTheInvalidUsername(String InvalidUsername) {
        waiter=new WebDriverWait(BrowserFactory.getDriver(), 10);
        loginPage.sendUsername(InvalidUsername);
    }

    @And("user have entered the invalid password {string}")
    public void userHaveEnteredTheInvalidPassword(String InvalidPassword)
    {
        loginPage.sendPassword(InvalidPassword);
    }


    @Then("user should see the {string}")
    public void userShouldSeeThe(String ExceptionMessage) {
        Assert.assertEquals(loginPage.LoginException(),ExceptionMessage);
    }


}
