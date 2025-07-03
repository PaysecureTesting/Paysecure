package com.paySecure.report.testngClass;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.report.pomClasses.apiLog_PomClasses;
import com.report.pomClasses.transaction_Log_pomClasses;
import com.report.pomClasses.transaction_pomClasses;

public class transactionLog extends baseClass {

	loginPage lp;
	transaction_Log_pomClasses tl;
	transaction_pomClasses ts;

	@BeforeMethod
	public void setUp() throws IOException, Exception {
		launchTheBrowser();

		lp = new loginPage(driver);
		lp.loginUsingValidCredentials(driver);
		tl=new transaction_Log_pomClasses(driver);

		ts = new transaction_pomClasses(driver);

	}

	@Test
	public void verifyTransactionLog() throws InterruptedException {
		tl.verifyUserIsOnTransactionLogPage(driver);
		ts.selectDateRange(driver,"Last 30 Days");
		tl.searchThroughPurchaseID(driver);
		tl.searchTransactionLog(driver);
		tl.click_downloadButton(driver);
		tl.verifyTransactionPurchaseDetails(driver);
	}
}
