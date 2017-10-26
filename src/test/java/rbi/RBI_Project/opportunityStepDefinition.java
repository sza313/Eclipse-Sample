package rbi.RBI_Project;




import cucumber.api.java.en.And;

import cucumber.api.java.en.Then;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class opportunityStepDefinition {
	 
	WebDriver driver = Utils.driver;
	 String url;		
	 
	 
	 @And("^I click the New button on opportunities tab$")
		public void i_click_New_Button() throws Throwable {
			 if(Utils.checkIfPageIsReady()){
			Utils.checkIfOkClick("//div[@title='New'][@class='slds-truncate']").click();
			 }
		}
	 
	 @And("^I Select the type of the opportunity \"([^\"]*)\"$")
		public void i_click_Select_Opportunity_Type(String oppportunityType) throws Throwable {
			Utils.checkIfOkClick("//span[text()='"+oppportunityType+"']/../..//span[@class='slds-radio--faux']").click();
			Utils.checkIfOkClick("//div[@class='forceChangeRecordTypeFooter']//span[text()='Next']/../..//button[2]").click();						
		}
	 
		@And("^I set the Cancellation Type to \"([^\"]*)\"$")
		public void i_set_Cancellation_Type(String cancellationType) throws Throwable {
				Utils.checkIfOkClick("//span[text()='Cancellation Type']/../../../..//a").sendKeys(cancellationType);
				Utils.checkIfOkClick("//a[@title='"+cancellationType+"']").click(); 
		} 
		
		@And("^I set the Cancellation Reason to \"([^\"]*)\"$")
		public void i_set_Cancellation_Reason(String cancellationReason) throws Throwable {
				Utils.checkIfOkClick("//span[text()='Cancellation Reason']/../../../..//a").sendKeys(cancellationReason);
			Utils.checkIfOkClick("//a[@title='"+cancellationReason+"']").click(); 
		} 
	 

		
		
		@And("^I select the record type as \"([^\"]*)\" and press Next button$")
		public void i_select_RecordType(String recordType) throws Throwable {
			try {		
				Thread.sleep(Utils.standardWait + 2000);
				Utils.checkIfOkClick("//span[text()='"+recordType+"']/../..//span[@class='slds-radio--faux']").click();
				Utils.checkIfOkClick("//div[@class='modal-footer slds-modal__footer']//span[text()='Next']").click();			
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

		@And("^I Enter \"([^\"]*)\" on the Opportunity Name field$")
		public void i_EnterStandardOpportunity_Name(String opportunityName) throws Throwable {
			if (opportunityName.equals("Automation Standard Opp")) {
				opportunityName = dataFactory.getInstance().getStandardOpportunity();
			} else if(opportunityName.equals("Automation Opp With Approval")) {
				opportunityName = dataFactory.getInstance().getOpportunityNameApproval();
				}
			 else if(opportunityName.equals("Automation Opp Full Credit Cancellation")) {
					opportunityName = dataFactory.getInstance().getOpportunityNameFullCreditCancelation();
				}
			 else if(opportunityName.equals("Automation Opp Partial Credit Cancellation")) {
					opportunityName = dataFactory.getInstance().getOpportunityNamePartialCreditCancelation();
				}		
				Utils.checkIfOkClick("//span[text()='Opportunity Name']/../..//input[@type='text']").sendKeys(opportunityName);
		}
		
		
		@And("^I select \"([^\"]*)\" from the Account field$")
		public void i_Select_Account(String accountName) throws Throwable {
			accountName = dataFactory.getInstance().getAccountName();
				Utils.checkIfOkClick("//span[.='Account Name']/../..//div[@class='autocompleteWrapper']").click();
			try {driver.findElement(By.xpath("//label[@class='uiLabel-left form-element__label uiLabel']//span[.='Account Name']/../..//span[@class='deleteIcon']")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Utils.checkIfOkClick("//span[.='Account Name']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(accountName);
			Utils.checkIfOkClick("//div[@title='"+accountName+"']").click();
			}

		@And("^I set the Primary Sales Rep$")
		public void i_Select_Primary_Sales_Rep() throws Throwable {
			String personName = null;
			personName= Utils.checkIfOkClick("//span[text()='Opportunity Owner']/../..//div[@class='slds-form-element__control slds-grid itemBody']//span[@class='uiOutputText forceOutputLookup']").getText();
				Utils.checkIfOkClick("//span[.='Primary Sales Rep']/../..//div[@class='autocompleteWrapper']").click();
				Utils.checkIfOkClick("//input[@placeholder='Search People...']").click();
				Utils.checkIfOkClick("//input[@placeholder='Search People...']").sendKeys(personName);
				Utils.checkIfOkClick("//div[@title='"+personName+"']").click();
			}

		
		@And("^I select an existing opportunity \"([^\"]*)\"$")
		public void i_select_an(String opportunityName) throws Throwable {
			if (opportunityName.equals("Automation Standard Opp")) {
				opportunityName = dataFactory.getInstance().getStandardOpportunity();
			} else if(opportunityName.equals("Automation Opp With Approval")) {
				opportunityName = dataFactory.getInstance().getOpportunityNameApproval();
			}else if(opportunityName.equals("Automation Opp Full Credit Cancellation")) {
				opportunityName = dataFactory.getInstance().getOpportunityNameFullCreditCancelation();	
			}else if(opportunityName.equals("By Conversion")) {
					opportunityName = dataFactory.getInstance().getAccountName() + "-";
			}
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        if(Utils.checkIfOkToContinue("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//a[text()='"+opportunityName+"']")){
	          int link_size=driver.findElements(By.xpath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//a[text()='"+opportunityName+"']")).size();		 
			  driver.findElements(By.xpath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//a[text()='"+opportunityName+"']")).get(link_size-1).click();  
	        }
	       }
		
		@And("^I click the Edit button on the Opportunity$")
		public void clickEditButton() throws Throwable {
			Thread.sleep(Utils.standardWait);
			try{
					driver.findElement(By.xpath("//a[@title='Edit']")).click();
			}catch(Exception error){
				driver.navigate().refresh();
				Utils.checkIfOkClick("//a[@title='Edit']").click();
				//Utils.checkIfOkClick("//p[text()='Opportunity']/../../..//a[@title='Edit']").click();
			}
		}
		
		@And("^I set the Opportunity Stage to \"([^\"]*)\"$")
		public void i_set_Opportunity_Stage(String opportunityStage) throws Throwable {
			Utils.checkIfOkClick("//a[@class='select']").sendKeys(opportunityStage);
			Utils.checkIfOkClick("//a[@title='"+opportunityStage+"']").click(); 
		
		}
		
		@And("^I set the Opportunity Type to \"([^\"]*)\"$")
		public void i_set_Opportunity_Type(String opportunityType) throws Throwable {
			Utils.checkIfOkClick("//span[text()='Opportunity Type']/../../../..//a").sendKeys(opportunityType);
			Utils.checkIfOkClick("//a[@title='"+opportunityType+"']").click(); 
			
		}
	 
	 
		   @And("^I change Shipping Street \"([^\"]*)\"$")
		   public void ui_change_shipping_street(String shippingStreet) throws Throwable {
		   	Thread.sleep(Utils.standardWait);
		   	Utils.checkIfOkClick("//span[text()='Shipping Street']/../..//input").clear();
		   	Utils.checkIfOkClick("//span[text()='Shipping Street']/../..//input").sendKeys(shippingStreet);
		       Thread.sleep(Utils.standardWait + 2000);                                                 
		   }
		   
		   @And("^I change Shipping City \"([^\"]*)\"$")
		   public void ui_change_shipping_city(String shippingCity) throws Throwable {
		   	Utils.checkIfOkClick("//span[text()='Shipping City']/../..//input").clear();
		   	Utils.checkIfOkClick("//span[text()='Shipping City']/../..//input").sendKeys(shippingCity);
		       Thread.sleep(Utils.standardWait + 2000);                                                 
		   }
	 
	@Then("^I update the Opportunity Stage to \"([^\"]*)\"$")
	public void i_Update_The_Opportunity_Stage_to(String opportunityStage) throws Throwable {
			Utils.checkIfOkClick("//a[@class='select']").sendKeys(Keys.ENTER);
			Utils.checkIfOkClick("//ul[@class='scrollable']//a[@title='"+opportunityStage+"']").click(); 

	}
	
	
	
	@And("^I update the Closed Lost Reason to \"([^\"]*)\"$")
	 public void i_Update_The_Lost_Stage_to(String lostStage) throws Throwable {
         driver.findElement(By.xpath("//span[text()='Closed Lost Reason']/../..//a")).click();
         Thread.sleep(Utils.standardWait + 2000);
         driver.findElement(By.xpath("//a[@title='"+lostStage+"']")).click();
         Thread.sleep(Utils.standardWait);
  } 
	
	@And("^I set Competitior name to \"([^\"]*)\"$")
	public void i_Set_Competitors_Name(String competitorName) throws Throwable {
	   competitorName = dataFactory.getInstance().getCompetitorName();
		Utils.checkIfOkClick("//option[@label='"+competitorName+"']").click();	   
	}
		
	@And("^I check if the Opportunity Stage is \"([^\"]*)\"$")
	public void i_check_the_Opportunity_Stage(String opportunityStage) throws Throwable {
		Thread.sleep(Utils.standardWait -1000);
		Assert.assertTrue(Utils.checkIfOkClick("//span[text()='Stage']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']/span[text()='"+opportunityStage+"']").isDisplayed());
	}
	
	@And("^I check if the Approval Stage is \"([^\"]*)\"$")
	public void i_check_the_Approval_Stage(String opportunityStage) throws Throwable {
		Thread.sleep(Utils.standardWait);
		Assert.assertTrue(Utils.checkIfOkClick("//span[text()='Approval Stage']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']/span[text()='"+opportunityStage+"']").isDisplayed());
		Thread.sleep(Utils.standardWait);
	}
	
	@And("^I check if the Proposal Total is \"([^\"]*)\"$")
	public void i_check_the_Proposal_Total(String totalAmount) throws Throwable {
		Thread.sleep(Utils.standardWait);
		Assert.assertTrue(Utils.checkIfOkClick("//span[text()='Proposal Total']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']/span[text()='"+totalAmount+"']").isDisplayed());
		Thread.sleep(Utils.standardWait);
	}

	@And("^I set up High Level Estimated Value to \"([^\"]*)\"$")
	public void i_Set_Up_High_Level_Estimated_Value(String Value) throws Throwable {
		Utils.checkIfOkClick("//span[text()='High Level Estimated Value']/../..//input").sendKeys(Value);
		Thread.sleep(Utils.standardWait);
	}
	
	
	
	@And("^I check if the \"([^\"]*)\" opportunity was created$")
	public void i_Check_Opportunity(String opportunityName) throws Throwable {
		if (opportunityName.equals("Automation Standard Opp")) {
			opportunityName = dataFactory.getInstance().getStandardOpportunity();
		} else if(opportunityName.equals("Automation Opp With Approval")) {
			opportunityName = dataFactory.getInstance().getOpportunityNameApproval();
		}
		Thread.sleep(Utils.standardWait + 2000); 
		Assert.assertTrue(Utils.checkIfOkClick("//h1//span[text()='"+opportunityName+"']").isDisplayed());
		Thread.sleep(Utils.standardWait + 2000);
	}
	
	@And("^I set the actual date as Close Date$")
	public void i_Se_Close_Date() throws Throwable {
			Utils.checkIfOkClick("//span[text()='Close Date']/../..//div[@class='form-element']").click();
			Utils.checkIfOkClick("//span[text()='Today']").click(); 
	}
	
	@And("^I approve from Approval History$")
	public void i_click_on_the_proposal() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(Utils.standardWait + 2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,350);");
        Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//span[text()='Approval History']/../../../../../..//a[contains(text(),'Auto Approved')]")).click();
		Thread.sleep(Utils.standardWait + 7000);
		driver.findElement(By.xpath("//p[text()='Approval Request']/../../..//div[@title='Approve']")).click();
  Thread.sleep(Utils.standardWait+2000);
	    driver.findElement(By.xpath("//textarea[@class='inputTextArea cuf-messageTextArea textarea']")).sendKeys("Contact requested full cancellation.");
	    Thread.sleep(Utils.standardWait+2000);
	    driver.findElement(By.xpath("//span[text()='Approve']")).click();
	}
	
	
	@And("^I update the Why Lost To A Competitor \"([^\"]*)\"$")
	public void updateWhyLostToACompetitor(String reason) throws Throwable {
		driver.findElement(By.xpath("//span[text()='Why Lost To A Competitor']/../..//a")).click();
		Thread.sleep(Utils.standardWait + 2000);
		try {
			driver.findElement(By.xpath("//a[@title='"+reason+"']")).click(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(Utils.standardWait);
	}
	
	@And("^I click submit for approval on opportunity$")
	public void clickSubmitForApprovalOnOpportunity() throws Throwable {
		Thread.sleep(Utils.standardWait+2000);
	    driver.findElement(By.xpath("//div[@title='Submit for Approval']")).click();
	    Thread.sleep(Utils.standardWait+2000);
	    driver.findElement(By.xpath("//textarea[@class='inputTextArea cuf-messageTextArea textarea']")).sendKeys("Contact requested full cancellation.");
	    Thread.sleep(Utils.standardWait+2000);
	    driver.findElement(By.xpath("//span[text()='Submit']")).click();
	 }
	 }

