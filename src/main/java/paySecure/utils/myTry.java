package paySecure.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class myTry implements IRetryAnalyzer {
	
	private int retryCount=0;
	private static final int maxRetryCount=0;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
