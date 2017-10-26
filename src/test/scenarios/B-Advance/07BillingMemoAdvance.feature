Feature: Scenarios based on Credits Memo

  @advance
  Scenario: Generate Credit Memo
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I click app launcher
    And I search in app launcher "Invoice Runs"
    And I click the New button on Invoice Run
    And I fill the Invoice Run fields "Credit Memo Test" "Account.Name" "REED BUSINESS INFORMATION LIMITED" "Invoice Template" "NOSPLIT" "Memo"
    And Close driver
