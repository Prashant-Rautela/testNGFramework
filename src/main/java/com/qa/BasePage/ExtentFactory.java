package com.qa.BasePage;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	
	
	private ExtentFactory() {
		
	}

private static ExtentFactory Extentinstance = new ExtentFactory();
	
	public static ExtentFactory getInstance() {
		return Extentinstance;
	}
	
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	
	public ExtentTest getExtentTest() {
		return extent.get();
	}
	
	public void setExtentTest(ExtentTest extentTestObject) {
		extent.set(extentTestObject);
	}
	
	public void removeExtent() {
		
		extent.remove();
		
	}
	
}
