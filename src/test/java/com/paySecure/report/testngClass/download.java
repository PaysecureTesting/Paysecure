package com.paySecure.report.testngClass;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.report.pomClasses.apiLog_PomClasses;
import com.report.pomClasses.download_pomClasses;
import com.report.pomClasses.transaction_Log_pomClasses;
import com.report.pomClasses.transaction_pomClasses;

public class download extends baseClass {
  
	
	loginPage lp;
	download_pomClasses download;
	transaction_pomClasses ts;
	transaction_Log_pomClasses tl;
	
	@BeforeMethod
	public void setUp() throws IOException, Exception {
		launchTheBrowser();
		
		download=new download_pomClasses(driver);
		
		lp = new loginPage(driver);
		lp.loginUsingValidCredentials(driver);

ts=new transaction_pomClasses(driver);
 tl = new transaction_Log_pomClasses(driver);




	}
	
	
	
	
	@Test
  public void downloadTransaction() throws InterruptedException {
		download.verifyUserIsOnDownloadPage(driver);
		ts.filterTransactionThroughSelectStatus();
	//	ts.selectDashboardusinAllMerchant(driver);
		ts.selectDashboardusinAllBank(driver);
		ts.selectMID();
		ts.selectDateRange(driver,"Yesterday");
		ts.selectTimeZone(driver);
	//	ts.selectCurrency(driver);
		download.downloadPurchaseOrBanktransaction("Bank Transactions");
		tl.click_downloadButton(driver);
		
		
		
		
		
		
		
		
		
  }
}
