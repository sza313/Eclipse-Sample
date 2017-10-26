package rbi.RBI_Project;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import auto.framework.ConfigProvider;



public class leadCreateStepDefinition {
	 
	 WebDriver driver = Utils.driver;		

	@And("^I click the New button on Leads tab$")
	public void clickNewButton() throws Throwable {
		 Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//a[@title='New'][@class='forceActionLink'][@href='javascript:void(0);']").click();

	}
	
	@And("^Enter \"([^\"]*)\" on the First Name field$")
	public void enterFirstName(String firstName) throws Throwable {
	   
		firstName = dataFactory.getInstance().getFirstName();
	    Utils.inputField("First Name", firstName,1);
	   // Utils.checkIfOkClick("//input[@placeholder=]").sendKeys(firstName);
	}

	@And("^Enter \"([^\"]*)\" on the Last name field$")
	public void enterLastName(String lastName) throws Throwable {	
		lastName = dataFactory.getInstance().getLastName();
		 Utils.inputField("Last Name", lastName,1);
		//Utils.checkIfOkClick("//input[@placeholder='Last Name']").sendKeys(lastName);
	}
	
	@And("^Enter \"([^\"]*)\" on the Email name field$")
	public void enterEmail(String eMail) throws Throwable {	
		eMail = dataFactory.getInstance().getLeadEmail();
		 Utils.inputField("Email", eMail,1);
		// Utils.checkIfOkClick("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/span[text()='Email']//../../..//input").sendKeys(eMail);
	}

	@And("^Enter \"([^\"]*)\" on the Company field$")
	public void enterCompany(String companyName) throws Throwable {
		companyName = dataFactory.getInstance().getAccountName();
		 Utils.inputField("Company", companyName,1);
		// Utils.checkIfOkClick("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[.='Company']/../..//input").sendKeys(companyName);
	}
	
	@And("^select Lead Status to \"([^\"]*)\"$")
	public void selectLeadStatus(String leadStatus) throws Throwable {
		leadStatus = dataFactory.getInstance().getLeadStatus();
		 Utils.inputField("Lead Status", leadStatus,2);
			 //Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Lead Status']").click();
			 //Utils.checkIfOkClick("//a[@title='"+leadStatus+"']").click();
	
	}
	@And("^select Organisation Type$")
	public void selectOrganisationType() throws Throwable {
		Utils.inputField("Organisation Type", dataFactory.getInstance().getleadOrganisationType(),2);
		Thread.sleep(Utils.standardWait);
	}
	
	@And("^select Type OF Business$")
	public void selectBusiness() throws Throwable {
		Utils.inputField("Type Of Business", dataFactory.getInstance().getLeadTypeOfBusiness(),2);
		//Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Type Of Business']").click();
		//Utils.checkIfOkClick("//a[@title='"+typeOfBusiness+"']").click();
	}
	
	
	
	@And("^select Lead Source to \"([^\"]*)\"$")
	public void selectLeadSource(String leadSource) throws Throwable {
		leadSource = dataFactory.getInstance().getLeadSource();
		Utils.inputField("Lead Source", leadSource,2);
			//Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Lead Source']").click();
			//Utils.checkIfOkClick("//a[@title='"+leadSource+"']").click();
	}
	
	@And("^select Lead Source Most Recent to \"([^\"]*)\"$")
	public void selectLeadSourceMostRecent(String leadSourceMostRecent) throws Throwable {
		leadSourceMostRecent = dataFactory.getInstance().getLeadSourceMostRecent();
		
		  	Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Lead Source Most Recent']").click();
		    Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Lead Source Most Recent']").sendKeys(leadSourceMostRecent);
		    Utils.checkIfOkClick("//span[text()='Lead Source Most Recent']/../..//a[text()='"+leadSourceMostRecent+"']").click();

	}
	
	@And("^select Industry to \"([^\"]*)\"$")
	public void selectIndustry(String industry) throws Throwable {
		industry = dataFactory.getInstance().getIndustry();
		Utils.inputField("Industry", industry,2);
			//Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Industry']").click();
			//Utils.checkIfOkClick("//a[@title='"+industry+"']").click();

	}
	
	@And("^select Country List to \"([^\"]*)\"$")
	public void selectCountryList(String countryList) throws Throwable {
		countryList = dataFactory.getInstance().getCountryList();
			
	}
	
	@And("^Click Save button$")
	public void clickSaveButton() throws Throwable {
		 Utils.checkIfOkClick("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']").click();	
		 Thread.sleep(Utils.standardWait);
	}
	
	@And("^LeadDuplicate Check the error message about duplication$")
    public void checkDuplicationErrorMessage() throws Throwable {
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          Assert.assertTrue(Utils.checkIfOkClick("//div[contains(string(), \"The record you're about to create looks like a duplicate.\") and @class='slds-col slds-align-middle']").isDisplayed());
		 
    }
	
	@And("^I select product \"([^\"]*)\"$")
	public void selectProduct(String product) throws Throwable {
		product = dataFactory.getInstance().getProductName();
			 Utils.checkIfOkClick("//option[@label='"+product+"']").click();


	}
	


@And("^LeadCreate I close Browser$")
public void CLoseBrowser() throws Throwable {
	driver.close();

}
	
	@And("^I click on the SRL Lead checkbox$")
	public void clickOnSRLLeadCheckBox() throws Throwable {
			Utils.checkIfOkClick("//h3//span[text()='Additional Information']/../..//span[text()='SRL']/../..//img").click();
	}
	
	
	@And("^I enter lead address \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_enter_the_lead_Address(String billingStreet, String billingCity, String billingZip,
			String billingCountry) throws Throwable {
		billingStreet = dataFactory.getInstance().getAccountStreet();
		billingCity = dataFactory.getInstance().getAccountCity();
		billingZip = dataFactory.getInstance().getAccountPostCode();
		billingCountry = dataFactory.getInstance().getAccountCountry();
		//Thread.sleep(Utils.standardWait);
			Utils.checkIfOkClick("//span[text()='Street']/../..//textarea").sendKeys(billingStreet);
			Utils.checkIfOkClick("//span[text()='City']/../..//input").sendKeys(billingCity);
			Utils.checkIfOkClick("//span[text()='Zip/Postal Code']/../..//input").sendKeys(billingZip);
			Utils.checkIfOkClick("//span[text()='Country']/../..//input").sendKeys(billingCountry);

		}

	
}
	