package rbi.RBI_Project;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import auto.framework.ConfigProvider;



public class deleteFirstGroupTestDataStepDefinition {
	 
	 WebDriver driver = Utils.driver;
	 
	 @And("^I click the Related tab$")
     public void clickRelatedTab() throws Throwable {
            Utils.checkIfOkClick("//span[text()='Related'][@class='title']").click();
              
     }
    
     @And("^I delete the Related Opportunity \"([^\"]*)\"$")
     public void deleteOpp(String oppName) throws Throwable {
            Thread.sleep(Utils.standardWait+10000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(0, 500);");
            Thread.sleep(Utils.standardWait+6000);
            driver.findElement(By.xpath("//tbody//tr[.//th//a[text()='"+oppName+"']]//span//span")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[@title='Delete']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[text()='Delete']")).click(); 
}
	 
	 
		@And("^Initializer Delete \"([^\"]*)\" opportunity from the list$")
		public void deleteOpportunityFromList(String opportunityName) throws Throwable {	
			Thread.sleep(Utils.standardWait);
			try {
//				driver.findElement(By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//a[text()='Automation Opportunity 1']/../../..//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
				driver.findElement(By.xpath("//tr//td//a[@title='"+opportunityName+"']/../..//div//a//span//span")).click();
				Thread.sleep(Utils.standardWait + 2000);
				driver.findElement(By.xpath("//a[@title='Delete']")).click();
				Thread.sleep(Utils.standardWait);
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				Thread.sleep(Utils.standardWait + 5000);
			} catch (Exception e) {
				
			}	
		}
		
		
		
		@And("^Initializer Delete \"([^\"]*)\" account from the list$")
		public void deleteAccountFromList(String accountName) throws Throwable {
			accountName = dataFactory.getInstance().getAccountName();
			try {
				Utils.checkIfOkClick("//a[text()='"+accountName+"']/../../..//a[@role='button']").click();
				Utils.checkIfOkClick("//a[@title='Delete']").click();
				Utils.checkIfOkClick("//span[text()='Delete']").click();
			} catch (Exception e) {
				Thread.sleep(Utils.standardWait);
			}
		
		}
		
		@And("^I search the datadotcom Account \"([^\"]*)\"$")
		public void searchdatadotcomAccount(String accountName) throws Throwable {
			Thread.sleep(Utils.standardWait + 5000);
			driver.findElement(By.xpath("//a[contains(.,'Accounts')]")).click();
			Thread.sleep(Utils.standardWait + 5000);
			driver.findElement(By.xpath("//input[@placeholder='Search Accounts and more...']")).sendKeys(accountName);
			driver.findElement(By.xpath("//input[@placeholder='Search Accounts and more...']")).sendKeys(Keys.ENTER);
			Thread.sleep(Utils.standardWait);
			driver.findElement(By.xpath("//a[text()='Accounts']")).click();
			Thread.sleep(Utils.standardWait);	
		}
		
		@And("^Initializer Delete \"([^\"]*)\" datadotcom account from the list$")
		public void deleteDataDotComAccountFromList(String accountName) throws Throwable {	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(Utils.standardWait);
			try {
//				driver.findElement(By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//a[text()='"+accountName+"']/../../..//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
				driver.findElement(By.xpath("//tr//td//a[@title='"+accountName+"']/../..//div//a//span//span")).click();
				Thread.sleep(Utils.standardWait+2000);
				driver.findElement(By.xpath("//a[@title='Delete']")).click();
				Thread.sleep(Utils.standardWait);
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				
			} catch (Exception e) {
				
			}
		
		}
		
		@And("^Initializer Delete \"([^\"]*)\", \"([^\"]*)\" lead from the list$")
		public void deleteLeadFromList(String firstName, String lastName) throws Throwable {	
			firstName = dataFactory.getInstance().getFirstName();
			lastName = dataFactory.getInstance().getLastName();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
				try {
//					driver.findElement(By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//a[text()='"+firstName+" "+lastName+"']/../../..//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
//					driver.findElement(By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//a[text()='"+firstName+" "+lastName+"']")).click();
					driver.findElement(By.xpath("//tr//th//a[text()='"+firstName+" "+lastName+"']/../../..//a[@role='button']")).click();
					Thread.sleep(Utils.standardWait+5000);
					driver.findElement(By.xpath("//a[@title='Delete']")).click();
					Thread.sleep(Utils.standardWait+2000);
					driver.findElement(By.xpath("//span[text()='Delete']")).click();
					Thread.sleep(Utils.standardWait+5000);
				} catch (Exception e) {
					driver.close();
				}
			
			
		}	
		
		
	
	@And("^Initializer Delete \"([^\"]*)\", \"([^\"]*)\" contact from the list$")
	public void deleteContactFromList(String firstName, String lastName) throws Throwable {
			
		firstName = dataFactory.getInstance().getContactFirstName();
		lastName = dataFactory.getInstance().getContactLastName();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//a[text()='"+firstName+" "+lastName+"']/../../..//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@title='Delete']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='Delete']")).click();
		} catch (Exception e) {
			driver.close();
		}

	}	
	
	@And("^Initializer I set back to lightning view$")
	public void changeView() throws Throwable {
		try {
			driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();	
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Switch to Lightning Experience']")).click();
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.close();

	}
	
	@And("^Initializer Delete direct \"([^\"]*)\" account from the list$")
	public void deleteDirectLeadFromList(String accountName) throws Throwable {
		
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//a[text()='"+accountName+"']/../../..//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@title='Delete']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='Delete']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		driver.close();
	}
		
	
		@After("@selenium")
	    public void killBrowser(Scenario scenario){
	        if (scenario.isFailed()) {
	         scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	        }
	        driver.close();
	        driver.quit();
	    }
		
		@And("^I select Lead filter \"([^\"]*)\"$")
		public void leadFilter(String filter) throws Throwable {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='slds-media slds-no-space slds-grow'][.//div[@class='slds-media__body slds-align-middle']]//a[@title='Select List View']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='scroller'][.//ul[@class='slds-dropdown__list slds-show']]//span[text()='All Open Leads']")).click();
		}
	
		@And("^I delete the All Related Opportunity$")
		public void deleteAllOpp() throws Throwable {
			Thread.sleep(Utils.standardWait);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 600);");
			Thread.sleep(Utils.standardWait+2000);
			Integer opsize = 0;
			try {
			Utils.checkIfOkClick("//span[@class='view-all-label'][text()='View All']").click();
			} catch (Exception e) {
				return;
			}
			Thread.sleep(Utils.standardWait);
			driver.navigate().refresh();		
			if(Utils.checkIfPageIsReady() && Utils.checkIfOkClick("//h1[text()='Opportunities']/../../../../../..//table//tr").isDisplayed()){
				List<WebElement> record = driver.findElements(By.xpath("//h1[text()='Opportunities']/../../../../../..//table//tr"));
				opsize = record.size();
			}

			for (int i=1; i<opsize; i++){
					if(Utils.checkIfOkClick("//tbody//tr[1]//a[@role='button']").isDisplayed()){
						int link_size=driver.findElements(By.xpath("//tbody//tr[1]//a[@role='button']")).size();		 
						driver.findElements(By.xpath("//tbody//tr[1]//a[@role='button']")).get(link_size-1).click();
					}
					Utils.checkIfOkClick("//a[@title='Delete']").click();
					Utils.checkIfOkClick("//span[text()='Delete']").click();
					Thread.sleep(Utils.standardWait + 2000);
			}
		}
		}

