package com.NaveenAutomations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.NaveenAutomation.Utils.WebEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	public static WebDriver driver;
public static EventFiringWebDriver e_driver;
	public static Logger log;

	public Properties prop;
	public static WebDriverEventListener web;
	

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
		case ("Chrome"):
			driver = WebDriverManager.chromedriver().create();
			break;
		case ("Edge"):
			driver = WebDriverManager.edgedriver().create();
			break;
		case ("Firefox"):
			driver = WebDriverManager.firefoxdriver().create();
			break;

		default:
			System.out.println("Have u entered the right browser");
			break;
		}
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
		driver.manage().timeouts().implicitlyWait(Long.valueOf(prop.getProperty("wait")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Long.valueOf(prop.getProperty("wait")), TimeUnit.SECONDS);
	}
	
	public void logsetup() {
		log = Logger.getLogger(BaseTests.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		log.setLevel(Level.INFO);
	}

	public void tearDown() {
		driver.quit();
	}
}
