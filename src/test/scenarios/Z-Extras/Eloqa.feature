Feature: Scenarios based on eloqa

  Background: Login as eloqa user
    Given I open eloqa in the browser and access
    When I enter the "<Username>" and "<Password>" as eloqa user
    Then I am able to login to Eloqa
@Extras
  Scenario: Eloqa testing
    And I create new contact "Szabolcs" "Hudak" "United Kingdom" "accenture"
    And I click on the Settings button
    And I click on Integration
    And I click on Outbound
    And I Open and click on Test External Call
    And I select contact for External Call Testing
    And I click on Prepare Test
    And I click on Execute Test
    And I check if test run was successfull
    And Close driver
    
    

