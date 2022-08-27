package com.naveenautomationsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.ForgotPassword;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomations.BaseTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ForgotPasswordTest extends BaseTests {
	YourStorePage yourStore;
	AccountLoginPage login;
	ForgotPassword password;
@BeforeMethod
	public void openBrowser() {
		initialise();

	}

	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:To check whether password change is successful")
	@Story("To check message in login page")
	public void changePasswordTest() {
		yourStore = new YourStorePage();
		yourStore.clickMyAccountBtn();
		login = yourStore.clickloginBtn();
		password = login.clickforgotPassword();
		password.fillEmailField(emailChange);
		login = password.clickContinueButton();
		Assert.assertEquals(login.getMessage(), "An email with a confirmation link has been sent your email address.",
				"Password not changed");
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
