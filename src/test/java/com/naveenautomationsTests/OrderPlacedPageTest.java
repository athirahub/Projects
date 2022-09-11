package com.naveenautomationsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NaveenAutomation.Base.BaseTests;
import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.CheckOutPage;
import com.NaveenAutomation.Page.MonitorsPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.OrderPlacedPage;
import com.NaveenAutomation.Page.YourStorePage;

public class OrderPlacedPageTest extends BaseTests {
	MonitorsPage monitor;
	MonitorsPage monitors;
	MyAccountPage acc;
	AccountLoginPage login ;
	YourStorePage yp;
	CheckOutPage check;
	OrderPlacedPage order;

	WebDriverWait wait;

	@BeforeMethod
	public void openBrowser() {
		initialise();

		

	}

	@Test
	public void orderPlacedTest() {
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		login = yp.clickloginBtn();
		acc = login.isLoginSuccessful(email, password);
		acc.clickComponents();
		monitor = acc.clickMonitors();
		monitor.clickaddCartButton2();
		wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(monitor.locatorCart())));
		monitor.addCartButton();
		check = monitor.clickCheckOut();
		
		check.clickContinueButton();
		check.clickContinueButtonDelivery();
		check.clickDeliveryMethodContinue();
		check.clickterms();
		check.clickPaymentMethodContinue();
		 order=check.clickConfirm();
		
		//wait.until(ExpectedConditions.elementToBeClickable(order.getContinue()));

		Assert.assertEquals(order.getText(), "Your order has been successfully processed!");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
