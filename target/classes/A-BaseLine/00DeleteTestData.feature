Feature: Deletions of test data

 
    

   @BaseLine
  Scenario: Delete related Opportunity
    Given I open the browser and access Salesforce
    When I enter the "<Username>" and "<Password>" as admin
    Then I am able to login to SalesForce
    And I set to lightning view
    And I click the "Accounts" tab
    And I search an existing "REED BUSINESS INFORMATION LIMITED" on the Account page search box
    And I click the Related tab
    And I delete the All Related Opportunity
    And I click the "Accounts" tab
    And Initializer Delete "REED BUSINESS INFORMATION LIMITED" account from the list
    And Close driver
