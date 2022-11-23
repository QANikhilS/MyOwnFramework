package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_ConfigurationPageTest extends BaseClass
{
	
	@Test(priority = 1)
	public void OpenNVRsPage()
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openNVRsPage();
		
		String expectedURL = "http://localhost/#/configuration/devices/nvrs";
		String actualURL  = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);
		log.info("NVR page is opened successfully.");
	}
	
	
	
	@Test(priority = 2)
	public void OpenRNVRsPage()
	{
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openRNVRsPage();
		
		
		String expectedURL = "http://localhost/#/configuration/devices/nvr_redundancy";
		String actualURL  = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);
		log.info("RNVR page is opened successfully.");
	}
	
	
	@Test(priority = 3)
	public void OpenAnalyticsServersPage()
	{
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openAnalyticsServerPage();
		
		String expectedURL = "http://localhost/#/configuration/devices/analytics_server";
		String actualURL  = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);
		log.info("Analytics servers page is opened successfully.");
	}
	
	
	@Test(priority = 4)
	public void OpenVideoChannelsPage()
	{
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openVideoChannelsPage();
		
		String expectedURL = "http://localhost/#/configuration/network_entities/video_channels";
		String actualURL  = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);
		log.info("Video channels page is opened successfully.");
	}
	

	@Test(priority = 5)
	public void OpenAudioChannelsPage()
	{
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openAudioChannelsPage();
		
		String expectedURL = "http://localhost/#/configuration/network_entities/audioIn_channels";
		String actualURL  = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);
		log.info("Audio channels page is opened successfully.");
	}
	
	//@Test(priority = 6)
	public void OpenNumericIDPage()
	{
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openNumericIDsPage();
		
		String expectedURL = "http://localhost/#/configuration/network_entities/shortCutNm";
		String actualURL  = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL);
		log.info("Numeric IDs page is opened successfully.");
	}
	
	
	
	
}

