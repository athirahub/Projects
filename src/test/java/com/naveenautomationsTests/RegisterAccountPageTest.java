package com.naveenautomationsTests;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NaveenAutomation.Page.AccountLoginPage;
import com.NaveenAutomation.Page.MyAccountPage;
import com.NaveenAutomation.Page.RegisterAccountPage;
import com.NaveenAutomation.Page.YourAccountCreatedPage;
import com.NaveenAutomation.Page.YourStorePage;
import com.NaveenAutomation.Utils.ExcelUtil;
import com.NaveenAutomation.Utils.Utils;
import com.NaveenAutomations.BaseTests;

public class RegisterAccountPageTest extends BaseTests {
	YourStorePage yp;
	
	RegisterAccountPage register;
	YourAccountCreatedPage account;

	@BeforeMethod
	public void startBorwserSession() {
		initialise();
		yp = new YourStorePage();
	}
	@Test(dataProvider="register")
	public void registerTest(String firstname,String lastname,String email,String telephone,String password,String confirm) {
		
		yp.clickMyAccountBtn();
		register=yp.clickregisterButton();
		Utils.sleep(2000);
		register.fillFirstName(firstname);
		Utils.sleep(2000);
		register.filllastName(lastname);
		Utils.sleep(2000);
		register.fillemail(email+RandomStringUtils.randomNumeric(3));
		Utils.sleep(2000);
		register.filltelephone(telephone);
		register.fillPassword(password);
		Utils.sleep(2000);
		register.fillConfirmPassword(confirm);
		Utils.sleep(2000);
		register.clickPolicy();
		account=register.submitButton();
		
	Assert.assertEquals(account.getText(), "Congratulations! Your new account has been successfully created!", "Texts  match");


}
	@DataProvider(name="register")
	String[][] readingData() throws IOException{
		String file="C:\\Users\\my pc\\Desktop\\assignments\\Register.xlsx";
		int row=ExcelUtil.getLastRow(file, "Sheet1");
		int column=ExcelUtil.getLastColumn(file, "Sheet1", row);
		String[][] data=new String[row][column];
		for(int i=1;i<=row;i++) {
			for(int k=0;k<column;k++) {
				data[i-1][k]=ExcelUtil.getCellData(file, "Sheet1", i, k);
			}
		}
		return data;
	}
}
