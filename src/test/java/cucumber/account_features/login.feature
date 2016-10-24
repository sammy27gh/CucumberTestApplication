Feature: Facebook Login Functionality

  Scenario: To be able to Test the facebook Login feature
    Given I navigate to the Login Page
    When I enter the User Name and Password and click on Enter
    Then I can see that the Home Page is displayed.
    And close the Browser.
