package rbi.RBI_Project;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import auto.framework.ConfigProvider;
import java.util.concurrent.TimeUnit;

public class createContactStepDefinition {
	
	 WebDriver driver = Utils.driver;
	 
	@And("^ContactCreate I click the New button on Contacts tab$")
	public void clickNewButton() throws Throwable {
		 Thread.sleep(Utils.standardWait);
		 Utils.checkIfOkClick("//a[@title='New']").click();   
	}
	
	@And("^I fill out the Name by populating the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_fill_out_the_Name_by_populating_the_and(String firstName, String lastName) throws Throwable {
		firstName = dataFactory.getInstance().getContactFirstName();
		lastName = dataFactory.getInstance().getContactLastName();
		Utils.checkIfOkClick("//input[@placeholder='First Name']").sendKeys(firstName);
		Utils.checkIfOkClick("//input[@placeholder='Last Name']").sendKeys(lastName);
	}

	@And("^I fill out the \"([^\"]*)\"$")
	public void filloutAccountName(String accountName) throws Throwable {
		accountName = dataFactory.getInstance().getAccountName();	
			Utils.checkIfOkClick("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[.='Account Name']/../..//input").sendKeys(accountName);		
			Utils.checkIfOkClick("//div[@title='"+accountName+"']").click();
	}
	
	@And("^I fill out the \"([^\"]*)\" for contact phone$")
	public void fillOutPhoneNumber(String number) throws Throwable {
		number= dataFactory.getInstance().getContactPhone();
		Utils.checkIfOkClick("//input[@type='tel']").sendKeys(number);
	}
	@And("^ContactCreate Click Save button$")
	public void clickSaveButton() throws Throwable {
		Utils.checkIfOkClick("//div[@class='modal-footer slds-modal__footer']//button[@title='Save'][@type='button']").click();
	}
	
}
