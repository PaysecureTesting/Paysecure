package com.paySecure.report.testngClass;

import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.payout.pomClasses.payout_dashBoard;
import com.report.pomClasses.transaction_pomClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import paySecure.utils.myTry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class transaction extends baseClass {

	loginPage lp;
	transaction_pomClasses ts;

	@BeforeMethod
	public void setUp() throws  IOException, InterruptedException {

		launchTheBrowser();
		lp = new loginPage(driver);
		lp.loginUsingValidCredentials(driver);
		ts = new transaction_pomClasses(driver);
		ts.navigateUptoTransaction(driver);

	}

	@Test(retryAnalyzer = myTry.class, priority = -1, enabled =false)
	@Description("Test to transactionUsingSelectStatus")
	public void transactionUsingSelectStatus() throws InterruptedException, TimeoutException {
		ts.filterTransactionThroughSelectStatus();
		ts.clickOnSearchButton(driver);

		ts.checkStatus(driver);

	}

	@Test(retryAnalyzer = myTry.class, priority = 0, enabled =true)
	@Description("Test to transactionUsingSelectStatus")
	public void transactionUsingSelectMerchant() throws InterruptedException, TimeoutException {
		ts.selectDashboardusinAllMerchant(driver);
		ts.clickOnSearchButton(driver);
		ts.checkStatus(driver);
	}

	@Test(retryAnalyzer = myTry.class, enabled =false, priority = 1)
	@Description("Test to transactionUsingSelectStatus")
	public void transactionUsingSelectBank() throws InterruptedException, TimeoutException {
		ts.selectDashboardusinAllBank(driver);
		ts.clickOnSearchButton(driver);
		ts.checkStatus(driver);
	}

	@Test(retryAnalyzer = myTry.class, enabled =false, priority = 2)
	@Description("Test to transactionUsingSelectStatus")
	public void selectMIDBasedOnBank() throws InterruptedException, TimeoutException {

		ts.selectDashboardusinAllBank(driver);
		ts.selectMID();
		ts.clickOnSearchButton(driver);
		ts.checkStatus(driver);

	}

	@Test(retryAnalyzer = myTry.class, priority = 3, enabled =false)
	@Description("Test to transactionUsingSelectStatus")
	public void selectDate() throws InterruptedException, TimeoutException {
		// ts.selectDashboardusinAllBank(driver);

		ts.selectDateRange(driver, "Yesterday");
		ts.clickOnSearchButton(driver);
		ts.checkStatus(driver);

	}

	@Test(retryAnalyzer = myTry.class, priority = 4, enabled =false)
	@Description("Test to transactionUsingSelectStatus")
	public void selectDateRangeToAndFrom() throws InterruptedException, TimeoutException {
		ts.selectDateRange(driver, "Yesterday");
		ts.selectDate_To(driver);

		ts.clickOnApplyButton(driver);

		// ts.clickOnSearchButton(driver);
		// ts.checkStatus(driver);
	}

	@Test(retryAnalyzer = myTry.class, priority = 5, enabled =false)
	@Description("Test to transactionUsingSelectStatus")
	public void selectTimeZoneAndVerify() throws InterruptedException, TimeoutException {
		ts.selectTimeZone(driver);
		ts.clickOnSearchButton(driver);
		ts.checkStatus(driver);

	}

	@Test(retryAnalyzer = myTry.class, priority = 6, enabled =false)
	@Description("Test to transactionUsingSelectStatus")
	public void selectCurrency() throws InterruptedException, TimeoutException {
		ts.selectCurrency(driver);
		ts.clickOnSearchButton(driver);
		ts.checkStatus(driver);

	}

	@Test(retryAnalyzer = myTry.class, priority = 7,invocationCount = 3, enabled =false)
	public void status() throws InterruptedException {
		ts.testSelectFilters(driver);
	}

	@Test(retryAnalyzer = myTry.class, priority = 8,enabled =false)
	public void allActionOnTransactionPage() throws InterruptedException {
		ts.lastActionOnTransactionTable(driver);
		ts.historyOnTransaction(driver);
		ts.remarksOnTransactiontable(driver);

		ts.verifyErrorInRemarksField(driver);
		ts.verifyElementsInUserType(driver);

		ts.verifyUsers(driver);

		ts.selectError(driver);

		ts.checkAll_SelectError(driver);

		ts.enterMessage(driver);

		ts.clickOnSubmitButton(driver);

		ts.verifySuccessmessage(driver);

	}

	@Test(enabled =false)
	public void endToEndFlowOfTransaction() throws InterruptedException, TimeoutException {

		ts.filterTransactionThroughSelectStatus();
		ts.selectDashboardusinAllMerchant(driver);
		ts.selectDashboardusinAllBank(driver);
		ts.selectMID();
		ts.selectDateRange(driver, "Yesterday");
		ts.selectTimeZone(driver);
		ts.selectCurrency(driver);
		ts.clickOnSearchButton(driver);
		ts.checkStatus(driver);
		
	}

	@Test(enabled =false)
	public void validatetransactiondataWithCSV() throws InterruptedException {
		ts.selectDateRange(driver,"Yesterday");
		ts.clickOnSearchButton(driver);
		ts.validateTransactiondataWithCSV(driver);
		
}
	
	
	
	
	
	
	
	
	// payment flow
	// mid
	// Issuerbank
	// MDR
	// PSP -payout/payin/accuring bank
	// Risk factor
	// rolling reserver

}
