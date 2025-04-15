Feature: User login page

  user should able to login to the page using the valid username and password

  Background:
    Given  user on the login page


  Scenario Outline: Successful login with valid credentials
    Given user have entered the valid username <UsernameValue>
    And user have entered the valid password <PasswordValue>
    When user clicks on the login button
    Examples:
      | UsernameValue | PasswordValue |
      | "Admin"       | "admin123"    |

  Scenario: UnSuccessfull Login with invalid credentials
    Given user have entered the invalid username "Admi"
    And user have entered the invalid password "Admi"
    When user clicks on the login button
    Then user should see the "Invalid credentials"



