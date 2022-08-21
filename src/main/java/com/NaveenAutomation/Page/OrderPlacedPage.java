package com.NaveenAutomation.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomations.BaseTests;

public class OrderPlacedPage extends BaseTests {
	public OrderPlacedPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#content p:first-of-type")
	private WebElement header;
	@FindBy(css="div.buttons a")
	private WebElement continueBtn;
	public String getText() {
		return header.getText();
		
	}
	public WebElement getContinue() {
		return continueBtn;
	}

}
