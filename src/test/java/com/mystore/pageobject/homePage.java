package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

WebDriver ldriver;
	
	public homePage(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	//identify the webElements
	
	@FindBy(xpath = "(//li[@class='alert alert-info'])[1]")
	WebElement alertForHomePage;
	
	@FindBy(xpath = "//li[@class='alert alert-info']")
	WebElement scrollToElement;
	
	//identify the action on WebElement
	public String  getTextOfAlertForHomePage() {
		
		return(alertForHomePage.getText());
	}
	
	public  void scrollToViewElement() {
		Actions actions = new Actions(ldriver);
		actions.moveToElement(scrollToElement).perform();
		
	}
	
}
