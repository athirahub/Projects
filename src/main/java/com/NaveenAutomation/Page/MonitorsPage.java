package com.NaveenAutomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomation.Base.BaseTests;
import com.NaveenAutomation.Utils.Utils;

public class MonitorsPage extends BaseTests {
	public MonitorsPage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	private WebElement header;
	@FindBy(xpath  ="//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[2]/button[1]")
	private WebElement addCart2Button;
	@FindBy(css = "div.row div.product-layout:last-of-type button:nth-of-type(2) i")
	private WebElement wishList2Button;
	@FindBy(css = "div.row div.product-layout:last-of-type button:nth-of-type(3) i")
	private WebElement compare2;
	@FindBy(xpath ="// span[@id='cart-total']")
	private WebElement cartButton;
	@FindBy(xpath ="//strong[contains(text(),' Checkout')]")
	private WebElement checkOut;
	//ul.dropdown-menu li:last-of-type p a:last-of-type strong
	@FindBy(css="#product-category div.alert")
	private WebElement message;
	@FindBy(css="#cart")
	private WebElement cart;

	public void clickaddCartButton2() {
		Utils.sleep(15);
		//*[@id="content"]/div[3]/div[2]/div/div[2]/div[2]/button[1]
		addCart2Button.click();
	}

	public String getText() {
		return Utils.getText(header);
		
	}
	public String getmessage() {
		Utils.waitForElementToBeDisplayed(message);
		return message.getText();
	}
	public String locatorCart() {
		return "#cart-total";
	}
	public void addCartButton() {
		Utils.waitForElementToBeDisplayed(cartButton);
		cartButton.click();
	}
	public CheckOutPage clickCheckOut() {
		Utils.sleep(15);
		Utils.waitForAttribute(cart,"class","btn-group btn-block open");
		
		checkOut.click();
		return new CheckOutPage();
	}

}
