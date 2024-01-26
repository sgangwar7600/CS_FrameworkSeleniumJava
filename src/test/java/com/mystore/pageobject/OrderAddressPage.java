package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressPage {


WebDriver ldriver;
	
	public OrderAddressPage(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
		}
	
	//identify the webElements
	
	@FindBy(name = "processAddress")
	WebElement proceedfromAddressPage;
	
	//identify the actions on WebElement
	public void clickOnProceedToCheckout() {
		proceedfromAddressPage.click();
		
	}
	
	
}
