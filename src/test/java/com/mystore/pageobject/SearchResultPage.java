package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	
	WebDriver ldriver;

	public SearchResultPage(WebDriver rdriver) {   //constructor

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);  //driver that will be used to lookup the web element	
	}
	
	
	//identify the elements present in search result page
	
	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']" )
	WebElement searchResultProduct;
	
	//@FindBy(linkText = "More")
	@FindBy(xpath = "//div[@class='right-block']")
	WebElement hoverMore;
	
	@FindBy(linkText  = "More")
	WebElement ClickOnMore;
	
	//identify the action on web elements of search result page
	
	public String getSearchResultProductName( ) {
		return (searchResultProduct.getText());
	}
	
	public void hoverToMoreLink(){

		Actions actions = new Actions(ldriver);
		actions.moveToElement(hoverMore).perform();

		}
	public void ClickOnMoreLink() {
		ClickOnMore.click();
	}
	
}
