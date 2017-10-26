package rbi.RBI_Project;

import auto.framework.DataTable;

public class dataFactory {

	private static final dataFactory INSTANCE = new dataFactory();
	private static String accountName="";
	private static String accountStreet="";
	private static String accountCity="";
	private static String accountPostCode="";
	private static String accountCountry="";
	private static String Association="";
	private static String ApplicationUrl="";
	private static String BillingAddressFirstPart="";
	private static String BillingAddressSecondPart="";
	private static String CompetitorName="";
	private static String contactPhone="";
	private static String ContactFirstName="";
	private static String ContactLastName="";
	private static String CountryList="";
	private static String ClosedWonStage="";
	private static String ClosedWonDetailedReason="";
	private static String DiscountType="";
	private static String DiscountReason="";
	private static String EloquaUrl="";
	private static String FirstName="";
	private static String FulfilmentType="";
	private static String BillingFrequency="";
	private static String Industry="";
	private static String LastName="";
	private static String leadEmail="";
	private static String LeadName="";
	private static String leadStatus="";
	private static String LeadSource="";
	private static String LeadSourceMostRecent="";
	private static String leadOrganisationType="";
	private static String leadTypeOfBusiness="";
	private static String NetPrice="";
	private static String OpportunityForConversion="";
	private static String OpportunityExisting="";
	private static String OpportunityNameApproval="";
	private static String OpportunityNameFullCreditCancelation="";
	private static String OpportunityNamePartialCreditCancelation="";
	private static String PrimaryContactName="";
	private static String ProductName="";
	private static String ProposalFormat="";
	private static String ProposalWatermark="";
	private static String StandardOpportunityName="";
	private static String UserNameSalesUserUAT="";
	private static String UserPwdSalesUserUAT="";
	private static String UserNameSalesUserSIT="";
	private static String UserPwdSalesUserSIT="";
	private static String UserNameEloqua="";
	private static String UserPwdEloqua="";
	private static String UserNameBillingUserUAT="";
	private static String UserPwdBillingUserUAT="";
	private static String UserNameBillingUserSIT="";
	private static String UserPwdBillingUserSIT="";
	private static String UserNameSalesOpsUserUAT="";
	private static String UserPwdSalesOpsUserUAT="";
	private static String UserNameSalesOpsUserSIT="";
	private static String UserPwdSalesOpsUserSIT="";
	private static String UserNameAdminUAT="";
	private static String UserPwdAdminUAT="";
	private static String UserNameAdminSIT="";
	private static String UserPwdAdminSIT="";
	private static String UserNameDataDotComUAT="";
	private static String UserPwdDataDotComUAT="";
	private static String UserNameDataDotComSIT="";
	private static String UserPwdDataDotComSIT="";
	private static String UserNameSalesManagerUAT="";
	private static String UserPwdSalesManagerUAT="";
	private static String UserNameSalesManagerSIT="";
	private static String UserPwdSalesManagerSIT="";

	public static String InvoiceOracleIntegrationStatus = null;
	public static String InvoiceAmount = null;
	public static String InvoiceBillToID = null;
	public static String InvoiceShipToID = null;
	public static String InvoiceTaxAmount = null;
	public static String InvoiceID = null;
	public static String InvoiceAmountSQL = null;
	public static String InvoiceBillToIDSQL = null;
	public static String InvoiceShipToIDSQL = null;
	public static String InvoiceTaxAmountSQL = null;
	public static String InvoiceIDSQL = null;

	// Private constructor prevents instantiation from other classes
	private dataFactory() {
	}

	public static dataFactory getInstance() {
		return INSTANCE;
	}

	public String getAccountName() {
		try {
			 accountName = DataTable.getDataTableValue(2, 2, 5);
			if (accountName != "")
				return accountName;
			return "REED BUSINESS INFORMATION LIMITED";
		} catch (Exception error) {
			return "REED BUSINESS INFORMATION LIMITED";
		}
	}
	
	public String getAccountStreet() {
		try {
			accountStreet = DataTable.getDataTableValue(2, 2, 27);
			if (accountStreet == "")
			return "Quadrant House";
			return accountStreet;
		} catch (Exception error) {
			return "Quadrant House";
		}
	}
	
