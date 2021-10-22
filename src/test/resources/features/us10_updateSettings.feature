@us_10
Feature: As a user, I should be able to update settings.

  Background:
    Given user on the dashboard page
    When user clicks "Files" module

  Scenario:As a user, I should be able to update settings.
    And user clicks Settings on the left bottom corner
    Then user should be able to click any buttons


  Scenario: As a user, I should be able to see the app storage usage
    And user checks the current storage usage
    And user  uploads file with upload file option
    And user refreshs the page
    Then user should be able to see storage usage is increased