package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;
import junit.framework.Assert;

public class TC_MyAccountPageTest extends BaseClass {

	@Test(enabled = false)
	public void verifyRegisterationAndLogin() {

		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		Logger.info("click on sign in button");

		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterCreateEmailAddress("cs1212123321123@gmail.com");
		Logger.info("email address and create account section");

		myAcpg.clickSubmitCreate();
		Logger.info("click on create an account button ");

		accountCreationDetails accCreationPg = new accountCreationDetails(driver);
		accCreationPg.selectTitleMrs();
		accCreationPg.enterCustomerFirstName("Prachi");
		accCreationPg.enterLastName("Gupta");
		accCreationPg.enterCustomerPassword("Pass@12121232");


		accCreationPg.clickOnRegisterButton();
		Logger.info("clicked on Register button");

		registeredUserAccount regUser = new registeredUserAccount(driver); String
		userName = regUser.getUserName();

		Assert.assertEquals("Prachi Gupta", userName);  //for verifying
	}

	@Test
	public void VerifyLogin()   throws IOException {
		
		Logger.info("verifylogin execution stared");

		indexPage pg = new indexPage(driver);
		
		pg.clickOnSignIn();
		Logger.info("click on sign In link");


		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterEmailAddress("cs1212123321123@gmail.com");
		Logger.info("enter email");

		myAcpg.enterPassword("Pass@12121232");
		Logger.info("enter password");

		myAcpg.clickSignIn();
		Logger.info("click on submit login button");

		
		registeredUserAccount regUser = new registeredUserAccount(driver); 
		String userName = regUser.getUserName();
		
		if (userName.equals("Prachi Gupta")) 
		{
			Logger.info("VerifyLogin - Passed");
			regUser.clickOnSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			Logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}

		Logger.info("***************TestCase Verify Login ends*****************"); 
	}
	
	@Test	
	public void VerifySignOut() throws IOException {
		
		Logger.info("********************TestCase Verify Sign Out Starts**************************************");
		
		indexPage pg = new indexPage(driver);
		
		pg.clickOnSignIn();
		Logger.info("click on sign In link");


		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterEmailAddress("cs1212123321123@gmail.com");
		Logger.info("enter email");

		myAcpg.enterPassword("Pass@12121232");
		Logger.info("enter password");

		myAcpg.clickSignIn();
		Logger.info("click on submit login button");
		
		registeredUserAccount regUser = new registeredUserAccount(driver); 
		regUser.clickOnSignOut();
		
		if(pg.getPageTitle().equals("Login - My Store")) {
			
			Logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}
		else {
			Logger.info("VerifySignOut - Failed");
			captureScreenShot(driver, "VerifySignOut");
			Assert.assertFalse(false);
		}	
}
	}
