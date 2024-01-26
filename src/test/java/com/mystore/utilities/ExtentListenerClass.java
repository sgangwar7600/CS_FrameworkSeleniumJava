package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	
	ExtentSparkReporter htmlRepoter;    //create object1
	ExtentReports reports;              //create object2
	ExtentTest test;					//create object3
	
	
	public void configureReport() {
		
		ReadConfig readConfig =   new ReadConfig();
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport -" + timestamp + ".html";

		htmlRepoter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName );  // what object we have created above, we initialize here
		reports = new ExtentReports(); // what object we have created above, we initialize here
		reports.attachReporter(htmlRepoter); // what object we have created above, we initialize here
		
		//add system information/environment info to reports
		
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "window 11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("user name:", "Prachi");
		
		
		//configuration to change look and feel of report
		htmlRepoter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlRepoter.config().setReportName("This is first report");
		htmlRepoter.config().setTheme(Theme.DARK);
		htmlRepoter.config().setTimeStampFormat("EEEE, MMMM dd , yyyy , hh:mm a '('zzz')'");

	}
	
		public void onStart(ITestContext Result) {
		
		configureReport();
		
		System.out.println("On Start method invoked....");
	}
	
	public void onFinish(ITestContext Result) {
		System.out.println("On Finished method invoked....");
		reports.flush();  //Writes test information from the started reporters to their output view 
		//it is mandatory to call flush method to ensure information is written to the started reporter.

	}
	
	//when test case get failed, this method is called
	public void onTestFailure(ITestResult Result) 					
	{		
		System.out.println("Name of test method failed:" + Result.getName() );  		
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
	
	String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";
	
	File screenShotFile = new File(screenShotPath);
	
	if(screenShotFile.exists())
	{
		test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		
	}
	}
	
	//when test case get skipped, this method is called
	public void onTestSkipped(ITestResult Result) 
	{
		System.out.println("Name of test method skipped : " + Result.getName() );
		
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skip test case is :" + Result.getName(), ExtentColor.YELLOW));
	}
	
	//when test case get started , this method is called
	public void onTestStart(ITestResult Result)  
	{
		System.out.println("Name of test method started : " + Result.getName() );
	}
	
	//when test case get passed, this method is called
	public void onTestSuccess(ITestResult Result) 
	{
		System.out.println("Name of test method sucessfully executed : " + Result.getName());
		
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the pass test case is :" + Result.getName(), ExtentColor.GREEN));
	
	}
	
	public void onTestFailedButWithInSuccessPercentage(ITestResult Result) {
		
	}
}
