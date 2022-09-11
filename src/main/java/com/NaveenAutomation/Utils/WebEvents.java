package com.NaveenAutomation.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.NaveenAutomation.Base.BaseTests;

public class WebEvents extends BaseTests implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		log.info("Accepting alert on" + driver.getCurrentUrl());

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		log.info("Accepted alert on" + driver.getCurrentUrl());
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		log.info("Dismissed alert on" + driver.getCurrentUrl());
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		log.info("Dismissing alert on" + driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Navigating to" + url);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		log.info("Navigated to" + url);

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		log.info("Navigating from" + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		log.info("Navigated from" + driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		log.info("Navigating from" + driver.getCurrentUrl());

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		log.info("Navigated from" + driver.getCurrentUrl());

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		log.info("Refreshing:" + driver.getCurrentUrl());
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		log.info("Refreshed:" + driver.getCurrentUrl());

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("finding element" + element);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("found element" + element);

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("clicking element" + element);

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("clicked element" + element);

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("sending" + keysToSend + "to" + element);
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("send" + keysToSend + "to" + element);

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		log.info("switching to new window" + windowName);
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		log.info("switched to new window" + windowName);

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		log.info("has an exception" + throwable.getMessage());
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		log.info("getting screenshot at" + target);
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		log.info("");

	}

	@Override
	public void afterScript(String script, WebDriver driver) {

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		log.info("got screenshot as" + screenshot);
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		log.info("getting text from" + element);

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		log.info("got text from" + element);

	}

}
