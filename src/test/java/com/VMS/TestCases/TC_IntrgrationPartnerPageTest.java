package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_IntrgrationPartnerPageTest extends BaseClass{
	
	@Test(priority = 0)
	public void openIntegrationPartnerpage()
	{
		Integrationpartner.openIntegrationPartnerPage();
	}
	
	
	
	@Test(priority = 1, groups = {"Setup", "SetupVAX"}, dependsOnMethods = {"openIntegrationPartnerpage"})
	public void AddIntrgrationPartner()
	{
		String ExpectedIPtoAdd = "192.168.1.51";
		Integrationpartner.clickOnAddPartner();
		log.info("Add new Integration Partner form has been opened");
		Integrationpartner.PartnerTypeAsAccessControl();
		log.info("Selected access control type");
		Integrationpartner.PartnerNameAsVAX();
		log.info("Selected partner name as VAX");
		Integrationpartner.IntrgrationPartnerEnterName("VAX3.1");
		log.info("Entered VAX name");
		Integrationpartner.IntrgrationPartnerEnterIP(ExpectedIPtoAdd);
		log.info("Entered VAX IP");
		Integrationpartner.IntrgrationPartnerEnterUsername("ADMIN");
		log.info("Entered VAX Username");
		Integrationpartner.IntrgrationPartnerEnterpassword("Cemtrex@123");
		log.info("Entered VAX password");
		Integrationpartner.ClickOnNEXTbtn();
		Integrationpartner.selectAllDoors();
		log.info("Selected all Doors");
		Integrationpartner.ClickOnNEXTbtn();
		Integrationpartner.ClickOnSAVEbtn();
		log.info("Integration Partner has been added");	
		try { Thread.sleep(2000); } catch (InterruptedException e) {   e.printStackTrace();  }
		
		String ActualIP = Integrationpartner.getaddedIntegrationPartnerIP();
		Assert.assertEquals(ExpectedIPtoAdd, ActualIP, "Integration Partner is added Successfully.");
	
	}

	//@Test(priority = 2, groups = {"Setup", "SetupVAX"}, dependsOnMethods = {"openIntegrationPartnerpage"})
	public void AddIntrgrationPartner2_10_54()
	{
		Integrationpartner.clickOnAddPartner();
		log.info("Add new Integration Partner form has been opened");
		Integrationpartner.PartnerTypeAsAccessControl();
		log.info("Selected access control type");
		Integrationpartner.PartnerNameAsVAX();
		log.info("Selected partner name as VAX");
		Integrationpartner.IntrgrationPartnerEnterName("VAX2.1_1");
		log.info("Entered VAX name");
		Integrationpartner.IntrgrationPartnerEnterIP("192.168.1.54");
		log.info("Entered VAX IP");
		Integrationpartner.IntrgrationPartnerEnterUsername("vjathode@cemtrexlabs.com");
		log.info("Entered VAX Username");
		Integrationpartner.IntrgrationPartnerEnterpassword("Cemtrex@321");
		log.info("Entered VAX password");
		Integrationpartner.ClickOnNEXTbtn();
		Integrationpartner.selectAllDoors();
		log.info("Selected all Doors");
		Integrationpartner.ClickOnNEXTbtn();
		Integrationpartner.ClickOnSAVEbtn();
		log.info("Integration Partner has been added");		
	}
	
	
	//@Test(priority = 2, groups = {"Setup", "SetupVAX"}, dependsOnMethods = "openIntegrationPartnerpage")
	public void AddIntrgrationPartner2_10_68()
	{
		Integrationpartner.clickOnAddPartner();
		log.info("Add new Integration Partner form has been opened");
		Integrationpartner.PartnerTypeAsAccessControl();
		log.info("Selected access control type");
		Integrationpartner.PartnerNameAsVAX();
		log.info("Selected partner name as VAX");
		Integrationpartner.IntrgrationPartnerEnterName("VAX2.1_2");
		log.info("Entered VAX name");
		Integrationpartner.IntrgrationPartnerEnterIP("192.168.1.68");
		log.info("Entered VAX IP");
		Integrationpartner.IntrgrationPartnerEnterUsername("vjathode@cemtrexlabs.com");
		log.info("Entered VAX Username");
		Integrationpartner.IntrgrationPartnerEnterpassword("Cemtrex@321");
		log.info("Entered VAX password");
		Integrationpartner.ClickOnNEXTbtn();
		Integrationpartner.selectAllDoors();
		log.info("Selected all Doors");
		Integrationpartner.ClickOnNEXTbtn();
		Integrationpartner.ClickOnSAVEbtn();
		log.info("Integration Partner has been added");		
	}
	
	
	//@Test(priority = 3 , dependsOnMethods = {"openIntegrationPartnerpage"})
	public void RefreshUserInformationfeature() throws Exception
	{
			
		Thread.sleep(2000);
		Integrationpartner.clickonRefreshUserInfo();
		log.info("Clicked on RefreshUserInfo button.");

		if (Integrationpartner.refreshUserInfoConfirmationMessageWindowVisibility() == true)
		{
			String ExpectedConfirmationMsg = "User Information Refreshed Successfully";
			String ActualConfirmationMsg = Integrationpartner.refreshUserInfoConfirmationMessage(); 
			
			if (ExpectedConfirmationMsg.equals(ActualConfirmationMsg))
			{
				log.info("RefreshUserInformationfeature  -  Passed. ");
				Assert.assertTrue(true);
				Integrationpartner.clickOnOKbtn();
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
	
	
	
	//@Test(priority = 4, enabled = true)
	public void DeleteIntrgrationPartner() throws Exception
	{
				
		Thread.sleep(2000);
				
		if (Integrationpartner.listOfAvailableIPs()>0)
		{
			Integrationpartner.deleteAnyIntegrationPartner();
			log.info(Integrationpartner.deleteConfirmationMessage());
			Integrationpartner.closeDeleteProcessWindow();
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
