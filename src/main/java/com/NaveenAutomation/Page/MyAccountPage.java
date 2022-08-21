package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomations.BaseTests;



public class MyAccountPage extends BaseTests {
	public MyAccountPage() {
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
	
	@FindBy(css = "#content h2")
	private WebElement Text;
	
	public void clickComponents() {
		components.click();
	}
	public MonitorsPage clickMonitors() {
		monitors.click();
		return new MonitorsPage();
	}
	public String getText() {
		
		return Text.getText();
	}
}
