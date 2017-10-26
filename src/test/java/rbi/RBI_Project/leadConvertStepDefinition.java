package rbi.RBI_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import auto.framework.ConfigProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

            
public class leadConvertStepDefinition  {

	 WebDriver driver = Utils.driver;
	
	
	@And("^I click the Convert button$")
	public void clicktheConvertbutton() throws Throwable {
		Utils.checkIfOkClick("//a[@title='Convert']").click();
		Thread.sleep(Utils.standardWait);
	}


	


	@And("^I click Convert button$")
	public void i_click_Convert_button() throws Throwable {
		if(Utils.checkIfOkClick("//div[@class='modal-footer slds-modal__footer']//button[2]")!=null){
		int link_size=driver.findElements(By.xpath("//div[@class='modal-footer slds-modal__footer']//button[2]")).size();		 
		driver.findElements(By.xpath("//div[@class='modal-footer slds-modal__footer']//button[2]")).get(link_size-1).click();
		Thread.sleep(Utils.standardWait + 3000);
		}
	}
	
	@And("^I click on oppotrunity \"([^\"]*)\"$")
	public void i_click_Opportunity(String opportunityName) throws Throwable {
		opportunityName = dataFactory.getInstance().getOpportunityForConversion();
		Utils.checkIfOkClick("//div[@class='modal-body scrollable slds-modal__content slds-p-around--medium']//a[text()='"+opportunityName+"']").click();
		
	}
	
	@And("^I click on contact \"([^\"]*)\"$")
	public void i_click_Contact(String contactName) throws Throwable {
		Thread.sleep(Utils.standardWait);
		contactName = dataFactory.getInstance().getLeadName();
		Utils.checkIfOkClick("//div[@class='modal-body scrollable slds-modal__content slds-p-around--medium']//a[text()='"+contactName+"']").click();
		Thread.sleep(Utils.standardWait + 2000);
		
	}
	
	@And("^I click on account \"([^\"]*)\"$")
	public void i_click_Account(String accountName) throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		accountName = dataFactory.getInstance().getAccountName();
		Utils.checkIfOkClick("//div[@class='containerBodyPadding']//div[3]//a[text()='"+ accountName +"']").isDisplayed();
		int link_size=driver.findElements(By.xpath("//div[@class='containerBodyPadding']//div[3]//a[text()='"+ accountName +"']")).size();		 
		driver.findElements(By.xpath("//div[@class='containerBodyPadding']//div[3]//a[text()='"+ accountName +"']")).get(link_size-1).sendKeys(Keys.ENTER);
		Thread.sleep(Utils.standardWait + 3000);
		
	}
	
	@And("^I Check if the Lead Source value is \"([^\"]*)\"$")
	public void i_check_fieldLeadSource(String fieldValue) throws Throwable {
		fieldValue = dataFactory.getInstance().getLeadSource();
		checkField("Lead Source", fieldValue);
	}
	
	@And("^I Check if the Industry value is \"([^\"]*)\"$")
	public void i_check_fieldIndustry(String fieldValue) throws Throwable {
		fieldValue = dataFactory.getInstance().getIndustry();
		checkField("Industry", fieldValue);
	}
	
	@And("^I Check if the Lead Source Most Recent value is \"([^\"]*)\"$")
	public void i_check_fieldLeadSourceMostRecent(String fieldValue) throws Throwable {
		fieldValue = dataFactory.getInstance().getLeadSourceMostRecent();
		checkField("Lead Source Most Recent", fieldValue);
	}
	
	@And("^I Check if the Product Line Item value is \"([^\"]*)\"$")
	public void i_check_fieldProductLineItem(String fieldValue) throws Throwable {
		fieldValue = dataFactory.getInstance().getProductName();
		checkField("Product Line Item", fieldValue);
	}
	
	@And("^I Check if the Type Of Business field value is \"([^\"]*)\"$")
	public void i_check_fieldTypeOfBusiness(String fieldValue) throws Throwable {
		fieldValue = dataFactory.getInstance().getLeadTypeOfBusiness();
		checkField("Type Of Business", fieldValue);
	}
	
	@And("^I Check if the SRL Lead field is checked$")
	public void i_check_if_SRL_Lead_is_Checked_In() throws Throwable {
		Assert.assertTrue(Utils.checkIfOkClick("//span[text()='SRL Lead']/../..//div[@class='slds-form-element__control slds-grid itemBody']//img[@class='unchecked']").isDisplayed());
	}
	
	

	@And("^I click Go to Leads button$")
	public void i_click_Go_to_Leads_button() throws Throwable {
		Thread.sleep(Utils.standardWait+2000);
		Utils.checkIfOkClick("//span[.='Go to Leads']").click();
		driver.close();				
	}
	
	@And("^LeadConvert I click Save button for account$")
	public void clickSaveButton() throws Throwable {
	 try{
		driver.findElement(By.xpath("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']")).click();
		Thread.sleep(Utils.standardWait);
		} catch (Exception error){
		  	driver.findElement(By.xpath("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']")).click();
		   Thread.sleep(Utils.standardWait);	
		}
	}
	
	@And("^I fill out the \"([^\"]*)\" field$")
	public void filloutOpportunityField(String opportunityName) throws Throwable {		
		opportunityName = dataFactory.getInstance().getOpportunityForConversion();
			Utils.checkIfOkClick("//input[@class=' input']").sendKeys(opportunityName);
	}
	
	
	private void checkField(String fieldName, String fieldValue) throws Throwable {
		Assert.assertEquals(fieldValue, driver.findElement(By.xpath("//span[text()='"+fieldName+"']/../..//div[@class='slds-form-element__control slds-grid itemBody']//span")).getAttribute("innerText"));
		
		
	}
	

	
}
