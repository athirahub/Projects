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

public class MonitorsPageTest extends BaseTests {
	MonitorsPage monitor;
	MyAccountPage acc;
	AccountLoginPage login=new AccountLoginPage();
	YourStorePage yp ;
	CheckOutPage check;
	@BeforeMethod
	public void openBrowser() {
		initialise();
		
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
		acc=login.isLoginSuccessful("dfyu23@gmail.com", "Apple123@");
		acc.clickComponents();
		monitor=acc.clickMonitors();
		
	}
	@Test
	public void isAddedToCartTest() {
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
