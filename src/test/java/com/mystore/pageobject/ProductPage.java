package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	//1. create object of webdriver

	@FindBy(id = "quantity_wanted")
	WebElement quantityWanted;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(name = "Submit")
	WebElement addToCard ;
	
	@FindBy(linkText ="Proceed to checkout")
	WebElement proceed;
	
	//identify the webElements
	
	public void setQuantity(String qty) {
		
		quantityWanted.clear();
		quantityWanted.sendKeys(qty);
	}
	
	public void  setSize(String sizeType) {
		
		Select oSelect = new Select(size);
		oSelect.selectByVisibleText(sizeType);	
	}
	public void clickOnAddToCart( ) {
		addToCard.click();
	}
	
	public void clickOnProceedToCheckOut( ) {
		proceed.click();
	}
}
