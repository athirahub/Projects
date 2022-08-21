package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomations.BaseTests;

public class MonitorsPage extends BaseTests {
	public MonitorsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	private WebElement header;
	@FindBy(css = "div.row div.product-layout:last-of-type div.button-group span")
	private WebElement addCart2Button;
	@FindBy(css = "div.row div.product-layout:last-of-type button:nth-of-type(2) i")
	private WebElement wishList2Button;
	@FindBy(css = "div.row div.product-layout:last-of-type button:nth-of-type(3) i")
	private WebElement compare2;
	@FindBy(css="#cart-total")
	private WebElement cartButton;
	@FindBy(css="ul.dropdown-menu li:last-of-type p a:last-of-type strong")
	private WebElement checkOut;
	@FindBy(css="#product-category div.alert")
	private WebElement message;

	public void clickaddCartButton2() {
		addCart2Button.click();
	}

	public String getText() {
		return header.getText();
	}
	public String getmessage() {
		return message.getText();
	}
	public String locatorCart() {
		return "#cart-total";
	}
	public void addCartButton() {
		cartButton.click();
	}
	public CheckOutPage clickCheckOut() {
		checkOut.click();
		return new CheckOutPage();
	}

}
