package com.paySecure.baseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import paySecure.utils.utility;


public class baseClass {

	public WebDriver driver;

	public void launchTheBrowser() throws FileNotFoundException, IOException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.navigate().to(utility.propertyFile("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterMethod

	public void failurMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {

			try {

				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);

				String timestamp = new SimpleDateFormat("yyyy-dd--hh-mm").format(new Date());

				FileUtils.copyFile(src, new File(".\\screenshot\\" + " " + timestamp + ".png"));

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

	}

}
