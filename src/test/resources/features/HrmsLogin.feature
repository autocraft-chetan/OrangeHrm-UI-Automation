Feature: Verify the login functionality of HRMS portal

  @login
  Scenario: Verify logging into HRMS poral with valid username and  password
    Given user is not navigated to HRMS login page
    When user enters userName and Password
    When user clicks on the login button
    Then verify the dashboard is displayed


