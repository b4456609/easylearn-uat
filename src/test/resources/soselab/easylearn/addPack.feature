Feature: add pack
  @easylearn-pack endpoint / POST
  Scenario: add pack
    Given I am a  logged-in  user
    When I add pack with following content
      | title | description      | content |
      | test  | test descritpion | afwfawe |

    Then the pack create
