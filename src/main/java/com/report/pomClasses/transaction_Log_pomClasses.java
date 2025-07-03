package com.report.pomClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import paySecure.utils.utility;

public class transaction_Log_pomClasses {
    //avigate upto transaction log
	@FindBy(xpath = "//span[text()='Analytics']")
	private WebElement analytics;
	
	@FindBy(xpath = "//span[text()='Report']")
	private WebElement report;
	
	@FindBy(xpath = "//span[text()='Transaction Log']")
	private WebElement Transaction_Log;
	
	@FindBy(xpath = "//span[text()='Transaction Log']")
	private WebElement Transaction_Log1;
	
	//search transaction log through purchase ID
	@FindBy(xpath = "//input[@id='purchaseId']")
	private WebElement searchFiled_purchaseID;
	
	@FindBy(xpath = "(//a[contains(@onclick,'getBank')])[1]")
	private WebElement purchaseID;
	
	@FindBy(xpath = "(//button[@class='btn-close'])[5]")
	private WebElement closeButton;
	
	
	//search button
		@FindBy(xpath = "//button[text()='Search']")
		private WebElement searchButton;
		
		//Download Button
		@FindBy(xpath = "//button[@title='Download']")
		private WebElement downloadButton;
	
	//verify transaction details
		
		@FindBy(xpath = "//span[@id='purchaseInfo']")
		private WebElement purchaseInfo;
		

		
	
	// page factory constructor
		public transaction_Log_pomClasses(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	//navigate upto transaction log
	
		public void verifyUserIsOnTransactionLogPage(WebDriver driver) throws InterruptedException {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
	        Thread.sleep(1800);
			// scroll to element
			utility.scrollToElement(driver, analytics);

			w.until(ExpectedConditions.elementToBeClickable(report)).click();
			Reporter.log("Click on Report Module", true);
			w.until(ExpectedConditions.elementToBeClickable(Transaction_Log)).click();
			Reporter.log("Click on Transaction Log Sub Module", true);
			
			Assert.assertTrue(Transaction_Log1.isDisplayed(),"user is not on the Api Report Report this page");
			Reporter.log("Verify user is on the Transaction Log page", true);
		}
	
	
	public void searchThroughPurchaseID(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(2800);
		
        String PID = purchaseID.getText();

		w.until(ExpectedConditions.elementToBeClickable(searchFiled_purchaseID)).sendKeys(PID);
		Reporter.log("User enter purchase ID in Purchase ID text Field", true);
		
		
		
	}
	
	public void searchTransactionLog(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(1800);
	

		w.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		Reporter.log("Click on Search Button", true);
		
		
	}
	
	
	public void click_downloadButton(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(1800);
	
       

		w.until(ExpectedConditions.elementToBeClickable(downloadButton)).click();
		Reporter.log("Click on Download Button", true);
		
		
	}
	
	
	
	public void verifyTransactionPurchaseDetails(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(1800);
        
        
        String PID = purchaseID.getText();
        
        System.out.println(PID);

		w.until(ExpectedConditions.elementToBeClickable(purchaseID)).click();
		Reporter.log("Click on Purchase ID Button", true);
		

		 Thread.sleep(2800);
		String purchase_ID = purchaseInfo.getText();
		Assert.assertEquals(PID,purchase_ID,"If purchase ID in Info page is not same then OUR TC is should be failed");
		Reporter.log("Verified same purchase ID is occure Transactional details page", true);
		
		w.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
		Reporter.log("Click on close Button in transactional Details page", true);
		
		
		
	}
	
	
	
}
