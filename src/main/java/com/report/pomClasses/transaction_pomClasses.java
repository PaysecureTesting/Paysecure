package com.report.pomClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import paySecure.utils.CSVUtils;
import paySecure.utils.utility;

public class transaction_pomClasses {

	// scrolling point of view
	@FindBy(xpath = "//span[text()='Analytics']")
	private WebElement analytics;

	@FindBy(xpath = "//th[text()='Last Status']")
	private WebElement lastStatus;

	// report
	@FindBy(xpath = "//span[text()='Report']")
	private WebElement report;

	@FindBy(xpath = "//span[text()='Transactions']")
	private WebElement transactions;

	// filter transaction thrugh select status
	@FindBy(xpath = "//select[@id='status']")
	private WebElement selectStatus;

	@FindBy(xpath = "(//a[contains(@class,'colorpid lstStatusBtn')])[1]")
	private WebElement status;

	// search button
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;

	// filter through select merchant
	@FindBy(xpath = "//span[text()='Select Merchant']")
	private WebElement selectmerchant;
	@FindBy(xpath = "(//input[@type='text'])[4]")
	private WebElement searchmerchant;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement selectSearchmerchantCheckbox;

	// filter through select Bank
	@FindBy(xpath = "//span[text()='Select Bank']")
	private WebElement selectbank;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchFieldBank;
	@FindBy(xpath = "//li[contains(@id,'select2-bnk-result')]")
	private WebElement selectBankFromSearchFiled;

	// select MID
	@FindBy(xpath = "//select[@id='midn']")
	private WebElement selectMID;

	// select date range
	@FindBy(xpath = "//div[@id='reportrange']")
	private WebElement date;

	@FindBy(xpath = "//div[@class='ranges']/descendant::li")
	private WebElement dateRanges;

	@FindBy(xpath = "(//td[@data-title='r1c2'])[1]")
	private WebElement dateFrom;

	@FindBy(xpath = "(//td[@data-title='r2c5'])[1]")
	private WebElement dateTo;

	@FindBy(xpath = "//td[text()='No Records Found']")
	private WebElement notRecordFount;

	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement applyButton;

	// select timezone

	@FindBy(xpath = "(//td[@data-title='r1c2'])[1]")
	private WebElement arun;

	@FindBy(xpath = "//select[@id='tZone']")
	private WebElement selectTimeZone;
	@FindBy(xpath = "//ul[@id='select2-tZone-results']/li")
	private WebElement timeZones;
	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement SearchFiledtimeZones;
	@FindBy(xpath = "//select[@id='tZone']")
	private WebElement TimeZoneRollBox;

	// select currency

	@FindBy(xpath = "//select[@id='merCurr']")
	private WebElement selectCurrency;
	@FindBy(xpath = "//span[@id='select2-merCurr-container']")
	private WebElement getCurrencyFromCurrencyField;
	@FindBy(xpath = "//*[@id=\"filterTransStats\"]/tr[1]/td[9]")
	private WebElement getCurrencyFromTable;

	// Last actions in a Transaction page table
	@FindBy(xpath = "(//button[@title='Last Action'])[1]")
	private WebElement lastAction;
	@FindBy(xpath = "//span[@id='lAhistory']")
	private WebElement transactionID;
	@FindBy(xpath = "(//table[@class='table table-bordered'])[5]/descendant::th")
	private WebElement appProperties;
	@FindBy(xpath = "//h4[text()='Last Action']/following-sibling::button")
	private WebElement cancelButtonOnLastAction;

	// History button in Transaction Table
	@FindBy(xpath = "(//button[@title='History'])[1]")
	private WebElement history;
	@FindBy(xpath = "//h4[text()='Status History']")
	private WebElement statusHistory;
	@FindBy(xpath = "//span[@id='phistory']")
	private WebElement historyTransaction;
	@FindBy(xpath = "//h4[text()='Status History']/following-sibling::button")
	private WebElement cancelButtonOnHistory;

	// Remarks button in Transaction table

	@FindBy(xpath = "(//button[@title='Remarks'])[1]")
	private WebElement remarks;
	@FindBy(xpath = "//input[@id='Transaction_Id']")
	private WebElement remarksTransactionId;
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[2]")
	private WebElement sendMessageButton;
	@FindBy(xpath = "//div[text()='All input fields must be completed before submitting.']")
	private WebElement errorMessage;
	@FindBy(xpath = "(//h5[@id='exampleModalLabel'])[2]/following-sibling::button")
	private WebElement canCel_Remarks;
	@FindBy(xpath = "(//label[text()='Message'])[2]")
	private WebElement message;
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement OK;

