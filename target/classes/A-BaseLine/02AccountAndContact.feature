Feature: Scenarios based on account validation, account update and creating contact.

  @BaseLine
  Scenario: Validate and update Account
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    And I click the "Accounts" tab
    And I search an existing "Account" on the Account page search box
    And I click the Edit button on the Account Page
    And I click Save button on popup
    And I check the error message
    And I select "Association"
    And I clear account billing address
    And I enter account billing address "Street" "City" "Zip" "Country"
    And I select "GBP" currency on Account
    And I click Save button on popup
    And Close driver

  @BaseLine
  Scenario: Adding duplicate Account
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as salesuser
    Then I am able to login to SalesForce
    Given I click the "Accounts" tab
    And I click the New button on accounts tab
    And I Enter "Account Name" on the Account Name field
    And I select "Association"
    And I clear account billing address
    And I enter account billing address "Street" "City" "Zip" "Country"
    And AccountDuplicate Check the error message about duplication
    And I click Cancel button on popup
    

  @BaseLine
  Scenario: Creating a New Contact
    Given I click the Contacts tab
    And ContactCreate I click the New button on Contacts tab
    And I fill out the Name by populating the "First Name" and "Last Name"
    And I fill out the "Account Name"
    And I fill out the "Number" for contact phone
    And ContactCreate Click Save button
    And Close driver
