@web
Feature: Gmail page
  Gmail log in functionality when user provides incorrect credentials

#  Background:
#    Given User is on gmail page
#
#  Scenario: Providing creadentials from data table
##    When User try to login with credentials from datatable
##      | datatable@gmail.com | datatablepass1 |
#    When User try to login with credentials from datatable with headers
#      | credentials         | password       |
#      | datatable@gmail.com | datatablepass1 |
#      | +48141435233        | fakepass034    |
#    Then Error message is displayed
#
#  Scenario: Providing creadentials from json file
#    When User try to login with incorrect credentials from json "settings.json"
#    Then Error message is displayed