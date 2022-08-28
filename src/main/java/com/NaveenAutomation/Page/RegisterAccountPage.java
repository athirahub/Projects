package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomation.Utils.Utils;
import com.NaveenAutomations.BaseTests;

public class RegisterAccountPage extends BaseTests {
	public RegisterAccountPage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#input-firstname")
	private WebElement firstNameField;

	@FindBy(css="#input-lastname")
	private WebElement lastNameField;
	
	@FindBy(css="#input-email")
	private WebElement emailField;
	@FindBy(css="#input-telephone")
	private WebElement telephoneField;
	@FindBy(css="#input-password")
	private WebElement passwordField;
	@FindBy(css="#input-confirm")
	private WebElement confirmPasswordField;
	@FindBy(css="div.pull-right >input:first-of-type")
	private WebElement policyField;
	@FindBy(css="div.pull-right:nth-of-type(1) input:last-of-type")
	private WebElement submitButton;
	
	public void fillFirstName(String name) {
		Utils.sendKeys(firstNameField, name);
		
	}
	public void filllastName(String name) {
		Utils.sendKeys(lastNameField, name);
		
	}public void fillemail(String name) {
		Utils.sendKeys(emailField, name);
		
	}
	public void fillPassword(String password) {
		Utils.sendKeys(passwordField, password);
		
	}
	public void fillConfirmPassword(String password) {
		Utils.sendKeys(confirmPasswordField, password);
		
	}
	public void clickPolicy() {
		Utils.waitForElementToBeClickable(policyField);
		policyField.click();
	}
	public YourAccountCreatedPage submitButton() {
		Utils.waitForElementToBeClickable(submitButton);
		submitButton.submit();
		return new YourAccountCreatedPage();
	}
	public void filltelephone(String password) {
		Utils.sendKeys(telephoneField, password);
		
	}
	
	
	
	
}
