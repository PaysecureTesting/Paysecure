package com.payout.pomClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ReporterConfig;

public class payout_dashBoard {

	@FindBy(xpath = "//span[text()='Payout']")
	private WebElement payout;

	@FindBy(xpath = "//div[@id='payouts']/ul/li/a/span[text()='Dashboard']")
	private WebElement dashboard;

	@FindBy(xpath = "//h1[text()='Dashboard Analytics']")
	private WebElement dashboardAnalytics;

	// payout dashboard - for all using all merchant and currency

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[2]")
	private WebElement allMerchants;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchAllMerchants;

	@FindBy(xpath = "//li[contains(@id,'select2-merchantList')]")
	private WebElement selectMar;

	// select currency from all currency

	@FindBy(xpath = "//span[text()='Total in USD']")
	private WebElement totalUSD;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchAllCurrencies;

	@FindBy(xpath = "//li[contains(@id,'select2-merCurr')]")
	private WebElement selectCur;

	// dashboard analytics - today and yesterday
	@FindBy(xpath = "//select[@id='dateSelector']")
	private WebElement today;

	@FindBy(xpath = "//select[@id='todayCntAmt']")
	private WebElement todayCount;

	// dashboard analytics - weekly
	@FindBy(xpath = "//select[@id='weekCntAmt']")
	private WebElement weeklyCount;

	// dashboard analytics - Monthly
	@FindBy(xpath = "//input[@id='tansMonth']")
	private WebElement monthly;
	
	@FindBy(xpath = "//select[@id='monthCntAmt']")
	private WebElement monthlyCount;
	
	
	//yearly count
	@FindBy(xpath="//select[@id='yearlist']")
	private WebElement yearly;
	
	@FindBy(xpath="//select[@id='yearCntAmt']")
	private WebElement yearlyCount;
	
	
	public payout_dashBoard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnPayout_Dashboard(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(payout)).click();
		w.until(ExpectedConditions.elementToBeClickable(dashboard)).click();

		// check user is on the payout dashboard or not

//		String actText = "Dashboard Analytics";
//		String expText = dashboardAnalytics.getText();
//
//		Assert.assertSame(actText, expText,
//				"If actual dashboard text is not match with Expected dashboard text then our test case is failed");

	}

	public void selectDashboardusinAllMerchant(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(allMerchants)).click();
		org.testng.Reporter.log("click on all merchants", true);

		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(searchAllMerchants)).sendKeys("002");
		;
		org.testng.Reporter.log("search merchants from all merchants", true);

		List<WebElement> suggestions = w.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-merchantList-results']/li")));

		// If there's only one suggestion, just click it
		if (suggestions.size() == 1) {
			suggestions.get(0).click();
		} else {

			for (WebElement s : suggestions) {
				if ("Merchant002".equalsIgnoreCase(s.getText().trim())) {
					s.click();
					break;
				}
			}
		}

		org.testng.Reporter.log("click on the all merchants", true);

	}

	public void selectDashboardusinAllCurrency(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(totalUSD)).click();
		org.testng.Reporter.log("click on total USD", true);

		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(searchAllCurrencies)).sendKeys("Total in USD");
		;
		org.testng.Reporter.log("search merchants from all merchants", true);

		List<WebElement> suggestions = w.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-merCurr-results']/li")));

		// If there's only one suggestion, just click it
		if (suggestions.size() == 1) {
			suggestions.get(0).click();
		} else {

			for (WebElement s : suggestions) {
				if ("Total in USD".equalsIgnoreCase(s.getText().trim())) {
					s.click();
					break;
				}
			}
		}

		org.testng.Reporter.log("click on the all merchants", true);

	}

	public void selectDashboardTodayAndYesterday(String Today, String Count) throws InterruptedException {

		Select s = new Select(today);

		s.selectByVisibleText(Today);

		org.testng.Reporter.log("click on Today filter", true);

		Select t = new Select(todayCount);
		
		Thread.sleep(3000);

		t.selectByVisibleText(Count);

		org.testng.Reporter.log("click on Today count", true);

	}

	public void selectDashboardWeekly(String Weekly) {

		Select s = new Select(weeklyCount);

		s.selectByVisibleText(Weekly);

	}

	public void selectDashboardMonthly(WebDriver driver) throws InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(1000);
		w.until(ExpectedConditions.elementToBeClickable(monthly)).click();
		org.testng.Reporter.log("click on Monthly", true);

		List<WebElement> suggestions = w
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//td[@colspan='7'])[1]/span")));

		// If there's only one suggestion, just click it
		if (suggestions.size() == 1) {
			suggestions.get(0).click();
		} else {

			for (WebElement t : suggestions) {
				if ("JUL".equalsIgnoreCase(t.getText().trim())) {
					t.click();
					break;
				}
			}
		}

	}

	public void selectDashboardMonthllyUsingCount(String monthly) {

		Select s = new Select(monthlyCount);

		s.selectByVisibleText(monthly);

	}
	
	public void selectDashboardYearly(String year) {

		Select s = new Select(yearly);

		s.selectByVisibleText(year);

	}
	
	public void selectDashboardYearlyCount(String yearCount) {

		Select s = new Select(yearlyCount);

		s.selectByVisibleText(yearCount);

	}

}
