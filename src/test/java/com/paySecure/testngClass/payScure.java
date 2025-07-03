package com.paySecure.testngClass;

import org.testng.annotations.Test;

import com.paySecure.baseClass.baseClass;
import com.paySecure.pomClasses.loginPage;
import com.paySecure.pomClasses.paySecure_homePage;

import paySecure.utils.utility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;

public class payScure extends baseClass{
	loginPage lp ;
	paySecure_homePage ph;
	@BeforeMethod
	  public void setUp() throws FileNotFoundException, IOException {
		
		launchTheBrowser();
		lp= new loginPage(driver);
		ph=new paySecure_homePage(driver);
		
		lp.loginUsingValidCredentials(driver);
		
		
		
		
	  }
	
	
  @Test
  public void f() {
	  
	  ph.paysecureModules1(driver);
  }
  

}
