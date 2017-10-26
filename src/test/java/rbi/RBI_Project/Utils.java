package rbi.RBI_Project;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import auto.framework.ConfigProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {


	String url;		
	public static WebDriver driver=null;
	public static final long standardWait = 3000;
	public static String testEnv = "UAT";//System.getProperty("atestEnvironment");
	public static Scenario ascenario;
	//Begin: Different Roles Logins  


	@Before
	public void before(Scenario scenario)
	{
		Utils.ascenario=scenario;
	}

	@Given("^I open the browser and access Salesforce$")
	public void navigateToSalesforce() throws Throwable{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
		Proxy proxy = new Proxy(); 
		proxy.setHttpProxy("10.52.68.237:3128"); 
		proxy.setSslProxy("10.52.68.237:3128"); 
		capabilities.setCapability("proxy", proxy); 
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("start-maximized"); 
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
		System.setProperty("webdriver.chrome.driver", ConfigProvider.getDriverPath());
		driver = new ChromeDriver(capabilities);
		url = dataFactory.getInstance().getApplicationUrl();
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Given("^I open eloqa in the browser and access$")
	public void navigateToEloqa() throws Throwable{

		try{
			//Runtime.getRuntime().exec("TASKKILL /IM chrome.exe /F");
		}catch (Exception error){
			//Not sessions identified.
		}

		System.setProperty("webdriver.chrome.driver", ConfigProvider.getDriverPath());
		driver = new ChromeDriver();
		url = dataFactory.getInstance().getEloquaUrl();
		driver.get(url);
		driver.manage().window().maximize();

	}


	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as salesuser$")
	public void enterCredentials(String userName, String password ) throws Throwable {

		if(testEnv.equals("UAT"))
		{
			userName = dataFactory.getInstance().getUserNameSalesUserUAT();
			password = dataFactory.getInstance().getUserPwdSalesUserUAT();
		}
		else{
			userName = dataFactory.getInstance().getUserNameSalesUserSIT();
			password = dataFactory.getInstance().getUserPwdSalesUserSIT();
		}
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);	
	}

	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as eloqa user$")
	public void enterEloqaUser(String userName, String password ) throws Throwable {

		if(testEnv.equals("UAT"))
		{
			userName = dataFactory.getInstance().getUserNameEloqua();
			password = dataFactory.getInstance().getUserPwdEloqua();
		}
		else{
			userName = dataFactory.getInstance().getUserNameEloqua();
			password = dataFactory.getInstance().getUserPwdEloqua();

		}


		driver.findElement(By.id("sitename")).sendKeys("RBIAccuitySandbox");
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);	
	}

	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as billing user$")
	public void enterAsBillingUser(String userName, String password ) throws Throwable {


		if(testEnv.equals("UAT"))
		{
			userName = dataFactory.getInstance().getUserNameBillingUserUAT();
			password = dataFactory.getInstance().getUserPwdBillingUserUAT();
		}
		else{
			userName = dataFactory.getInstance().getUserNameBillingUserSIT();
			password = dataFactory.getInstance().getUserPwdBillingUserSIT();
		}

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);	
	}

	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as salesops$")
	public void enterSalesOpsCredentials(String userName, String password ) throws Throwable {
		if(testEnv.equals("UAT"))
		{
			userName = dataFactory.getInstance().getUserNameSalesOpsUserUAT();
			password = dataFactory.getInstance().getUserPwdSalesOpsUserUAT();
		}
		else{
			userName = dataFactory.getInstance().getUserNameSalesOpsUserSIT();
			password = dataFactory.getInstance().getUserPwdSalesOpsUserSIT();
		}

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);	

	}


	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as admin$")
	public void enterAsAdmin(String userName, String password ) throws Throwable {
		if(testEnv.equals("UAT"))
		{
			userName = dataFactory.getInstance().getUserNameAdminUAT();
			password = dataFactory.getInstance().getUserPwdAdminUAT();
		}
		else{
			userName = dataFactory.getInstance().getUserNameAdminSIT();
			password = dataFactory.getInstance().getUserPwdAdminSIT();
		}

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);	
	}

	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as datadotcom user$")
	public void enterDataDotComUserCredentials(String userName, String password ) throws Throwable {
		if(testEnv.equals("UAT"))
		{
			userName = dataFactory.getInstance().getUserNameDataDotComUAT();
			password = dataFactory.getInstance().getUserPwdDataDotComUAT();
		}
		else{
			userName = dataFactory.getInstance().getUserNameDataDotComSIT();
			password = dataFactory.getInstance().getUserPwdDataDotComSIT();
		}

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);	
	}

	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as sales manager$")
	public void enterAsSalegManager(String userName, String password ) throws Throwable {
		if(testEnv.equals("UAT"))
		{
			userName = dataFactory.getInstance().getUserNameSalesManagerUAT();
			password = dataFactory.getInstance().getUserPwdSalesManagerUAT();
		}
		else{
			userName = dataFactory.getInstance().getUserNameSalesManagerSIT();
			password = dataFactory.getInstance().getUserPwdSalesManagerSIT();
		}

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);	
	}

	@Then("^I am able to login to SalesForce$")
	public void clickLoginButton() throws Throwable {
		driver.findElement(By.id("Login")).click();
		Thread.sleep(Utils.standardWait+2000);

	}

	@Then("^I am able to login to Eloqa$")
	public void clickEloqaLoginButton() throws Throwable {
		driver.findElement(By.id("submitButton")).click();
	}


	//End: Different Roles Logins


	//Begin: Tabs

	@And("^I click the \"([^\"]*)\" tab$")
	public void clickTab(String tabName) throws Throwable {
		//driver.findElement(By.xpath("//a[contains(.,'"+tabName+"')][@class='slds-context-bar__label-action']")).click();
		Thread.sleep(Utils.standardWait+1000);
		WebElement aelement =Utils.checkIfOkClick("//a[contains(.,'" + tabName+ "')]");
		if(aelement ==null){
			driver.navigate().refresh();
			aelement =Utils.checkIfOkClick("//a[contains(.,'" + tabName+ "')]");
		}
		aelement.click();
		Thread.sleep(Utils.standardWait);
	}

	

	@And("^I click Save button for account$")
	public void clickSaveButton() throws Throwable {
		Utils.checkIfOkClick("//button[@title='Save'][@type='button']").click();
	}


	@Given("^I click the Leads tab$")
	public void clickLeadsTab() throws Throwable {
		Utils.checkIfOkClick("//a[contains(.,'Leads')][@href='#/sObject/Lead/home'][@class='slds-context-bar__label-action']").click();
		Thread.sleep(Utils.standardWait);
	}

	@Given("^I click the Contacts tab$")
	public void clickContactsTab() throws Throwable {
		Utils.checkIfOkClick("//a[contains(.,'Contacts')][@href='#/sObject/Contact/home'][@class='slds-context-bar__label-action']").click();
	}




	@And("^I select an \"([^\"]*)\"$")
	public void selectExistingLead(String leadName) throws Throwable {
		if (leadName.equals("Existing Lead")) {
			leadName = dataFactory.getInstance().getLeadName();
		}
		else{
			leadName="AAA";
		}
		if(Utils.checkIfPageIsReady() && Utils.checkIfOkToContinue("//a[@title='"+leadName+"']") ){
			driver.findElement(By.xpath("//a[@title='"+leadName+"']")).click();
		}

	}

	@And("^I click app launcher$")
	public void clickAppLauncher() throws Throwable {
		Utils.checkIfOkClick("//div[@class='slds-icon-waffle']").click();
	}

	@And("^I search in app launcher \"([^\"]*)\"$")
	public void searchInAppLauncher(String tabName) throws Throwable {
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//input[@class='slds-input input']")).sendKeys(tabName);
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//mark[text()='"+ tabName + "']")).click();
		Thread.sleep(Utils.standardWait);
	}

	@And("^I search and select an existing \"([^\"]*)\" with search box$")
	public void searchexistingAccount(String item) throws Throwable {
		if (item.equals("Existing Lead")) {
			item = dataFactory.getInstance().getLeadName();
		}
		else if(item.equals("Existing Opportunity for approval")){
			item = dataFactory.getInstance().getOpportunityNameApproval();
		}		
		else if(item.equals("Automation Full Cancellation Opp")){
			item = dataFactory.getInstance().getOpportunityNameFullCreditCancelation();
		}
		else if(item.equals("Automation Opp Partial Credit Cancellation")){
			item = dataFactory.getInstance().getOpportunityNamePartialCreditCancelation();
		}
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//div[@class='uiInput uiAutocomplete uiInput--default']//input")).sendKeys(item);
		Utils.checkIfOkClick("//div[@class='uiInput uiAutocomplete uiInput--default']//input").click();
		Utils.checkIfOkClick("//span[@title='"+item+"']").click();
	}

	
	@And("^I search the Opportunity \"([^\"]*)\"$")
	public void searchOpportunity(String opportunityName) throws Throwable {
		String searchString;
		searchString = opportunityName;
		if (opportunityName.equals("Renewal")) {
			opportunityName ="Renew:Q-";
			searchString = opportunityName.substring(0, 17);
		}
		
			Utils.checkIfOkClick("//input[@placeholder='Search Opportunities and more...']").sendKeys(searchString);
			Utils.checkIfOkClick("//input[@placeholder='Search Opportunities and more...']").sendKeys(Keys.ENTER);
			Utils.checkIfOkClick("//a[text()='Opportunities']").click();
			Utils.checkIfOkClick("//div[text()='Opportunities']/../../../../..//a[@title='"+opportunityName+"']").click(); 
	} 
	

	@Then("^I click the Save button$")
	public void i_click_the_Save_button() throws Throwable {
		Utils.checkIfOkClick("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']").click();
		Thread.sleep(Utils.standardWait);

	}

	@And("^Enter \"([^\"]*)\" for Currency and \"([^\"]*)\" for Opportunity Org and High Level Estimated Value \"([^\"]*)\"$")
	public void enter_org(String currency, String org, String value) throws Throwable {
		/*    	Thread.sleep(Utils.standardWait);
        driver.findElement(By.xpath("//span[text()='Opportunity Org']/../..//a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(Utils.standardWait + 2000);
        driver.findElement(By.xpath("//a[@title='"+org+"']")).click();
    	Thread.sleep(Utils.standardWait);
        driver.findElement(By.xpath("//span[text()='Currency']/../..//a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(Utils.standardWait + 2000);
        driver.findElement(By.xpath("//a[@title='"+currency+"']")).click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Thread.sleep(Utils.standardWait);
        if (!value.equals("0")) {
        driver.findElement(By.xpath("//span[text()='High Level Estimated Value']/../..//input")).sendKeys(value);
        Thread.sleep(Utils.standardWait);
		}*/
		//driver.findElement(By.xpath("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save']")).click();
		//Thread.sleep(Utils.standardWait + 2000);                                                 
	}


	@And("^Enter \"([^\"]*)\" for Currency$")
	public void enter_org(String currency) throws Throwable {

		Utils.checkIfOkClick("//span[text()='Currency']/../..//a").click();
		Utils.checkIfOkClick("//a[@title='"+currency+"']").click();

	}

	@And("^Enter \"([^\"]*)\" for Org$")
	public void enter_opp_org(String currency) throws Throwable {
		Thread.sleep(Utils.standardWait);
		driver.findElement(By.xpath("//span[text()='Opportunity Org']/../..//a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(Utils.standardWait + 2000);
		driver.findElement(By.xpath("//a[@title='"+currency+"']")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	@And("^I set \"([^\"]*)\" for Product Line Items$")
	public void set_product_line_items(String productLineItem) throws Throwable {
		if(Utils.checkIfOkToContinue("//option[@value='"+productLineItem+"']")){
			driver.findElement(By.xpath("//option[@value='"+productLineItem+"']")).click();
		}

	}
	@And("^I click on the Edit button$")
	public void i_Click_On_Edit_Button() throws Throwable {
		driver.findElement(By.xpath("//div[@title='Edit']")).click();
		Thread.sleep(Utils.standardWait);                                                 
	}

	@And("^I click Save button on popup$")
	public void i_click_Save_Button_Popup() throws Throwable {
		Utils.checkIfOkClick("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']").click();
		//if(Utils.checkIfOkToContinue("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']")){
		//driver.findElement(By.xpath("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'][@type='button']")).click();
		//}
		Thread.sleep(Utils.standardWait);
	}

	@And("^I click Cancel button on popup$")
	public void i_click_Cancel_Button_Popup() throws Throwable {
		Utils.checkIfOkClick("//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Cancel'][@type='button']").click();
		Thread.sleep(Utils.standardWait);
	}

	@And("^Close driver$")
	public void closeBrowser() throws Throwable {
		try{
			Utils.driver.close();
		}catch (Exception error){
			//Do Nothing
		}
	}



	public static boolean checkIfOkToContinue(String xPath){
		Boolean done=false;
		Integer counter= 0;

		while( !done){
			try{
				if(driver.findElement(By.xpath(xPath))!= null){
					if(driver.findElement(By.xpath(xPath)).isEnabled()){ 
						done=true;
						return true;
					}	
				}
			}catch (Exception error){

			}

			try{
				Thread.sleep(Utils.standardWait);
			}catch (Exception err){
				//do nothing
			}
			counter++;
			if (counter==3) break;
		}
		return false;
	}	

 
	public static void inputField(String fieldlabel, String fieldValue, int fieldType){
		switch (fieldType)
		{
		case 1: 
			Utils.checkIfOkClick("//label[@data-aura-class='uiLabel']//span[text()='"+ fieldlabel + "']/../..//input").sendKeys(fieldValue);
			break;
		case 2: 
			
		
				Utils.checkIfOkClick("//span[@data-aura-class='uiPicklistLabel']//span[text()='"+ fieldlabel + "']/../..//a").click();
				
			Utils.checkIfOkClick("//a[@title='"+fieldValue+"']").click();
			break;
        case 3: //Lookup fields
			Utils.checkIfOkClick("//label[@data-aura-class='uiLabel']//span[text()='"+ fieldlabel + "']/../..//input").click();
			Utils.checkIfOkClick("//label[@data-aura-class='uiLabel']//span[text()='"+ fieldlabel + "']/../..//input").sendKeys(fieldValue);
			Utils.checkIfOkClick("//div[@title='" + fieldValue + "']").click();
         break;
		}
			

	}

	public static WebElement checkIfOkClick(String xPath){
		Boolean done=false;
		Integer counter= 0;
		WebElement aelement=null;
		WebDriverWait wait = null; 
		while( !done){
			try{
				wait = new WebDriverWait(driver, 5);
				//aelement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
				aelement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

				if(aelement!=null){
					done=true;
					break;
				}
			}catch (Exception error){

			}
			counter++;
			if (counter==10) break;
		}
		return aelement;
	}


	public static boolean checkIfPageIsReady()
	{
		Boolean done=false;
		Integer counter= 0;

		while( !done){
			if(Utils.waitForJStoLoad()){
				done=true;
				return true;
			}
			try{
				Thread.sleep(Utils.standardWait);
			}catch (Exception error){
				//Do nothing.
			}
			counter++;
			if (counter==3) break;
		}
		return false;
	}

	public static boolean waitForJStoLoad() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		final JavascriptExecutor jse = (JavascriptExecutor)driver;
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long)jse.executeScript("return jQuery.active") == 0);
				}
				catch (Exception e) {
					return true;
				}
			}
		};

		// wait for script to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return jse.executeScript("return document.readyState")
						.toString().equals("complete");
			}
		};



		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	@And("^I check the error message$")
	public void i_check_error_message() throws Throwable {	
		if(Utils.checkIfOkToContinue("//ul[@class='errorsList']/li")){
			ascenario.write("Unity Validation Message: " + driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText());
			System.out.println(driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText());
		}
	}


	@And("^I compare results from SF and SQL$")
	public void I_Check_Invoice() throws Throwable {
		System.out.println("The Oracle Integration Status of the current Invoice is: " + dataFactory.InvoiceOracleIntegrationStatus);
		ascenario.write("The Oracle Integration Status of the current Invoice is: " + dataFactory.InvoiceOracleIntegrationStatus);
		System.out.println("The Invoice ID in SF is : " + dataFactory.InvoiceID +"  Invoice ID from Oracle is: " + dataFactory.InvoiceIDSQL);
		ascenario.write("The Invoice ID in SF is : " + dataFactory.InvoiceID +"  Invoice ID from Oracle is: " + dataFactory.InvoiceIDSQL);
		System.out.println("The Amount Value in SF is : " + dataFactory.InvoiceAmount +"  Amount Value from Oracle is: " + dataFactory.InvoiceAmountSQL);
		ascenario.write("The Amount Value in SF is : " + dataFactory.InvoiceAmount +"  Amount Value from Oracle is: " + dataFactory.InvoiceAmountSQL);
		System.out.println("The Bill To ID in SF is : " + dataFactory.InvoiceBillToID +"  Bill To ID from Oracle is: " + dataFactory.InvoiceBillToIDSQL);
		ascenario.write("The Bill To ID in SF is : " + dataFactory.InvoiceBillToID +"  Bill TO ID from Oracle is: " + dataFactory.InvoiceBillToIDSQL);
		System.out.println("The Ship To ID in SF is : " + dataFactory.InvoiceShipToID +"  Ship To ID from Oracle is: " + dataFactory.InvoiceShipToIDSQL);
		ascenario.write("The Ship To ID in SF is : " + dataFactory.InvoiceShipToID +"  Ship To ID from Oracle is: " + dataFactory.InvoiceShipToIDSQL);
		System.out.println("The Tax Amount in SF is : " + dataFactory.InvoiceTaxAmount +"  Tax Amount from Oracle is: " + dataFactory.InvoiceTaxAmountSQL);
		ascenario.write("The Tax Amount in SF is : " + dataFactory.InvoiceTaxAmount +"  Tax Amount from Oracle is: " + dataFactory.InvoiceTaxAmountSQL);
	}

}