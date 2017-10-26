package rbi.RBI_Project;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import auto.framework.ConfigProvider;



public class dataDotComStepDefinition{
	
	 WebDriver driver = Utils.driver;

		@Given("^I set to lightning view$")
		public void changeToLightningView() throws Throwable {
			Thread.sleep(Utils.standardWait);
			try{
			driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();	
			Thread.sleep(Utils.standardWait);
			driver.findElement(By.xpath("//a[text()='Switch to Lightning Experience']")).click();
			Thread.sleep(Utils.standardWait);
			}catch(Exception Error){
				//TODO
			}
		}
			
	
		@And("^DataCom I Enter \"([^\"]*)\" on the Account Name field$")
		public void enterccountName(String accountName) throws Throwable {
			accountName = dataFactory.getInstance().getAccountName();
			Utils.checkIfOkClick("//span[text()='Account Name']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(accountName);
		
			Utils.checkIfOkClick("//span[text()='Account Name']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(Keys.ENTER);
			
			Utils.checkIfOkClick("//div[@title='"+accountName+"']/../../..//a").click();
		}
		
		@And("^DataCom I type \"([^\"]*)\" on the Account Name field$")
		public void typeaccountName(String accountName) throws Throwable {
			accountName = dataFactory.getInstance().getAccountName();	
			driver.findElement(By.xpath("//span[text()='Account Name']/../..//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")).sendKeys(accountName);
			Thread.sleep(Utils.standardWait);
		}
		
		
		@And("^DataCom I Enter \"([^\"]*)\" on the Phone field$")
		public void enterPhone(String phoneNumber) throws Throwable {	
			driver.findElement(By.xpath("//span[text()='Phone']/../..//input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(Utils.standardWait);
			driver.findElement(By.xpath("//span[text()='Phone']/../..//input")).sendKeys(Keys.DELETE);
			Thread.sleep(Utils.standardWait);
			driver.findElement(By.xpath("//span[text()='Phone']/../..//input")).sendKeys(phoneNumber);
			Thread.sleep(Utils.standardWait);
		}
		
		@And("^DataCom I click on the profile button$")
		public void clickProfileButton() throws Throwable {
			Thread.sleep(Utils.standardWait);
			driver.findElement(By.xpath("//img[@class='profileTrigger']")).click();
		}
		
		@And("^I click on Switch to Salesforce Classic$")
		public void clickClassicView() throws Throwable {
			Thread.sleep(Utils.standardWait);
			try{
			Utils.checkIfOkClick("//img[@class='profileTrigger circular']").click();
			Utils.checkIfOkClick("//a[text()='Switch to Salesforce Classic']").click();
			}catch (Exception error){
				driver.navigate().refresh();
				Thread.sleep(Utils.standardWait);
				Utils.checkIfOkClick("//img[@class='profileTrigger circular']").click();
				Utils.checkIfOkClick("//a[text()='Switch to Salesforce Classic']").click();
			}
				
		}
 		@And("^DataCom I search the account \"([^\"]*)\"$")
		public void clickClassicView(String accountName) throws Throwable {
 			accountName = dataFactory.getInstance().getAccountName();
 			Thread.sleep(Utils.standardWait);
			Utils.checkIfOkClick("//input[@id='phSearchInput']").sendKeys(accountName);
			Utils.checkIfOkClick("//input[@id='phSearchInput']").sendKeys(Keys.ENTER);
			Utils.checkIfOkClick("//a[text()='Search All']").click();
			Utils.checkIfOkClick("//a[text()='"+accountName+"']").click();
			
		}
 		
		@And("^DataCom I clean the selected account$")
		public void checkPhone() throws Throwable {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,400);");
			Thread.sleep(Utils.standardWait);
			Utils.checkIfOkClick("//input[@title='Clean']").click();
			Thread.sleep(Utils.standardWait);
			Utils.checkIfOkClick("//a[text()='Select All']").click();
			Thread.sleep(Utils.standardWait);
			Utils.checkIfOkClick("//input[@id='cleanSaveButton']").click();
			Thread.sleep(Utils.standardWait);
		}


		@And("^DataCom I set back to lightning view$")
		public void changeView() throws Throwable {
			try{
			driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();	
			Thread.sleep(Utils.standardWait);
			driver.findElement(By.xpath("//a[text()='Switch to Lightning Experience']")).click();
			Thread.sleep(Utils.standardWait);
			}catch(Exception Error){
				//TODO
			}
		}

	
		
		

		
	
	
	
	


	
}
