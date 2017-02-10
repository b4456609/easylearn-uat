Feature: add version

  @easylearn_pack_endpoint_/{packId}/version_POST
  @easylearn_pack_endpoint_/_GET
  Scenario: add version
    Given I am viewing a pack
    When I edit a version with following content
       """The government has already recaptured more than 70% of the rebel-controlled areas in the east, the UK-based Syrian Observatory for Human Rights says.
        More than 100,000 people are believed to be trapped in districts still in rebel hands.
        Food supplies are exhausted and there are no functioning hospitals.
        """

    Then The version is created
