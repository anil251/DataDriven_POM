package com.DataDriven_POM.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.DataDriven.POM.PageFactory.Home;
import com.DataDriven.POM.TestBase.BaseEngine;
import com.relevantcodes.extentreports.LogStatus;

import co.DataDriven.POM.Utilities.ExcelReader1;

public class Contacts extends BaseEngine {
	
	@Test
	public static void contact() {
		System.out.println("Browser Is Opened");
		getDriver().get("https://storechemistry.com/");
		String url=getDriver().getCurrentUrl();		   
		System.out.println("The Url Is : " +url);
		Home.Contact_us();
		
		ExcelReader1 excelReader = new ExcelReader1("H:\\Workspace\\DataDriven_POM\\src\\main\\java\\com\\DataDriven\\POM\\DataFiles\\Registration_Deatils.xlsx");
		
		String Name=excelReader.getCellData("contacts", "Name", 2);
		  System.out.println(Name);
		 
			
		String Mobile =excelReader.getCellData("contacts","Mobile",2);
			System.out.println(Mobile);
			
			
			  String Email=excelReader.getCellData("contacts", "Email", 2);
			  System.out.println(Email);
			  
			  String Message=excelReader.getCellData("contacts", "Message", 2);
			  System.out.println(Message);
			  
			  getDriver().findElement(By.name("name")).sendKeys(Name);
			  getExtentTest().log(LogStatus.PASS, "Name Is Entered");
			  getDriver().findElement(By.name("mobile")).sendKeys(Mobile);
			  getExtentTest().log(LogStatus.PASS, "Mobile Is Entered");
			  getDriver().findElement(By.name("email")).sendKeys(Email);
			  getExtentTest().log(LogStatus.PASS, "Name Is Email");
			  getDriver().findElement(By.xpath("//textarea[@placeholder='Type Message']")).sendKeys(Message);
			  getExtentTest().log(LogStatus.PASS, "Name Is Message");
			  getDriver().findElement(By.xpath("//button[contains(text(),'SUBMIT')]")).click();
			  getExtentTest().log(LogStatus.PASS, "Clicking Subbmit");
			 if(getDriver().getPageSource().contains("//h2[contains(text(),'Thanks For Choosing Storechemistry...')]"));
			 {
			 System.out.println("The Text Is Present");
			 }
			
			
			 /* if (success.isDisplayed()) {
				  System.out.println("The Text is Present and Contacts Submited Succesfully :" +success);
				
			}
			  else {
				System.out.println("The Text is Not Present and Contacts Not Submited Succesfully :");*/
			//}
			  
			 
	}

}