	@FindBy(xpath = "//select[@id='usertype-select']")
	private WebElement userType;
	@FindBy(xpath = "(//span[@aria-disabled='false'])[2]")
	private WebElement selectUserType;
	@FindBy(xpath = "//select[@id='recipient-select']")
	private WebElement users;

	@FindBy(xpath = "//select[@id='recipient-Error']")
	private WebElement selectError;

	@FindBy(xpath = "//textarea[@id='message-text']")
	private WebElement error_Message;
	@FindBy(xpath = "//div[text()='Message sent successfully']")
	private WebElement successsMessage;

	// variable directory
	String partialMerchantname = "AbhiMerchant";
	String merchant = "AbhiMerchant";
	String bankName = "Delhi Lo";

	// variable for change status
	final static String status1 ="Error";

	// variable for SELECT MID
	final static String MID = "dvxv";

	// Date Range -- please select from it
	/*
	 * Today 
	 * Yesterday 
	 * Last 7 Days 
	 * This Week 
	 * Last 30 Days 
	 * This Month 
	 * Last Month
	 * Custom Range
	 */
	final static String dateRange = "Last 7 Days";
//	final static String date_To="10";
//	final static String date_From="20";

//  select - time zone
	final static String time_ZOne = "Asia/Hong_Kong";

	// select - currency
	final static String currency = "USD";

	// Transaction remarks success message
	final static String expectedSuccessMessage = "Message sent successfully";

