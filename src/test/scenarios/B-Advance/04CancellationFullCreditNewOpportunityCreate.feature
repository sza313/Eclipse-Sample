Feature: Scenarios based on cancellation of full credit

  @advance
  Scenario: Create Standard opportunity and Qualify credit cancellation
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I click the New button on opportunities tab
    And I Select the type of the opportunity "Cancellation"
    And I Enter "Automation Full Credit Cancellation Opp" on the Opportunity Name field
    And I select "REED BUSINESS INFORMATION LIMITED" from the Account field
    And I set the Opportunity Stage to "Identify"
    And I set the Opportunity Type to "Cancellation"
    And I set the Cancellation Reason to "Out of Business"
    And I set the Cancellation Type to "Billing approval only"
    And Enter "UK" for Org
    And Enter "USD" for Currency
    And I set the actual date as Close Date
    And I click Save button on popup
    And I check if the "Automation Full Credit Cancellation Opp" opportunity was created
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Qualify"
    And Enter "USD" for Currency
    And I click the Save button
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Solution & Propose"
    And I click the Save button
    And I click the Create/Quote Proposal link
    And I edit quote with billing user
    And I enter "start date" "end date" "Primary Contact" and select contact details correct checkbox
    And I fill the Billing Preference field "Standard"
    And I click Save button on popup
    And I click Configure Products button on the Quote page
    And I click Installed Products button
    And I select the installed product "ABA Key to Routing Numbers"
    And I click Terminate button
    And I set the date of the termination
    And I click Calculate button
    And I click Confirm button
    And I click Goto Pricing from Status bar
    And I click Finalize Cancellation button
    And I click Accept button on the Quote Page
    And I click the "Opportunities" tab
    And I select an existing opportunity "Automation Full Credit Cancellation Opp"
    And I click submit for approval on opportunity
    And Close driver
    
    
    @advance   
    Scenario: Approve the cancellation by Administrator
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as admin
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Automation Full Credit Cancellation Opp"
    And I click the related tab inside Opportunity
    And I approve from Approval History 
    And Close driver
    
    
   @advance   
  Scenario: Set Opportunity to Closed Won
   Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I select an existing opportunity "Automation Full Credit Cancellation Opp"
    And I click the Edit button on the Opportunity
    And I update the Opportunity Stage to "Closed Won"
    And I click the Save button
    And Close driver

  @advance  
  Scenario: Quote - Fulfilment handling
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as billing user
    Then I am able to login to SalesForce
    And I click the "Opportunities" tab
    And I search the Opportunity "Automation Full Credit Cancellation Opp"
    And I click the related tab inside Opportunity
    And I handle fulfilment items
    And Close driver
