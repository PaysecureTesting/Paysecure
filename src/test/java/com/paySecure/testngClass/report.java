package com.paySecure.testngClass;

import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.payout.pomClasses.payout_dashBoard;
import com.report.pomClasses.transaction;

import paySecure.utils.myTry;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class report extends baseClass {
	
	 loginPage lp;
	 transaction  ts;
	 
		
		@BeforeMethod
	 public void setUp() throws FileNotFoundException, IOException {
			
			launchTheBrowser();
			lp= new loginPage(driver);
			lp.loginUsingValidCredentials(driver);
			ts=new transaction(driver);
			ts.navigateUptoTransaction(driver);
			

		  }
 
		@Test (retryAnalyzer = myTry.class)
		  public void transactionUsingSelectStatus() throws InterruptedException {
			
				ts.filterTransactionThroughSelectStatus();
				ts.clickOnSearchButton(driver);
				ts.checkStatus(driver);
				
		  }
}
