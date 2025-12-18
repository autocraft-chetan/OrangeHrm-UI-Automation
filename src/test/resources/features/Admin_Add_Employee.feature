@PIM
Feature: Verify the PIM module to Add new Employee


  Background:
   # Given I am logged in as a user with role "Admin"
    Given user is not navigated to HRMS login page
    When user enters userName and Password
    When user clicks on the login button
    Then verify the dashboard is displayed
    And navigate to the PIM tab

  Scenario: Add a new employee with required details
    Given click on add employee menu item
    And current highest Employee ID should be present
    When I enter a First Name "TestFirstName" and Last Name "TestLastName"
    And I click the "Save" button
    Then I should see a success message containing "Successfully Saved"
    And I should be navigated to the Employee List page
    Then the personal details of employee list should display the details entered during the creation

