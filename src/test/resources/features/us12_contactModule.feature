@us-12
Feature: As a user, I should be able to access to Contacts module.

  Background:
    Given user on the login page
    Given user on the dashboard page
    When user clicks "Talk" module

  Scenario: As a user, I should be able to access to Talks module
    Then verify the page title is "Contacts - Trycloud QA"