Feature: To test for test objects on OI Shopping List application

  Scenario: Create a New Shopping List
    Given User on the login page
    When User Selects new list "Test Automation"
    Then User random items to the list
    And User added items should display