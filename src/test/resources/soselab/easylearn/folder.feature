Feature: add fodler
  @easylearn_user_endpoint_/folder_GET
  @easylearn_user_endpoint_/folder_POST
  Scenario: add version
    Given I am a  logged-in  user
    When I add a folder with following name
      | name        |
      | My favorite |
      | Dog         |
      | ToDo        |
      | 600         |
    Then The folder is created
