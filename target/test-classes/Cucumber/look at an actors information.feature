Feature: Look at a actors information
  As a user I would like to look at an actors information

  Scenario: I successfully look at an actors information
    Given I have the actors id number
    When I input the id into the search
    Then I get the string with the actors information