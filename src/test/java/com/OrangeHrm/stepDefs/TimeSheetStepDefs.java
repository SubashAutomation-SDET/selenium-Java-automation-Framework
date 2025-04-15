package com.OrangeHrm.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TimeSheetPage;

public class TimeSheetStepDefs {

    private TimeSheetPage timeSheetPage=new TimeSheetPage();

    @Given("User should be able to login with {string}, {string}")
    public void user_should_be_able_to_login_with(String string, String string2) {
        timeSheetPage.OpenUrl();
        timeSheetPage.sendUsername(string);
        timeSheetPage.sendPassword(string2);
        timeSheetPage.ClickSubmitButton();
    }

    @Given("User clicks on the timesheet button")
    public void user_clicks_on_the_timesheet_button() {
     timeSheetPage.ClickTimeBtn();
    }

    @Then("User can types the hint in employee name test box")
    public void user_can_types_the_hint_in_employee_name_test_box() {
        timeSheetPage.EnterEmployeeName();
        timeSheetPage.ClickViewBtn();
    }

    @When("User should able to see the records fetched")
    public void user_should_able_to_see_the_records_fetched() {
      timeSheetPage.RecordsTable();
    }



}
