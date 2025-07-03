package com.paySecure.report.testngClass;

import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.report.pomClasses.bank_Transaction_Time_Report_pomClasses;
import com.report.pomClasses.transaction_pomClasses;


import java.io.IOException;


import org.testng.annotations.BeforeMethod;

public class bankTransactionTime extends baseClass {
	loginPage lp;
	bank_Transaction_Time_Report_pomClasses bank;
	transaction_pomClasses ts;



	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {
		launchTheBrowser();
		
		
		
		lp = new loginPage(driver);
		lp.loginUsingValidCredentials(driver);
		ts = new transaction_pomClasses(driver);
		
		bank=new bank_Transaction_Time_Report_pomClasses(driver);

	}

	@Test
	public void verifyBankTransactionTimeReport() throws InterruptedException{
		bank.navigateUptoBankTransactionTimeReport(driver);
		bank.convertDateFormat();
		bank.selectDate(driver);
		bank.applyButton(driver);
		ts.selectDashboardusinAllBank(driver);
		bank.enterTimeIn_Transaction_Time_more_than(driver,"0");
		bank.searchButton(driver);

	}
	


}
