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

public class download_pomClasses {

	//navigate upto Download
	
	@FindBy(xpath = "//span[text()='Analytics']")
	private WebElement analytics;
	
	@FindBy(xpath = "//span[text()='Report']")
	private WebElement report;
	
	@FindBy(xpath="//span[text()='Download']") private WebElement download;
	
	@FindBy(xpath = "//h1[text()='Download']")
	private WebElement DOWNLOAD;
	
	
	//download -- select class -- purchase or Bank Transactions
	@FindBy(xpath = "//select[@id='downloadType']")
	private WebElement downloadSelect;
	
	// page factory constructor
		public download_pomClasses(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	
		public void verifyUserIsOnDownloadPage(WebDriver driver) throws InterruptedException {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
	        Thread.sleep(1800);
			// scroll to element
			utility.scrollToElement(driver, analytics);

			w.until(ExpectedConditions.elementToBeClickable(report)).click();
			Reporter.log("Click on Report Module", true);
			w.until(ExpectedConditions.elementToBeClickable(download)).click();
			Reporter.log("Click on download Sub Module", true);
			
			Assert.assertTrue(DOWNLOAD.isDisplayed(),"user is not on the Api Report Report this page");
			Reporter.log("Verify user is on the Download page", true);
		}
	
	
	public void downloadPurchaseOrBanktransaction(String downloadType) {
		utility.selectByVisibleText(downloadSelect, downloadType);
		Reporter.log("user select values "+ downloadType, true);
		
	}
			
			
			
			
	
}
