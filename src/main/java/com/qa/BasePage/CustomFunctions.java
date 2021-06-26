package com.qa.BasePage;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class CustomFunctions {
	
	
	public static String getTitle(WebDriver driver) {
		
		String title = driver.getTitle();
		ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "driver has fetched the title");
		return title;
		
	}
	
	

}
