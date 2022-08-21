package com.naveenautomationsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.MonitorsPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomations.BaseTests;


public class MyAccountPageTest extends BaseTests {
	MyAccountPage acc;
	AccountLoginPage login=new AccountLoginPage();
	YourStorePage yp ;
	
	@BeforeMethod
	public void openBrowser() {
		initialise();
		
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
		acc=login.isLoginSuccessful("dfyu23@gmail.com", "Apple123@");
		
	}
	@Test
	public void selectMonitors() {
		acc.clickComponents();
	MonitorsPage monitor=acc.clickMonitors();
		Assert.assertEquals(monitor.getText(),"Monitors");
		
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
