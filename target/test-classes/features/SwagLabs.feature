Feature: Swag Labs 

Scenario: Successful Swag Labs Login
    Given User navigates to the Swag Labs login page
    When User enters a valid username 
    And User enters a valid password
    And User clicks on the login button
    Then User should be logged in to the Swag Labs account
    
Scenario: Add few Items into Swag Labs Shopping Cart
    Given User navigates to the Swag Labs login page
    When User enters a valid username 
    And User enters a valid password
    And User clicks on the login button
    When User added few items into shopping cart
    And User clicks on shopping cart icon
    Then User should be on shopping cart page
    
Scenario Outline: Verify the filter icon functionalities on Swag Labs home page 
    Given User navigates to the Swag Labs login page
    When User enters a valid username 
    And User enters a valid password
    And User clicks on the login button   
    When User select filter <filterType>
    Then User should be able to see the displayed items as per the filter <filterType>
    Examples:
    | filterType      | 
    |    lohi         |  
    |    hilo         |  
   
    
Scenario Outline: Verify the items sorting functionalities on Swag Labs home page 
    Given User navigates to the Swag Labs login page
    When User enters a valid username 
    And User enters a valid password
    And User clicks on the login button
    When User sort the items by selecting a filter <filterType>
    Then User should be able to see items alphabetical order as per the filter <filterType>
    Examples:
    | filterType      | 
    |    az           |  
    |    za           | 
    
