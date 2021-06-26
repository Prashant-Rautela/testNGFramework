package com.qa.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class getScreenshot {
	
	public static String getScreenshotPath(WebDriver driver, String testName) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String testTime = dtf.format(now);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = "C:\\Users\\raute\\eclipse-workspace\\FrameWork-Artifact\\src\\test\\java\\Screenshots\\" + testName +"_" + testTime + ".png";
		File dest = new File(destinationPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return destinationPath;
		
	}
	
	

}