	// page factory constructor
	public transaction_pomClasses(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// code

	public void navigateUptoTransaction(WebDriver driver) throws InterruptedException {
		// expli
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(1800);
		// scroll to element
		utility.scrollToElement(driver, analytics);

		w.until(ExpectedConditions.elementToBeClickable(report)).click();
		Reporter.log("Click on Report Module", true);
		w.until(ExpectedConditions.elementToBeClickable(transactions)).click();
		Reporter.log("Click on Transaction Sub Module", true);

	}

	public void filterTransactionThroughSelectStatus() throws InterruptedException {
		Thread.sleep(3500);
	Select s=new Select(selectStatus);
	
	s.selectByVisibleText(status1);

		Reporter.log("user select status like " + status1, true);

	}

	public void clickOnSearchButton(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		Reporter.log("click on the search button ", true);
	}

	public void checkStatus(WebDriver driver) throws InterruptedException, TimeoutException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			// Wait for either 'No record found' or table result
			WebElement noRecordFound = wait.until(ExpectedConditions.visibilityOf(notRecordFount));

			if (noRecordFound.isDisplayed()) {
				System.out.println("After filtering no records are found");
				Reporter.log("After filtering no records are found", true);
			}

		} catch (Exception e) {
			// 'No record found' not shown - check for records and scroll

			// Wait for status column to appear
			wait.until(ExpectedConditions.visibilityOf(lastStatus));

			Thread.sleep(2000);
			// Scroll to the last column
			utility.scrollToElement(driver, lastStatus);

			if (status.isDisplayed()) {
				System.out.println("After filtering records are displayed");
				Reporter.log("After filtering records are displayed", true);
			}
		}

	}

	public void selectDashboardusinAllMerchant(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(selectmerchant)).click();

		Reporter.log("click on the select merchant filed", true);
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(searchmerchant)).sendKeys(partialMerchantname);
		Reporter.log("Enter merchant name in a search merchant functioanlity", true);

		Thread.sleep(2000);

		w.until(ExpectedConditions.elementToBeClickable(selectSearchmerchantCheckbox)).click();

		Reporter.log("select merchant from all merchnat", true);

	}

	public void selectDashboardusinAllBank(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(selectbank)).click();
		org.testng.Reporter.log("click on Select Bank", true);
		org.testng.Reporter.log("click on the Select Bank", true);
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(searchFieldBank)).sendKeys(bankName);
		Reporter.log("Enter Merchnat bank name in a Search Bank name text field", true);

		Thread.sleep(2000);

		w.until(ExpectedConditions.elementToBeClickable(selectBankFromSearchFiled)).click();
		Reporter.log("select Merchant Bank from all Merchant bank", true);
	}

	public void selectMID() throws InterruptedException {
		Thread.sleep(2000);
		utility.selectByVisibleText(selectMID, MID);

		Reporter.log("Select MID from MID dropdown", true);

	}

	public void selectDateRange(WebDriver driver, String date_Range) throws InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(date)).click();
	//	utility.scrollToElement(driver, applyButton);
		Reporter.log("Click on the Date range", true);
		List<WebElement> suggestions = w.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ranges']/descendant::li")));

		for (WebElement s : suggestions) {
			if (date_Range.equalsIgnoreCase(s.getText().trim())) {
				Thread.sleep(1000);
				s.click();
				Reporter.log("select date range :- " + date_Range, true);
				break;

			}
		}
	}

	public void selectDate_To(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
//				w.until(ExpectedConditions.elementToBeClickable(dateTo)).click();
//				w.until(ExpectedConditions.elementToBeClickable(dateFrom)).click();

		Thread.sleep(2000);
		utility.clickElementByJS(driver, dateFrom);
		Reporter.log("select date range :- " + dateFrom, true);
		Thread.sleep(4000);
		utility.clickElementByJS(driver, dateTo);
		Reporter.log("select date range :- " + dateTo, true);
		Thread.sleep(4000);
//				Actions a=new Actions(driver);
//				a.click(dateFrom).build().perform();
//				a.click(dateTo).build().perform();

	}

	public void clickOnApplyButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		// w.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
		utility.clickElementByJS(driver, applyButton);
	}

	public void selectTimeZone(WebDriver driver) throws InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);

		utility.selectByVisibleText(selectTimeZone, time_ZOne);
		Thread.sleep(4000);
		Reporter.log("Select Time Zone :- " + time_ZOne, true);

		WebElement tm1 = w.until(ExpectedConditions.presenceOfElementLocated(By.id("select2-tZone-container")));

		String tm = tm1.getAttribute("title");

		// String tm = TimeZoneRollBox.getAttribute("role");
		Assert.assertEquals(time_ZOne, tm, "if this time zone is not match then our TC is should be fail");
		Thread.sleep(4000);
	}

	public void selectCurrency(WebDriver driver) throws InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);

		utility.selectByVisibleText(selectCurrency, currency);
		Thread.sleep(4000);
		Reporter.log("Select currency from currency dropdown " + currency, true);

		WebElement tm1 = w.until(ExpectedConditions.presenceOfElementLocated(By.id("select2-merCurr-container")));

		String tm = tm1.getAttribute("title");

		Assert.assertEquals(currency, tm, "if this time zone is not match then our TC is should be fail");
		Thread.sleep(4000);
		Reporter.log("Assertion passed: selected currency matches", true);

		utility.scrollToElement(driver, lastStatus);

		WebElement tm2 = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[text()='USD'])[1]")));

		String tm3 = tm2.getText();

		Assert.assertEquals(currency, tm3, "if this Currency is not match then our TC is should be fail");
		Thread.sleep(4000);
		Reporter.log("Assertion passed: selected currency matches with table", true);

	}

	public void testSelectFilters(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Select dropdown = new Select(selectStatus);
		List<WebElement> options = dropdown.getOptions();

		int totalOptions = options.size();

		for (int i = 6; i < totalOptions; i++) { // Start from 1 to skip "Select" or default
			String filterValue = options.get(i).getText().trim();

			dropdown.selectByVisibleText(filterValue);
			Reporter.log("🔽 Selected filter value: " + filterValue, true);

			wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
			Reporter.log("🔍 Clicked on Search button", true);

			// Wait for the result rows to load (customize if you use loader or spinner)
			// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//a[contains(@class,'colorpid
			// lstStatusBtn')])[1]")));

			List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='filterTransStats']/tr"));

			if (rows.isEmpty()) {
				Reporter.log("⚠️ No records found for filter: " + filterValue, true);
				continue; // Or Assert.fail() if it's expected to have records
			}

			// Iterate through rows and verify filter applied
			for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
				WebElement statusCell = rows.get(rowIndex)
						.findElement(By.xpath("(//a[contains(@class,'colorpid lstStatusBtn')])[1]")); // Update column
																										// index if
																										// needed
				String actualStatus = statusCell.getText().trim();

				Reporter.log("Row " + (rowIndex + 1) + ": Expected = " + filterValue + ", Found = " + actualStatus,
						true);
				Assert.assertTrue(actualStatus.equalsIgnoreCase(filterValue), "❌ Status mismatch at row "
						+ (rowIndex + 1) + ": Expected = " + filterValue + ", Found = " + actualStatus);
			}

			Reporter.log("✅ All rows matched for filter: " + filterValue, true);
		}
	}

	public void lastActionOnTransactionTable(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(lastAction)).click();

		Reporter.log("Click on the Last Action Button in transaction Table", true);

		Thread.sleep(2500);
		Assert.assertTrue(transactionID.isDisplayed());

		Reporter.log("Verified transaction id test is present on Last action", true);

		WebElement transactionId = w.until(ExpectedConditions.visibilityOf(transactionID));
		if (transactionId.isDisplayed()) {

			System.out.println("Transaction ID is displays on Last Action");

		}
		Thread.sleep(2000);
		List<WebElement> appPropertys = w.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@id='lastActionList']/tr")));
		for (WebElement app : appPropertys) {
			System.out.println(app.getText());
		}
		w.until(ExpectedConditions.elementToBeClickable(cancelButtonOnLastAction)).click();

		Reporter.log("Click on the Cancel  Button", true);

	}

	public void historyOnTransaction(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(history)).click();

		Reporter.log("Click on the History Button in transaction Table", true);

		WebElement status_History = w.until(ExpectedConditions.visibilityOf(statusHistory));
		Assert.assertTrue(status_History.isDisplayed(), "element is not displays");

		// check headers in history tab

		// expected headers in History tab
		// List<String> expectedValues = Arrays.asList("DATE", "STATUS", "UPDATED BY");

		// List<WebElement> actualValues = w.until(
		// ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//th[@class='text-center
		// tdwith11']")));

		// Assert.assertEquals(actualValues, expectedValues, "Mismatch in element list
		// values");

		w.until(ExpectedConditions.elementToBeClickable(cancelButtonOnHistory)).click();

		Reporter.log("Click on the Cancel  Button", true);

	}

	public void remarksOnTransactiontable(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(remarks)).click();

		Reporter.log("Click on the Remarks Button in transaction Table", true);

		WebElement remarks_TransactionID = w.until(ExpectedConditions.visibilityOf(remarksTransactionId));

		Assert.assertTrue(!remarks_TransactionID.isEnabled(), "this field is enable");

		Reporter.log("Veirifies Transaction ID on Remarks page is disabled", true);

		w.until(ExpectedConditions.elementToBeClickable(canCel_Remarks)).click();

		Reporter.log("Click on the Cancel  Button", true);

	}

	public void verifyErrorInRemarksField(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(remarks)).click();
		Reporter.log("Click on the Remarks Button in transaction Table", true);
		utility.scrollToElement(driver, message);

		w.until(ExpectedConditions.elementToBeClickable(sendMessageButton)).click();
		Reporter.log("Click on the send message Button", true);

		String actualErrorMessage = "All input fields must be completed before submitting.";

		WebElement expectedErrormessage = w.until(ExpectedConditions.visibilityOf(errorMessage));

		Assert.assertEquals(actualErrorMessage, expectedErrormessage.getText(), "Error message is not same as Figma");
		Reporter.log("Verify error message ", true);
		utility.clickElementByJS(driver, canCel_Remarks);

		w.until(ExpectedConditions.elementToBeClickable(OK)).click();

		Reporter.log("Click on the OK  Button", true);
	}

	public void verifyElementsInUserType(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for Remarks button and click
		wait.until(ExpectedConditions.elementToBeClickable(remarks)).click();
		Reporter.log("Click on the Remarks Button in transaction Table", true);

		// Scroll to the message element (custom utility)
		utility.scrollToElement(driver, message);

		// Wait until dropdown is present and visible
		wait.until(ExpectedConditions.visibilityOf(userType));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='usertype-select']"))); // Replace with actual locator if needed

		// Wrap the dropdown
		Select dropdown = new Select(userType);

		// Wait until options are loaded (dropdown must have more than 1 value)
		wait.until(driver1 -> dropdown.getOptions().size() > 1);

		// Expected values
		String[] expectedArray = {
		    "Select a Users", "ADMIN", "FULLADMIN", "SUPERADMIN", 
		    "REPORTADMIN", "ACCOUNTADMIN", "MERCHANT", "AGENT"
		};
		List<String> expectedValues = Arrays.asList(expectedArray);

		// Get actual dropdown values
		List<String> actualValues = new ArrayList<>();
		for (WebElement option : dropdown.getOptions()) {
		    actualValues.add(option.getText().trim());
		}

		// Log values
		System.out.println("Expected: " + expectedValues);
		System.out.println("Actual:   " + actualValues);

		// Assertions
		Assert.assertEquals(actualValues.size(), expectedValues.size(), "Mismatch in number of dropdown options.");
		for (String expected : expectedValues) {
		    Assert.assertTrue(actualValues.contains(expected), "Missing dropdown value: " + expected);
		}
		System.out.println("✅ User type Dropdown values validated successfully.");

		// Wait and click cancel remarks button
		wait.until(ExpectedConditions.elementToBeClickable(canCel_Remarks)).click();
		Reporter.log("Click on the Cancel Button", true);

	}

	public void verifyUsers(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.elementToBeClickable(remarks)).click();
		Reporter.log("Click on the Remarks Button in transaction Table", true);
		utility.scrollToElement(driver, message);
		Thread.sleep(3500);

		Assert.assertFalse(!selectUserType.isEnabled(), "select user type field is enabled");
		Reporter.log("when user click on Remarks then at initial stage select user type field is disabled", true);
		Thread.sleep(3500);
		utility.selectByVisibleText(userType, "ADMIN");

		Reporter.log("User select values from user type dropdown", true);
		Thread.sleep(3500);
		Assert.assertTrue(selectUserType.isEnabled(), "select user type field is enabled");

		Reporter.log("After selecting user type values then Select user type field is enabled", true);

		utility.selectByVisibleText(users, "harshitaadmin");

	}

	public void selectError(WebDriver driver) {
		utility.selectByVisibleText(selectError, "Expired card");
		Reporter.log("User select a error", true);
	}

	public void checkAll_SelectError(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		// w.until(ExpectedConditions.elementToBeClickable(remarks)).click();
		// Reporter.log("Click on the Remarks Button in transaction Table", true);
		utility.scrollToElement(driver, message);
		Select dropdown = new Select(selectError);

//	        List<WebElement> opt = dropdown.getOptions();
//	        Thread.sleep(2500);
//	        for(WebElement o:opt) {
//	        	System.out.println(o.getText());
//	        }

		// Using array and converting to list
		String[] expectedArray = { "Select a Error", "Invalid Phone Number", "Bank Decline", "Blocked Payment",
				"Insufficient Funds", "Expired card", "Payment gateway errors", "Security concerns", "Unknown errors" };
		List<String> expectedValues = Arrays.asList(expectedArray);

		// Getting actual values
		List<String> actualValues = new ArrayList<>();
		for (WebElement option : dropdown.getOptions()) {
			actualValues.add(option.getText().trim());
		}

		// Logging
		System.out.println("Expected: " + expectedValues);
		System.out.println("Actual:   " + actualValues);

		// Assertions
		Assert.assertEquals(actualValues.size(), expectedValues.size(), "Mismatch in number of dropdown options.");
		for (String expected : expectedValues) {
			Assert.assertTrue(actualValues.contains(expected), "Missing dropdown value: " + expected);
		}

	}

	public void enterMessage(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.elementToBeClickable(error_Message)).sendKeys("Your card hasb been expired");
		Reporter.log("User enter Error message is Message Field", true);
	}

	public void clickOnSubmitButton(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(sendMessageButton)).click();
		Reporter.log("User click on send message button", true);
	}

	public void verifySuccessmessage(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement messageElement = w.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Message sent successfully']")));

		String actualMessage = messageElement.getText().trim();
		System.out.println("Displayed Message: " + actualMessage);

		// Assertion
		Assert.assertEquals(actualMessage, expectedSuccessMessage, "❌ Message mismatch");

		Reporter.log("Message sent successfully is verified", true);

		w.until(ExpectedConditions.elementToBeClickable(OK)).click();

		Reporter.log("Click on OK button on success message", true);

	}
	
	public void validateTransactiondataWithCSV(WebDriver driver) {
		String csvPath = "C:\\Users\\LENOVO\\eclipse-workspace\\paySecure\\src\\test\\resources\\csv\\Transaction Report.csv"; 
		  List<Map<String, String>> csvData = CSVUtils.readCSV(csvPath);

	        for (int i = 0; i < csvData.size(); i++) {
	            Map<String, String> row = csvData.get(i);
	            String expectedTxnId = row.get("Transaction ID");
	            String expectedAmount = row.get("Amount");
	            String expectedStatus = row.get("Last Status");

	            // Example XPath — modify per your actual table row/column locators
	            String xpathBase = "//tbody[@id='filterTransStats']/tr";

	            String uiTxnId = driver.findElement(By.xpath(xpathBase + "/td[4]")).getText().trim();
	            String uiAmount = driver.findElement(By.xpath(xpathBase + "/td[8]")).getText().trim();
	            String uiStatus = driver.findElement(By.xpath(xpathBase + "/td[10]")).getText().trim();

	            System.out.println(uiTxnId);
	            System.out.println(expectedTxnId);
	            
	            System.out.println(uiAmount);
	            System.out.println(expectedAmount);
	            
	            // Assertions
	      //      Assert.assertEquals(uiTxnId, expectedTxnId, "Mismatch in Transaction ID at row: " );
	       //     Assert.assertEquals(uiAmount, expectedAmount, "Mismatch in Amount at row: ");
	        //    Assert.assertEquals(uiStatus.toUpperCase(), expectedStatus.toUpperCase(), "Mismatch in Status at row: " + (i + 2));
	        }
		
		
		
		
		
		
	}
	
	
	
	

}
