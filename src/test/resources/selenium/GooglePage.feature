@web
Feature: Google homepage
  This feature verifies the functionality on Google Homepage

  Scenario: Check that main elements on Google Homepage are displayed
    When I open Google Homepage
    Then I verify that the page displays search text box
    And the page displays Google Search button
    And the page displays Im Feeling Lucky button

  @web
  Scenario Outline: Check that search functionality works
    When I open Google Homepage
    And I search for information about my favorite football club <clubName>
    Then I should get wiki page about the club <clubName>
    And Official web page of the club <clubName>
    Examples:
      | clubName      |
#      |  "Barcelona"   |
#      |  "Real Madryt" |
      | "Real Madryt" |