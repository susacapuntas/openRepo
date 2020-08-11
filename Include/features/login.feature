@tag
Feature: Login feature
  I want to make login

  @login
  Scenario Outline: Login
    Given I navigate to a login website
    When I make login with <username> and <password>
    And It displays an error <error>
    Then I close the browser

    Examples: 
      | username | password | error        |
      | srepetop | srepetop | Failed Login |
