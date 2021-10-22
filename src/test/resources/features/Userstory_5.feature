Feature: As a user, I should be able to able to access to Files module.
  #5. Story: As a user, I should be able to able to access to Files module.
    #AC #1 - verify users can remove a file from favorites.
    #1. Login as a user
    #2. Click action-icon from any file on the page
    #3. Click “Remove from Favorites” option
    #4. Verify that the file is removed from Favorites sub-module’s table.
    #(Pre-condition: there should be at least 1 file is added to favorites table)
    #AC #2 - verify users can upload a file directly to the homepage (File-Uploading)
    #1. Login as a user
    #2. Click the “+” icon on top
    #3. Click “upload file”
    #4. Upload a file
    #5. Verify the file is displayed on the page
  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials

    When user use username "<username>" and password "<password>"
    Then user should be at dashboard page

    When user click the "Files" module on the page
    And Click action-icon from any file on the page
    And Click "Remove from favorites" option
    And Click "Favorites" sub-module on the left side
    Then Verify that the "B23-Selenium" file is removed from Favorites sub-module's table.

    When user click the "Files" module on the page
    When Click the + icon on top
    And Click "Upload file"
    Then Verify the "Demo porpose" file is displayed on the page

    Examples:
      | username | password    |
      | user7    | Userpass123 |
   #   | user37   | Userpass123 |
  #    | user67   | Userpass123 |
   #   | user97   | Userpass123 |

