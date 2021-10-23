@us-12
Feature: As a user, I should be able to access to Contacts module.

  Background:
    Given user on the login page
    Given user on the dashboard page
    When user clicks "Contacts" module

  Scenario: As a user, I should be able to access to Talks module
#    Given user on the dashboard page
#    When user clicks "Contacts" module
    Then verify the page title is "Contacts - Trycloud QA"

    Scenario: verify users can add contacts
  When click "New Contact" button
  And Fill out the contact info
  Then Verify the contact name is added to the contact list



#    AC #2 - verify users can add contacts
#    1. Login as a user
#    2. Click contacts module
#    3. Click “New Contact” button
#    4. Fill out the contact info like : Title, Phone, email, address , etc
#    5. Verify the contact name is added to the contact list