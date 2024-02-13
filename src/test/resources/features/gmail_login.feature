Feature: Gmail Login

  Scenario: Successful Gmail Login
    Given User navigates to the Gmail login page
    When User enters a valid username and password
    And User clicks on the login button
    Then User should be logged in to the Gmail account