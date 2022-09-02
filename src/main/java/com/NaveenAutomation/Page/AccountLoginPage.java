package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomation.Base.BaseTests;
import com.NaveenAutomation.Utils.Utils;

import io.qameta.allure.Step;

public class AccountLoginPage extends BaseTests {
	public AccountLoginPage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-email")
	private WebElement emailField;
	@FindBy(css = "#input-password")
	private WebElement passwordField;
	@FindBy(css = "div.form-group:last-of-type input")
	private WebElement loginButton;
	@FindBy(css = "div.form-group:last-of-type a")
	private WebElement forgottenPassword;

	@FindBy(css = "#account-login div.alert")
	private WebElement passwordChangeMessage;

	@Step("Filling login page email")
	public void fillEmailField(String data) {
		Utils.sendKeys(emailField, data);
		
	}

	@Step("Filling login page password")
	public void fillPasswordField(String data) {
		Utils.sendKeys(passwordField, data);
		
	}

	@Step("Submitting login")
	public MyAccountPage submitLogin() {
		Utils.waitForElementToBeClickable(loginButton);
		loginButton.submit();
		return new MyAccountPage();
	}

	@Step("Logging with username:{0} and password:{1} step..")
	public MyAccountPage isLoginSuccessful(String email, String pass) {
		
		fillEmailField(email);
		
		fillPasswordField(pass);
		return submitLogin();

	}

	@Step("Getting password reset")
	public ForgotPassword clickforgotPassword() {
		forgottenPassword.click();
		return new ForgotPassword();
	}

	@Step("Getting login page header")
	public String getMessage() {
		return passwordChangeMessage.getText();
	}
}
