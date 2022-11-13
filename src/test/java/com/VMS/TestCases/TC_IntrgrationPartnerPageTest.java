package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;
import com.VMS.PageObject.vms_IntegrationPartnerPage;

public class TC_IntrgrationPartnerPageTest extends BaseClass{
	
	
	@Test(priority = 1)
	public void AddIntrgrationPartner()
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openIntegrationPartnerPage();
		log.info("Integration Partner page has been opened");
		
		vms_IntegrationPartnerPage ip = new vms_IntegrationPartnerPage(driver);
		ip.clickOnAddPartner();
		log.info("Add new Integration Partner form has been opened");
		ip.PartnerTypeAsAccessControl();
		log.info("Selected access control type");
		ip.PartnerNameAsVAX();
		log.info("Selected partner name ");
		ip.IntrgrationPartnerEnterName("VAX-54");
		log.info("Entered VAX name");
		ip.IntrgrationPartnerEnterIP("192.168.1.54");
		log.info("Entered VAX IP");
		ip.IntrgrationPartnerEnterUsername("vjathode@cemtrexlabs.com");
		log.info("Entered VAX Username");
		ip.IntrgrationPartnerEnterpassword("Cemtrex@321");
		log.info("Entered VAX password");
		ip.ClickOnNEXTbtn();
		ip.selectAllDoors();
		log.info("Selected all Doors");
		ip.ClickOnNEXTbtn();
		ip.ClickOnSAVEbtn();
		log.info("Integration Partner has been added");		
	}

	
	@Test(priority = 2)
	public void RefreshUserInformationfeature() throws Exception
	{
		
		  vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		  hm.openConfigurationPage(); vms_ConfigurationPage cp = new
		  vms_ConfigurationPage(driver); cp.openIntegrationPartnerPage();
		  log.info("Integration Partner page has been opened");
		
		Thread.sleep(2000);
		vms_IntegrationPartnerPage ip = new vms_IntegrationPartnerPage(driver);
		Thread.sleep(2000);
		ip.clickonRefreshUserInfo();
		log.info("Clicked on RefreshUserInfo button.");

		if (ip.refreshUserInfoConfirmationMessageWindowVisibility() == true)
		{
			String ExpectedConfirmationMsg = "User Information Refreshed Successfully";
			String ActualConfirmationMsg = ip.refreshUserInfoConfirmationMessage(); 
			
			if (ExpectedConfirmationMsg.equals(ActualConfirmationMsg))
			{
				log.info("RefreshUserInformationfeature  -  Passed. ");
				Assert.assertTrue(true);
				ip.clickOnOKbtn();
				log.info("User's Information has been refreshed successfully.");
			}
			else
			{
				log.info("RefreshUserInformationfeature  -  Failed. ");
				capctureScreenshot(driver, "RefreshUserInformationfeature");
				Assert.assertTrue(false);
			}
		}
		else 
		{
			log.info("RefreshUserInformationfeature  -  Failed. ");
			log.info("User information refreshed successfully ---- MESSAGE WINDOW IS NOT OPENED");
			capctureScreenshot(driver, "RefreshUserInformationfeature");
		}	   
	}	
	
	
	
	@Test(priority = 3, enabled = true)
	public void DeleteIntrgrationPartner() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openIntegrationPartnerPage();
		log.info("Integration Partner page has been opened");      
		
		Thread.sleep(2000);
		vms_IntegrationPartnerPage ip = new vms_IntegrationPartnerPage(driver);
		
		if (ip.listOfAvailableIPs()>0)
		{
			ip.deleteAnyIntegrationPartner();
			log.info(ip.deleteConfirmationMessage());
			ip.closeDeleteProcessWindow();
			log.info("Delete Device Progress window closed");
			//Assert.assertEquals("Deleted", ip.deleteConfirmationMessage());
		}
		else 
		{
			System.out.println("No integration partner is present in VMS.");
			log.info("No integration partner is present in VMS.");
		}
		
		
	}
	
	

	
}
