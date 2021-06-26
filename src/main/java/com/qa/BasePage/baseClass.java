package com.qa.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static  WebDriver driver;
	public static Properties prop;
	static ExtentReports extentReport;
	static ExtentHtmlReporter extentHtmlReporter;
	static ExtentTest extentTest;
	
	public baseClass() {
		
		prop = new Properties();

		File file = new File(
				"C:\\Users\\raute\\eclipse-workspace\\FrameWork-Artifact\\src\\main\\java\\com\\qa\\Utilities\\config.properties");
		try {

			FileInputStream input = new FileInputStream(file);
			prop.load(input);

		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public static WebDriver initDriver(String browserName) {
		
		if (browserName.equals("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
		}
		
		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		return driver;
	}

		
	
	public static void launchBrowser() {
		String browserName = prop.getProperty("browser"); 
		String url = prop.getProperty("loginURL"); 
		DriverClass.getInstance().setDriver(initDriver(browserName));
		driver = DriverClass.getInstance().getDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
	}
	
	public static ExtentReports setUpExtentReport() {
		
		//set up extent reporter
		extentHtmlReporter = new ExtentHtmlReporter("C:\\Users\\raute\\eclipse-workspace\\FrameWork-Artifact\\src\\test\\java\\Screenshots\\ExtentReport.html");
		extentHtmlReporter.config().setDocumentTitle("Automation report");
		extentHtmlReporter.config().setReportName("Functional report");
		extentHtmlReporter.config().setTheme(Theme.DARK);
		
		//build reports
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentHtmlReporter);
		extentReport.setSystemInfo("Tester", "Prashant");
		extentReport.setSystemInfo("TestEnv", "UI.QA");
		
		return extentReport;
	}

	
	
}
