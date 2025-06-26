package com.paySecure.testngClass;

import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.paySecure.pomClasses.paySecure_homePage;
import com.payout.pomClasses.payout_dashBoard;

import paySecure.utils.myTry;

public class payoutDashboard extends baseClass{
  loginPage lp;
  payout_dashBoard pd;
	
	@BeforeMethod
 public void setUp() throws FileNotFoundException, IOException {
		
		launchTheBrowser();
		lp= new loginPage(driver);
		lp.loginUsingValidCredentials(driver);
		pd=new payout_dashBoard(driver);

	  }
	
	
	
	
	@Test (retryAnalyzer = myTry.class)
  public void verifyUserIsOnPayoutDashBoard() throws InterruptedException {
		pd.clickOnPayout_Dashboard(driver);
		pd.selectDashboardusinAllMerchant(driver);
		pd.selectDashboardusinAllCurrency(driver);
		
		pd.selectDashboardTodayAndYesterday("Yesterday","Both");
		pd.selectDashboardWeekly("Amount");
		pd.selectDashboardMonthly(driver);
		pd.selectDashboardMonthllyUsingCount("Amount");
		
		pd.selectDashboardYearly("2022");
		pd.selectDashboardYearlyCount("Both");
		
		
  }
}
