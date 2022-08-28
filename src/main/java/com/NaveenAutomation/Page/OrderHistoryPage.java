package com.NaveenAutomation.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NaveenAutomations.BaseTests;

public class OrderHistoryPage extends BaseTests {
	public OrderHistoryPage() {
		
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
		 headers = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover']  thead td"));
		 rows = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover']  tbody tr"));
	}

	@FindBy(css = "#content h1")
	private WebElement header;

	@FindBy(css = "table[class='table table-bordered table-hover']")
	private WebElement table;

	List<WebElement> headers;

	List<WebElement> rows;

	public enum Table_name {
		ORDERID("Order ID"), CUSTOMER("Customer"), NOOFPRODUCTS("No. of Products"), STATUS("Status"), TOTAL("Total"),
		DATEADDED("Date Added");

		public String value;

		Table_name(String value) {
			this.value = value;
		}

		public String getText() {
			return value;
		}
	}

	public String findText(String name, Table_name target) {
		int uniqueIndex = findIndex(Table_name.ORDERID);
		int targetIndex = findIndex(target);
		for (int k = 1; k < rows.size(); k++) {
			List<WebElement> cells = rows.get(k).findElements(By.tagName("td"));
			String text = cells.get(uniqueIndex).getText();
			if (text.equals(name)) {
				return cells.get(targetIndex).getText();
			}
		}
		System.out.println("Unable to find Element");
		return null;

	}

	public int findIndex(Table_name column) {
		for (WebElement head : headers) {
			if (head.getText().equals(column.getText())) {
				return headers.indexOf(head);
			}
		}
		return -1;
	}
}
