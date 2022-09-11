package com.naveenautomationsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Base.BaseTests;
import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.MonitorsPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.YourStorePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class MyAccountPageTest extends BaseTests {
	MyAccountPage acc;
	AccountLoginPage login;
	YourStorePage yp;

	@BeforeMethod
	public void openBrowser() {
		initialise();

	
	}

	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:To check whether selecting monitor is successful")
	@Story("To check header in login page")
	public void selectMonitors() {
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
	login = yp.clickloginBtn();
		acc = login.isLoginSuccessful(email, password);

		acc.clickComponents();
		MonitorsPage monitor = acc.clickMonitors();
		Assert.assertEquals(monitor.getText(), "Monitors");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
