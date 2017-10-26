Feature: Scenarios based on opportunities with approvals

  @advance
  Scenario: Create opportunity, Qualify, Generate Quote and mark closed won
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I click the New button on opportunities tab
    And I Enter "Automation Opp With Approval" on the Opportunity Name field
    And I select "REED BUSINESS INFORMATION LIMITED" from the Account field
    And I set the Opportunity Stage to "Identify"
    And I set the actual date as Close Date
    And I set "Fircosoft" for Product Line Items
    And I click Save button on popup
    And I check if the "Automation Opp With Approval" opportunity was created
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Qualify"
    And I set the Primary Sales Rep
    And Enter "EUR" for Currency
    And I click Save button on popup
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Solution & Propose"
    And I click the Save button
    And I click the Create/Quote Proposal link
    And I edit quote
    And I enter "start date" "Primary Contact" and select contact details correct checkbox
    And I set the Price List "Unity Price List (EUR)"
    And I click Save button on popup
    And I click Configure Products button on the Quote page
    And I click Browse catalog and select "Fircosoft"
    And I select the "Firco Continuity for SAA" and click configure button
    And I configure the product
    And I click Validate button
    And I populate the Discount fields "Discount Type" "Discount Reason" "4000"
    And I click Reprice button
    And I set the Billing frequency "Yearly" and the number of years "1"
    And I click Reprice button
    And I click Submit for Approval button
    And I click Submit button
    And Close driver

  @advance
  Scenario: Quote - Approval with Sales Manager user
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as sales manager
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Automation Opp With Approval"
    And I click the related tab inside Opportunity
    And I click on the proposal
    And I click on the My Approvals button
    And I click on the Approve button
    And Close driver
    
   @advance
  Scenario: Opportunity with Approval Generate Quote and Closed Won opportunity
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Automation Opp With Approval"
    And I click the related tab inside Opportunity
    And I click on the proposal
    And I click Configure Products button on the Quote page
    And I click Finalize button
    And I click Generate button on the Quote Page
    And I complete Generate Proposal Options: "Format" "WaterMark" "CPQ Proposal Template (EMEA)"
    And I click Accept button on the Quote Page
    And I click the "Opportunities" tab
    And I select an existing opportunity "Automation Opp With Approval"
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
    And I search the Opportunity "Automation Opp With Approval"
    And I click the related tab inside Opportunity
    And I handle fulfilment items
    And Close driver
