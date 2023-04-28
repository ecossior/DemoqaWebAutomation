Feature: Login
  Scenario: login
    When the user login to web with valid credentials
    Then the user should see: ed7
