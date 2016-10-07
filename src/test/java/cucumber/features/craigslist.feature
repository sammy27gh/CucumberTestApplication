Feature: search for apartment

  Scenario: apartment search
    Given I am able to navigate to the craigslist main site
    And Go to the apartment and housing section
    When filter by posted today and also price between 1100 and 1100 and search
    And some other action
    And yet another action
    Then I validate the outcomes
    And close the browser
