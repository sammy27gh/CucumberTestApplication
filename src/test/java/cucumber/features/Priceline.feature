Feature: Book a flight

  Scenario: Test the functionality of the flight application
    Given I am on the fligh application page
    And Navigated to the flight section of the page
    When I enter the Booking details and search for october 10  and return on Nov 17
    Then I should see airlines and their corresponding flight price
    And close the browser
