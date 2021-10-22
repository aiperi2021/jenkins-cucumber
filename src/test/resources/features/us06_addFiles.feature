@us_06
Feature: As a user, I should be able to remove files from favorites
  and upload a file directly

  Background:
    Given user on the dashboard page
    When user clicks "Files" module

  Scenario: As a user, I should be able to add folder
    And user clicks the add icon on top
    And user click "New folder"
    And user write a folder name
    When user click submit icon
    Then Verify the folder is displayed on the page


  Scenario: As a user, I should be able to  upload a file inside a folder
    And user choose a folder from the page
    And user clicks the add icon on top
    When user  uploads file with upload file option
    Then Verify the file is displayed on the page