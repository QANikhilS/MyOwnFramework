package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_DigitalInputsPage;

public class TC_DigitalInputTest extends BaseClass 
{

    public vms_DigitalInputsPage DigitalInput ;
 	
   @BeforeClass
	public void OpenDigitalInputPage() throws Exception 
	{
	    DigitalInput = new vms_DigitalInputsPage(driver);
   }
	
   
   @Test(priority = 0)
   public void verifyDigitalInputPageisOpened()
   {  
   	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/digitalInput"))
	       {    Assert.assertTrue(true, "Digital Input is successfuly opened.");   log.info("Digital Input is successfuly opened.");     	}
	   else 
	       {   capctureScreenshot(driver, "verifyDigitalInputPageisOpened");
		       log.info(" Something went wrong. Digital Input page is not opened");
		       Assert.assertTrue(false, "Digital Input is not opened");
	       }
   }
   
   

	//@Test(priority = 1)
	public void enableAllVAXDigitalInputs() throws Exception
	{
		DigitalInput.visibleAllVAXInputs();
	}
	
}
