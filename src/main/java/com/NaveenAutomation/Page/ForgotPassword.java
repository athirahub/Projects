package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomation.Utils.Utils;
import com.NaveenAutomations.BaseTests;

public class ForgotPassword extends BaseTests {
	public ForgotPassword() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#input-email")
	private WebElement emailField;
	
	@FindBy(css="div.buttons div.pull-right input")
	private WebElement continueButton;
	
	public void fillEmailField(String email) {
		Utils.sendKeys(emailField, email);
		
	}
	public AccountLoginPage clickContinueButton() {
		Utils.waitForElementToBeClickable(continueButton);
		continueButton.click();
		return  new AccountLoginPage();
	}
}
