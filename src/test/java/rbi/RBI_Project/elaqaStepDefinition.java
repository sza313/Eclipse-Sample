package rbi.RBI_Project;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import auto.framework.ConfigProvider;



public class elaqaStepDefinition {
	 
	WebDriver driver = Utils.driver;
	 String url;
	 String emailWithTimeStamp = null;
	 
	
	@And("^I create new contact \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_Create_New_Contact(String firstName, String lastName, String country, String company) throws Throwable {
		Thread.sleep(Utils.standardWait + 5000);
		driver.findElement(By.xpath("//span[text()='Audience']")).click();
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//label[text()='New...']/../..//span")).click();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss");
		emailWithTimeStamp = firstName+"."+lastName+df.format(new java.util.Date()).toString()+"@accenture.com";
		System.out.println(emailWithTimeStamp);
		driver.findElement(By.xpath("//input[@name='edit-contact-field-C_EmailAddress']")).sendKeys(emailWithTimeStamp);
		driver.findElement(By.xpath("//input[@name='edit-contact-field-C_FirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='edit-contact-field-C_LastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//select[@id='edit-contact-field-C_Country']")).sendKeys(country);
		driver.findElement(By.xpath("//input[@name='edit-contact-search-field']")).sendKeys("company");		
		driver.findElement(By.xpath("//input[@name='edit-contact-field-C_Company']")).sendKeys(company);
		driver.findElement(By.xpath("//label[text()='Create']/../..//span")).click();
				
	}
	
	@And("^I click on the Settings button$")
	public void i_Click_Settings_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//i[@title='Settings']/../../..//li[1]")).click();
				
	}
	
	@And("^I click on Integration$")
	public void i_Click_Integration_Link() throws Throwable {

		driver.findElement(By.xpath("//a[text()='Integration']")).click();
				
	}
	
	@And("^I click on Outbound$")
	public void i_Click_Outbound_Tab() throws Throwable {
		Thread.sleep(Utils.standardWait + 5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='tabBar']//div[4]")).click();		
				
	}
	
	@And("^I click on Execute Test$")
	public void i_Click_Execute_Test() throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='interface-div'][3]//iframe[starts-with(@name,'InterfaceFrame')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name,'IntegrationFrame')]")));
		driver.findElement(By.xpath("//td[@class='LayoutTableRowStart']//span[@name='ExecuteTestButton']")).click();		
				
	}
	
	@And("^I check if test run was successfull$")
	public void i_Check_If_Test_Run_Successfull() throws Throwable {
		Thread.sleep(Utils.standardWait + 15000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='interface-div'][3]//iframe[starts-with(@name,'InterfaceFrame')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name,'IntegrationFrame')]")));
		Assert.assertEquals("Your test completed successfully. The lead you created in Salesforce has an Id value of", driver.findElement(By.xpath("//tr[@class='InformationBox']//td[@name='NotificationText']")).getText().substring(0,87));						
	}
	
	@And("^I click on Prepare Test$")
	public void i_Click_Prepare_Test() throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='interface-div'][3]//iframe[starts-with(@name,'InterfaceFrame')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name,'IntegrationFrame')]")));
		driver.findElement(By.xpath("//td[@class='LayoutTableRowStart']//span[1]")).click();		
				
	}
	
	@And("^I Open and click on Test External Call$")
	public void i_Click_Test_External_Test() throws Throwable {		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='interface-div'][3]//iframe[starts-with(@name,'InterfaceFrame')]")));
		Thread.sleep(Utils.standardWait + 5000);
		driver.findElement(By.xpath("//div[@title='External Calls']")).click();
		Thread.sleep(Utils.standardWait + 5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name,'IntegrationCallsMain')]")));
		driver.findElement(By.xpath("//span[@id='RecentItems']//table//tr[1]//td[2]//span//img")).click();
		Thread.sleep(Utils.standardWait + 5000);
		driver.findElement(By.xpath("//span[@id='TestExternalCall']")).click();	
		
	}
	
	@And("^I select contact for External Call Testing$")
	public void i_Create_External_Call_Testing() throws Throwable {	
		Thread.sleep(Utils.standardWait + 7000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='interface-div'][3]//iframe[starts-with(@name,'InterfaceFrame')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@name,'IntegrationFrame')]")));
		driver.findElement(By.xpath("//img[@id='imgContactID']")).click();
		Thread.sleep(Utils.standardWait + 2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'dialogiframe')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='MainDiv']//iframe")));
		driver.findElement(By.xpath("//select[@name='ctl00$ctl00$Content$Content$Search$SearchType']")).sendKeys("Email");
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//input[@name='ctl00$ctl00$Content$Content$Search$SearchTerm']")).sendKeys(emailWithTimeStamp);
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//span[@title='Search']")).click();
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//span[text()='"+emailWithTimeStamp.toString().substring(0, 32)+"...']")).click();	
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//div[@class='RightStrip']//span[1]")).click();
		
	}
	
	
	
	
	
	
	
}