	public String getAccountCity() {
		try {
			accountCity = DataTable.getDataTableValue(2, 2, 28);
			if (accountCity != "")
				return accountCity;
			return "Sutton";
		} catch (Exception error) {
			return "Sutton";
		}
	}
	
	
	public String getAccountPostCode() {
		try {
			accountPostCode = DataTable.getDataTableValue(2, 2, 29);
			if (accountPostCode != "")
				return accountPostCode;
			return "SM2 5AS";
		} catch (Exception error) {
			return "SM2 5AS";
		}
	}
	
	public String getAccountCountry() {
		try {
			accountCountry = DataTable.getDataTableValue(2, 2, 30);
			if (accountCountry != "")
				return accountCountry;
			return "United Kingdom";
		} catch (Exception error) {
			return "United Kingdom";
		}
	}
	
	public String getAssociation() {
		try {
			Association = DataTable.getDataTableValue(2, 4, 11);
			if (Association != "")
				return Association;
			return "Competitor";
		} catch (Exception error) {
			return "Competitor";
		}
	}
	
	public String getBillingAddressFirstPart() {
		try {
			BillingAddressFirstPart = DataTable.getDataTableValue(3, 18, 36);
			if (BillingAddressFirstPart != "")
				return BillingAddressFirstPart;
			return "Quadrant House, The Quadrant, Brighton Road,";
		} catch (Exception error) {
			return "Quadrant House, The Quadrant, Brighton Road,";
		}
	}
	
	public String getBillingAddressSecondPart() {
		try {
			BillingAddressSecondPart = DataTable.getDataTableValue(3, 18, 37);
			if (BillingAddressSecondPart != "")
				return BillingAddressSecondPart;
			return "Sutton, Surrey SM2 5AS United Kingdom";
		} catch (Exception error) {
			return "Sutton, Surrey SM2 5AS United Kingdom";
		}
	}
	
	public String getContactFirstName() {
		try {
			ContactFirstName = DataTable.getDataTableValue(2, 6, 3);
			if (ContactFirstName != "")
				return ContactFirstName;
			return "Andy";
		} catch (Exception error) {
			return "Andy";
		}
	}
	
	public String getContactLastName() {
		try {
			ContactLastName = DataTable.getDataTableValue(2, 6, 4);
			if (ContactLastName != "")
				return ContactLastName;
			return "ReedC";
		} catch (Exception error) {
			return "ReedC";
		}
	}
	
	public String getCompetitorName() {
		try {
			CompetitorName = DataTable.getDataTableValue(2, 17, 25);
			if (CompetitorName != "")
				return CompetitorName;
			return "Actimize";
		} catch (Exception error) {
			return "Actimize";
		}
	}
	
	public String getContactPhone() {
		try {
			contactPhone = DataTable.getDataTableValue(2, 2, 26);
			if (contactPhone != "")
				return contactPhone;
			return "447730668521";
		} catch (Exception error) {
			return "447730668521";
		}
	}
	
	public String getLeadEmail() {
		try {
			leadEmail = DataTable.getDataTableValue(2, 2, 15);
			if (leadEmail != "")
				return leadEmail;
			return "abc@gmail.com";
		} catch (Exception error) {
			return "abc@gmail.com";
		}
	}
	
	public String getleadOrganisationType() {
		try {
			leadOrganisationType = "Corporate";//DataTable.getDataTableValue(2, 2, 19);
			if (leadOrganisationType != "")
				return leadOrganisationType;
			return "Corporate";
		} catch (Exception error) {
			return "Corporate";
		}
	}
	public String getLeadTypeOfBusiness() {
		try {
			leadTypeOfBusiness ="IT Services";// DataTable.getDataTableValue(2, 2, 19);
			if (leadTypeOfBusiness != "")
				return leadTypeOfBusiness;
			return "IT Services";
		} catch (Exception error) {
			return "IT Services";
		}
	}
	
	public String getFirstName() {
		try {
			FirstName = DataTable.getDataTableValue(2, 2, 3);
			if (FirstName != "")
				return FirstName;
			return "Andy";
		} catch (Exception error) {
			return "Andy";
		}
	}
	
