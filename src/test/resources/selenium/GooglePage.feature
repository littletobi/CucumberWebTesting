Feature: Google Homepage
  This feature verifies the functionality on Google Homepage

  Scenario: Check that main elements on Google Homepage are displayed
    Given I launch the browser Chrome
    When I open Google Homepage
    Then I verify that the page displays search text box    And the page displays Google Search button
    And the page displays Im Feeling Lucky button