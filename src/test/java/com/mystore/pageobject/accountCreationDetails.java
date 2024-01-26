package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {

WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver) {   //constructor
	
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);	
	}
	
	//identify the webElements
	
	@FindBy(id  = "id_gender2")   //TitleMrs
	WebElement TitleMrs;
	
	@FindBy(id = "customer_firstname")
	WebElement custfirstName;
	
	@FindBy(id = "customer_lastname")
	WebElement custLastName;
	
	
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "submitAccount")
	WebElement submitAccount;
	
	//identify actions to be performed on web elements
	
	public void selectTitleMrs() {
		
		TitleMrs.click();
	}
	
	public void enterCustomerFirstName(String fname) {
		
		custfirstName.sendKeys(fname) ;
		}
	public void enterLastName(String lname) {
	
		custLastName.sendKeys(lname);
	}

	
	public void enterCustomerPassword(String enterPassword) {
		password.sendKeys(enterPassword);	
	}
	
	public void clickOnRegisterButton() {
		submitAccount.click();
	}
}
