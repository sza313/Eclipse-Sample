Feature: Scenarios based on scope change opportunity

  @advance
  Scenario: Create Scope Change opportunity and Qualify
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I click the New button on opportunities tab
    And I Enter "Automation Scope Change Opportunity" on the Opportunity Name field
    And I select "REED BUSINESS INFORMATION LIMITED" from the Account field
    And I set the Opportunity Stage to "Identify"
    And I set the actual date as Close Date
    And I set the Opportunity Type to "Scope Change"
    And I set "BA for KYC" for Product Line Items
    And I click Save button on popup
    And I check if the "Automation Scope Change Opportunity" opportunity was created
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Qualify"
    And I set the Primary Sales Rep
    And Enter "GBP" for Currency
    And I change Shipping Street "Main Street"
    And I change Shipping City "London"
    And I click the Save button
    And I check if the Opportunity Stage is "Qualify"
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Solution & Propose"
    And I click the Save button
    And I check if the Opportunity Stage is "Solution & Propose"
    And I click the Create/Quote Proposal link
    And I edit quote
    And I enter "start date" "end date" "Primary Contact" and select contact details correct checkbox
    And I click Save button on popup
    And I click Configure Products button on the Quote page
    And I click Installed Products button
    And I select the installed product "Bankers Almanac"
    And I click Change button
    And I change number of users
    And I click Validate button
    And I set the Billing frequency "Yearly" and the number of years "1"
    And I click Reprice button
    And I click Finalize button
    And I click Generate button on the Quote Page
    And I complete Generate Proposal Options: "Format" "WaterMark" "CPQ Proposal Template (EMEA)"
    And I click Accept button on the Quote Page
    And I click the "Opportunities" tab
    And I select an existing opportunity "Automation Scope Change Opportunity"
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Closed Won"
    And I set Competitior name to "Actimize"
    And I click the Save button
    And I check if the Opportunity Stage is "Closed Won"
    And Close driver

  @advance  
  Scenario: Quote - Fulfilment handling
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Automation Scope Change Opportunity"
    And I click the related tab inside Opportunity
    And I handle fulfilment items
    And Close driver

