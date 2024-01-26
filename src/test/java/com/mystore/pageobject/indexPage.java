package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	//1. create object of webdriver
	
	WebDriver ldriver;
	
	public indexPage(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	//identify the webElements
	
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	//identify the action on WebElement
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public String getPageTitle() {
		
		return(ldriver.getTitle());
	}
	
	
	
	
}
