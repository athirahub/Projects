package com.naveenautomationsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.OrderHistoryPage;
import com.NaveenAutomation.Page.OrderHistoryPage.Table_name;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomations.BaseTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class OrderHistoryPageTest extends BaseTests {
	YourStorePage store;
	MyAccountPage account;
	AccountLoginPage login;
	OrderHistoryPage history;

	@BeforeMethod
	public void openBrowser() {
		initialise();

	}

	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:To check whether date is correct")
	@Story("To check date in history page")
	public void verifyDateTest() {
		store = new YourStorePage();
		store.clickMyAccountBtn();
		login = store.clickloginBtn();
		
		account = login.isLoginSuccessful(email, password);
		history = account.clickOrderTab();
		String text = history.findText(columnData2, Table_name.DATEADDED);
		Assert.assertEquals(text, "25/08/2022", "The dates match");
	}

	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:To check whether total is correct")
	@Story("To check total in history page")
	public void verifyTotalTest() {
		store = new YourStorePage();
		store.clickMyAccountBtn();
		login = store.clickloginBtn();
		
		account = login.isLoginSuccessful(email, password);
		history = account.clickOrderTab();
		String text = history.findText(columnData2, Table_name.TOTAL);
		Assert.assertEquals(text, "$405.00", "The total match");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
