package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;
import com.VMS.PageObject.vms_WebPagesPage;

public class TC_WebPagesTest extends BaseClass 

{
	
	@Test(priority = 1)
	public void AddWebPages() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openWebPagePage();
		log.info("Webpages page is opened");
		vms_WebPagesPage wb = new vms_WebPagesPage(driver);
		
		wb.clickOnNewWebpageBtn();
		log.info("clicked on NEW button.");
		wb.addWebPage("1. Alibaba", "http://www.alibaba.com");
		Thread.sleep(300);
		log.info("Alibaba webpage added.");
		wb.addWebPage("2. NDTV", "http://www.ndtv.com");
		Thread.sleep(300);
		log.info("NDTV webpage added.");
		wb.addWebPage("3. Vicon", "https://www.vicon.com/");
		Thread.sleep(300);
		log.info("Vicon webpage added.");
		wb.addWebPage("4. ZeeNews", "http://www.zeenews.com");
		Thread.sleep(300);
		log.info("ZeeNews webpage added.");
		wb.addWebPage("5. Selenium Dev", "https://www.selenium.dev/");
		Thread.sleep(300);
		log.info("Selenium webpage added.");
		wb.addWebPage("6. TestNG", "https://testng.org/doc/");
		Thread.sleep(300);
		log.info("TestNG webpage added.");
		wb.addWebPage("7. CemtrexLabs", "https://cemtrex.com/");
		Thread.sleep(500);	
		log.info("CemtrexLabs webpage added.");
	}
	
	
	@Test(priority = 2)
	public void deleteWebPages() throws Exception
	{
		
		/*
		 * vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		 * hm.openConfigurationPage(); log.info("Configuration page is opened");
		 * vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		 * cp.openWebPagePage(); log.info("Webpages page is opened");
		 */
		   		
		vms_WebPagesPage wb = new vms_WebPagesPage(driver); 
		wb.deleteAllWebPages();
		Thread.sleep(1000);
		
		if(wb.listOfAvailableWebPages.size() == 0)
           {
			    log.info("deleteWebPages  -  Passed. ");
	     		Assert.assertTrue(true);
	            log.info("All webpages are deleted.");
           }
           else 
           {
        	    log.info("deleteWebPages  -  Failed. ");
	     		capctureScreenshot(driver, "deleteWebPages");
	            log.info(" Something went wrong. All webpages are not deleted.");
	            Assert.assertTrue(false);
           }
	
	}
	
	
	
	
	
	

}
