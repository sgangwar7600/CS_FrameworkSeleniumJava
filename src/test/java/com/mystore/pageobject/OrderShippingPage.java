package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {

WebDriver ldriver;
	
	public OrderShippingPage(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
		}
	
	//identify the webElements
	
	@FindBy(name = "processCarrier")
	WebElement proceedShipping;
	
	@FindBy(id = "cgv")
	WebElement termOfServices;
	
	
	
	//identify the actions on WebElement
	public void clickOnProceedToCheckout() {
		proceedShipping.click();
	}
	public void selectTrmsOfServices() {
		termOfServices.click();
	}
	
}
