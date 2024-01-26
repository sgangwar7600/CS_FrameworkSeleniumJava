package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

WebDriver ldriver;
	
	public OrderConfirmationPage(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
		}
	
	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement confirmOrder;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement successAlert;
	
	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	public void clickOnConfirmOrder() {
		confirmOrder.click();
	}
	
	public void clickOnSignOut() {
		signOut.click();
	}
	public String getOrderSuccessMessage() {
		return(successAlert.getText());
	}
	
}
