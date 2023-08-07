package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_NetworkingPage;

public class TC_NetworkingPageTest extends BaseClass 
{
<<<<<<< HEAD
=======
    public vms_NetworkingPage networking ;
	
    @BeforeClass
	public void OpenNetworkingPage() throws Exception 
	{
    	networking = new vms_NetworkingPage(driver);
	}
    	
    
    @Test(priority = 0)
    public void verifyNetworkingPageisOpened()
    {
    	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/procedures"))
    	{    Assert.assertTrue(true, "Networking page is successfuly opened.");       log.info("Networking page is successfuly opened.");  	}
    	else 
    	{   capctureScreenshot(driver, "verifyNetworkingPageisOpened");
			log.info(" Something went wrong. Networking page is not opened");
    		Assert.assertTrue(false, "Networking page is not opened");
    	}
	}
>>>>>>> 2a100a0fd94d72e8f3a4f35948a220a30992cf2c
	
	public static vms_NetworkingPage networking;
	
    @BeforeClass
	public void OpenNetworkingPage() throws Exception 
	{
    	networking = new vms_NetworkingPage(driver);
    }
    
    //@Test(priority = 0)
    public void verifyNetworkingPageisOpened()
    {  
    	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/system/system_settings"))
	       {    Assert.assertTrue(true, "Networking page is successfuly opened.");   log.info("Networking page is successfuly opened.");     	}
	   else 
	       {   capctureScreenshot(driver, "verifyNetworkingPageisOpened");
		       log.info(" Something went wrong. Networking page is not opened");
		       Assert.assertTrue(false, "Networking page is not opened");
	       }
    }
	
    
	@Test(priority = 0,  groups = {"Setup", "SetupVAX"})
	public void enableVAXTab() throws Exception
	{
		if(networking.verifyVAXtabIsEnabled().equalsIgnoreCase("Disabled"))
		{
		   networking.openNetworingPage();
		   networking.enabletheVAXIntegrationToggleBtn();
		   log.info("VAX Integration toggle btn enabled");
		   networking.enterVAXIP("192.168.1.51");
		   log.info("VAX IP is entered");
		   networking.clickOnSaveBtn();
		   BaseClass.wait(1500);
		}
		else
		{  log.info("VAX Tab is already enabled.");  }
	}
	
	@Test(priority = 1, groups = "Setup")
	public void verifyIntegratedVAX() throws Exception
	{
		networking.verifyConfiguredVAX();
	}
	
	
}	