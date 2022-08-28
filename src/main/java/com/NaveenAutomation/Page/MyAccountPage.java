package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomation.Utils.Utils;
import com.NaveenAutomations.BaseTests;



public class MyAccountPage extends BaseTests {
	public MyAccountPage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div.collapse >ul:first-of-type >li:nth-of-type(3) >a")
	private WebElement components;
	@FindBy(css="ul.nav.navbar-nav li.dropdown:nth-of-type(3) li:nth-of-type(2) a")
	private WebElement monitors;
	@FindBy(css="div.collapse >ul:first-of-type >li:nth-of-type(1) >a")
	private WebElement desktop;
	@FindBy(css="ul.nav li.dropdown:first-of-type li:last-of-type a ")
	private WebElement mac;
	@FindBy(css="#content ul:nth-of-type(2) li:first-of-type a")
	private WebElement orderHistoryTab;
	
	@FindBy(css = "#content h2")
	private WebElement Text;
	
	public void clickComponents() {
		Utils.waitForElementToBeClickable(components);
		components.click();
	}
	public MonitorsPage clickMonitors() {
		Utils.waitForElementToBeClickable(monitors);
		monitors.click();
		return new MonitorsPage();
	}
	public OrderHistoryPage clickOrderTab() {
		Utils.waitForElementToBeClickable(orderHistoryTab);
		orderHistoryTab.click();
		return new OrderHistoryPage();
	}
	public String getText() {
		Utils.waitForElementToBeDisplayed(Text);
		return Text.getText();
	}
}
