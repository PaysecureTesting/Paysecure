package com.report.pomClasses;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.apache.poi.ss.util.DateFormatConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import paySecure.utils.utility;

public class bank_Transaction_Time_Report_pomClasses {

	// navigate upto Bank Transaction Time Report
	@FindBy(xpath = "//span[text()='Analytics']")
	private WebElement analytics;

	@FindBy(xpath = "//span[text()='Report']")
	private WebElement report;

	@FindBy(xpath = "//span[contains(text(),'Transaction Time')]")
	private WebElement bank_Transaction_Time;

	@FindBy(xpath = "//h1[text()='Bank Transaction Time Report']")
	private WebElement bank_Transaction_Time_Report;

	// todays date verify
	@FindBy(xpath = "//span[@class='settleFont']")
	private WebElement todaysDate;

	// verify dates in select bank

	@FindBy(xpath = "(//td[text()='2'])[2]")
	private WebElement disableDate;

	@FindBy(xpath = "(//td[@data-title='r0c2'])[1]")
	private WebElement enableDate;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancel;

	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement apply;

	@FindBy(xpath = "//img[@class='left_calander']")
	private WebElement calendor;

	// select bank
	@FindBy(xpath = "//select[@id='bnk']")
	private WebElement selectbank;

	// Transaction Time more than
	@FindBy(xpath = "//input[@id='moreThanSeconds']")
	private WebElement enterTime;

	// search button
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;

	// page factory constructor
	public bank_Transaction_Time_Report_pomClasses(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void navigateUptoBankTransactionTimeReport(WebDriver driver) throws InterruptedException {
		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(1800);
		// scroll to element
		utility.scrollToElement(driver, analytics);

		w.until(ExpectedConditions.elementToBeClickable(report)).click();
		Reporter.log("Click on Report Module", true);
		w.until(ExpectedConditions.elementToBeClickable(bank_Transaction_Time)).click();
		Reporter.log("Click on Bank Transaction Time Sub Module", true);

		Assert.assertTrue(bank_Transaction_Time_Report.isDisplayed(),
				"user is not on the Bank Transaction Time Report this page");
		Reporter.log("verify user is on the Bank Transaction Time Report", true);
	}

	public void convertDateFormat() {
		// rawDate is like: "02-07-2025 00:00"
		String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Reporter.log("todays date :- " + expectedDate, true);

		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String inputDate = todaysDate.getText();

		TemporalAccessor date = inputFormat.parse(inputDate);
		String convertedDate = outputFormat.format(date);

		Reporter.log("Converted Date: " + convertedDate, true);

		Assert.assertEquals(convertedDate, expectedDate, "if Both date are not matching then our Test Cases is failed");

		Reporter.log("checking todays date are displays on this Bank transaction report page", true);

	}

	public void selectDateisDisabled(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(calendor)).click();

		boolean date = disableDate.isEnabled();

		System.out.println(date);

		Assert.assertFalse(disableDate.isEnabled(), "The field should be disabled but it's enabled.");
		Reporter.log("Date is disabled", true);

		w.until(ExpectedConditions.elementToBeClickable(cancel)).click();
		Reporter.log("Click on Cancel Button in Calendor", true);

	}

	public void verifySelectDateIsEnabled(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(calendor)).click();

		boolean date = enableDate.isEnabled();

		Assert.assertFalse(date, "The field should be enable but it's disable.");
		Reporter.log("Date is enabled", true);

		w.until(ExpectedConditions.elementToBeClickable(enableDate)).click();
		Reporter.log("Click on Date", true);

		w.until(ExpectedConditions.elementToBeClickable(apply)).click();
		Reporter.log("Click on Apply Button in Calendor", true);
	}

	public void selectDate(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(calendor)).click();
		Reporter.log("Click on Calendor Button in Calendor", true);
		w.until(ExpectedConditions.elementToBeClickable(enableDate)).click();
		Reporter.log("Click on Date", true);
	}

	public void cancelButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(cancel)).click();
		Reporter.log("Click on Cancel Button in Calendor", true);

	}

	public void applyButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(apply)).click();
		Reporter.log("Click on Apply Button in Calendor", true);

	}

	public void selectBank(WebDriver driver, String bank) {
		Select s = new Select(selectbank);
		s.selectByVisibleText(bank);

	}

	public void enterTimeIn_Transaction_Time_more_than(WebDriver driver, String time) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(enterTime)).sendKeys(time);

	}

	public void searchButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		;

	}
}
