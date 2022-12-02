package com.VMS.TestCases;

import org.testng.annotations.Test;

import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;
import com.VMS.PageObject.vms_NetworkingPage;

public class TC_NetworkingPageTest extends BaseClass {
	
	@Test(priority = 0)
	public void enableVAXTab() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openNetworkingPage();
		log.info("Networking page is opened");
		Thread.sleep(1500);
		vms_NetworkingPage np = new vms_NetworkingPage(driver);
		
		if(np.verifyVAXtabIsEnabled().equalsIgnoreCase("Disabled"))
		{
		np.enabletheVAXIntegrationToggleBtn();
		log.info("VAX Integration toggle btn enabled");
		np.enterVAXIP("192.168.1.51");
		log.info("VAX IP is entered");
		np.clickOnSaveBtn();
		Thread.sleep(1500);
		}
		else
		{  log.info("VAX Tab is already enabled.");  }
	}
	
	@Test(priority = 1)
	public void verifyIntegratedVAX() throws Exception
	{
			vms_NetworkingPage np = new vms_NetworkingPage(driver);
		    np.verifyConfiguredVAX();
	}
	
	
}	