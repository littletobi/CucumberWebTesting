@api
Feature: Verify different operations using REST-assured with authentication

  Scenario Outline: Verify GET operation for one user
    Given I perform authentication operation for "/auth/login"
      | email          | password  |
      | test1@mail.com | password1 |
    When I perform GET operation for "/people/1" url with token
    Then There should be user with first name <firstName> last name <lastName> and email <email>
    Examples:
      | firstName | lastName | email              |
      | Bill      | Gates    | bill@microsoft.com |