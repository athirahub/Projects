package com.naveenautomationsTests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.CheckOutPage;
import com.NaveenAutomation.Page.MonitorsPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.OrderPlacedPage;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomations.BaseTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CheckOutPageTest extends BaseTests{
	MonitorsPage monitor;
	MonitorsPage monitors;
	MyAccountPage acc;
	AccountLoginPage login=new AccountLoginPage();
	YourStorePage yp ;
	CheckOutPage check;
	
	WebDriverWait wait;
	@BeforeMethod
	public void openBrowser() {
		initialise();
		
		
		
	}

	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:To check whether order successfully placed")
	@Story("To check text in order placed page")
	public void checkoutTest() {
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
		acc=login.isLoginSuccessful(email, password);
		acc.clickComponents();
		monitor=acc.clickMonitors();
		monitor.clickaddCartButton2();
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(monitor.locatorCart())));
		monitor.addCartButton();
		check=monitor.clickCheckOut();
		
		
		
		check.clickContinueButton();
		check.clickContinueButtonDelivery();
		check.clickDeliveryMethodContinue();
		check.clickterms();
		check.clickPaymentMethodContinue();
		OrderPlacedPage order=check.clickConfirm();
		wait.until(ExpectedConditions.elementToBeClickable(order.getContinue()));
		
	Assert.assertEquals(order.getText(),"Your order has been successfully processed!");
		
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
