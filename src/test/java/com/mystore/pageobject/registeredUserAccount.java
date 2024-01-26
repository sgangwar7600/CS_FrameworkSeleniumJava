package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class registeredUserAccount {


	WebDriver ldriver;

	public registeredUserAccount(WebDriver rdriver) {   //constructor

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);	
	}

	//identify the webElements

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement userName;

	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	@FindBy(name = "search_query")
	WebElement searchBox;
	
	@FindBy(name = "submit_search")
	WebElement submit_search;
	
	
	
	//identify the actions on WebElement

	public void clickOnSignOut() {
		signOut.click();
	}
	
	public String getUserName() {

		String text = userName.getText();
		return text;
	}
	public void EnterDataInSearchBox(String searchKey) {
		searchBox.sendKeys(searchKey);
	}
	
	public void ClickOnSearchButton() {
		submit_search.click();
	}

}
