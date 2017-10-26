package rbi.RBI_Project;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import auto.framework.ConfigProvider;



public class quoteStepDefinition {

	WebDriver driver = Utils.driver;                        


	@And("^I click the Create/Quote Proposal link$")
	public void i_Click_Create_Quote_Link() throws Throwable {
		Thread.sleep(Utils.standardWait + 15000);
		
		try {
			
				 Utils.checkIfOkClick("//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']").click();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
			 Utils.checkIfOkClick("//a[@title='Create Quote/Proposal']").click();
		try {
			 
				 driver.switchTo().frame(3);
				 driver.findElement(By.xpath("//input[@value='Continue']")).click();
			 
		} catch (Exception e) {
			
		}
			

	}


	@And("^I set the Price List \"([^\"]*)\"$")
	public void selectPriceListOnQuote(String priceList) throws Throwable {
		try{
		Utils.checkIfOkClick("//span[text()='Price List']/../..//span[@class='deleteIcon']").click(); 
		}catch (Exception error){
			
		}
		Utils.checkIfOkClick("//input[@placeholder='Search Price Lists...']").sendKeys(priceList);
		Utils.checkIfOkClick("//div[@title='"+priceList+"']").click();
	}


	@And("^Based on user region a Pricelist should be selected automatically$")
	public void validatePriceListField() throws Throwable {

		Thread.sleep(Utils.standardWait + 20000);
		WebElement fieldValue = driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//span[text()='Price List']]//a"));
		String value = driver.findElement(By.xpath("//div[@class='slds-grid full forcePageBlockSectionRow'][.//span[text()='Price List']]//a")).getText();
		Thread.sleep(Utils.standardWait);                            
		if(fieldValue.isDisplayed()){
			System.out.println("Price List: " + value);
		}else{System.out.println("ERROR: Price Field is not populated");                
		}
		Assert.assertTrue(fieldValue.isDisplayed());

	}


	@And("^I edit quote$")
	public void clickEditButton() throws Throwable {
	  Thread.sleep(Utils.standardWait);
		try{
			driver.findElement(By.xpath("//div[@class='slds-page-header s1FixedFullWidth s1FixedTop forceHighlightsStencilDesktop']//p[text()='Quote/Proposal']/../../..//li[1]")).click();		

		}catch (Exception error){
			Utils.checkIfOkClick("//p[text()='Quote/Proposal']/../../..//ul[@data-aura-class='oneActionsRibbon forceActionsContainer']//li[1]").click();
			
		}
	}

	@And("^I edit quote with billing user$")
	public void clickEditButton_Billing_User() throws Throwable {
		//Thread.sleep(Utils.standardWait + 5000);
		try{
			driver.findElement(By.xpath("//div[@class='slds-page-header s1FixedFullWidth s1FixedTop forceHighlightsStencilDesktop']//p[text()='Quote/Proposal']/../../..//li[2]")).click();		

		}catch (Exception error){
						Utils.checkIfOkClick("//p[text()='Quote/Proposal']/../../..//ul[@data-aura-class='oneActionsRibbon forceActionsContainer']//li[2]").click();
		}
	}

	@And("^I enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and select contact details correct checkbox$")
	public void i_Enter_And_Select_Contact_Details_Correct_Checkbox(String startDate, String endDate, String primaryContact) throws Throwable {
		primaryContact = dataFactory.getInstance().getPrimaryContactName();
		/* 
		try {
			driver.findElement(By.xpath("//span[text()='Primary Contact']/../..//span[@class='deleteIcon']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		} 
       Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//span[text()='Primary Contact']/../..//input")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")).sendKeys(primaryContact);
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//div[@title='"+primaryContact+"']")).click();*/
        Utils.checkIfOkClick("//span[text()='Expected Start Date']/../..//input").click();
		Utils.checkIfOkClick("//span[text()='Today']").click(); 
	    Utils.checkIfOkClick("//span[text()='Expected End Date']/../..//div[@class='form-element']").click();
	    Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//span[text()='Today']")).click(); 
		Utils.checkIfOkClick("//span[text()='Contract Details Correct?']/../..//input").click();
	    }


	@And("^I fill the Billing Preference field \"([^\"]*)\"$")
	public void i_Fill_Billing_Preference(String billingPreference) throws Throwable {                              
		Utils.checkIfOkClick("//span[text()='Billing Preference']/../..//input").click();
		Utils.checkIfOkClick("//input[@placeholder='Search Billing Preferences...']").sendKeys(billingPreference);
		Utils.checkIfOkClick("//div[@title='"+billingPreference+"']").click();
	}



	@And("^I enter \"([^\"]*)\" \"([^\"]*)\" and select contact details correct checkbox$")
	public void i_Enter_And_Select_Contact_Details_Correct_Checkbox(String startDate, String primaryContact) throws Throwable {
		primaryContact = dataFactory.getInstance().getPrimaryContactName();
		//Thread.sleep(Utils.standardWait);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0,200);");
		//driver.findElement(By.xpath("//span[text()='Primary Contact']/../..//button[@title='Edit Primary Contact']")).click();                                
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(Utils.standardWait);
		try {
			if(Utils.checkIfPageIsReady()){
				Utils.checkIfOkClick("//span[text()='Primary Contact']/../..//span[@class='deleteIcon']").click(); 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}                    
		//Thread.sleep(Utils.standardWait);
/*		driver.findElement(By.xpath("//span[text()='Primary Contact']/../..//input")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")).sendKeys(primaryContact);
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//div[@title='"+primaryContact+"']")).click();
		Thread.sleep(Utils.standardWait);*/
		Utils.checkIfOkClick("//span[text()='Expected Start Date']/../..//input").click();                    		
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//span[text()='Today']").click();
		Utils.checkIfOkClick("//span[text()='Contract Details Correct?']/../..//input").click();
	}



	@And("^I click save button on the Quote page$")
	public void i_Click_Save_Button() throws Throwable {                              
		Utils.checkIfOkClick("//div[@class='footer active']//button[2]").click();  
		Thread.sleep(Utils.standardWait+10000);
	}

	@And("^I click Configure Products button on the Quote page$")
	public void i_Click_Configure_Products_Button() throws Throwable {
		Thread.sleep(Utils.standardWait+3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 900);");
		Thread.sleep(Utils.standardWait);
		if(Utils.checkIfPageIsReady()) {
			 Utils.checkIfOkClick("//span[text()='Configure Products']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']//a").click();
		}
	}



	@And("^I click Generate Proforma button on the Quote page$")
	public void i_Click_Generate_Proforma_Button() throws Throwable {

		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		// jse.executeScript("scroll(0, 1000);");
		Thread.sleep(Utils.standardWait + 5000);
		Utils.checkIfOkClick("//span[text()='Generate Proforma Invoice']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']//a").click();                              
	}

	@And("^I click Browse catalog and select \"([^\"]*)\"$")
	public void i_Click_Browse_Catalog_And_Select_Product_Family(String productFamily) throws Throwable {     
		Thread.sleep(Utils.standardWait + 12000);
		Utils.checkIfOkClick("//div[@class='main-product-catalog block main-block ng-scope']//a[text()='"+productFamily+"']").click();
	}

	@And("^I select the \"([^\"]*)\" and click configure button$")
	public void i_Select_Product(String product) throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		WebElement aElement = null;
		if(Utils.checkIfPageIsReady()){
		Utils.checkIfOkClick("//div[@class='search-area']//input").sendKeys(product);
		}
	 Utils.checkIfOkClick("//div[@class='search-area']//input").sendKeys(Keys.ENTER);
	 Thread.sleep(Utils.standardWait);
     Utils.checkIfOkClick("//a[text()='"+product+"']/../../../..//span[@class='listing-check checkbox-override']").click();
     Thread.sleep(Utils.standardWait);
	 Utils.checkIfOkClick("//a[text()='"+product+"']/../../../..//span[text()='Configure...']").click();

	}

	@And("^I select the installed product \"([^\"]*)\"$")
	public void i_Select_Installed_Product(String product) throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//table[@class='ng-scope']/tbody//td//a[text()='"+product+"']/../../../..//div[@class='checkbox-override ng-scope']").click();

	}



