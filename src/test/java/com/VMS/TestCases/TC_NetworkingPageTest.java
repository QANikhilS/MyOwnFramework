package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_NetworkingPageTest extends BaseClass {
	
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
		   Thread.sleep(1500);
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