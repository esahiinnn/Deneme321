Feature: Employee Names
  Scenario: Duplicate employee names
    Given User goes to codeshake.io webpage "codeshake_url"
    And User Scroll down to Meet Our Partner section and Visit their page (use link Pay them a visit).
    And User Goes to This is Cloudwise
    And User Goes to All Cloudwisers
    Then User clicks on all department links one by one and gets Employee names
    And User lists all employees that have the same name

