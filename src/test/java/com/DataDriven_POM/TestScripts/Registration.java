package com.DataDriven_POM.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.DataDriven.POM.PageFactory.Home;
import com.DataDriven.POM.TestBase.BaseEngine;

import co.DataDriven.POM.Utilities.ExcelReader1;

public  class Registration extends BaseEngine {
	
	@Test
	public static void registration() {
		System.out.println("Browser Is Opened");
		getDriver().get("https://storechemistry.com/");
		String url=getDriver().getCurrentUrl();		   
		System.out.println("The Url Is : " +url);		
		Home.Register();
		ExcelReader1 excelReader = new ExcelReader1("H:\\Workspace\\DataDriven_POM\\src\\main\\java\\com\\DataDriven\\POM\\DataFiles\\Registration_Deatils.xlsx");
		
		
		  String Name=excelReader.getCellData("userdetails", "Name", 3);
		  System.out.println(Name);
		 
			
		String Mobile =excelReader.getCellData("userdetails","Mobile",3);
			System.out.println(Mobile);
			
			
			  String Email=excelReader.getCellData("userdetails", "Email", 3);
			  System.out.println(Email);
			  
			  String Standard=excelReader.getCellData("userdetails", "Standard", 3);
			  System.out.println(Standard);
			  
			  String Password=excelReader.getCellData("userdetails", "Password", 3);
			  System.out.println(Password);
			  
			  
			  getDriver().findElement(By.name("name")).sendKeys(Name);
			  getDriver().findElement(By.id("number")).sendKeys(Mobile);
			  getDriver().findElement(By.id("email")).sendKeys(Email);
			  org.openqa.selenium.support.ui.Select select = new
			  org.openqa.selenium.support.ui.Select(getDriver().findElement(By.name("cl_id")));
			  select.selectByVisibleText(Standard);
			  getDriver().findElement(By.name("password")).sendKeys(Password);
			  getDriver().findElement(By.xpath("//button[@type='submit']")).click();
			 
	}
		
}

