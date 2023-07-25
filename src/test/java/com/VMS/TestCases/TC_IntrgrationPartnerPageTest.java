package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_IntegrationPartnerPage;
import com.VMS.PageObject.vms_ProcedurePage;

public class TC_IntrgrationPartnerPageTest extends BaseClass
{
	public vms_IntegrationPartnerPage Integrationpartner ;
	
    @BeforeClass
	public void OpenIntegrationPartnerPage() throws Exception 
	{
    	Integrationpartner = new vms_IntegrationPartnerPage(driver);
	}
	
	@Test(priority = 0)
	public void verifyIntegrationPartnerPageIsOpened()
	{
		if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/procedures"))
    	{    Assert.assertTrue(true, "Integration Partner is successfuly opened.");       log.info("Integration Partner is successfuly opened.");  	}
    	else 
    	{   capctureScreenshot(driver, "verifyIntegrationPartnerPageIsOpened");
			log.info(" Something went wrong. Integration Partner page is not opened");
    		Assert.assertTrue(false, "Integration Partner is not opened");
    	}
	}
	
	
	
	
	
	
	
	@Test(priority = 1, groups = {"Setup", "SetupVAX"}, dependsOnMethods = {"openIntegrationPartnerpage"})
	public void AddIntrgrationPartner2_54()
	{
		String ExpectedIPtoAdd = "192.168.1.54";
		Integrationpartner.clickOnAddPartner();
		log.info("Add new Integration Partner form has been opened");
		Integrationpartner.PartnerTypeAsAccessControl();
		log.info("Selected access control type");
		Integrationpartner.PartnerNameAsVAX();
		log.info("Selected partner name as VAX");
		Integrationpartner.IntrgrationPartnerEnterName("VAX2.1_1");
		log.info("Entered VAX name");
		Integrationpartner.IntrgrationPartnerEnterIP(ExpectedIPtoAdd);
		log.info("Entered VAX IP");
		Integrationpartner.IntrgrationPartnerEnterUsername("vjathode@cemtrexlabs.com");
		log.info("Entered VAX Username");
		Integrationpartner.IntrgrationPartnerEnterpassword("Cemtrex@321");
		log.info("Entered VAX password");
		Integrationpartner.ClickOnNEXTbtn();
		log.info("Clicked on Next button.");
		Integrationpartner.selectAllDoors();
		log.info("Selected all Doors");
		Integrationpartner.ClickOnNEXTbtn();
		log.info("Clicked on Next button.");
		Integrationpartner.ClickOnSAVEbtn();
		log.info("Clicked on SAVE button.");	
        BaseClass.wait(2000);
		
		String ActualIP = Integrationpartner.getaddedIntegrationPartnerIP();
		Assert.assertEquals(ExpectedIPtoAdd, ActualIP, "Integration Partner is added Successfully.");
	}
	
	@Test(priority = 2 , dependsOnMethods = {"openIntegrationPartnerpage"})
	public void RefreshUserInformationfeature() throws Exception
	{
		BaseClass.wait(2000);	
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

	@Test(priority = 3, enabled = true)
	public void DeleteIntrgrationPartner() throws Exception
	{
		BaseClass.wait(2000);		
		if (Integrationpartner.listOfAvailableIPs()>0)
		{
			Integrationpartner.deleteAnyIntegrationPartner();
			log.info(Integrationpartner.deleteConfirmationMessage());
			Integrationpartner.closeDeleteProcessWindow();
			log.info("Delete Device Progress window closed");
			Assert.assertEquals("Deleted", Integrationpartner.deleteConfirmationMessage());
		}
		else 
		{
			System.out.println("No integration partner is present in VMS.");
			log.info("No integration partner is present in VMS.");
		}
	}
	
	@Test(priority = 4, groups = {"Setup", "SetupVAX"}, dependsOnMethods = {"openIntegrationPartnerpage"})
	public void AddIntrgrationPartner1_51()
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
		log.info("Clicked on Next button.");
		Integrationpartner.selectAllDoors();
		log.info("Selected all Doors");
		Integrationpartner.ClickOnNEXTbtn();
		log.info("Clicked on Next button.");
		Integrationpartner.ClickOnSAVEbtn();
		log.info("Clicked on SAVE button.");	
		BaseClass.wait(2000);
		
		String ActualIP = Integrationpartner.getaddedIntegrationPartnerIP();
		Assert.assertEquals(ExpectedIPtoAdd, ActualIP, "Integration Partner is added Successfully.");
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
	
}
