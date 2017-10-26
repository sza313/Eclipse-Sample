Feature: Scenarios based on DataDotCom & Trillium

  @BaseLine
  Scenario: Cleaning Account using DataDotCom
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as datadotcom user
    Then I am able to login to SalesForce
    Given I set to lightning view
    And I click on Switch to Salesforce Classic
    And DataCom I search the account "REED BUSINESS INFORMATION LIMITED"
    And DataCom I clean the selected account
    And DataCom I set back to lightning view
    And Close driver

  @BaseLine
  Scenario: Address Check Using Trillium
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    Given I click the "Accounts" tab
    And I search an existing "Account" on the Account page search box
    And I click the Find Address button on the Account Page
    And I search the following address "SM2 5AS" "United Kingdom" and update
    And I check the Billing Address
    And I check the Shipping Address
    And Close driver

  @BaseLine
  Scenario: Validate that SalesOps can verify an existing account.
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesops
    Then I am able to login to SalesForce
    Given I click the "Accounts" tab
    And I search an existing "Account" on the Account page search box
    And I click the Edit button on the Account Page
    And I select "Bill To Contact"
    And I select "Ship To Contact"
    And I select "Invoice Template" from Default Invoice Template
    And I select "ACCUITY INC. - INVOICE" from Invoice Email Template
    And I set "Europe" for Region
    And I set "GB Great Britain" for Country List
    And I set "Credit Memo" for Default Credit Memo Template
    And I set "Default Memo Email Template" for Default Credit Memo Email Template
    And select Account Status to Verified
    And I click the Save button on the Account Edit page
    And Close driver
