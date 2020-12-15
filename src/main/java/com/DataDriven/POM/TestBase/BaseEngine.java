package com.DataDriven.POM.TestBase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseEngine {
	
	private static String curredir;
	private static ChromeOptions options;
	private static WebDriver driver;
	private static String tcname;
	private static ExtentTest extentTest;
	private static ExtentReports extentReports;
	
	
	@BeforeSuite
	public void openbrowser() {
		
		curredir=System.getProperty("user.dir");
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();		
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 
		
	}
	@BeforeMethod
	public void BeforeTcExecution(Method method) {
		tcname=method.getName();
		System.out.println("The Present Test Case Is : " +tcname);
		extentTest=extentReports.startTest(tcname);
		
	}
	
	@BeforeTest
	public void Reports() {
		extentReports = new ExtentReports("H:\\Workspace\\DataDriven_POM\\ExtentReports\\Reports.html");
	}
	
	
	@AfterMethod
	public void AfterTCExcution(ITestResult result) throws IOException {
		extentReports.endTest(extentTest);
		  extentReports.flush();
		  
		  
	}
	@AfterTest
	public void generateReports() {
		Optional optional = Optional.ofNullable(extentReports);
		if (optional.isPresent()) {
			extentReports.close();
			
			
			
			
		}
		else {
			System.out.println("Extent Reoprts Pointing To Null");
		}
		 
	}
	
	@AfterSuite
	public  void tearDown() {
		//driver.quit();
		
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static String getTcName() {
		return tcname;
	}
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	
	
	

}
