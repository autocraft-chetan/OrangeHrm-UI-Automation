@PIM
@Admin
Feature: Verify the PIM module to Add new Employee

  Background:
    Given user is on Add Employee page

  @createEmp
  Scenario: Add a new employee with required details
    When click on add employee menu item
    And current highest Employee ID should be present
    And I enter a First Name "chetFirstName" and Last Name "chetLastName"
    And I click the "Save" button
    Then I should see a success message containing "Successfully Saved"
    And I should be navigated to the Employee List page
    And the personal details of employee list should display the details entered during the creation

  @createEmpWithLoginCred
  Scenario: Add a new employee with required details with login details
    When click on add employee menu item
    And current highest Employee ID should be present
    And I enter a First Name "chetFirstName" and Last Name "chetLastName"
    And click on toggle to create with login details
    And enter username "chetUserName",password "TestAuto@123" and confirm password "TestAuto@123"
    And I click the "Save" button
    Then I should see a success message containing "Successfully Saved"
    And I should be navigated to the Employee List page
