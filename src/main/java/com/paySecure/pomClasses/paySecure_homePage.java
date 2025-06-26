package com.paySecure.pomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class paySecure_homePage {

	
	
	
	public paySecure_homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void paysecureModules(WebDriver driver) {
		List<WebElement> modules = driver.findElements(By.xpath("//div[contains(@class,'tPad56')]/ul"));
		
		for(WebElement m:modules) {
			System.out.println(m.getText());
		}
		
		
		
	}
	public void paysecureModules1(WebDriver driver) {
		 List<WebElement> modules = driver.findElements(By.xpath("//div[@class='d-flex flex-column flex-shrink-0  bg-body-tertiary leftFirstPad45']"));
		
		for(WebElement m:modules) {
			System.out.println(m.getText());
		}
	
	
	
	
	
	
	
	
	}}
	
	
	

