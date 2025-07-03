package com.paySecure.report.testngClass;

import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.report.pomClasses.bank_Transaction_Time_Report;
import com.report.pomClasses.transaction;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;

public class Bank_Transaction_Time_Report extends baseClass{
	loginPage lp;
	bank_Transaction_Time_Report bt;
	transaction ts;
	
	
	@BeforeMethod
	  public void beforeMethod() throws IOException, Exception {
		launchTheBrowser();
		
		bt=new bank_Transaction_Time_Report(driver);
		lp = new loginPage(driver);
		lp.loginUsingValidCredentials(driver);
		ts=new transaction(driver);
		
	  }	
	
	
	
	@Test
  public void verifyUserisOnBankTransactionTimeReportpage() throws InterruptedException {
	  bt.navigateUptoBankTransactionTimeReport(driver);
	  bt.convertDateFormat();
      bt.selectDate(driver);
      bt.applyButton(driver);
    ts.selectDashboardusinAllBank(driver);
	  bt.enterTimeIn_Transaction_Time_more_than(driver,"0");
	  bt.searchButton(driver);
  }
  

}
