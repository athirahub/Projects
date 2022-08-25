package com.NaveenAutomation.Utils;

import com.NaveenAutomations.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseTests implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test started:"+result.getMethod().getMethodName());	

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("test success:"+result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
	log.info("Test failed:"+result.getMethod().getMethodName());	
	Utils.takeFailedScreenshots(result.getMethod().getMethodName());
	}
	@Override
	 public void onTestSkipped(ITestResult result) {
	log.info("Skipped:"+result.getMethod().getMethodName());	 
	 }
	 

}