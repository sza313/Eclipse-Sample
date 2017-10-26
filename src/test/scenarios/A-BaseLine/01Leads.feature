Feature: Scenarios based on leads creation, conversion and account creation

  @BaseLine
  Scenario: Creating new lead, Convert lead using existing account and check account field mapping
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    Given I click the Leads tab
    And I click the New button on Leads tab
    And Click Save button
    And I check the error message
    And Enter "First Name" on the First Name field
    And Enter "Last Name" on the Last name field
    And Enter "Company" on the Company field
    And Enter "Email" on the Email name field
    And select Lead Status to "Lead Status"
    And select Country List to "Country"
    And I select product "Product"
    And I click on the SRL Lead checkbox
    And select Organisation Type
    And select Type OF Business
    And select Lead Source to "Lead Source"
    And select Industry to "Industry"
    And select Lead Source Most Recent to "Lead Source Most Recent"
    And I enter lead address "Street" "City" "Zip" "Country"
    And Click Save button
    And I click the Convert button
    And I click Convert button
    And I click on account "Account Name"
    And I Check if the Industry value is "Industry"
    And I Check if the Product Line Item value is "Product Line Item"
    And I Check if the Type Of Business field value is "Type Of Business"

  @BaseLine
  Scenario: Duplicate lead check
    Given I click the Leads tab
    And I click the New button on Leads tab
    And Enter "First Name" on the First Name field
    And Enter "Last Name" on the Last name field
    And Enter "Company" on the Company field
    And Enter "Email" on the Email name field
    And select Lead Status to "Lead Status"
    And select Country List to "Country"
    And I select product "Product"
    And I click on the SRL Lead checkbox
    And select Organisation Type
    And select Type OF Business
    And select Lead Source to "Lead Source"
    And select Industry to "Industry"
    And select Lead Source Most Recent to "Lead Source Most Recent"
    And I enter lead address "Street" "City" "Zip" "Country"
    And LeadDuplicate Check the error message about duplication
    And I click Cancel button on popup
    
    
  @BaseLine
  Scenario: Closed lost existing opportunity
    And I click the "Opportunities" tab
    And I select an existing opportunity "By Conversion"
    And I click the Edit button on the Opportunity
    And Enter "USD" for Currency
    And I update the Opportunity Stage to "Closed Lost"
    And I update the Closed Lost Reason to "Competitor Chosen"
    And I update the Why Lost To A Competitor "Lower Price"
    And I set Competitior name to "Actimize"
    And I click Save button on popup
    And Close driver