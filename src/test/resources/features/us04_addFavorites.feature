@us_04
Feature: As a user, I should be able to access to Files module - Favorites button

  Background:
    Given user on the dashboard page
    When user clicks "Files" module

  Scenario: As a user, I should be able to add files to Favorites
    When user click action-icon  from any file on the page
    And user choose "Add to favorites" option
    And user click "Favorites" sub-module on the left side
    Then Verify the chosen file is listed on the table