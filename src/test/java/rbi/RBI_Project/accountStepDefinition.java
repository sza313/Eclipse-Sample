package rbi.RBI_Project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;
import cucumber.api.java.*;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class accountStepDefinition {

	WebDriver driver = Utils.driver;

	@And("^I click the New button on accounts tab$")
	public void clickNewButton() throws Throwable {
		try{
			Utils.checkIfOkClick("//div[@title='New'][@class='slds-truncate']").click();
		} catch(Exception error){
			driver.navigate().refresh();
			Utils.checkIfOkClick("//div[@title='New'][@class='slds-truncate']").click();
		}
	}

	@And("^I Enter \"([^\"]*)\" on the Account Name field$")
	public void enterAcountName(String accountName) throws Throwable {
		   accountName = dataFactory.getInstance().getAccountName();
		  Utils.checkIfOkClick("//span[text()='Account Name']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(accountName);
	}

	@And("^I select \"([^\"]*)\" currency on Account$")
	public void selectAccountCurrency(String currency) throws Throwable {
		Utils.checkIfOkClick("//span[text()='Currency']/../..//a").click();
		Utils.checkIfOkClick("//a[@title='" + currency + "']").click();
		
	}

	@And("^I select \"([^\"]*)\"$")
	public void selectAssociation(String association) throws Throwable {
		association = dataFactory.getInstance().getAssociation();
		Utils.checkIfOkClick("//option[@label='" + association + "']").click();

	}

	@And("^I clear account billing address$")
	public void i_clear_the_Billing_Address() throws Throwable {
		Utils.checkIfOkClick("//textarea[@placeholder='Billing Street']").clear();
		driver.findElement(By.xpath("//div[3]/div/div/input")).clear();
		driver.findElement(By.xpath("//div[4]/div/div/input")).clear();
		driver.findElement(By.xpath("//div[4]/div[2]/div/input")).clear();
	}

	@And("^I enter account billing address \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_enter_the_Billing_Address(String billingStreet, String billingCity, String billingZip,String billingCountry) throws Throwable {
		billingStreet = dataFactory.getInstance().getAccountStreet();
		billingCity = dataFactory.getInstance().getAccountCity();
		billingZip = dataFactory.getInstance().getAccountPostCode();
		billingCountry = dataFactory.getInstance().getAccountCountry();
		Utils.checkIfOkClick("//textarea[@placeholder='Billing Street']").sendKeys(billingStreet);
		driver.findElement(By.xpath("//div[3]/div/div/input")).sendKeys(billingCity);
		driver.findElement(By.xpath("//div[4]/div/div/input")).sendKeys(billingZip);
		driver.findElement(By.xpath("//div[4]/div[2]/div/input")).sendKeys(billingCountry);
		

	}


	@And("^AccountDuplicate Check the error message about duplication$")
	public void checkDuplicationErrorMessage() throws Throwable {
		Assert.assertTrue(Utils.checkIfOkClick("//div[contains(string(), \"The record you're about to create looks like a duplicate.\") and @class='slds-col slds-align-middle']").isDisplayed());
	}

	@And("^I search an existing \"([^\"]*)\" on the Account page search box$")
	public void searchexistingAccount(String accountName) throws Throwable {
		accountName = dataFactory.getInstance().getAccountName();
		Utils.checkIfOkClick("//input[@placeholder='Search Accounts and more...']").sendKeys(accountName);
		Utils.checkIfOkClick("//input[@placeholder='Search Accounts and more...']").sendKeys(Keys.ENTER);
		Utils.checkIfOkClick("//a[@title='Accounts'][@class='slds-navigation-list--vertical__action slds-text-link--reset scopesItem']").click();
		driver.navigate().refresh();
		Utils.checkIfOkClick("//a[@title='Accounts'][@class='slds-navigation-list--vertical__action slds-text-link--reset scopesItem']").click();
	
			if(Utils.checkIfOkClick("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//a[@title='" + accountName + "']").isDisplayed()){	
				int link_size=driver.findElements(By.xpath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//a[@title='" + accountName + "']")).size();		 
				driver.findElements(By.xpath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//a[@title='" + accountName + "']")).get(link_size-1).click();	
			}
	}

	@And("^I select \"([^\"]*)\" from the Payment Term$")
	public void i_Payment_Terms(String paymentTerm) throws Throwable {
		Thread.sleep(Utils.standardWait);
		try {
			Utils.checkIfOkClick("//span[.='Payment Term']/../..//span[@class='pillText']").isDisplayed();
		} catch (Exception e) {
			Utils.checkIfOkClick("//span[.='Payment Term']/../..//div[@class='autocompleteWrapper']").click();
			Utils.checkIfOkClick("//span[.='Payment Term']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(paymentTerm);
			Thread.sleep(Utils.standardWait + 2000);
			Utils.checkIfOkClick("//div[@title='" + paymentTerm + "']").click();
		}
	}

	@And("^I select \"([^\"]*)\" Contact$")
	public void i_Select_Bill_To_Contact(String contactType) throws Throwable {
		    Thread.sleep(Utils.standardWait);
		    String contactName= dataFactory.getInstance().getContactFirstName()+ " " +dataFactory.getInstance().getContactLastName();
		    Utils.inputField(contactType, contactName ,3);
		    /*
			Utils.checkIfOkClick("//span[.='Bill To Contact']/../..//div[@class='autocompleteWrapper']").click();
			Utils.checkIfOkClick("//span[.='Bill To Contact']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(contactName);
			Thread.sleep(Utils.standardWait + 2000);
			Utils.checkIfOkClick("//div[@title='" + contactName + "']").click();
			*/

	}

	/*
	@And("^I select \"([^\"]*)\" Contact$")
	public void i_Select_Ship_To_Contact(String contactName) throws Throwable {
		Thread.sleep(Utils.standardWait);
	    contactName= dataFactory.getInstance().getContactFirstName()+ " " +dataFactory.getInstance().getContactLastName();
		
		Thread.sleep(Utils.standardWait);
			Utils.checkIfOkClick("//span[.='Ship To Contact']/../..//div[@class='autocompleteWrapper']").click();
			Utils.checkIfOkClick("//span[.='Ship To Contact']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(contactName);
			Thread.sleep(Utils.standardWait + 2000);
			Utils.checkIfOkClick("//div[@title='" + contactName + "']").click();
	}*/

	@And("^I select \"([^\"]*)\" from Default Invoice Template$")
	public void i_Select_Default_Invoice_Template(String templateName) throws Throwable {
		
		Utils.checkIfOkClick("//span[.='Default Invoice Template']/../..//input").click();
		driver.findElement(By.xpath("//span[.='Default Invoice Template']/../..//input")).sendKeys(templateName);
		
	}

	@And("^I select \"([^\"]*)\" from Invoice Email Template$")
	public void i_Select__Invoice_Email_Template(String templateName) throws Throwable {
		
		Utils.checkIfOkClick("//span[.='Invoice Email Template']/../..//input").click();
		driver.findElement(By.xpath("//span[.='Invoice Email Template']/../..//input")).sendKeys(templateName);
	}

	@And("^I set \"([^\"]*)\" for Country List$")
	public void i_Set_Country_List(String country) throws Throwable {
			Utils.checkIfOkClick("//span[text()='Billing Country List']/../../../..//a").click();
			Utils.checkIfOkClick("//span[text()='Billing Country List']/../../../..//a").sendKeys(country);
			driver.findElement(By.xpath("//a[@title='" + country + "']")).click();
		
	}

	@And("^I set \"([^\"]*)\" for Region$")
	public void i_Set_Region(String region) throws Throwable {
			Utils.checkIfOkClick("//span[text()='Region']/../../../..//a").click();
			Utils.checkIfOkClick("//span[text()='Region']/../../../..//a").sendKeys(region);
			driver.findElement(By.xpath("//a[@title='" + region + "']")).click();
	
	}

	@And("^I set \"([^\"]*)\" for Default Credit Memo Template$")
	public void i_Set_Default_Credit_Memo_Template(String template) throws Throwable {
		Utils.checkIfOkClick("//span[text()='Default Credit Memo Template']/../..//input").sendKeys(template);
		
	}

	@And("^I set \"([^\"]*)\" for Default Credit Memo Email Template$")
	public void i_Set_Default_Credit_Memo_Email_Template(String emailTemplate) throws Throwable {
		Utils.checkIfOkClick("//span[text()='Credit Memo Email Template']/../..//input").sendKeys(emailTemplate);
		
	}

	@And("^I check the Billing Address$")
	public void i_Check_Billing_Address() throws Throwable {
		String address1 = dataFactory.getInstance().getBillingAddressFirstPart();
		String address2 = dataFactory.getInstance().getBillingAddressSecondPart();
		Thread.sleep(Utils.standardWait + 2000);
		Assert.assertEquals(address1,Utils.checkIfOkClick("//span[text()='Billing Address']/../..//a//div[@class='street slds-truncate forceOutputAddressText']").getText());
		Assert.assertEquals(address2, Utils.checkIfOkClick("//span[text()='Billing Address']/../..//a//div[@class='desktop municipality slds-truncate forceOutputAddressText']").getText());
	
	}

	@And("^I check the Shipping Address$")
	public void i_Check_Shipping_Address() throws Throwable {
		String address1 = dataFactory.getInstance().getBillingAddressFirstPart();
		String address2 = dataFactory.getInstance().getBillingAddressSecondPart();
		Assert.assertEquals(address1,Utils.checkIfOkClick("//span[text()='Shipping Address']/../..//a//div[@class='street slds-truncate forceOutputAddressText']").getText());
		Assert.assertEquals(address2,Utils.checkIfOkClick("//span[text()='Shipping Address']/../..//a//div[@class='desktop municipality slds-truncate forceOutputAddressText']").getText());

	}

	@And("^I click the Edit button on the Account Page$")
	public void clickEditButton() throws Throwable {
		Utils.checkIfOkClick("//a[@title='Edit']").click();
	}

	@And("^I click the Find Address button on the Account Page$")
	public void clickFindAddressButton() throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		Utils.checkIfOkClick("//a[@title='Find Address']").click();
		Thread.sleep(Utils.standardWait + 2000);
	}

	@And("^I select \"([^\"]*)\" from the Billing Preferences field$")
	public void i_Select_Billing_Preferences(String billingPreferences) throws Throwable {
		
		Utils.checkIfOkClick("//span[.='Billing Preference']/../..//div[@class='autocompleteWrapper']").click();
		try {
			Utils.checkIfOkClick("//label[@class='uiLabel-left form-element__label uiLabel']//span[.='Billing Preference']/../..//span[@class='deleteIcon']").click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Utils.checkIfOkClick("//span[.='Billing Preference']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(billingPreferences);
		Utils.checkIfOkClick("//div[@title='" + billingPreferences + "']").click();
	}

	@And("^I search the following address \"([^\"]*)\" \"([^\"]*)\" and update$")
	public void i_Search_Address(String zipNumber, String state) throws Throwable {
		zipNumber = dataFactory.getInstance().getAccountPostCode();
		state = dataFactory.getInstance().getAccountCountry();
		Thread.sleep(Utils.standardWait + 2000);
		String a = driver.findElement(By.xpath("//iframe[contains(@name,'vfFrameId')]")).getAttribute("innerHTML");
		System.out.println("Content" + a.toString());
		driver.switchTo().frame(4);
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//span[text()='Billing Street']/../..//input")).clear();
		driver.findElement(By.xpath("//span[text()='Billing City']/../..//input")).clear();
		driver.findElement(By.xpath("//span[text()='Billing State']/../..//input")).clear();
		driver.findElement(By.xpath("//span[text()='Billing Zip/Postal Code']/../..//input")).clear();
		driver.findElement(By.xpath("//span[text()='Billing Zip/Postal Code']/../..//input")).sendKeys(zipNumber);
		driver.findElement(By.xpath("//span[text()='Billing Country']/../..//input")).clear();
		driver.findElement(By.xpath("//span[text()='Billing Country']/../..//input")).sendKeys(state);
		Utils.checkIfOkClick("//span[text()='Find Address']").click();
		Thread.sleep(Utils.standardWait + 40000);
		Utils.checkIfOkClick("//span[text()='Quadrant House, The Quadrant, Brighton Road, Sutton, Surrey, United Kingdom, SM2 5AS']/..//span[@class='slds-radio--faux']").click();
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//span[text()='Copy Billing Address']")).click();
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//div[@class='slds-page-header']//span[text()='Save']")).click();
		Thread.sleep(Utils.standardWait);
		driver.switchTo().defaultContent();

	}

	@And("^I update the Account Status field to \"([^\"]*)\"$")
	public void updateAccountStatus(String accountStatus) throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver
				.findElement(By.xpath("//span[@class='test-id__field-value slds-form-element__static slds-grow']")))
		.doubleClick().build().perform();
		Utils.checkIfOkClick("//a[@aria-label='Account Status']").click();
		Utils.checkIfOkClick("//a[contains(text(), '" + accountStatus + "')]").click();

	}

	@And("^I click the Save button on the Account Edit page$")
	public void clickSaveButton() throws Throwable {
		Utils.checkIfOkClick("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save']").click();
	}

	@And("^select Account Status to Verified$")
	public void selectAccountStatusVerified() throws Throwable {
		Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Account Status']").click();
		Utils.checkIfOkClick("//a[@title='Verified']").click();
	}

	@And("^select Account Status to Unverified$")
	public void selectAccountStatusUnverified() throws Throwable {
		Utils.checkIfOkClick("//a[@class='select'][@role='button'][@aria-label='Account Status']").click();
		Utils.checkIfOkClick("//a[@title='Unverified']").click();
	}

	@And("^AccountValidation Close browser$")
	public void closeBrowser() throws Throwable {
		driver.close();
	}

	@And("^check if account status is Unverified$")
	public void checkUnverifiad() throws Throwable {
		
		Utils.checkIfOkClick("//li[@class='slds-page-header__detail-block'][4]//p[@class='slds-text-heading--label-normal slds-m-bottom--xx-small slds-truncate' and text()='Account Status']/..//span[text()='Unverified']").isDisplayed();
	}

	@And("^I check if account status in the pop up is Unverified$")
	public void checkUnverifiadinPopUp() throws Throwable {
		
		Utils.checkIfOkClick("//div[@class='modal-body scrollable slds-modal__content slds-p-around--medium']//span[text()='Account Status']/../..//span[text()='Unverified']").isDisplayed();
	}

	@And("^check if account status is Verified$")
	public void checkVerified() throws Throwable {
		Utils.checkIfOkClick("//li[@class='slds-page-header__detail-block'][4]//p[@class='slds-text-heading--label-normal slds-m-bottom--xx-small slds-truncate' and text()='Account Status']/..//span[text()='Verified']").isDisplayed();
	}


	@And("^I add an existing account \"([^\"]*)\"$")
	public void i_Add_Existing_Account(String accountName) throws Throwable {
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//div[@class='matchPanel']//div[@class='header']//input[@type='radio'][@name='Account']/..//span[text()='Choose Existing']").click();
		accountName = dataFactory.getInstance().getAccountName();
		Utils.checkIfOkClick("//span[.='Account Search']/../..//div[@class='autocompleteWrapper']").click();
		Utils.checkIfOkClick("//span[.='Account Search']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(accountName);
		Utils.checkIfOkClick("//div[@title='"+accountName+"']").click();
	}

}
