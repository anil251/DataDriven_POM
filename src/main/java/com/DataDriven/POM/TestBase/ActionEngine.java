package com.DataDriven.POM.TestBase;

public class ActionEngine extends BaseEngine {
	
	public static void url(String url) {		
		
		getDriver().get(url);
	}

}
