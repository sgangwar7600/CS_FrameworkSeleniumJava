package com.mystore.testcases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

import com.mystore.pageobject.OrderAddressPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.homePage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseClass {

	@Test (priority=3)
	public void VerifySearchProduct() throws IOException {
		
		
		String searchKey = "T-shirts";
		
		String email = emailAddress;
		String pwd = password ;
		
		Logger.info("****************TestCase Search product  Started*********************");

		indexPage pg = new indexPage(driver);
		
		//sign in
		pg.clickOnSignIn();
		Logger.info("click on sign In link");
				
		
		myAccountPage myAcpg = new myAccountPage(driver);
		
		//enter account details - email and password
		myAcpg.enterEmailAddress(email);
		Logger.info("enter email");
		
		myAcpg.enterPassword(pwd);
		Logger.info("enter password");
		
		myAcpg.clickSignIn();
		Logger.info("click on submit login button");
		
		
		//enter search key in search box
		registeredUserAccount productPg = new registeredUserAccount(driver); 

		productPg.EnterDataInSearchBox(searchKey);
		productPg.ClickOnSearchButton();
		
		//get name of search product
		SearchResultPage resultpg  = new SearchResultPage(driver);
		String SearchResultProductName = resultpg.getSearchResultProductName();
	
		//verify the correct product is displaying after search
		if(SearchResultProductName.contains(searchKey))
		{
			
			Assert.assertTrue(true);
			Logger.info("Search Product Testcase - Passed");
			productPg.clickOnSignOut();
			} 
		
		else 
			
		{
			Logger.info("Search Product Testcase - Failed");
			Assert.assertFalse(false);
			captureScreenShot(driver, "verifySearchProduct");

		}	
	}
	
	@Test (priority=2)
	public void VerifyBuyProduct() throws IOException, InvocationTargetException {
		
		String email = emailAddress;
		String pwd = password ;
		
		
		Logger.info("\n***************TestCase Buy Product started*****************"); 
		
		//sign in
		indexPage indexpg = new indexPage(driver);
		indexpg.clickOnSignIn();
		Logger.info("click on sign In link");
				
		//enter account details - email and password
		myAccountPage pg = new myAccountPage(driver);
		pg.enterEmailAddress(email);
		Logger.info("enter email");
		
		pg.enterPassword(pwd);
		Logger.info("enter password");
		
		pg.clickSignIn();
		Logger.info("Sign In Link Click");
		
		//enter search key in search box
		registeredUserAccount prodCatPg = new registeredUserAccount(driver); 

		prodCatPg.EnterDataInSearchBox("T-shirts");
		Logger.info("T-shirt entered in search box");
		
		prodCatPg.ClickOnSearchButton();
		Logger.info("clicked on search button");

		//get name of search product
		SearchResultPage searchResultPg  = new SearchResultPage(driver);
		
		searchResultPg.hoverToMoreLink();
		Logger.info("Clicked on more button");
		searchResultPg.ClickOnMoreLink();
		
		Logger.info("Clicked on more button");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductPage prodPg = new ProductPage(driver);
		prodPg.setQuantity("2");
		Logger.info("quantity 2 entered");
		
		prodPg.setSize("M");
		Logger.info("Size M entered");
		
		prodPg.clickOnAddToCart();
		Logger.info("Click on add to cart");
		
		prodPg.clickOnProceedToCheckOut();
		Logger.info("click to proceed to checkout on product page");

		
		OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
		orderSumPg.clickOnProceedToCheckout();
		Logger.info("Click on proceed to checkout on order summary page");

		OrderAddressPage orderAddPg = new OrderAddressPage(driver);
		orderAddPg.clickOnProceedToCheckout();
		Logger.info("Click on proceed to checkout on order address page");

		OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
		orderShippingPg.selectTrmsOfServices();
		Logger.info("Select term of service check box");

		orderShippingPg.clickOnProceedToCheckout();
		Logger.info("Click on proceed to checkout on order shipping page");

		OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
		Logger.info(orderPaymentPg.getPageTitle());
		
		orderPaymentPg.clickOnPayByCheque();
		Logger.info("Clicked on pay by cheque");

		OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
		orderConfirmPg.clickOnConfirmOrder();
		
		Logger.info("Click on confirm order");
		
		String sucessMsg =  orderConfirmPg.getOrderSuccessMessage();
				
		if(sucessMsg.equals("Your order on My Shop is complete."))
		{
			Logger.info("VerifyBuyProduct - Passed");
			Assert.assertTrue(true);
			
			orderConfirmPg.clickOnSignOut();	
		}
		else
		{
			Logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver, "VerifyBuyProduct");
			Assert.assertFalse(false);
		}

		Logger.info("************************TestCase BuyProduct ends**********************************");
	}
	
	
	@Test (priority=1)
	public void verifyTextOnHomePage() throws IOException
	{
		
		
		Logger.info("\n***********verify Text On HomePage started************"); 

		homePage homePg = new homePage(driver);
		
		homePg.scrollToViewElement();
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	
		String actualAlertMsg = homePg.getTextOfAlertForHomePage();
		String expectedAlertMsg = "No featured products at this time.";

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(actualAlertMsg.equals(expectedAlertMsg))
		{
			Logger.info("verifyTextOnHomePage - passed"); 
			Assert.assertTrue(true);
		}
		else
		{
			Logger.info("verifyTextOnHomePage - failed"); 
			captureScreenShot(driver,"verifyTextOnHomePage");
			Assert.assertTrue(false);
		}
		
	}
	
}





















