package com.NaveenAutomation.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLogoutPage {
	WebDriver driver;
	private WebElement header=driver.findElement(By.cssSelector("#content h1"));
	private WebElement continueBtn=driver.findElement(By.cssSelector("div.buttons a"));
	
	public boolean isAccountLogoutheaderDisplayed() {
		return header.isDisplayed();
	}

}
