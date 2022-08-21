package com.naveenautomationsTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomations.BaseTests;

public class YourStorePageTest extends BaseTests {
	YourStorePage yp;
	AccountLoginPage accountLogin;

	@BeforeMethod
	public void startBorwserSession() {
		initialise();
		yp = new YourStorePage();
	}

	@Test()
	public void testSomething() {
		yp.clickMyAccountBtn();
	}

	@AfterMethod
	public void quitBrowserSession() {
		tearDown();
	}
}
