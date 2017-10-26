Feature: Scenarios based on advance billing invoices

  @advance
  Scenario: Invoice run for advance scenarios
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I click app launcher
    And I search in app launcher "Invoice Runs"
    And I click the New button on Invoice Run
    And I fill the Invoice Run fields "Invoice Run Test" "Account.Name" "REED BUSINESS INFORMATION LIMITED" "Invoice Template" "NOSPLIT" "Invoice"
    And Close driver
