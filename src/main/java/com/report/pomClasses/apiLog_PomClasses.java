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

public class apiLog_PomClasses {
	
	//navigate uptoAPI LOG
	@FindBy(xpath = "//span[text()='Analytics']")
	private WebElement analytics;
	
	@FindBy(xpath = "//span[text()='Report']")
	private WebElement report;
	
	@FindBy(xpath = "//span[text()='Api Log']")
	private WebElement apiLog;
	
	@FindBy(xpath = "//h1[text()='Api Report']")
	private WebElement apiReport;
	
	//select API
	@FindBy(xpath = "//select[@id='sapi']")
	private WebElement selectAPI;
	
	//search button
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;
	
	//Download Button
	@FindBy(xpath = "//button[text()='Download']")
	private WebElement downloadButton;
	
	@FindBy(xpath = "//div[text()='No records to download.']")
	private WebElement alertDownload;
	
	//download API Report
	
	@FindBy(xpath = "//td[text()='No Records Found']")
	private WebElement noRecordFound;
	
	@FindBy(xpath = "//button[text()='ok']")
	private WebElement OK;
	
	// page factory constructor
	public apiLog_PomClasses(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyUserIsOnApiReportPage(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(1800);
		// scroll to element
		utility.scrollToElement(driver, analytics);

		w.until(ExpectedConditions.elementToBeClickable(report)).click();
		Reporter.log("Click on Report Module", true);
		w.until(ExpectedConditions.elementToBeClickable(apiLog)).click();
		Reporter.log("Click on Api Log Sub Module", true);
		
		Assert.assertTrue(apiReport.isDisplayed(),"user is not on the Api Report Report this page");
		Reporter.log("Verify user is on the Api Report page", true);
	}
	
	
	public void selectAPI(String api) {
		utility.selectByVisibleText(selectAPI, api);
		

	}
	
	
	public  void click_SearchButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		Reporter.log("Click on Search Button", true);
		
	}
	
	
public void click_DownloadButton(WebDriver driver) {
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
	w.until(ExpectedConditions.elementToBeClickable(downloadButton)).click();
	Reporter.log("Click on Download Button", true);
	}


public void  verify_AlertMessageForDownload(WebDriver driver){


		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(downloadButton)).click();
		Reporter.log("Click on Download Button", true);
		
		String alertMessage = w.until(ExpectedConditions.elementToBeClickable(alertDownload)).getText();
		Assert.assertEquals(alertMessage, "No records to download.", "Alert message mismatch.");
		Reporter.log("Verify 'No records to download.' this alert message verified succesfully", true);
	
	
		w.until(ExpectedConditions.elementToBeClickable(OK)).click();
		Reporter.log("Click on OK Button", true);
	
}










}
