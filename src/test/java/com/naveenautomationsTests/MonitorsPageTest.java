package com.naveenautomationsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.CheckOutPage;
import com.NaveenAutomation.Page.MonitorsPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomations.BaseTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class MonitorsPageTest extends BaseTests {
	MonitorsPage monitor;
	MyAccountPage acc;
	AccountLoginPage login=new AccountLoginPage();
	YourStorePage yp ;
	CheckOutPage check;
	@BeforeMethod
	public void openBrowser() {
		initialise();
		

		
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:To check whether item added to cart")
	@Story("To check message in monitor page")
	public void isAddedToCartTest() {
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
		acc=login.isLoginSuccessful(email, password);
		acc.clickComponents();
		monitor=acc.clickMonitors();
		
		monitor.clickaddCartButton2();
		
//		monitor.addCartButton();
//	check=monitor.clickCheckOut();
	Assert.assertEquals(monitor.getmessage().contains("Success"), true);
			
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	

}
