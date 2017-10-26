$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("scenarios/A-BaseLine/00DeleteTestData.feature");
formatter.feature({
  "line": 1,
  "name": "Deletions of test data",
  "description": "",
  "id": "deletions-of-test-data",
  "keyword": "Feature"
});
formatter.before({
  "duration": 349128,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Delete related Opportunity",
  "description": "",
  "id": "deletions-of-test-data;delete-related-opportunity",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@BaseLine"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I open the browser and access Salesforce",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I enter the \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\" as admin",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I am able to login to SalesForce",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I set to lightning view",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click the \"Accounts\" tab",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I search an existing \"REED BUSINESS INFORMATION LIMITED\" on the Account page search box",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the Related tab",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I delete the All Related Opportunity",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I click the \"Accounts\" tab",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Initializer Delete \"REED BUSINESS INFORMATION LIMITED\" account from the list",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Close driver",
  "keyword": "And "
});
formatter.match({
  "location": "Utils.navigateToSalesforce()"
});
formatter.result({
  "duration": 28566484992,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cUsername\u003e",
      "offset": 13
    },
    {
      "val": "\u003cPassword\u003e",
      "offset": 30
    }
  ],
  "location": "Utils.enterAsAdmin(String,String)"
});
formatter.result({
  "duration": 790477147,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"username\"}\n  (Session info: chrome\u003d61.0.3163.100)\n  (Driver info: chromedriver\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 244 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.45.0\u0027, revision: \u00275017cb8e7ca8e37638dc3091b2440b90a1d8686f\u0027, time: \u00272015-02-27 09:10:26\u0027\nSystem info: host: \u0027CPX-OB8P68FCNQO\u0027, ip: \u0027192.168.43.211\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233), userDataDir\u003dC:\\Users\\SZABOL~1.HUD\\AppData\\Local\\Temp\\scoped_dir18660_22617}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d61.0.3163.100, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 8280a6ad445114bf323c538f62532468\n*** Element info: {Using\u003did, value\u003dusername}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:204)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:156)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:599)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:393)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:214)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)\r\n\tat rbi.RBI_Project.Utils.enterAsAdmin(Utils.java:165)\r\n\tat ✽.When I enter the \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\" as admin(scenarios/A-BaseLine/00DeleteTestData.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Utils.clickLoginButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "dataDotComStepDefinition.changeToLightningView()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Accounts",
      "offset": 13
    }
  ],
  "location": "Utils.clickTab(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "REED BUSINESS INFORMATION LIMITED",
      "offset": 22
    }
  ],
  "location": "accountStepDefinition.searchexistingAccount(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "deleteFirstGroupTestDataStepDefinition.clickRelatedTab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "deleteFirstGroupTestDataStepDefinition.deleteAllOpp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Accounts",
      "offset": 13
    }
  ],
  "location": "Utils.clickTab(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "REED BUSINESS INFORMATION LIMITED",
      "offset": 20
    }
  ],
  "location": "deleteFirstGroupTestDataStepDefinition.deleteAccountFromList(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Utils.closeBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("scenarios/A-BaseLine/01Leads.feature");
formatter.feature({
  "line": 1,
  "name": "Scenarios based on leads creation, conversion and account creation",
  "description": "",
  "id": "scenarios-based-on-leads-creation,-conversion-and-account-creation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 80000,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Creating new lead, Convert lead using existing account and check account field mapping",
  "description": "",
  "id": "scenarios-based-on-leads-creation,-conversion-and-account-creation;creating-new-lead,-convert-lead-using-existing-account-and-check-account-field-mapping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@BaseLine"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open the browser and access Salesforce",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter the \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\" as salesuser",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I am able to login to SalesForce",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I click the Leads tab",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I click the New button on Leads tab",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Click Save button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I check the error message",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Enter \"First Name\" on the First Name field",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Enter \"Last Name\" on the Last name field",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Enter \"Company\" on the Company field",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Enter \"Email\" on the Email name field",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "select Lead Status to \"Lead Status\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "select Country List to \"Country\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I select product \"Product\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I click on the SRL Lead checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "select Organisation Type",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "select Type OF Business",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "select Lead Source to \"Lead Source\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "select Industry to \"Industry\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "select Lead Source Most Recent to \"Lead Source Most Recent\"",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I enter lead address \"Street\" \"City\" \"Zip\" \"Country\"",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Click Save button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I click the Convert button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I click Convert button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I click on account \"Account Name\"",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I Check if the Industry value is \"Industry\"",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I Check if the Product Line Item value is \"Product Line Item\"",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I Check if the Type Of Business field value is \"Type Of Business\"",
  "keyword": "And "
});
formatter.match({
  "location": "Utils.navigateToSalesforce()"
});
