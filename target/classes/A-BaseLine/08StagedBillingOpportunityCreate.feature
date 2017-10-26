Feature: Scenarios based on staged billing opportunity

  @BaseLine
  Scenario: Create Staged Billing opportunity, Qualify, Generate Quote and mark closed won.
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I click the New button on opportunities tab
    And I Enter "Automation Staged Billing Opp" on the Opportunity Name field
    And I set the Opportunity Stage to "Identify"
    And I select "Account" from the Account field
    And I set the actual date as Close Date
    And I set "Advertising" for Product Line Items
    And I click Save button on popup
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Qualify"
    And I set the Primary Sales Rep
    And Enter "GBP" for Currency
    And I click the Save button
    And I check if the Opportunity Stage is "Qualify"
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Solution & Propose"
    And I click the Save button
    And I click the Create/Quote Proposal link
    And I edit quote
    And I enter "start date" "Primary Contact" and select contact details correct checkbox
    And I set the Price List "Unity Price List (GBP)"
    And I click Save button on popup
    And I click Configure Products button on the Quote page
    And I click Browse catalog and select "Advertising"
    And I select the "Leaderboard Institution Search Page" and click configure button
    And I set the number of months "10"
    And I click Validate button
    And I set the Billing frequency "Yearly" and the number of years "1"
    And I click Reprice button
    And I click Add More Products button
    And I select the "Bankers Almanac" and click configure button
    And I add number of users
    And I click Validate button
    And I set the Billing frequency "Yearly" and the number of years "1" of the second product
    And I click Reprice button
    And I click Finalize button
    And I click the "Related" in Proposal
    And I click on the New Billing Plan Button
    And I enter Billing Plan Details
    And I click the "Related" in Proposal
    And I check if the Test Billing Plan is generated
    And Close driver
    
 @BaseLine
  Scenario: Create Staged Billing opportunity, Qualify, Generate Quote and mark closed won.
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Automation Staged Billing Opp"
    And I click the related tab inside Opportunity
    And I click on the proposal
    And I click Generate button on the Quote Page
    And I complete Generate Proposal Options: "Format" "WaterMark" "CPQ Proposal Template (Americas)"
    And I click Accept button on the Quote Page
    And Close driver

  @BaseLine
  Scenario: Mark Staged billing opportunity as closed won
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I select an existing opportunity "Automation Staged Billing Opp"
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Closed Won"
    And I set Competitior name to "Actimize"
    And I click the Save button
    And Close driver

  @BaseLine
  Scenario: Staged Billing Opportunity Quote - Fulfilment handling
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Automation Staged Billing Opp"
    And I click the related tab inside Opportunity
    And I handle fulfilment items
    And Close driver
