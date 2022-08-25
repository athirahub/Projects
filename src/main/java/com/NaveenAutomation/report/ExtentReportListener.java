package com.NaveenAutomation.report;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.collections.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {
	private ExtentHtmlReporter htmlReporter;
	private ExtentReports reports;
	private ExtentTest tests;
	
	  

	  

	  @Override
	  public void onStart(ITestContext testContext) {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			// Report Name
			String repName = "Extent Report" + "_" + timeStamp + ".html";
			htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"./Extent Reports/"+repName);
			htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
			reports.setSystemInfo("Name of the host", "localhost");
			reports.setSystemInfo("Env", "Prod");
			reports.setSystemInfo("Tester Name", "Athira");

			htmlReporter.config().setDocumentTitle("Naveen Automation  Testing");
			htmlReporter.config().setReportName("Regression Suite Testing");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
	  }

	 
	  @Override
		public void onFinish(ITestContext testContext) {
			reports.flush();
		}

		@Override
		public void onTestSuccess(ITestResult tr) {
			tests = reports.createTest(tr.getName());
			tests.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}

		@Override
		public void onTestFailure(ITestResult tr) {
			tests = reports.createTest(tr.getName());
			tests.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		}

		@Override
		public void onTestSkipped(ITestResult tr) {
			tests = reports.createTest(tr.getName());
			tests.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		}
}
	

	 
	 

