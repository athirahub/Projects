package com.NaveenAutomation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.NaveenAutomations.BaseTests;

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

}
