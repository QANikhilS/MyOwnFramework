package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_RelayOutputPage;

public class TC_RelayOutputTest extends BaseClass
{

    public static vms_RelayOutputPage RelayOutput ;
 	
   @BeforeClass
	public void OpenRelayOutputPage() throws Exception 
	{
	   RelayOutput = new vms_RelayOutputPage(driver);
   }
   
   @Test(priority = 0)
   public void verifyRelayOutputPageisOpened()
   {  
   	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/relayOutput"))
	       {    Assert.assertTrue(true, "Relay Output page is successfuly opened.");   log.info("Relay Output page is successfuly opened.");     	}
	   else 
	       {   capctureScreenshot(driver, "verifyRelayOutputPageisOpened");
		       log.info(" Something went wrong. Relay Output page is not opened");
		       Assert.assertTrue(false, "Relay Output page is not opened");
	       }
   }
	
	

	//@Test(priority = 1)
	public void enableAllVAXRelayOutputs() throws Exception
	{
		RelayOutput.visibleAllRelayOutputs();
	}
	

	//@Test(priority = 2)
	public void triggerRelayOutputEvent() throws Exception
	{
		RelayOutput.triggerRelayOutput("VAX_Output 3_VAX Demo");
	}
	
}
