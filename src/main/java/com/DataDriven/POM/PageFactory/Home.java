package com.DataDriven.POM.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DataDriven.POM.TestBase.BaseEngine;
import com.relevantcodes.extentreports.LogStatus;

public class Home extends BaseEngine {
	
	@FindBy(how=How.LINK_TEXT,using="HOME")
	static WebElement home;
	
	@FindBy(how=How.LINK_TEXT,using="ABOUT US")
	static WebElement about_us;
	
	@FindBy(how=How.LINK_TEXT,using="DOWNLOADS")
	static WebElement downloads;
	
	@FindBy(how=How.LINK_TEXT,using="GALLERY")
	static WebElement gallery;
	
	@FindBy(how=How.LINK_TEXT,using="CAREERS")
	static WebElement careers;
	
	@FindBy(how=How.LINK_TEXT,using="CONTACT US")
	static WebElement contactsus;
	
	@FindBy(how=How.XPATH,using=" //span[contains(text(),'Register')][@class='mb_nn']")
	static WebElement register;
	
	@FindBy(how=How.XPATH,using="//span[normalize-space()='Login']")
	static WebElement login;
	
	public static void home() {
		if (home.isDisplayed()&& home.isEnabled()) {
			home.click();	
			getDriver().switchTo().alert().dismiss();
			System.out.println("Home Is Clicking");
			
		}	
		else {
			System.out.println("Home Page not Clicking");
		}
		
	}
	public static void About_Us() {
		if (about_us.isDisplayed()&& about_us.isEnabled()) {
			about_us.click();
			
		}
	}
	
	public static void Downloads() {
		if (downloads.isDisplayed()&&downloads.isEnabled()) {
			downloads.click();
			
		}
	}
	
	public static void Gallery() {
		if (gallery.isDisplayed()&&gallery.isEnabled()) {
			gallery.click();			
		}		
	}
	
	public static  void Carrers() {
		if (careers.isDisplayed()&&careers.isEnabled()) {
			careers.click();
			
		}
	}
	
	public static void Contact_us() {
		if (contactsus.isDisplayed()&&contactsus.isEnabled()) {
			contactsus.click();
			
		}
	}
	
	public static void Register() {
		if (register.isDisplayed()&&register.isEnabled()) {
			register.click();
			System.out.println("Rigister Is Clicking");
			getExtentTest().log(LogStatus.PASS, "Clicking To Register");
			String text=getDriver().findElement(By.xpath("//h4[contains(text(),'REGISTER')]")).getText().trim();			
			Assert.assertEquals(text, "REGISTER");
			WebElement imagepath =getDriver().findElement(By.xpath("//div[@class='col-md-5 signup-greeting overlay']"));
			if (imagepath.isDisplayed()) {
				System.out.println("Image Is Displayed");
				System.out.println("The Imge Text Is :" +imagepath.getAttribute("style"));
			}
			//System.out.println("Navigate To Home Page");
			
		}
		else {
			System.out.println("Image Not Displayed");
			getExtentTest().log(LogStatus.FAIL, "Not Clicked On Register");
		}
	}
	
	public static void Login() {
		if (login.isDisplayed()&&login.isEnabled()) {
			login.click();
			getExtentTest().log(LogStatus.PASS, "Clicking To Login Button");
			
		}
		else {
			getExtentTest().log(LogStatus.FAIL, "Not Clicking To Login Button");
			
		}
	}
	static {
		PageFactory.initElements(getDriver(), Home.class);
	}
	
	
	
	
	
	
	
	
	
	
	

}
