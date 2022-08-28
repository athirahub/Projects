package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomation.Utils.Utils;
import com.NaveenAutomations.BaseTests;

public class YourAccountCreatedPage extends BaseTests {
	 public YourAccountCreatedPage() {
		 waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}
	 @FindBy(css="#content p:first-of-type")
	 private WebElement header;
	 
	 public String getText() {
		 Utils.waitForElementToBeDisplayed(header);
		return header.getText();
	 }
}
