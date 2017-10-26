package rbi.RBI_Project;

import java.sql.Timestamp;
import java.util.Calendar;
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
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class billingStepDefinition {
	WebDriver driver = Utils.driver;
	String BillingDate =null;
	
							 
	@And("^Billing I click the New button on opportunities tab$")
	public void clickNewButton() throws Throwable {
		//driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//div[@title='New'][@class='slds-truncate']")).click();

	}
	
	@And("^I click on the App Launcher$")
	public void i_Click_App_Launcher() throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//div[@class='slds-icon-waffle']").click();

	}
	
	
	
	@And("^I click the New button on Invoice Run$")
	public void billing_clickNewButton() throws Throwable {
		Utils.checkIfOkClick("//div[@class='slds-media__body slds-align-middle']//span[text()='Invoice Runs']/../../../../../../..//div[@title='New'][@class='slds-truncate']").click();
		Thread.sleep(Utils.standardWait + 7000);
	}
	
	@And("^I fill the Invoice Run fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void billing_fill_INvoice_Run_Name(String invoiceRunName, String searchCategory, String searchValue, String template, String split, String type) throws Throwable {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'vfFrameId')]")));
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()); 
		driver.findElement(By.xpath("//table[@class='detailList']//td[@class='dataCol  first  last ']//input")).sendKeys(invoiceRunName+"_"+currentTimestamp);
		driver.findElement(By.xpath("//table[@class='list']//tr[1]//td[1]//select/option[@value='"+searchCategory+"']")).click();
		driver.findElement(By.xpath("//table[@class='list']//tr[1]//td[2]//select/option[@value='equal to']")).click();
		driver.findElement(By.xpath("//table[@class='list']//tr[1]//td[3]//input")).sendKeys(searchValue);
		driver.findElement(By.xpath("//table[@class='detailList']//tr[1]//td[1]//select/option[@value='"+template+"']")).click();
		Thread.sleep(Utils.standardWait);
		if (split.equals("SPLIT")) {
			driver.findElement(By.xpath("//table[@class='detailList']//tr[2]//td[2]//input")).click();
			Thread.sleep(Utils.standardWait);
		}
		if (type.equals("Invoice")) {
		driver.findElement(By.xpath("//table[@class='detailList']//tr[1]//td[2]//input")).click();
		} else if(type.equals("Memo")){
			driver.findElement(By.xpath("//table[@class='detailList']//tr[2]//td[1]//input[@type='checkbox']")).click();
		}
		Thread.sleep(Utils.standardWait);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,1000);");
		Utils.checkIfOkClick("//h3[text()='Scheduling Options']/../..//table[@class='detailList']//tr[1]//td[1]//input").click();
		Utils.checkIfOkClick("//h3[text()='Scheduling Options']/../..//table[@class='detailList']//tr[3]//td[1]//span[@class='dateFormat']").click();
		Utils.checkIfOkClick("//h3[text()='Scheduling Options']/../..//table[@class='detailList']//tr[3]//td[2]//span[@class='dateFormat']").click();
		Thread.sleep(Utils.standardWait);
		jse.executeScript("scroll(0,400);");
		Utils.checkIfOkClick("//div[@class='pbBottomButtons']//input[@value='Save']").click();	
		Thread.sleep(Utils.standardWait + 2000);
		driver.switchTo().defaultContent();
		Thread.sleep(Utils.standardWait + 2000);
		
	}
	@And("^I click the \"([^\"]*)\" in Proposal$")
	public void i_click_tab_proposal(String tabTitle) throws Throwable {
		 Utils.checkIfOkClick("//p[text()='Quote/Proposal']/../../../../../../../..//span[contains(., '"+tabTitle+"')]/../..//a//span[contains(., '"+tabTitle+"')]/../..//a").click();
	}
	@And("^I fill the Invoice Run fields with multiple search \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void billing_fill_INvoice_Run_Name_multiple_Accounts_Multiple_Search_Value(String invoiceRunName, String searchCategory, String searchValue, String searchValue2, String template, String type) throws Throwable {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'vfFrameId')]")));
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()); 
		driver.findElement(By.xpath("//table[@class='detailList']//td[@class='dataCol  first  last ']//input")).sendKeys(invoiceRunName+"_"+currentTimestamp);
		driver.findElement(By.xpath("//table[@class='list']//tr[1]//td[1]//select/option[@value='"+searchCategory+"']")).click();
		driver.findElement(By.xpath("//table[@class='list']//tr[1]//td[2]//select/option[@value='equal to']")).click();
		driver.findElement(By.xpath("//table[@class='list']//tr[1]//td[3]//input")).sendKeys(searchValue);
		driver.findElement(By.xpath("//table[@class='list']//tr[2]//td[1]//select/option[@value='"+searchCategory+"']")).click();
		driver.findElement(By.xpath("//table[@class='list']//tr[2]//td[2]//select/option[@value='equal to']")).click();
		driver.findElement(By.xpath("//table[@class='list']//tr[2]//td[3]//input")).sendKeys(searchValue2);
		driver.findElement(By.xpath("//table[@class='detailList']//tr[1]//td[1]//select/option[@value='"+template+"']")).click();
		if (type.equals("Invoice")) {
		driver.findElement(By.xpath("//table[@class='detailList']//tr[1]//td[2]//input")).click();
		} else {
			driver.findElement(By.xpath("//table[@class='detailList']//tr[3]//td[1]//input")).click();
		}
		driver.findElement(By.xpath("//h3[text()='Scheduling Options']/../..//table[@class='detailList']//tr[1]//td[1]//input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h3[text()='Scheduling Options']/../..//table[@class='detailList']//tr[3]//td[1]//span[@class='dateFormat']")).click();
		driver.findElement(By.xpath("//h3[text()='Scheduling Options']/../..//table[@class='detailList']//tr[3]//td[2]//span[@class='dateFormat']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@value='Save']")).click();		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
	}
	
	
	
	@And("^I select the queue \"([^\"]*)\"$")
	public void i_Select_An(String queueName) throws Throwable {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Utils.checkIfOkClick("//span[@class='slds-icon_container slds-icon-utility-down downIcon slds-button__icon forceIcon']//span").click();
        Utils.checkIfOkClick("//span[text()='"+queueName+"']/../..//a").click();

       }
	
	@And("^I check if I can see the Billing Fulfilment Queue$")
	public void i_check_Billing_Fulfilment_Queue() throws Throwable {
		Utils.checkIfOkClick("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']").isDisplayed();

       }
	
	@And("^I check if I can see the Technical Fulfilment Queue$")
	public void i_check_Technical_Fulfilment_Queue() throws Throwable {
		Utils.checkIfOkClick("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//tr[1]//span[text()='Technical Fulfilment QC']").isDisplayed();

       }
	
	@And("^I check if I can see the Technical Fulfilment Line Item Queue$")
	public void i_check_Technical_Fulfilment_Line_Item_Queue() throws Throwable {
		Utils.checkIfOkClick("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']").isDisplayed();
	}
	
	
	@And("^I search an existing \"([^\"]*)\" on the Opportunity page search box$")
	public void searchexistingAccount(String opportunityName) throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		Utils.checkIfOkClick("//input[@class='slds-input slds-p-vertical--xxx-small slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']").sendKeys(opportunityName);
		Utils.checkIfOkClick("//input[@class='slds-input slds-p-vertical--xxx-small slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']").click();
		Utils.checkIfOkClick("//span[@title='"+opportunityName+"']").click();
		Thread.sleep(Utils.standardWait+3000);
	}
	
	@And("^Billing I click the \"([^\"]*)\" tab$")
	public void billing_I_click_the_tab_inside_Proposal(String tabTitle) throws Throwable {
		Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='"+tabTitle+"']/../../..//a[@title='"+tabTitle+"']")).click();

	}
	

	
	
	@And("^I handle fulfilment items$")
	public void i_handle_fulfilment_items() throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,1400);");
        Thread.sleep(Utils.standardWait + 2000);
		//List<WebElement> fulfilmentItems = driver.findElements(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr[*]"));
		for (int i = 0; i < 3; i++) {
			int row = i+1;
			try {
			driver.findElement(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr["+row+"]"));
			} catch (Exception e) {
				break;
			}
			 jse.executeScript("scroll(0,1400);");
			String fulfilmentType = driver.findElement(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr["+row+"]/td[1]")).getText();
			String fulfilmentState = driver.findElement(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr["+row+"]/td[2]")).getText();
			if (fulfilmentType.equals("Technical Fulfilment QC") && fulfilmentState.equals("Pending")) {
				driver.findElement(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr["+row+"]//a[contains(text(),'N-')]")).click();
				handle_fulfilment_items("Approved");							
			} 
			else if(fulfilmentType.equals("Billing Fulfilment QC") && fulfilmentState.equals("Pending")) {
				driver.findElement(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr["+row+"]//a[contains(text(),'N-')]")).click();
				handle_fulfilment_items("Approved");
			}
			else if(fulfilmentType.equals("Technical Fulfilment (Book Items)") && fulfilmentState.equals("Tech Ready")) {
				driver.findElement(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr["+row+"]//a[contains(text(),'N-')]")).click();
				handle_booked_fulfilment_items("1234","www.google.com","Tech Fulfiled");
			}
			else if(fulfilmentType.equals("Technical Fulfilment Line Item") && fulfilmentState.equals("Tech Ready")) {
				driver.findElement(By.xpath("//span[text()='Billing and Fulfilment Queues']/../../../..//table/tbody/tr["+row+"]//a[contains(text(),'N-')]")).click();
				handle_fulfilment_items("Tech Fulfiled");
			}
		}
	}
	
	

	private void handle_booked_fulfilment_items(String codeName, String urlName, String statusName) throws Throwable {
		WebElement aElement = Utils.checkIfOkClick("//p[text()='Billing and Fulfilment Queue']/../../..//div[@title='Edit']");
		aElement.click();
		Utils.checkIfOkClick("//span[text()='Tracking Number']/../../../..//input").sendKeys(codeName);
		Utils.checkIfOkClick("//span[text()='Link to UPS site']/../../../..//input").sendKeys(urlName);
		Utils.checkIfOkClick("//span[text()='Shipment Date']/../..//div[@class='form-element']").click();
		Utils.checkIfOkClick("//span[text()='Today']").click();
		try {
			    	driver.findElement(By.xpath("//span[text()='Status']/../..//span[@class='deleteIcon']")).click();                 
				} catch (Exception e) {
					// TODO: handle exception
				}                    
		Utils.checkIfOkClick("//span[text()='Status']/../..//a[@class='select']").click();
		Utils.checkIfOkClick("//a[text()='"+statusName+"']").click();
 		Utils.checkIfOkClick("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']").click();	
		Thread.sleep(Utils.standardWait + 7000);
		driver.navigate().back();
		Thread.sleep(Utils.standardWait);
		driver.navigate().refresh();
		Utils.checkIfOkClick("//p[text()='Opportunity']/../../../../../../../..//span[contains(.,'Related')]").click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,1200);");
        Thread.sleep(Utils.standardWait);
	}
	
	private void handle_fulfilment_items(String statusName) throws Throwable {
		WebElement aElement = Utils.checkIfOkClick("//p[text()='Billing and Fulfilment Queue']/../../..//div[@title='Edit']");
		aElement.click();	
		try {
			    	driver.findElement(By.xpath("//span[text()='Status']/../..//span[@class='deleteIcon']")).click();                 
				} catch (Exception e) {
					// TODO: handle exception
				}
		Utils.checkIfOkClick("//span[text()='Status']/../..//a[@class='select']").click();
		Utils.checkIfOkClick("//a[text()='"+statusName+"']").click();
		Utils.checkIfOkClick("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']").click();
		Thread.sleep(Utils.standardWait + 7000);
		driver.navigate().back();
		Thread.sleep(Utils.standardWait);
		driver.navigate().refresh();
		Utils.checkIfOkClick("//p[text()='Opportunity']/../../../../../../../..//span[contains(.,'Related')]").click();
		Thread.sleep(Utils.standardWait);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,1200);");
		Thread.sleep(Utils.standardWait);
	}
	
	 
	
	@And("^I click on the My Approvals button$")
	public void i_Click_On_My_Approvals_Button() throws Throwable {
		Utils.checkIfOkClick("//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']").click();
		Utils.checkIfOkClick("//a[@title='My Approvals']").click();
	}
	
	@And("^I click on the Approve button$")
	public void i_Click_On_Approve_Button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(Utils.standardWait + 12000);
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//input[@value='Approve']")).click();
		Thread.sleep(Utils.standardWait + 2000);
		driver.switchTo().defaultContent();
	}
	
				

	

	@And("^I check invoice$")
	public void I_Check_Invoice() throws Throwable {
		Thread.sleep(Utils.standardWait);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 500);");
		Thread.sleep(Utils.standardWait);
		jse.executeScript("scroll(0, 1000);");
		Thread.sleep(Utils.standardWait);
		jse.executeScript("scroll(0, 1200);");
		Thread.sleep(Utils.standardWait);
		try {
		Utils.checkIfOkClick("//span[text()='Invoices (Bill To)']/../../../../..//span[text()='View All']").click();
		} catch (Exception e) {
			return;
		}
	
		Utils.checkIfOkClick("//h1[@title='Invoices (Bill To)']/../../../../../..//tbody//tr[1]//a[contains(text(),'INV-')]").click();
		 Thread.sleep(Utils.standardWait+ 2000);
		driver.navigate().refresh();
		dataFactory.InvoiceOracleIntegrationStatus = Utils.checkIfOkClick("//span[text()='Oracle Integration Status']/../..//div[@class='slds-form-element__control slds-grid itemBody']/span").getText();
		if (dataFactory.InvoiceOracleIntegrationStatus.equals("")) {
			dataFactory.InvoiceOracleIntegrationStatus = "EMPTY";
		}
		dataFactory.InvoiceID = Utils.checkIfOkClick("//span[text()='Invoice Number']/../..//div[@class='slds-form-element__control slds-grid itemBody']/span").getText();
		dataFactory.InvoiceAmount = Utils.checkIfOkClick("//span[text()='Total Invoice Amount']/../..//div[@class='slds-form-element__control slds-grid itemBody']/span").getText();
		dataFactory.InvoiceBillToID = Utils.checkIfOkClick("//span[text()='Bill To']/../..//div[@class='slds-form-element__control slds-grid itemBody']/span").getText();
		dataFactory.InvoiceShipToID = Utils.checkIfOkClick("//span[text()='Ship To']/../..//div[@class='slds-form-element__control slds-grid itemBody']/span").getText();
		dataFactory.InvoiceTaxAmount = Utils.checkIfOkClick("//span[text()='Total Tax Amount']/../..//div[@class='slds-form-element__control slds-grid itemBody']/span").getText();
	}		
}
