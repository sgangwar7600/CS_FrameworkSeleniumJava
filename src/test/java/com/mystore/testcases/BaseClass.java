package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;
import org.apache.logging.log4j.Logger;
import com.mystore.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	
	String  baseurl = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	
	public String emailAddress = readConfig.getEmail();
	public String password = readConfig.getPassword();
	
	public static WebDriver driver ;          //creating object of webdriver
	
	public static Logger Logger ;
	
	@BeforeClass
	public void setup() {
		
		switch(browser.toLowerCase()) {
		
		
		case "chrome":
			//WebDriverManager.chromedriver().clearDriverCache().setup();
			//WebDriverManager.chromedriver().clearResolutionCache().setup();
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashikant\\eclipse-workspace\\MyStoreV1\\Driver\\chromedriver.exe");
			//WebDriverManager.chromedriver().driverVersion("120.0.6099.225").setup();
			//WebDriverManager.chromedriver().clearDriverCache();

			//WebDriverManager.chromedriver().setup();
			
			
			WebDriverManager.chromedriver().getDownloadedDriverVersion();
			driver = new ChromeDriver();
			break;
		
		case "msedge":
			//WebDriverManager.edgedriver().getDownloadedDriverVersion();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			//WebDriverManager.firefoxdriver().getDownloadedDriverVersion();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
			default:
				driver = null;
				break;	
		}
	
		//implicit wait of 10 second
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//maximize the browser
		driver.manage().window().maximize();
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//for logging , we will initialize
		Logger =  LogManager.getLogger("MyStoreV1");
		
		//open url
		//driver.navigate().to(url);
		driver.get(baseurl);
		Logger.info("url open");
	}
	
		
	
	  @AfterClass
	  public void tearDown() 
	  { 
		  driver.close();
		  driver.quit();
	  }
	 

	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert web driver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
	  
	  
	}
	

