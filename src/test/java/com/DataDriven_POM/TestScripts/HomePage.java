package com.DataDriven_POM.TestScripts;

import org.testng.annotations.Test;

import com.DataDriven.POM.PageFactory.Home;
import com.DataDriven.POM.TestBase.BaseEngine;

public class HomePage extends BaseEngine  {
	
	@Test
	public static void lunchurl() {
		System.out.println("Browser Is Opened");
		getDriver().get("https://storechemistry.com/");
		String url=getDriver().getCurrentUrl();		   
		System.out.println("The Url Is : " +url);		
		Home.Register();
		
	
	}
	
	

}
