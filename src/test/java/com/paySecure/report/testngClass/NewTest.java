package com.paySecure.report.testngClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;

public class NewTest extends baseClass{
 
	
	@Test
  public void f() throws FileNotFoundException, IOException {
		launchTheBrowser();
		
		loginPage lp=new loginPage(driver);
		lp.loginUsingValidCredentials(driver);
		
		
		
  }
}
