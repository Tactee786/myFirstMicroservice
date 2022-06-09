Feature: Delete an actors information
  As a user I would like to delete an actors information from the actor table

  Scenario: I successfully delete an actors information from the actor table
    Given I have the actor id number
    When I input the data into the database for deleting
    Then I get the success return string for delete