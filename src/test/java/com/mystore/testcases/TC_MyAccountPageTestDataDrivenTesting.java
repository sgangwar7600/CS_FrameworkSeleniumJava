package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {

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

	
	@Test(dataProvider = "LoginDataProvider")
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername )   throws IOException {
		
		Logger.info("****************TestCase VerifyLogin Starts*********************");

		indexPage pg = new indexPage(driver);
		
		pg.clickOnSignIn();
		Logger.info("click on sign In link");
				
		
		myAccountPage myAcpg = new myAccountPage(driver);
		
		myAcpg.enterEmailAddress(userEmail);
		Logger.info("enter email");
		
		myAcpg.enterPassword(userPwd);
		Logger.info("enter password");
		
		myAcpg.clickSignIn();
		Logger.info("click on submit login button");

		registeredUserAccount regUser = new registeredUserAccount(driver); 
		String userName = regUser.getUserName();
		
		if (userName.equals(expectedUsername)) 
		{
			Logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			
			regUser.clickOnSignOut();
		}
		else
		{
			Logger.info("VerifyLogin - Failed");
			captureScreenShot(driver , "VerifyLogin");
			Assert.assertTrue(false);
		}	
		
		
		
	}
	
	@DataProvider(name = "LoginDataProvider")
	
	public String[][] LoginDataProvider  ()
	{
		//System.out.println(System.getProperty("user.dir"));
		
		String fileName = System.getProperty("user.dir") + "\\Test Data\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		System.out.println(ttlRows);
		
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows; i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}
}
