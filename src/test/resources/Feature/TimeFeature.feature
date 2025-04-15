Feature:

Background:
    Given  user on the login page
    Given user have entered the valid username "Admin"
    And user have entered the valid password "admin123"
    When user clicks on the login button

  Scenario:
    Given User clicks on the timesheet button
    Then User can types the hint in employee name test box
    When User should able to see the records fetched