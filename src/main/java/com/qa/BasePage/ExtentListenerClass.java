package com.qa.BasePage;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.Utilities.getScreenshot;


public class ExtentListenerClass extends baseClass implements ITestListener {
	
	
	static ExtentReports report;
	static ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName()); 
		ExtentFactory.getInstance().setExtentTest(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "Test case name " + result.getMethod().getMethodName() +" is passed");
		ExtentFactory.getInstance().removeExtent();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Test Case failed: " + result.getName());

		String screenshotPath = getScreenshot.getScreenshotPath(driver, result.getName());

		try {
			ExtentFactory.getInstance().getExtentTest().addScreenCaptureFromPath(screenshotPath, "Test Case " + result.getName() + " is failed");
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		ExtentFactory.getInstance().removeExtent();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP, "Test Case skipped: " + result.getName());
		ExtentFactory.getInstance().removeExtent();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		//this method will be called once before any of the test method is called.
		
		report = baseClass.setUpExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}

	
	
}