	public String getIndustry() {
		try {
			Industry = DataTable.getDataTableValue(2, 2, 21);
			if (Industry != "")
				return Industry;
			return "Banking";
		} catch (Exception error) {
			return "Banking";
		}
	}
	
	
	public String getLastName() {
		try {
			LastName = DataTable.getDataTableValue(2, 2, 4);
			if (LastName != "")
				return LastName;
			return "Andy";
		} catch (Exception error) {
			return "Andy";
		}
	}
	
	public String getLeadStatus() {
		try {
			leadStatus = DataTable.getDataTableValue(2, 2, 6);
			if (leadStatus != "")
				return leadStatus;
			return "Qualified (Converted)";
		} catch (Exception error) {
			return "Qualified (Converted)";
		}
	}
	
	public String getCountryList() {
		try {
			CountryList = DataTable.getDataTableValue(2, 2, 17);
			if (CountryList != "")
				return CountryList;
			return "GB - United Kingdom";
		} catch (Exception error) {
			return "GB - United Kingdom";
		}
	}
	
	public String getEloquaUrl() {
		try {
			EloquaUrl = DataTable.getDataTableValue(0, 3, 2);
			if (EloquaUrl != "")
				return EloquaUrl;
			return "https://login.eloqua.com/";
		} catch (Exception error) {
			return "https://login.eloqua.com/";
		}
	}
	
	public String getProductName() {
		try {
			ProductName = DataTable.getDataTableValue(2, 2, 18);
			if (ProductName != "")
				return ProductName;
			return "Advertising";
		} catch (Exception error) {
			return "Advertising";
		}
	}
	
	public String getLeadSource() {
		try {
			LeadSource = DataTable.getDataTableValue(2, 2, 20);
			if (LeadSource != "")
				return LeadSource;
			return "Webinar";
		} catch (Exception error) {
			return "Webinar";
		}
	}
	
	public String getLeadSourceMostRecent() {
		try {
			LeadSourceMostRecent = DataTable.getDataTableValue(2, 2, 22);
			if (LeadSourceMostRecent != "")
				return LeadSourceMostRecent;
			return "Direct Mail";
		} catch (Exception error) {
			return "Direct Mail";
		}
	}
	
	public String getLeadName() {
		try {
			LeadName = DataTable.getDataTableValue(2, 5, 12);
			if (LeadName != "")
				return LeadName;
			return "Andy ReedL";
		} catch (Exception error) {
			return "Andy ReedL";
		}
	}
	
	public String getOpportunityForConversion() {
		try {
			OpportunityForConversion = DataTable.getDataTableValue(2, 14, 7);
			if (OpportunityForConversion != "")
				return OpportunityForConversion;
			return "Opportunity From Conversion New Account";
		} catch (Exception error) {
			return "Opportunity From Conversion New Account";
		}
	}
	
	public String getOpportunityExisting() {
		try {
			OpportunityExisting = DataTable.getDataTableValue(2, 5, 7);
			if (OpportunityExisting != "")
				return OpportunityExisting;
			return "Opportunity From Conversion Existing Account";
		} catch (Exception error) {
			return "Opportunity From Conversion Existing Account";
		}
	}
	
	public String getStandardOpportunity() {
		try {
			StandardOpportunityName = DataTable.getDataTableValue(3, 8, 7);
			if (StandardOpportunityName != "")
				return StandardOpportunityName;
			return "Automation Standard Opp";
		} catch (Exception error) {
			return "Automation Standard Opp";
		}
	}
	
	public String getOpportunityNameApproval() {
		try {
			OpportunityNameApproval = DataTable.getDataTableValue(3, 17, 7);
			if (OpportunityNameApproval != "")
				return OpportunityNameApproval;
			return "Automation Opp With Approval";
		} catch (Exception error) {
			return "Automation Opp With Approval";
		}
	}
	
	public String getOpportunityNameFullCreditCancelation() {
		try {
			OpportunityNameFullCreditCancelation = DataTable.getDataTableValue(3, 20, 7);
			if (OpportunityNameFullCreditCancelation != "")
				return OpportunityNameFullCreditCancelation;
			return "Automation Opp Full Credit Cancellation";
		} catch (Exception error) {
			return "Automation Opp Full Credit Cancellation";
		}
	}
	
