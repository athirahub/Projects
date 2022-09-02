package com.NaveenAutomation.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NaveenAutomation.Utils.WebEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	
	
	public static WebDriver driver;
public static EventFiringWebDriver e_driver;
	public static Logger log;
	public static String email;
	public static String password;
	public static String emailChange;
	
	public static String columnData2;
	



	public Properties prop;
	public static WebDriverEventListener web;
	public static JavascriptExecutor jse;

	public BaseTests() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					"C:\\JavaProject\\testingFrameworkLearn\\src\\main\\java\\com\\automation\\config\\configure");
			try {
				prop.load(file);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public void initialise() {
		String browser = prop.getProperty("browser");
		switch (browser) {
		
		
		case "Chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "Firefox":
			driver =WebDriverManager.firefoxdriver().create();
			break;
		case "MicrosoftEdge":
			driver =WebDriverManager.edgedriver().create();
			break;

		default:
			System.out.println(("Verify you have passed the correct browser name"));
			break;
		}
		email=prop.getProperty("Email");
		password=prop.getProperty("Password");
		emailChange=prop.getProperty("EmailChange");
		
		columnData2=prop.getProperty("Order2");
		
		web=new WebEvents();
		e_driver=new EventFiringWebDriver(driver);
		
		e_driver.register(web);
		driver=e_driver;
		log = Logger.getLogger(BaseTests.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		log.setLevel(Level.INFO);

		driver.get(prop.getProperty("base_url"));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Long.valueOf(prop.getProperty("wait")), TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(Long.valueOf(prop.getProperty("wait")), TimeUnit.SECONDS);
	}
	
	public void logsetup() {
		log = Logger.getLogger(BaseTests.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		log.setLevel(Level.INFO);
	}
	public void waitForDocumentCompleteState(int timeOutInSeconds) {
		new WebDriverWait(driver, timeOutInSeconds).until((ExpectedCondition<Boolean>)V-> {
			log.info("Verifying page has loaded......");
			jse = (JavascriptExecutor) driver;
			String documentIsReady = jse.executeScript("return document.readyState").toString();
			while (true) {
				if (documentIsReady.equalsIgnoreCase("complete")) {
					log.info("Page has loaded completely......");
					return true;
				} else {
					return false;
				}
			}
		});
	}

	public void tearDown() {
		driver.quit();
	}
}
