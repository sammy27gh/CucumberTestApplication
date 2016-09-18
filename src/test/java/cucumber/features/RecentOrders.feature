Feature: RecentOrder
  
  Looking for older orders?

  Scenario: Test the Recent Orders Functionality.
    Given Login
    And Update Recent Order CreditCardDetails
    When Edit you Email Address.    
    And Change the Password
    Then I validate the outcomes
    And Close the Browser.
