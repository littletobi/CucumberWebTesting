@api
Feature: Verify different operations using REST-assured

  Scenario Outline: Verify GET operation for one user
    Given I perform GET operation for <url> url
    Then There should be user with first name <firstName> last name <lastName> and email <email>
    Examples:
      | url       | firstName | lastName | email              |
      | /people/1 | Bill      | Gates    | bill@microsoft.com |
      | /people/4 | Tobi      | Kenobi   | empty              |

  Scenario: Verify collection of users
    Given I perform GET operation for /people url
    Then I should see users

  Scenario: Verify POST operation for one user
    Given I perform POST operation for url /people with body
      | id | firstName     | lastName     | email          |
      | 99 | testFirstName | testLastName | test@gmail.com |
    Then I should see the body has first name testFirstName and lastName testLastName
    When I perform DELETE  operation for  url /people/{id}/
      | id |
      | 99 |
    And I perform GET operation with path parameter for url /people/{id}
      | id |
      | 99 |
    Then There should not be user with first name testFirstName and last name testLastName

  Scenario: Verify POST operation for Countries
    Given I perform POST operation for url "/people/{countryNumberInPath}/countries" with body and path
      | countryNumber | countryName |
      | 99            | Jamaica     |
    Then I should see the body has country name Jamaica