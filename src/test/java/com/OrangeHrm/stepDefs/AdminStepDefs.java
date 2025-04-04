package com.OrangeHrm.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;

public class AdminStepDefs {

    private AdminPage admin=new AdminPage();

    @Given("User can able to nagiavte to admin page")
    public void userCanAbleToNagiavteToAdminPage()
    {
        System.out.println(admin.ClickAdminBtn());
    }



    @Then("the user can able to delete the admin access")
    public void theUserCanableToDeleteTheAdminAccess() {
        admin.DeleteRecords();
    }

    @When("In the admin page user can able to enter {string},{string},{string},{string}")
    public void inTheAdminPageUserCanAbleToEnter(String arg0, String arg1, String arg2, String arg3) {
        admin.EnterSystemUsersDetails(arg0,arg1,arg2,arg3);

    }

    @And("The user can able to click on the search button")
    public void theUserCanAbleToClickOnTheSearchButton() {
        admin.SearchAdminDetails();
    }
}
