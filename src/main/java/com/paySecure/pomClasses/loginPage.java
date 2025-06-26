package com.paySecure.pomClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import paySecure.utils.utility;

public class loginPage {
	@FindBy(xpath = "//input[@id='exampleFormControlInput1']") private WebElement id;
	@FindBy(xpath = "//input[@id='floatingPassword']") private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submit;
	
	
	
public loginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	
	public void loginUsingValidCredentials(WebDriver driver) throws FileNotFoundException, IOException {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(id)).sendKeys(utility.propertyFile("id"));
		w.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(utility.propertyFile("password"));
		w.until(ExpectedConditions.elementToBeClickable(submit)).click();
	
	
}}
