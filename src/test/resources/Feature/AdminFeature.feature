Feature: Admin rights

  Background:
    Given  user on the login page
    Given user have entered the valid username "Admin"
    And user have entered the valid password "admin123"
    When user clicks on the login button

    Scenario:
      Given User can able to nagiavte to admin page
      When In the admin page user can able to enter "Admin","Admin","Ayus Praja","Enabled"
      And The user can able to click on the search button
      Then the user can able to delete the admin access
