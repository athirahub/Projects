package com.Naveenautomatio.RetryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.NaveenAutomation.Base.BaseTests;

public class RetryTest extends BaseTests implements IRetryAnalyzer {
	int counter=0;
	int maxRetry=1;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<maxRetry) {
			counter++;
			return true;
		}
		return false;
		
		//added new logic
	}

}
