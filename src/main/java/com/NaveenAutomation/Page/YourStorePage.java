package com.NaveenAutomation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomation.Base.BaseTests;
import com.NaveenAutomation.Utils.Utils;


public class YourStorePage extends BaseTests {
	public YourStorePage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}
	public YourStorePage(WebDriver driver, boolean waitForPageToLoad) {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[title='My Account']")
	WebElement accountButton;
	@FindBy(css="#top-links ul:last-of-type ul >li:last-of-type a")
	WebElement login;
	@FindBy(css="#top-links ul:first-of-type ul >li:first-of-type a")
	private WebElement registerButton;
	public void clickMyAccountBtn() {
		Utils.waitForElementToBeClickable(accountButton);
		accountButton.click();
	}

	public AccountLoginPage clickloginBtn() {
		Utils.waitForElementToBeClickable(login);
		login.click();
		return new AccountLoginPage();
	}
	public RegisterAccountPage clickregisterButton() {
		Utils.waitForElementToBeClickable(registerButton);
		registerButton.click();
		return new RegisterAccountPage();
	}
}
