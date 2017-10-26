Feature: Scenarios based on fulfilment queues

   @BaseLine
  Scenario: Standard flow – dates stay the same. - Ready for billing date remain same as fulfilment start date.
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I click app launcher
    And I search in app launcher "Billing and Fulfilment Queues"
    And I select the queue "Billing Fulfilment QC"
    And I check if I can see the Billing Fulfilment Queue
    And I select the queue "Technical Fulfilment QC"
    And I check if I can see the Technical Fulfilment Queue
    And I select the queue "Technical Fulfilment Line Item"
    And I check if I can see the Technical Fulfilment Line Item Queue
    And Close driver
    