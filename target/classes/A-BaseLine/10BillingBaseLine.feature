Feature: Scenarios based on baseline billing
    

   @BaseLine
  Scenario: Invoice Run for baseline scenarios
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click app launcher
    And I search in app launcher "Invoice Runs"
    And I click the New button on Invoice Run
    And I fill the Invoice Run fields "Invoice Run Test" "Account.Name" "REED BUSINESS INFORMATION LIMITED" "Invoice Template" "NOSPLIT" "Invoice"
    And Close driver
