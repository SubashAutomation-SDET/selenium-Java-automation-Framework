package com.OrangeHrm.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddEmployeePage;
import pages.LoginPage;


public class AddEmployeeStepDefs {

    private AddEmployeePage addEmployeePage=new AddEmployeePage();


    @Given("User should click on the PIM button on the index page")
    public void user_should_click_on_the_pim_button_on_the_index_page()
    {
        Assert.assertEquals(addEmployeePage.ClickPIMbtn(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }

    @Given("User clicks on the add employee record")
    public void user_clicks_on_the_add_employee_record()
    {
        Assert.assertEquals(addEmployeePage.ClickAddEmployeebtn(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
    }

    @Given("User should able to enter {string},{string},{string}")
    public void user_should_able_to_enter(String string, String string2, String string3)
    {
       addEmployeePage.AddEmpDetails(string,string2,string3);
    }

    @When("User clicked on the create login details button")
    public void user_clicked_on_the_create_login_details_button()
    {
    addEmployeePage.clickCreateLgnDetailsBtn();
    }


    @Then("User should be able to enter the {string},{string},{string},{string}")
    public void userShouldBeAbleToEnterThe(String arg0, String arg1, String arg2, String arg3)
    {
        addEmployeePage.CreateLoginDetails(arg0,arg1,arg2,arg3);
    }


    @Then("user click on the save button")
    public void user_click_on_the_save_button()
    {
    addEmployeePage.clickSaveBtn();
    }

}
