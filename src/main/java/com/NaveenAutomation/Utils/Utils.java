package com.NaveenAutomation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NaveenAutomation.Base.BaseTests;

public class Utils extends BaseTests {
 public static void takeFailedScreenshots(String testcaseName) {
	 
	String timeformat =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshot, new File("./Screenshots\\"+"_"+testcaseName+"_"+timeformat+".jpeg"));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
 }
 
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

		}
 }
	public static String generateRandomEmail() {
		String email = RandomStringUtils.randomNumeric(3);
		String emailID = "Athira" + email + "@gmail.com";
		return emailID;
	}

	public static String generateRandomPassword() {
		String randomStringForPassword = RandomStringUtils.randomNumeric(3);
		String password = "Abhi@" + randomStringForPassword;
		return password;
	}
	public static void click(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static boolean isDisplayed(WebElement element) {
		return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	public static String getText(WebElement element) {
		return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element)).getText();
	}

	public static void acceptAlert() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public static void dismissAlert() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public static void selectFromDropDown(WebElement element, String value) {
		waitForElementToBeSelectable(element);
		Select sc = new Select(element);

		try {
			sc.selectByValue(value);
		} catch (Exception e) {
			sc.selectByVisibleText(value);
		}

	}

	public static void switchToNewTab(WebElement element) {
		String parentHandle = driver.getWindowHandle();
		log.info("Parent Window Handle is " + parentHandle);
		waitForElementToBeClickable(element);

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

	}

	public static void sendKeys(WebElement element, String keysInput) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element)).sendKeys(keysInput);
	}

	public static void waitForElementToBeSelectable(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public static void waitForElementToBeDisplayed(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeClickable(WebElement element) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void javascriptClick(WebElement element) {
		
		jse.executeScript("arguments[0].click();", element);
	}

	public static void scrollIntoViewUsingJavascript(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void sendKeysUsingJavascript(WebElement element, String emailInput) {
		jse.executeScript("arguments[0].setAttribute('value', '"+emailInput+"')", element);
	}


}
