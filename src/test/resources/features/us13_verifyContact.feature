@us-13
Feature: As a user, I should be able to access to Contacts module.

  Background:
    Given user on the login page
    Given user on the dashboard page
    When user clicks "Contacts" module
Scenario: verify users can see all the contact names on the contact list
    Then Verify the contact names are in the list

#    Examples:
#      | username | password    |
#      | User7    | Userpass123 |
#      | User37   | Userpass123 |
#      | User67   | Userpass123 |
#      | User97   | Userpass123 |