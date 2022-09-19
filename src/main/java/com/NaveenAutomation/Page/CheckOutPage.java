package com.NaveenAutomation.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.NaveenAutomation.Base.BaseTests;
import com.NaveenAutomation.Utils.Utils;

public class CheckOutPage extends BaseTests {
	
	public CheckOutPage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	private WebElement header;
	@FindBy(css = "#input-payment-firstname")
	private WebElement firstNameField;
	@FindBy(css = "#input-payment-lastname")
	private WebElement lastNameField;
	@FindBy(css = "#input-payment-company")
	private WebElement companyField;
	@FindBy(css = "#input-payment-address-1")
	private WebElement address1Field;
	@FindBy(css = "#input-payment-address-2")
	private WebElement address2Field;
	@FindBy(css = "#input-payment-city")
	private WebElement cityField;
	@FindBy(css = "#input-payment-postcode")
	private WebElement postalField;
	@FindBy(css = "#input-payment-country")
	private WebElement countryField;
	@FindBy(css = "#input-payment-zone")
	private WebElement regionField;
	@FindBy(css = "#button-payment-address:last-of-type")
	private WebElement billingDetailsContinue;

	@FindBy(css = "#button-shipping-address:last-of-type")
	private WebElement deliveryDetailsContinue;
	@FindBy(css = "#button-shipping-method:last-of-type")
	private WebElement deliveryMethodContinue;
	@FindBy(css = "div.panel-body >div.buttons div.pull-right a+input")
	private WebElement terms;
	@FindBy(css = "#button-payment-method:last-of-type")
	private WebElement paymentMethodContinue;
	@FindBy(css = "#button-confirm:first-of-type")
	private WebElement confirm;
	@FindBy(css = "#collapse-payment-method div.alert")
	private WebElement errorMessageTerms;

	public WebElement getConfirm() {
		return confirm;
	}

	public Select selectButton(WebElement element) {
		Select sc = new Select(element);
		return sc;
	}

	public void fillFirstNameField(String data) {
		Utils.sendKeys(firstNameField, data);
		
	}

	public void clickContinueButton() {
		Utils.sleep(10);
		Utils.waitForElementToBeClickable(billingDetailsContinue);
		billingDetailsContinue.click();
	}

	public void fillLastNameField(String data) {
		Utils.sendKeys(lastNameField, data);
		
	}

	public void fillcompanyField(String data) {
		Utils.sendKeys(companyField, data);
		
	}

	public void fillAddress1Field(String data) {
		Utils.sendKeys(address1Field, data);
		
	}

	public void fillAddress2Field(String data) {
		Utils.sendKeys(address2Field, data);
		
	}

	public void cityField(String data) {
		Utils.sendKeys(cityField, data);
		
	}

	public void postalField(String data) {
		Utils.sendKeys(postalField, data);
		
	}

	public void selectcountry(String data) {
		Utils.selectFromDropDown(countryField, data);
		//selectButton(countryField).selectByVisibleText(data);
	}

	public void selectregion(String data) {
		Utils.selectFromDropDown(regionField, data);
		//selectButton(regionField).selectByVisibleText(data);
	}

	public void clickContinueButtonDelivery() {
		Utils.waitForElementToBeClickable(deliveryDetailsContinue);
		deliveryDetailsContinue.click();
	}

	public void clickDeliveryMethodContinue() {
		Utils.waitForElementToBeClickable(deliveryMethodContinue);
		deliveryMethodContinue.click();
	}

	public void clickterms() {
		Utils.waitForElementToBeClickable(terms);
		terms.click();
	}

	public void clickPaymentMethodContinue() {
		Utils.waitForElementToBeClickable(paymentMethodContinue);
		paymentMethodContinue.click();
	}

	public OrderPlacedPage clickConfirm() {
		Utils.waitForElementToBeClickable(confirm);
		confirm.click();
		return new OrderPlacedPage();
	}

	public boolean isAlertMessageForTermsDisplaying() {
		return errorMessageTerms.isDisplayed();
	}

	public String getText() {
		return Utils.getText(header);
		
	}

}
