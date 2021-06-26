package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BasePage.CustomFunctions;
import com.qa.BasePage.baseClass;

public class SignInPage extends baseClass {
	
	
	@FindBy(id = "txtUsername")
	WebElement userName;
	
	@FindBy(xpath = "//div[@id = 'logInPanelHeading']")
	WebElement loginPanel;
	
	public SignInPage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
		
	}
	
	
	
	
}
