package rbi.RBI_Project;

import cucumber.api.java.en.And;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class customValidationsStepDefinition{
	WebDriver driver = Utils.driver;   
	
	

	@And("^AccountValidation: I enter the \"([^\"]*)\", \"([^\"]*)\" details$")
	public void i_enter_the_details(String invoiceOffSystem, String billingCity) throws Throwable {

		if(!(invoiceOffSystem.equals(""))){
			Utils.checkIfOkClick("//div[@class='slds-grid full forcePageBlockSectionRow'][.//span[text()='Alternative Billing System']]//input");
			if(driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//span[text()='Alternative Billing System']]//input")).isEnabled()){
				System.out.println("Sales User allowed to change alternative billing options"); 
			}
			
		}

	}

	@And("^I get the error message$")
	public void i_get_the_message() throws Throwable {
		String errorMessage = driver.findElement(By.xpath("//div[@class='pageLevelErrors'][.//ul[@class='errorsList']]")).getText();
		System.out.println(errorMessage);  
	}


	@And("^LeadsValidation: I search an existing \"([^\"]*)\" on the Leads page search box$")
	public void searchexistingAccount(String leadName) throws Throwable {
		driver.findElement(By.id("221:0;p")).sendKeys(leadName);
   		Utils.checkIfOkClick("//span[@title='"+leadName+"']").click();
   		Utils.checkIfOkClick("//ul[@class='tabs__nav'][.//a[@title='Details']]//span[text()='Details']").click();
	}

	@And("^LeadsValidation: I select \"([^\"]*)\"$")
	public void selectLeadStatus(String leadStatus) throws Throwable {
		driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//div[@class='slds-form-element__control']]//a[@aria-label='Lead Status']")).click();
		driver.findElement(By.xpath("//div[@class='select-options'][.//ul[@class='scrollable']]//a[@title='"+leadStatus+"']")).click();
	}

	@And("^LeadsValidation: I get the \"([^\"]*)\", \"([^\"]*)\" message$")
	public void leadsvalidation_I_get_the_message(String validationMessage, String errorMessage) throws Throwable {
		WebElement actualMessage = driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//div[@class='slds-form-element__control']]//li"));
		errorMessage = driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//div[@class='slds-form-element__control']]//li")).getText();

		if(actualMessage.isDisplayed()){
			System.out.println("Validation Mesage is dispayed: " + errorMessage);
		}else{
			System.out.println("Validation Message is not displayed");
		}
	}

	@And("^LeadsValidation: I select reason \"([^\"]*)\"$")
	public void selectReason(String reason) throws Throwable {
		driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//div[@class='slds-form-element__control']]//a[@aria-label='Qualified Out Reason']")).click();
		driver.findElement(By.xpath("//div[@class='select-options'][.//ul[@class='scrollable']]//a[@title='Other']")).click();
	}


	@And("^LeadsValidation: I get the reason \"([^\"]*)\", \"([^\"]*)\" message$")
	public void validationMessage(String validationMessage, String errorMessage) throws Throwable {
		WebElement actualMessage = driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//div[@class='slds-form-element__control']]//li"));
		errorMessage = driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//div[@class='slds-form-element__control']]//li")).getText();

		if(actualMessage.isDisplayed()){
			System.out.println("Validation Mesage is dispayed: " + errorMessage);
		}else{
			System.out.println("Validation Message is not displayed");
		}
	}

	@And("^I update the High Level Estimated Value to \"([^\"]*)\"$")
	public void i_Set_Up_High_Level_Estimated_Value(String Value) throws Throwable {
		driver.findElement(By.xpath("//span[text()='High Level Estimated Value']/../..//input")).clear();
		driver.findElement(By.xpath("//span[text()='High Level Estimated Value']/../..//input")).sendKeys(Value);
		Thread.sleep(Utils.standardWait);
	}

	@And("^I get the High level Estimated Value Validation Message$")
	public void verifyHLEVErrorMsg() throws Throwable {
		String hlev = driver.findElement(By.xpath("//span[text()='High Level Estimated Value']/../..//input/../..//ul")).getText();
		System.out.println("High Level Estimated Value Validation Message: " + hlev);
		Thread.sleep(Utils.standardWait);
	}

	@And("^I update the stage to \"([^\"]*)\"$")
	public void renewalopportunitycreate_I_update_the_stage_to(String opportunityStage) throws Throwable {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='slds-form-element slds-form-element_edit slds-hint-parent slds-p-vertical_xx-small'][.//div[@class='uiMenu uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']]//a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='"+opportunityStage+"']")).click(); 
	}

	@And("^I get the Closed Lost Reason Validation Message$")
	public void verifyClosedLostReasonErrorMsg() throws Throwable {
		String closedLostReasonMsge = driver.findElement(By.xpath("//div[@class='slds-form-element__control'][.//span[text()='Closed Lost Reason']]//li")).getText();
		System.out.println("Closed Lost Reason Validation Message: " + closedLostReasonMsge);
		Thread.sleep(Utils.standardWait);
	}

	@And("^I select the Closed Lost Reason \"([^\"]*)\"$")
	public void selectClosedLostReason(String reason) throws Throwable {
		driver.findElement(By.xpath("//span[text()='Closed Lost Reason']/../..//a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='select-options'][.//ul[@class='scrollable']]//a[@title='"+reason+"']")).click();
	}

	@And("^I get the Closed Lost Reason for Others Validation Message$")
	public void verifyClosedLostReasonOtherErrorMsg() throws Throwable {
		String closedLostReasonOtherMsge = driver.findElement(By.xpath("//div[@class='slds-form-element__control'][.//span[text()='Closed Lost Reason Comments']]//li")).getText();
		System.out.println("Closed Lost Reason Validation Message: " + closedLostReasonOtherMsge);
		Thread.sleep(Utils.standardWait);
	}


} 
