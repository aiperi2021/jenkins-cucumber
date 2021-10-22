@us_11
Feature: As a user, I should be able to access to Talks module.

  Background:
    Given user on the dashboard page
    When user clicks "Talk" module


  Scenario: As a user, I should be able to access to Talks module
    Then verify the page title is "Talk - Trycloud QA"



  Scenario: As a user, I should be able to send message
    And user search user from searchbox
    And user write message
    And user clicks to submit button
    Then user should be able to see message is displayed on the conversation log