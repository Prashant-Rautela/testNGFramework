package com.qa.BasePage;

import org.openqa.selenium.WebDriver;

public class DriverClass {
	
	
	//to implement singleton design pattern
	
	private DriverClass() {
		
	}
	
	//we will use factory design pattern to get and set the instance of the singleton class
	private static DriverClass instance = new DriverClass();
	
	public static DriverClass getInstance() {
		return instance;
	}
	
	ThreadLocal<WebDriver> localThread = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return localThread.get();
	}
	
	public void setDriver(WebDriver driver) {
		localThread.set(driver);
	}
	
	
	public void closeDriver() {
		localThread.get().close();
		localThread.remove();
	}
	

}
