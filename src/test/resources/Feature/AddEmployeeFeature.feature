Feature: Add and maintain employee records

  Background:
    Given  user on the login page
    Given user have entered the valid username "Admin"
    And user have entered the valid password "admin123"
    When user clicks on the login button


  Scenario: User should able to add an employee details
    Given User should click on the PIM button on the index page
    Given User clicks on the add employee record
    And User should able to enter "Subash","govindharaj","1116104"
    When User clicked on the create login details button
    Then User should be able to enter the "Subash","Enabled","Subash@123","Subash@123"
   # And user click on the save button.
