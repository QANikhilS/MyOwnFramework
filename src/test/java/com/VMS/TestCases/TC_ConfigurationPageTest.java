package com.VMS.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_ConfigurationPageTest extends BaseClass
{
	
	@Test(priority = 1)
	public void OpenNVRsPage() throws Exception
	{
		log.info("************  Test Case - OpenNVRsPage is started ************");	
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openNVRsPage();
		
		String expectedURL = "http://localhost/#/configuration/devices/nvrs";
		String actualURL  = driver.getCurrentUrl();
		
		if(expectedURL.equalsIgnoreCase(actualURL))
		{
			Assert.assertTrue(true);
			log.info("OpenNVRsPage  -  Passed.");
		}
		else
		{
			capctureScreenshot(driver, "OpenNVRsPage");
			log.info("OpenNVRsPage  -  Failed.");	
			Assert.assertTrue(false);
		}
	    
		log.info("************  Test Case - OpenNVRsPage is finished ************");	
	}
	
	
	
	@Test(priority = 2)
	public void OpenRNVRsPage() throws Exception
	{
		log.info("************  Test Case - OpenRNVRsPage is started ************");	
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openRNVRsPage();
		
		
		String expectedURL = "http://localhost/#/configuration/devices/nvr_redundancy";
		String actualURL  = driver.getCurrentUrl();
		
		if(expectedURL.equalsIgnoreCase(actualURL))
		{
			Assert.assertTrue(true);
			log.info("OpenRNVRsPage  -  Passed.");
		}
		else
		{
			capctureScreenshot(driver, "OpenRNVRsPage");
			log.info("OpenRNVRsPage  -  Failed.");		
			Assert.assertTrue(false);
		}
		log.info("************  Test Case - OpenRNVRsPage is finished ************");
	}
	
	
	@Test(priority = 3)
	public void OpenAnalyticsServersPage() throws Exception
	{
		log.info("************  Test Case - OpenAnalyticsServersPage is started ************");	
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openAnalyticsServerPage();
		
		String expectedURL = "http://localhost/#/configuration/devices/analytics_server";
		String actualURL  = driver.getCurrentUrl();

		if(expectedURL.equalsIgnoreCase(actualURL))
		{
			Assert.assertTrue(true);
			log.info("OpenAnalyticsServersPage  -  Passed.");
		}
		else
		{
			capctureScreenshot(driver, "OpenAnalyticsServersPage");
			log.info("OpenAnalyticsServersPage  -  Failed.");	
			Assert.assertTrue(false);
		}
		
		log.info("************  Test Case - OpenAnalyticsServersPage is finished ************");	
	}
	
	
	@Test(priority = 4)
	public void OpenVideoChannelsPage() throws Exception
	{
		log.info("************  Test Case - OpenVideoChannelsPage is started ************");	
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openVideoChannelsPage();
		
		String expectedURL = "http://localhost/#/configuration/network_entities/video_channels";
		String actualURL  = driver.getCurrentUrl();

		if(expectedURL.equalsIgnoreCase(actualURL))
		{
			Assert.assertTrue(true);
			log.info("OpenVideoChannelsPage  -  Passed.");
		}
		else
		{
			capctureScreenshot(driver, "OpenVideoChannelsPage");
			log.info("OpenVideoChannelsPage  -  Failed.");	
			Assert.assertTrue(false);
		}
		log.info("************  Test Case - OpenVideoChannelsPage is finished ************");	
	}
	

	@Test(priority = 5)
	public void OpenAudioChannelsPage() throws Exception
	{
		log.info("************  Test Case - OpenAudioChannelsPage is started ************");	
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openAudioChannelsPage();
		
		String expectedURL = "http://localhost/#/configuration/network_entities/audioIn_channels";
		String actualURL  = driver.getCurrentUrl();
		
		if(expectedURL.equalsIgnoreCase(actualURL))
		{
			Assert.assertTrue(true);
			log.info("OpenAudioChannelsPage  -  Passed.");
		}
		else
		{
			capctureScreenshot(driver, "OpenAudioChannelsPage");
			log.info("OpenAudioChannelsPage  -  Failed.");	
			Assert.assertTrue(false);
		}
		
		log.info("************  Test Case - OpenAudioChannelsPage is finished ************");	
	}
	
	@Test(priority = 6)
	public void OpenNumericIDPage() throws Exception
	{
		log.info("************  Test Case - OpenNumericIDPage is started ************");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openNumericIDsPage();
		
		String expectedURL = "http://localhost/#/configuration/network_entities/shortCutNm";
		String actualURL  = driver.getCurrentUrl();
		
		if(expectedURL.equalsIgnoreCase(actualURL))
		{
			Assert.assertTrue(true);
			log.info("OpenNumericIDPage  -  Passed.");
		}
		else
		{
			capctureScreenshot(driver, "OpenNumericIDPage");
			log.info("OpenNumericIDPage  -  Failed.");	
			Assert.assertTrue(false);
		}
		log.info("************  Test Case - OpenNumericIDPage is finished ************");
	}
	
	
	
	
}

