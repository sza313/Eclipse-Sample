Feature: Oracle Validation

   Background: Login as salesuser
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as admin
    Then I am able to login to SalesForce
    
   @OracleDBCheck
  Scenario: Check the result of the invoice run
    And I click the "Accounts" tab
    And I search an existing "Test Account Szab" on the Account page search box
    And I click the Related tab
    And I check invoice
    And Connect and validate records in Oracle Database
    And I compare results from SF and SQL
    And Close driver