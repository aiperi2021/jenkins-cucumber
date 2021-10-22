@us_09
Feature: As a user, I should be able to write comments to files/folders.

  Background:
    Given user on the dashboard page
    When user clicks "Files" module

  Scenario: As a user, I should be able to write comments to files/folder
    And user click action-icon  from any file on the page
    And user choose "Details" option
    And user write a comment inside to the input box
    And user click the submit button to post it
    Then Verify the comment is displayed in the comment section.