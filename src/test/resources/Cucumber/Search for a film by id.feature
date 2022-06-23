Feature: Find a film to watch
  As a user I would like to find a film to watch

  Scenario: I successfully find a film to watch
    Given I have the id of the film i want to watch
    When I input the id into the search bar
    Then I get the relevant information for the film i want to watch