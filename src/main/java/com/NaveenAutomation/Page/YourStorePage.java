package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomations.BaseTests;

public class YourStorePage extends BaseTests {
	public YourStorePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#top-links ul:first-of-type li.dropdown span:first-of-type")
	WebElement accountButton;
	@FindBy(css="#top-links ul:last-of-type ul >li:last-of-type a")
	WebElement login;
	public void clickMyAccountBtn() {
		accountButton.click();
	}

	public AccountLoginPage clickloginBtn() {
		login.click();
		return new AccountLoginPage();
	}

}
