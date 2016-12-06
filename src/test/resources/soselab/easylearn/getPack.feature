Feature: get pack

  Scenario: get pack
    Given I am a  logged-in  user
    When I get my packs
    Then the pack return