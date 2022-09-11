package com.naveenautomationsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Base.BaseTests;
import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomation.Utils.Utils;

import bsh.util.Util;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;




public class AccountLoginPageTest  extends BaseTests{
AccountLoginPage login;
YourStorePage yp;
	
	@BeforeMethod
	public void openBrowser() {
		initialise();
		
		yp = new YourStorePage();
		
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
	}
		
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:To check whether login is successful")
	@Story("To check header in login page")
	public void isLoginSuccessful() {
		MyAccountPage map= login.isLoginSuccessful(email,password);
		 Assert.assertEquals(map.getText(), "My Account");
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
