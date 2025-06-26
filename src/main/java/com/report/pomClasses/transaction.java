package com.report.pomClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import paySecure.utils.utility;

public class transaction {

	// scrolling point of view
	@FindBy(xpath = "//span[text()='Analytics']")
	private WebElement analytics;
	
	@FindBy(xpath = "//th[text()='Last Status']")
	private WebElement last;
	

	// report
	@FindBy(xpath = "//span[text()='Report']")
	private WebElement report;

	@FindBy(xpath = "//span[text()='Transactions']")
	private WebElement transactions;

	// filter transaction thrugh select status
	@FindBy(xpath = "//select[@id='status']")
	private WebElement selectStatus;
	
	@FindBy(xpath="(//a[contains(@class,'colorpid lstStatusBtn')])[1]")
	private WebElement status;
	
	
	// search button
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;
	
	String status1="Error";
	
	@FindBy(xpath = "//td[text()='No Records Found']")
	private WebElement notRecordFount;
	
	//td[text()='No Records Found']

	public transaction(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void navigateUptoTransaction(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		// scroll to element
		utility.scrollToElement(driver, analytics);

		w.until(ExpectedConditions.elementToBeClickable(report)).click();
		w.until(ExpectedConditions.elementToBeClickable(transactions)).click();

	}

	public  void filterTransactionThroughSelectStatus() {

		Select s = new Select(selectStatus);

		s.selectByVisibleText(status1);

		Reporter.log("user select status like " + status, true);
		
	}

	public void clickOnSearchButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		Reporter.log("click on the search button " , true);
	}
	
	public void checkStatus(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		//String expStatus = w.until(ExpectedConditions.elementToBeClickable(status)).getText();
		//String expStatusForNoRecordFound = w.until(ExpectedConditions.elementToBeClickable(notRecordFount)).getText();
		
		System.out.println(notRecordFount.isDisplayed());
		System.out.println("not record found 1st");
//		if(notRecordFount.isDisplayed()) {
//		System.err.println("no records are found");
//		Reporter.log("no records are found", true);
//		
//		} else {
		
			if(status.isDisplayed()) {
			System.err.println("Last status is displays");
			Reporter.log("no records are found", true);
		}else {
			System.out.println();
			
			
		}
		
		}
		
	}


