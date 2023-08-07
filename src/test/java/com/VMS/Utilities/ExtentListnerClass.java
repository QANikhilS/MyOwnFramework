package com.VMS.Utilities;

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

public class ExtentListnerClass implements ITestListener {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	
	public void configureReport()
	{
		readConfig rc = new readConfig();
		String timestamp = new SimpleDateFormat("dd.MM.yyyy "+"-"+" hh.mm.ss").format(new Date());
		String reportName = "VaxExecutionReport -" + timestamp + ".html";
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"\\Reports\\"+reportName);
		htmlReporter.config().setEncoding("utf-8");
		
		// Configuration to change feel and look of report.
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("VAX Test cases execution Report");
		htmlReporter.config().setTheme(Theme.DARK);	
		
		
		// this attaches to the report to above configured HTML report file in order to start .
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);	
		
		// add system information/environment info to reports
		reports.setSystemInfo("Machine", "NikhilShivarkarPC");   // key and value
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", rc.getBrowser());
		reports.setSystemInfo("VMS Version", rc.getAppServerVersion());
		reports.setSystemInfo("Username", "Nikhil");
	}
	
	
	
	// This method is called when first test execution Starts
	public void onStart(ITestContext Result)
	{
		configureReport();
		//System.out.println("On start this method invoked.");
	}
	
	
	// This method is called when all test cases execution is Finished.
	public void onFinish(ITestContext Result)
	{
		reports.flush();   // This method writes test information from the started reporters to their output view
		//System.out.println("On start this method invoked.");
	}
	
	
	// This method will execute when any test case gets failed.
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of the failed test method =" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case = "+ Result.getName(), ExtentColor.RED));
		
		String  ScreenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" +  Result.getName() + ".png";
		File screenshotFile = new File(ScreenShotPath);
		if (screenshotFile.exists())
		{
			test.fail("Captcured screenshot of failed test case is below : " + test.addScreenCaptureFromPath(ScreenShotPath));
		}
	    //test.addScreenCaptureFromPath(null);
	}
	
	
	// This method will execute when any test case gets Skipped.
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of the skipped test method =" + Result.getName());
		test = reports.createTest(Result.getName());    // To created any entery in HTML reporter. 
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case = "+ Result.getName(), ExtentColor.ORANGE));	
	}
	
	// This method will execute when any test case gets Passed.
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of the skipped test method =" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case = "+ Result.getName(), ExtentColor.GREEN));	
	}
	

	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of the test method started = " + Result.getName()); 
	}
	
	
	public void onTestFaulureWithinSuccessPercentrage(ITestResult Result)
	{
		
	}
	
	
}