	public String getOpportunityNamePartialCreditCancelation() {
		try {
			OpportunityNamePartialCreditCancelation = DataTable.getDataTableValue(3, 21, 7);
			if (OpportunityNamePartialCreditCancelation != "")
				return OpportunityNamePartialCreditCancelation;
			return "Automation Opp Partial Credit Cancellation";
		} catch (Exception error) {
			return "Automation Opp Partial Credit Cancellation";
		}
	}
	
	public String getClosedWonStage() {
		try {
			ClosedWonStage = DataTable.getDataTableValue(2, 17, 23);
			if (ClosedWonStage != "")
				return ClosedWonStage;
			return "Better Value";
		} catch (Exception error) {
			return "Better Value";
		}
	}
	
	public String getClosedWonDetailedReason() {
		try {
			ClosedWonDetailedReason = DataTable.getDataTableValue(2, 17, 24);
			if (ClosedWonDetailedReason != "")
				return ClosedWonDetailedReason;
			return "Better Value";
		} catch (Exception error) {
			return "Better Value";
		}
	}
	
	public String getPrimaryContactName() {
		try {
			PrimaryContactName = DataTable.getDataTableValue(3, 7, 13);
			if (PrimaryContactName != "")
				return PrimaryContactName;
			return "Andy ReedC";
		} catch (Exception error) {
			return "Andy ReedC";
		}
	}
	
	
	public String getFulfilmentType() {
		try {
			FulfilmentType = DataTable.getDataTableValue(3, 7, 26);
			if (FulfilmentType != "")
				return FulfilmentType;
			return "Annual";
		} catch (Exception error) {
			return "Annual";
		}
	}
	
	public String getBillingFrequency() {
		try {
			BillingFrequency = DataTable.getDataTableValue(3, 7, 27);
			if (BillingFrequency != "")
				return BillingFrequency;
			return "One Time";
		} catch (Exception error) {
			return "One Time";
		}
	}
	
	public String getDiscoutType() {
		try {
			DiscountType = DataTable.getDataTableValue(3, 15, 32);
			if (DiscountType != "")
				return DiscountType;
			return "Discount Amount";
		} catch (Exception error) {
			return "Discount Amount";
		}
	}	
	
	public String getDiscoutReason() {
		try {
			DiscountReason = DataTable.getDataTableValue(3, 15, 33);
			if (DiscountReason != "")
				return DiscountReason;
			return "Budget Excess";
		} catch (Exception error) {
			return "Budget Excess";
		}
	}
	
	public String getNetPrice() {
		try {
			NetPrice = DataTable.getDataTableValue(3, 7, 28);
			if (NetPrice != "")
				return NetPrice;
			return "USD 505,000.00";
		} catch (Exception error) {
			return "USD 505,000.00";
		}
	}
	
	public String getProposalFormat() {
		try {
			ProposalFormat = DataTable.getDataTableValue(3, 7, 29);
			if (ProposalFormat != "")
				return ProposalFormat;
			return "PDF";
		} catch (Exception error) {
			return "PDF";
		}
	}
	
	public String getProposalWatermark() {
		try {
			ProposalWatermark = DataTable.getDataTableValue(3, 7, 30);
			if (ProposalWatermark != "")
				return ProposalWatermark;
			return "Yes";
		} catch (Exception error) {
			return "Yes";
		}
	}
	
	public String getApplicationUrl() {
		try {
			ApplicationUrl = DataTable.getDataTableValue(0, 2, 2);
			if (ApplicationUrl != "")
				return ApplicationUrl;
			return "https://test.salesforce.com/";
		} catch (Exception error) {
			return "https://test.salesforce.com/";
		}
	}
	
	public String getUserNameSalesUserUAT() {
		try {
			dataFactory.INSTANCE.UserNameSalesUserUAT = DataTable.getDataTableValue(1, 10, 2);
			if (UserNameSalesUserUAT != "")
				return UserNameSalesUserUAT;
			return "automationsalesuser@rbi.co.uk.uat";
		} catch (Exception error) {
			System.out.println("Error "+ error.getMessage());
			return "automationsalesuser@rbi.co.uk.uat";
		}
	}
	
