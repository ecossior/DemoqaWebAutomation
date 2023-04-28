Feature: checkbox

  Background: login
    Given the user login to web with valid credentials

  Scenario: checkbox select nodes
    Given the user navigates in Left panel: select Elements > Check Box
    When the user expands TreeView
    And checks a set of nodes:
      | Commands       |
      | Veu            |
      | General        |
      | Excel File.doc |
    Then the user should see this message You have selected: commands veu general excelFile