package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {

WebDriver ldriver;
	
	public OrderPaymentPage(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
		}
	
	//identify the webElements
	
	@FindBy(xpath  = "//a[@title='Pay by check.']")
	WebElement payByCheque;
	
	@FindBy(xpath  = "//a[@title='Pay by bank wire']")
	WebElement PayByBankWire;
	
	public String getPageTitle() {
	
		return (ldriver.getCurrentUrl());
	}
	
	public void clickOnPayByCheque() {
		payByCheque.click();
	}
	
	public void clickOnPayByWire() {
		PayByBankWire.click();
	}
}
