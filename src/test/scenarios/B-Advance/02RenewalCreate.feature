Feature: Scenarios based on renewal opportunities

  @advance
  Scenario: Renewal Quote - Configure product, Generate and Present Quote
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Renewal"
    And I click the related tab inside Opportunity
    And I click on the proposal
    And I click Generate button on the Quote Page
    And I complete Generate Proposal Options: "Format" "WaterMark" "CPQ Proposal Template (EMEA)"
    And I click Accept button on the Quote Page
    And Close driver

  @advance
  Scenario: Mark opportunity as closed won
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Renewal"
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Closed Won"
    And I set Competitior name to "Actimize"
    And I click the Save button
    And Close driver

  @advance
  Scenario: Quote - Fulfilment handling
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Renewal"
    And I click the related tab inside Opportunity
    And I handle fulfilment items
    And Close driver