	@And("^I populate the Product Attributes \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_Populate_Product_Attributes(String fullfillmentType, String billingFrequency) throws Throwable {
		fullfillmentType = dataFactory.getInstance().getFulfilmentType();
		billingFrequency = dataFactory.getInstance().getBillingFrequency();
		Utils.checkIfOkClick("//span[@class='select2-arrow ui-select-toggle']").click();
		if(Utils.checkIfOkToContinue("//div[text()='"+fullfillmentType+"']")){
		Utils.checkIfOkClick("//div[text()='"+fullfillmentType+"']").click();
		}

	}

	@And("^I click on the New Billing Plan Button$")
	public void i_click_on_new_billing_plan() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(Utils.standardWait + 2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,450);");
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//span[text()='Billing Plans']/../../../../..//a[@title='New']")).click();
	}

	@And("^I check if the Test Billing Plan is generated$")
	public void i_check_if_test_billing_plan_generated() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(Utils.standardWait + 2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,450);");
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//span[text()='Billing Plans']/../../../../..//a[text()='Test Billing Plan']")).isDisplayed();
	}

	@And("^I enter Billing Plan Details$")
	public void i_enter_billing_plan_details() throws Throwable {
		if(Utils.checkIfPageIsReady()){
			driver.switchTo().frame(2);
		}
		Utils.checkIfOkClick("//div[@class='pbBody']//table//tr[1]//td[1]//select").click();
		Utils.checkIfOkClick("//option[@value = 'One Time']").click();
		Utils.checkIfOkClick("//input[@type = 'checkbox']").click();
		Utils.checkIfOkClick("//input[@value = 'Next']").click();
		Utils.checkIfOkClick("//label[text()='Plan Name']/../..//input").sendKeys("Test Billing Plan");
		Utils.checkIfOkClick("//label[text()='Number of Installments']/../../..//input").sendKeys("2");
		Utils.checkIfOkClick("//label[text()='Billing Start Date']/../../..//a").click();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1); 
		Date nextYear = cal.getTime();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String terminationDate = df.format(nextYear).toString();
		driver.findElement(By.xpath("//label[text()='Billing End Date']/../../..//input")).sendKeys(terminationDate);
		Utils.checkIfOkClick("//input[@value = 'Next']").click();
		Utils.checkIfOkClick("//table[@class='list']//tr[1]//td[1]//input").sendKeys("Billing Plan Item 1");
		Utils.checkIfOkClick("//table[@class='list']//tr[2]//td[1]//input").sendKeys("Billing Plan Item 2");
		Thread.sleep(Utils.standardWait);
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 178); 
		Date nextHalfYear = cal2.getTime();
		String midterminationDate = df.format(nextHalfYear).toString();
		driver.findElement(By.xpath("//table[@class='list']//tr[1]//td[4]//input")).sendKeys(midterminationDate);
		Utils.checkIfOkClick("//table[@class='list']//tr[2]//td[3]//input").sendKeys(midterminationDate);
		Utils.checkIfOkClick("//table[@class='list']//tr[1]//td[5]//a").click();
		Utils.checkIfOkClick("//table[@class='list']//tr[2]//td[5]//input").sendKeys(midterminationDate);
		Utils.checkIfOkClick("//table[@class='list']//tr[1]//td[6]//span//input").sendKeys("Net 28 Payment Term UK");
		Utils.checkIfOkClick("//table[@class='list']//tr[2]//td[6]//span//input").sendKeys("Net 28 Payment Term UK");
		Utils.checkIfOkClick("//input[@value = 'Save']").click();
		Thread.sleep(Utils.standardWait+2000);
		driver.navigate().refresh();
		
	}




	@And("^I set the number of months \"([^\"]*)\"$")
	public void i_set_the_number_of_months(String mounths) throws Throwable {


		Utils.checkIfOkClick("//span[text()='Months']/../..//input").sendKeys(mounths);


	}

	@And("^I configure the product$")
	public void i_configure_the_product() throws Throwable {

		Thread.sleep(Utils.standardWait + 7000);
		driver.findElement(By.xpath("//span[text()='Alert Review  - Firco Continuity for SAA']/../../..//div[@class='checkbox-override']")).click();
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//span[text()='Alert Review  - Firco Continuity for SAA']/../../../..//h3/..//input")).sendKeys("1000");
		Thread.sleep(Utils.standardWait+2000);

	}

	@And("^I add number of users$")
	public void iAddNumberOfUsers() throws Throwable {

		Utils.checkIfOkClick("//input[@type='text'][@ng-if='!dynamicField.gridCartView']").click();
		Utils.checkIfOkClick("//input[@type='text'][@ng-if='!dynamicField.gridCartView']").sendKeys("1000");


	}

	@And("^I change number of users$")
	public void iChangeNumberOfUsers() throws Throwable {

		Thread.sleep(Utils.standardWait + 10000);
		Utils.checkIfOkClick("//input[@type='text'][@ng-if='!dynamicField.gridCartView']").click();
		Utils.checkIfOkClick("//input[@type='text'][@ng-if='!dynamicField.gridCartView']").clear();
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//input[@type='text'][@ng-if='!dynamicField.gridCartView']").sendKeys("2000");
		Thread.sleep(Utils.standardWait);

	}


	@And("^I populate the Quantity field \"([^\"]*)\"$")
	public void i_Populate_Product_Attributes(String quantity) throws Throwable {
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//span[text()='Quantity']/../..//input").sendKeys(quantity);


	}
	@And("^I click Validate button$")
	public void i_Click_Validate_Button() throws Throwable {

		Utils.checkIfOkClick("//button[@ng-click='summary.updateBundle()']").click();
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//button[@ng-click='summary.updatePrice()']").click();
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//button[@ng-click='summary.gotoCart()']").click();
		
	}

	@And("^I click Go To Pricing button$")
	public void i_Click_Go_To_Pricing_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//button[@ng-click='summary.gotoCart()']").click();
		Thread.sleep(Utils.standardWait + 2000);
	}

	@And("^I click Finalize button$")
	public void i_Click_Finalize_Button() throws Throwable {
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Finalize']]").click();
		Thread.sleep(Utils.standardWait + 7000);

	}  

	@And("^I click Finalize Cancellation button$")
	public void i_Click_Finalize_Cancellation_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Finalize']]").click();
		Thread.sleep(Utils.standardWait + 15000);
	}

	@And("^I click Goto Pricing from Status bar$")
	public void i_Click_Go_to_Pricing_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Go to Pricing']]").click();
		Thread.sleep(Utils.standardWait + 15000);
	}

	@And("^I click Installed Products button$")
	public void i_Click_Installed_Products_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 12000);
		driver.navigate().refresh();
		Thread.sleep(Utils.standardWait + 5000);
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Installed Products']]").click();
		Thread.sleep(Utils.standardWait + 7000);
	}

	                @And("^I set the termination date$")
	                public void i_Set_Termination_Date() throws Throwable {
	                				Thread.sleep(Utils.standardWait);
	                				Utils.checkIfOkClick("//label[text()='Termination Date']/..//input").clear();
	                				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	                				String terminationDate = df.format(new java.util.Date()).toString();
	                				Utils.checkIfOkClick("//label[text()='Termination Date']/..//input").sendKeys(terminationDate);
	                                Thread.sleep(Utils.standardWait);
	                }

	@And("^I click Terminate button$")
	public void i_Click_Terminate_Button() throws Throwable {
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//button[@ng-click='actionCtrl.handleButtonClick(action.stateName)'][.//span[text()='Terminate']]").click();
		Thread.sleep(Utils.standardWait);
	}

	@And("^I set the date of the termination$")
	public void i_Set_Termination_Date_On_Termination_Page() throws Throwable {
		Thread.sleep(Utils.standardWait+5000);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1); 
		Date nextYear = cal.getTime();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String terminationDate = df.format(nextYear).toString();
		Utils.checkIfOkClick("//input[@id='terminateDate']").clear();
		Utils.checkIfOkClick("//input[@id='terminateDate']").sendKeys(terminationDate);
		Thread.sleep(Utils.standardWait+3000);
	}
	
	

	@And("^I click Change button$")
	public void i_Click_Change_Button() throws Throwable {
		Utils.checkIfOkClick("//button[@ng-click='actionCtrl.handleButtonClick(action.stateName)'][.//span[text()='Change']]").click();
	}



	@And("^I click Calculate button$")
	public void i_Click_Calculate_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//button[@ng-click='ctrl.handleCalculateMetrics(ctrl.globalEndDate)'][.//span[text()='Calculate']]").click();
		Thread.sleep(Utils.standardWait);
	}

	@And("^I click Confirm button$")
	public void i_Click_Confirm_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 15000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 900);");
		Utils.checkIfOkClick("//button[@ng-click='ctrl.handleConfirmOperation()'][.//span[text()='Confirm']]").click();
		Thread.sleep(Utils.standardWait + 10000);
	}

	@And("^I click Save button$")
	public void i_Click_Cart_Save_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Save']]").click();
		Thread.sleep(Utils.standardWait + 15000);
	} 


	@And("^I click Generate button on the Quote Page$")
	public void i_Click_Generate_Button_On_Quote_Page() throws Throwable {
		Thread.sleep(Utils.standardWait + 17000);

		try{
			driver.navigate().refresh();
			Thread.sleep(Utils.standardWait + 3000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 600);");
			Utils.checkIfOkClick("//span[text()='Generate']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']//a").click();
		}catch (Exception error){
			if( Utils.checkIfOkClick("//p[text()='Quote/Proposal']/../../..//ul[@data-aura-class='oneActionsRibbon forceActionsContainer']//li[1]") !=null){
				String currentUrl = driver.getCurrentUrl();
				String id = currentUrl.substring(currentUrl.indexOf("sObject/")+8, currentUrl.indexOf("/view"));
				String aurl=currentUrl.substring(0,currentUrl.indexOf(".com/")+5) + "apex/Apttus_Proposal__ProposalGenerate?id="+id;
				driver.navigate().to(aurl);
			}
		}


	}

	@And("^I click Generate proforma button on the Quote Page$")
	public void i_Click_Generate_Proforma_Button_On_Quote_Page() throws Throwable {
		Thread.sleep(Utils.standardWait + 15000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1100);");
		Utils.checkIfOkClick("//img[@alt='Generate']").click();
		Thread.sleep(Utils.standardWait + 15000);	                	
	}

	                @And("^I click Accept button on the Quote Page$")
	                public void i_Click_Accept_Button_On_Quote_Page() throws Throwable {
	                	              Thread.sleep(Utils.standardWait + 15000);
	                	              
		                             //  driver.navigate().refresh();
		                             //  Thread.sleep(Utils.standardWait + 3000);
		                               /*
		                                JavascriptExecutor jse = (JavascriptExecutor)driver;
		                                jse.executeScript("scroll(0, 800);");
		                                driver.findElement(By.xpath("//span[text()='Accept']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']//a")).click();
		                                Thread.sleep(Utils.standardWait + 15000);*/
	                  
		                            String currentUrl = driver.getCurrentUrl();
	        	                	String id = currentUrl.substring(currentUrl.indexOf("sObject/")+8, currentUrl.indexOf("/view"));
	                   				String aurl=currentUrl.substring(0,currentUrl.indexOf(".com/")+5) + "apex/Apttus_QPConfig__ProposalAccept?id="+id;
						            driver.navigate().to(aurl);
	                	
	                	Thread.sleep(Utils.standardWait + 3000);
	                }



	@And("^Add Product I click the \"([^\"]*)\" tab inside Proposal$")
	public void qualifyopportunity_I_click_the_tab_inside_Proposal(String tabTitle) throws Throwable {
		Thread.sleep(5000);
		Utils.checkIfOkClick("//span[text()='Details']/../../..//li[2]//a[@title='"+tabTitle+"']").click();
	}

	@And("^I check if the Quote Stage is \"([^\"]*)\"$")
	public void i_Check_The_Quote_Stage(String quoteStage) throws Throwable {

		Thread.sleep(Utils.standardWait + 32000);
		driver.navigate().refresh();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Approval Stage']/../..//span[@class='test-id__field-value slds-form-element__static slds-grow']/span[text()='"+quoteStage+"']")).isDisplayed());
		Thread.sleep(Utils.standardWait);
	}

	@And("^I click the related tab inside Opportunity$")
	public void createproposal_I_click_the_tab_inside_Opportunity() throws Throwable {
		Thread.sleep(10000);
		WebElement aelement=Utils.checkIfOkClick("//span[contains(.,'Related')]") ;
		if (aelement ==null){
			driver.navigate().refresh();
			aelement=Utils.checkIfOkClick("//span[contains(.,'Related')]") ;
		}
		aelement.click();
	}






	@And("^I populate the Discount fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void populateDiscountField(String discountType, String discountReason, String discountPercentage) throws Throwable {
		discountType = dataFactory.getInstance().getDiscoutType();
		discountReason = dataFactory.getInstance().getDiscoutReason();                				
	Thread.sleep(Utils.standardWait + 5000);		
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope']/td[10]//div[@class='fieldtype-wrapper fieldtype-wrapper--PICKLIST']").click();
		Utils.checkIfOkClick("//div[text()='"+discountType+"']").click();
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope']/td[12]//div[@class='fieldtype-wrapper fieldtype-wrapper--PICKLIST']").click();
		Utils.checkIfOkClick("//div[text()='"+discountReason+"']").click();
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope']/td[11]//input").click();
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope']/td[11]//input").sendKeys(discountPercentage);
	}

	@And("^I set the Billing frequency \"([^\"]*)\" and the number of years \"([^\"]*)\"$")
	public void populateBillingFrequency(String billingFrequency, String years) throws Throwable {               				
		Thread.sleep(Utils.standardWait + 5000);
		driver.findElement(By.xpath("//span[@class='fa fa-angle-double-right right-scroller']")).click();
		//}
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope'][1]/td[7]//span[@class='select2-arrow ui-select-toggle']").click();
		Utils.checkIfOkClick("//div[text()='"+billingFrequency+"']").click();
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope'][1]/td[6]//span[@class='select2-arrow ui-select-toggle']").click();
		Utils.checkIfOkClick("//div[@class='select2-result-label ui-select-choices-row-inner']//div[text()='"+years+"']").click();
	}

	@And("^I set the Billing frequency \"([^\"]*)\" and the number of years \"([^\"]*)\" of the second product$")
	public void populateBillingFrequencySecondProduct(String billingFrequency, String years) throws Throwable {               				

		Thread.sleep(Utils.standardWait + 5000);
		driver.findElement(By.xpath("//span[@class='fa fa-angle-double-right right-scroller']")).click();
		//}
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope'][2]/td[7]//span[@class='select2-arrow ui-select-toggle']").click();
		Utils.checkIfOkClick("//div[text()='"+billingFrequency+"']").click();
		Utils.checkIfOkClick("//tr[@class='line-item-row is--open ng-scope'][2]/td[6]//span[@class='select2-arrow ui-select-toggle']").click();
		Utils.checkIfOkClick("//div[@class='select2-result-label ui-select-choices-row-inner']//div[text()='"+years+"']").click();
	}

	@And("^I check if the calculated price is \"([^\"]*)\"'line-item-r and the discout is \"([^\"]*)\"$")
	public void i_CheckCCalculatedCValues(String calculatedPrice, String calculatedDiscount) throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Assert.assertEquals(calculatedPrice, driver.findElement(By.xpath("//tr[@class='ng-scope ng-isolate-scope'][6]//td[9]")).getText());
		Assert.assertEquals(calculatedDiscount, driver.findElement(By.xpath("//tr[@class='ng-scope ng-isolate-scope'][6]//td[10]")).getText());                               

	}





	@And("^I check if the \"([^\"]*)\" is correct$")
	public void i_Check_Price(String expectedNetPrice) throws Throwable {
		expectedNetPrice = dataFactory.getInstance().getNetPrice();
		System.out.println(expectedNetPrice);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(Utils.standardWait);
		String actualNetPrice = driver.findElement(By.xpath("//div[@class='configure-product__price-row']//span[2]")).getText();
		Thread.sleep(Utils.standardWait);
		try{             
			if(expectedNetPrice.equals(actualNetPrice)){
				System.out.println("Net Price is correct");
				System.out.println("Expected Net Price: " + expectedNetPrice);
				System.out.println("Actual Net Price: " + actualNetPrice);
			}else{
				System.out.println("Net Price is not correct");
				System.out.println("Expected Net Price: " + expectedNetPrice);
				System.out.println("Actual Net Price: " + actualNetPrice);
				Assert.fail("Net Price is not correct, Expected Net Price: " + expectedNetPrice +"Actual Net Price: " + actualNetPrice);
			}
		}catch (Exception e){
			return;
		}

	}



	@And("^I click Submit for Approval button$")
	public void i_Click_Submit_For_Approval_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 7000);
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Submit for Approval']]").click();
	}

	@And("^I click Submit button$")
	public void i_Click_Submit_Button() throws Throwable {
		Thread.sleep(Utils.standardWait + 17000);
		Utils.checkIfOkClick("//input[@value='Submit']").click();
		Thread.sleep(Utils.standardWait + 10000);
		Utils.checkIfOkClick("//input[@value='Return']").click();
		Thread.sleep(Utils.standardWait + 2000);
	}



	@And("^I click Reprice button$")
	public void i_Click_Reprice_Button() throws Throwable {
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Reprice']]").click();
      }
               
    @And("^I click Add More Products button$")
     public void i_Click_Add_More_Products_Button() throws Throwable {
		Utils.checkIfOkClick("//button[@ng-click='displayAction.doAction(action)'][.//span[text()='Add More Products']]").click();
                
	   }

    @And("^I click on the proposal$")
	public void i_click_on_the_proposal() throws Throwable {
		Thread.sleep(Utils.standardWait);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,900);");
        Thread.sleep(Utils.standardWait);
        try{
        Utils.checkIfOkClick("//span[text()='Proposals']/../../../../../..//a[contains(text(),'Q-')]").click();
        }catch (Exception error){
        	driver.navigate().refresh();
			Utils.checkIfOkClick("//span[contains(.,'Related')]").click();
			Thread.sleep(Utils.standardWait);
	        jse = (JavascriptExecutor)driver;
	        jse.executeScript("scroll(0,900);");
	        Thread.sleep(Utils.standardWait);
			Thread.sleep(Utils.standardWait);
        	Utils.checkIfOkClick("//span[text()='Proposals']/../../../../../..//a[contains(text(),'Q-')]").click();
        }
	}

	@And("^I complete Generate Proposal Options: \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_Complete_Generate_Proposal_Options(String format, String watermark, String template) throws Throwable {
		format = dataFactory.getInstance().getProposalFormat();
		watermark = dataFactory.getInstance().getProposalWatermark();
		Utils.checkIfOkClick("//td/input[@value='"+format+"']").click();
		if(watermark != null){
			Utils.checkIfOkClick("//input[@type='checkbox']").click();
		}
		Utils.checkIfOkClick("//span[text()='"+template+"']/../..//input").click();		
		Thread.sleep(Utils.standardWait);
		Utils.checkIfOkClick("//span/input[@value='Generate']").click();	
		Thread.sleep(Utils.standardWait + 15000);
		Utils.checkIfOkClick("//div[@class='individualPalette'][.//td[@class='pbButtonb']]//input").click();
	}

	@And("^I complete Generate Proforma Options: \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_Complete_Generate_Proforma_Options(String format, String watermark, String template) throws Throwable {
		Thread.sleep(Utils.standardWait + 2000);
		Utils.checkIfOkClick("//td/input[@value='"+format+"']").click();
		Utils.checkIfOkClick("//input[@type='checkbox']").click();
		Utils.checkIfOkClick("//span[text()='"+template+"']/../..//input").click();
		Thread.sleep(Utils.standardWait + 5000);
		Utils.checkIfOkClick("//span/input[@value='Generate']").click();
		Thread.sleep(Utils.standardWait + 15000);
		Utils.checkIfOkClick("//div[@class='pbBottomButtons'][.//td[@class='pbButtonb']]//input").click();
		Thread.sleep(Utils.standardWait + 10000);
	}



	@And("^Navigate back with the browser$")
	public void navigateBackCloseBrowser() throws Throwable {
		driver.navigate().back();
		Thread.sleep(5000);
	}
   
	

}
