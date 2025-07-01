package paySecure.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class utility {

	public static String propertyFile(String key) throws  IOException {
		Properties prop = new Properties();
		FileInputStream myFile=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\paySecure\\config\\config.properties");
        prop.load(myFile);
        
        String value = prop.getProperty(key);
       
		return value;
	}
	
	
	
	 public static void scrollToElement(WebDriver driver, WebElement element) {
	        if (driver == null || element == null) {
	            throw new IllegalArgumentException("Driver or Element cannot be null");
	        }

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	    }
	 
	 
	 
	   public static void selectByVisibleText(WebElement element, String visibleText) {
	        Select select = new Select(element);
	        select.selectByVisibleText(visibleText);
	    }
	   
	    public static void clickElementByJS(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", element);
	    }
	

}
