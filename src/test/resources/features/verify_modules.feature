Feature: As a user, I should be access all the main modules of the app.

  Scenario: Verify users access to the main modules
    Given user on the login page
    When we provide valid credentials
#    When user use username "<username>" and password "<password>"
    Then verify the user see the following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |

#    Examples:
#      | username | password    |
#      | user7    | Userpass123 |
#      | user37   | Userpass123 |
#      | user67   | Userpass123 |
#      | user97   | Userpass123 |