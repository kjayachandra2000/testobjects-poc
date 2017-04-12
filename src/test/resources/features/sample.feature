Feature: To test OI Shopping List application

  Scenario: Adding items to My Shopping List
    Given User on the login page
    When User random items to the list
    Then User added items should display

  Scenario: Create a New Shopping List
    Given User on the login page
    When User Selects new list "Test Automation"
    Then User random items to the list
    And User added items should display