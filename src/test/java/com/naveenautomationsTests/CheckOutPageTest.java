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
		
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
		acc=login.isLoginSuccessful("dfyu23@gmail.com", "Apple123@");
		acc.clickComponents();
		monitor=acc.clickMonitors();
		monitor.clickaddCartButton2();
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(monitor.locatorCart())));
		monitor.addCartButton();
		check=monitor.clickCheckOut();
		
	}
	@Test
	public void checkoutTest() {
		
		
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
