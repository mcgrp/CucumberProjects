Feature: 
  feature to understand background

  Background: 
    Given User is on the login page
    When User provides userid and Password
    And clicks on login button
    Then user lands to home page

  Scenario: 
    When Logout button is displayed
    Then login is success

  Scenario: 
    When user clicks on logout button
    Then user will navigate back to loginpage
