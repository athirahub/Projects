package com.naveenautomationsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomations.BaseTests;




public class AccountLoginPageTest  extends BaseTests{
AccountLoginPage login;
YourStorePage yp;
	
	@BeforeMethod
	public void openBrowser() {
		initialise();
		login=new AccountLoginPage();
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
	}
		
	
	@Test()
	public void isLoginSuccessful() {
		MyAccountPage map= login.isLoginSuccessful("dfyu23@gmail.com", "Apple123@");
		 Assert.assertEquals(map.getText(), "My Account");
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