	public String getUserPwdSalesUserUAT() {
		try {
			UserPwdSalesUserUAT = DataTable.getDataTableValue(1, 10, 3);
			if (UserPwdSalesUserUAT != "")
				return UserPwdSalesUserUAT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameSalesUserSIT() {
		try {
			UserNameSalesUserSIT = DataTable.getDataTableValue(1,2 ,2);
			if (UserNameSalesUserSIT != "")
				return UserNameSalesUserSIT;
			return "sheena.s.lopez@accenture.com.salesusersit";
		} catch (Exception error) {
			return "sheena.s.lopez@accenture.com.salesusersit";
		}
	}
	
	public String getUserPwdSalesUserSIT() {
		try {
			UserPwdSalesUserSIT = DataTable.getDataTableValue(1,2, 3);
			if (UserPwdSalesUserSIT != "")
				return UserPwdSalesUserSIT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameEloqua() {
		try {
			UserNameEloqua = DataTable.getDataTableValue(1, 16, 2);
			if (UserNameEloqua != "")
				return UserNameEloqua;
			return "Sebastien.Jorelle";
		} catch (Exception error) {
			return "Sebastien.Jorelle";
		}
	}
	
	public String getUserPwdEloqua() {
		try {
			UserPwdEloqua = DataTable.getDataTableValue(1, 16, 3);
			if (UserPwdEloqua != "")
				return UserPwdEloqua;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameBillingUserUAT() {
		try {
			UserNameBillingUserUAT = DataTable.getDataTableValue(1, 13, 2);
			if (UserNameBillingUserUAT != "")
				return UserNameBillingUserUAT;
			return "automationbillinguser@rbi.co.uk.uat";
		} catch (Exception error) {
			return "automationbillinguser@rbi.co.uk.uat";
		}
	}
	
	public String getUserPwdBillingUserUAT() {
		try {
			UserPwdBillingUserUAT = DataTable.getDataTableValue(1, 13, 3);
			if (UserPwdBillingUserUAT != "")
				return UserPwdBillingUserUAT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameBillingUserSIT() {
		try {
			UserNameBillingUserSIT = DataTable.getDataTableValue(1, 5, 2);
			if (UserNameBillingUserSIT != "")
				return UserNameBillingUserSIT;
			return "sheena.s.lopez@accenture.com.billingsit";
		} catch (Exception error) {
			return "sheena.s.lopez@accenture.com.billingsit";
		}
	}
	
	public String getUserPwdBillingUserSIT() {
		try {
			UserPwdBillingUserSIT = DataTable.getDataTableValue(1, 5, 3);
			if (UserPwdBillingUserSIT != "")
				return UserPwdBillingUserSIT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameSalesOpsUserUAT() {
		try {
			UserNameSalesOpsUserUAT = DataTable.getDataTableValue(1, 11, 2);
			if (UserNameSalesOpsUserUAT != "")
				return UserNameSalesOpsUserUAT;
			return "automationsalesoperations@rbi.co.uk.uat";
		} catch (Exception error) {
			return "automationsalesoperations@rbi.co.uk.uat";
		}
	}
	
	public String getUserPwdSalesOpsUserUAT() {
		try {
			UserPwdSalesOpsUserUAT = DataTable.getDataTableValue(1, 11, 3);
			if (UserPwdSalesOpsUserUAT != "")
				return UserPwdSalesOpsUserUAT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameSalesOpsUserSIT() {
		try {
			UserNameSalesOpsUserSIT = DataTable.getDataTableValue(1, 3, 2);
			if (UserNameSalesOpsUserSIT != "")
				return UserNameSalesOpsUserSIT;
			return "ricca.mae.c.casilla@accenture.com.salesopssit";
		} catch (Exception error) {
			return "ricca.mae.c.casilla@accenture.com.salesopssit";
		}
	}
	
	public String getUserPwdSalesOpsUserSIT() {
		try {
			UserPwdSalesOpsUserSIT = DataTable.getDataTableValue(1, 3, 3);
			if (UserPwdSalesOpsUserSIT != "")
				return UserPwdSalesOpsUserSIT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameAdminUAT() {
		try {
			UserNameAdminUAT = DataTable.getDataTableValue(1, 14, 2);
			if (UserNameAdminUAT != "")
				return UserNameAdminUAT;
			return "pawan.tokas@newaccuity.com.unityuat";
		} catch (Exception error) {
			return "pawan.tokas@newaccuity.com.unityuat";
		}
	}
	
	public String getUserPwdAdminUAT() {
		try {
			UserPwdAdminUAT = DataTable.getDataTableValue(1, 14, 3);
			if (UserPwdAdminUAT != "")
				return UserPwdAdminUAT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameAdminSIT() {
		try {
			UserNameAdminSIT = DataTable.getDataTableValue(1, 6, 2);
			if (UserNameAdminSIT != "")
				return UserNameAdminSIT;
			return "pawan.tokas@newaccuity.com.unitysit";
		} catch (Exception error) {
			return "pawan.tokas@newaccuity.com.unitysit";
		}
	}
	
	public String getUserPwdAdminSIT() {
		try {
			UserPwdAdminSIT = DataTable.getDataTableValue(1, 6, 3);
			if (UserPwdAdminSIT != "")
				return UserPwdAdminSIT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameDataDotComUAT() {
		try {
			UserNameDataDotComUAT = DataTable.getDataTableValue(1, 15, 2);
			if (UserNameDataDotComUAT != "")
				return UserNameDataDotComUAT;
			return "pawan.tokas@newaccuity.com.unityuat";
		} catch (Exception error) {
			return "pawan.tokas@newaccuity.com.unityuat";
		}
	}
	
	public String getUserPwdDataDotComUAT() {
		try {
			UserPwdDataDotComUAT = DataTable.getDataTableValue(1, 15, 3);
			if (UserPwdDataDotComUAT != "")
				return UserPwdDataDotComUAT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameDataDotComSIT() {
		try {
			UserNameDataDotComSIT = DataTable.getDataTableValue(1, 7, 2);
			if (UserNameDataDotComSIT != "")
				return UserNameDataDotComSIT;
			return "pawan.tokas@newaccuity.com.unitysit";
		} catch (Exception error) {
			return "pawan.tokas@newaccuity.com.unitysit";
		}
	}
	
	public String getUserPwdDataDotComSIT() {
		try {
			UserPwdDataDotComSIT = DataTable.getDataTableValue(1, 7, 3);
			if (UserPwdDataDotComSIT != "")
				return UserPwdDataDotComSIT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameSalesManagerUAT() {
		try {
			UserNameSalesManagerUAT = DataTable.getDataTableValue(1, 12, 2);
			if (UserNameSalesManagerUAT != "")
				return UserNameSalesManagerUAT;
			return "automationsalesmanager@rbi.co.uk.uat";
		} catch (Exception error) {
			return "automationsalesmanager@rbi.co.uk.uat";
		}
	}
	
	public String getUserPwdSalesManagerUAT() {
		try {
			UserPwdSalesManagerUAT = DataTable.getDataTableValue(1, 12, 3);
			if (UserPwdSalesManagerUAT != "")
				return UserPwdSalesManagerUAT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}
	
	public String getUserNameSalesManagerSIT() {
		try {
			UserNameSalesManagerSIT = DataTable.getDataTableValue(1, 4, 2);
			if (UserNameSalesManagerSIT != "")
				return UserNameSalesManagerSIT;
			return "sheena.s.lopez@accenture.com.salesmanagersit";
		} catch (Exception error) {
			return "sheena.s.lopez@accenture.com.salesmanagersit";
		}
	}
	
	public String getUserPwdSalesManagerSIT() {
		try {
			UserPwdSalesManagerSIT = DataTable.getDataTableValue(1, 4, 3);
			if (UserPwdSalesManagerSIT != "")
				return UserPwdSalesManagerSIT;
			return null;
		} catch (Exception error) {
			return null;
		}
	}

}
