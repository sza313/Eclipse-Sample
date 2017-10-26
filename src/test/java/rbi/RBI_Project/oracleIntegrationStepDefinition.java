package rbi.RBI_Project;

import cucumber.api.java.en.Given;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.Scenario;


 

public class oracleIntegrationStepDefinition {
	Scenario ascenario;
	
	
	
 @And("^Connect and validate records in Oracle Database$")
public void getOracleData() throws SQLException, Exception{
	 Utils.ascenario.write("connection to oracle start");
	 Connection conn =null;
		Statement stmt = null;
		
    	try {
    		
    		String dbUrl = "jdbc:oracle:thin:@10.55.36.12:1525/QA";
    		String username = "kat";	
    		String password = "k4t4n4pw";	
    		Utils.ascenario.write("1");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Utils.ascenario.write("2");
			conn = DriverManager.getConnection(dbUrl, username, password);
			stmt = conn.createStatement();
			String query = "Select INV_NUM, cust_acc_ID,Amount,Pay_Method,Status,Bill_To, Ship_To from rbi_transaction_detail where created_by ='BOOMI'  AND Inv_NUM ='INV-00000790' AND rownum <=1 order by creation_date desc";
			ResultSet resultSet = stmt.executeQuery(query);
			Utils.ascenario.write("Count:" +resultSet.getFetchSize());
						
			while(resultSet.next()){
			
				Utils.ascenario.write("InvoiceNumber:" + resultSet.getString("INV_NUM") + " Amount: " + resultSet.getString("Amount"));
			}
									
			
			
		}catch(Exception error) {
			 Utils.ascenario.write("Error:"+ error.getMessage());
    	}finally {
			if (conn !=null) {
				conn.close();
			}
		}
	}
	
}