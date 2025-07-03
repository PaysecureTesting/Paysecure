package com.paySecure.report.testngClass;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.report.pomClasses.apiLog_PomClasses;

import com.report.pomClasses.transaction_pomClasses;

public class apiLog extends baseClass{
	loginPage lp;
	apiLog_PomClasses api;
	transaction_pomClasses ts;
	
	@BeforeMethod
	public void setUp() throws IOException, Exception {
		launchTheBrowser();
		
		
		
		lp = new loginPage(driver);
		lp.loginUsingValidCredentials(driver);
 api=new apiLog_PomClasses(driver);
ts=new transaction_pomClasses(driver);





	}
	
	
	
	
	
	@Test
  public void f() throws IOException, InterruptedException, TimeoutException {
	
		api.verifyUserIsOnApiReportPage(driver);
		ts.selectDateRange(driver,"This Week");
		api.selectAPI("Check_Customer_TrustScore");
		ts.selectDashboardusinAllMerchant(driver);
		ts.checkStatus(driver);
		api.click_SearchButton(driver);
	//	api.click_DownloadButton(driver);
		ts.checkStatus(driver);
		api.verify_AlertMessageForDownload(driver);
		
  }
}
