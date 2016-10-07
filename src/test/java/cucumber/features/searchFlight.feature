Feature: Test that you can able to book a flight from IAH to JFK

  Scenario: Book a flight from IAH to JFK
    Given i Navigate to  the flight application
    When I enter the the departure and returning information and Searched
    Then I can be able to find American airlines which has 1 stop. .
    And close the browser.
