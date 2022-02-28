Feature: As a user I want to validate few features of exchangeRate website

  Scenario:As a use I can get Weather at given city
    Given I am on Weather Website
    When  I can get weather of "London" city
    Then  I can get status code 200
    And   I should get weather of london city
    And   I can get current visibility condition at london city
    And   I can get name of the city



