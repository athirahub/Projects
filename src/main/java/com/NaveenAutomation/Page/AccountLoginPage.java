package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomations.BaseTests;



public class AccountLoginPage extends BaseTests{
	public AccountLoginPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="#input-email")
	private WebElement emailField;
	@FindBy(css="#input-password")
	private WebElement passwordField;
	@FindBy(css="div.form-group:last-of-type input")
	private WebElement loginButton;
	
	

	public void fillEmailField(String data) {
		emailField.sendKeys(data);
	}
	public void fillPasswordField(String data) {
		passwordField.sendKeys(data);
	}
	public MyAccountPage submitLogin() {
		loginButton.submit();
		return new MyAccountPage();
	} 
	public MyAccountPage isLoginSuccessful(String email,String pass) {
		fillEmailField(email);
		fillPasswordField(pass);
		return submitLogin();
		
		
	}
}
