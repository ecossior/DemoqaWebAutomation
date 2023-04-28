Feature: Login

  Background: login
    Given the user login to web with valid credentials

  Scenario Outline: login
    Given the user navigates in Left panel: select Elements > Text Box
    When the user enters all information about user
      | userName   | email   | currentAddress   | permanentAddress   |
      | <userName> | <email> | <currentAddress> | <permanentAddress> |
    Then the user should see the user details
      | userName   | email   | currentAddress   | permanentAddress   |
      | <userName> | <email> | <currentAddress> | <permanentAddress> |
    Examples:
      | userName | email        | currentAddress     | permanentAddress     |
      | edmundo  | ed@gmail.com | C. Oquendo Nro 489 | Av. Benjamin Nro 489 |



