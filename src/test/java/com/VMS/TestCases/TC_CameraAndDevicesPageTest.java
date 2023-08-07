package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_CamerasAndDevicesPage;

public class TC_CameraAndDevicesPageTest extends BaseClass 
{
	
    public vms_CamerasAndDevicesPage camAndDev ;
 	
   @BeforeClass
	public void OpenCameraAndDevicesPage() throws Exception 
	{
	   camAndDev = new vms_CamerasAndDevicesPage(driver);
   }
   
   @Test(priority = 0)
   public void verifyCamerasAndDevicesPageisOpened()
   {  
   	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/web_sites"))
	       {    Assert.assertTrue(true, "Camera and Devices page is successfuly opened.");   log.info("Camera and Devices page is successfuly opened.");     	}
	   else 
	       {   capctureScreenshot(driver, "verifyCamerasAndDevicesPageisOpened");
		       log.info(" Something went wrong. Camera and Devices page is not opened");
		       Assert.assertTrue(false, "Camera and Devices is not opened");
	       }
   }

	//@Test
	public void AddSimulatorCamera() throws Exception
	{
		camAndDev.clickOnAddDiscoveredDevicesBtn();
		camAndDev.enterSimulatorIpInSearchTextBoxOfDiscoveredDevicesPage(BaseClass.getcurrentMachineIP());
		camAndDev.selectFilteredCamerafromDiscoveredDevicesWindow();
		
		String ExpectedSuccessMsg = "Successfully added";
		
		if (camAndDev.successMessageOnAddingCamera().equalsIgnoreCase(ExpectedSuccessMsg))
		{
			Assert.assertTrue(true);
			log.info(getcurrentMachineIP()+" camera is added successfully");
			camAndDev.clickOnCloseSuccessWindow();
		}
		else 
		{
			log.info("AddCamera  -  Failed. ");
			capctureScreenshot(driver, "AddCamera");
			camAndDev.clickOnCloseSuccessWindow();
			Assert.assertTrue(false);
		}  
	}
	
	
	//@Test
	public void verifyCameraIsAdded() throws Exception
	{
		camAndDev.isSimulatorCameraPresentinVMS();
			
		if (camAndDev.isSimulatorCameraPresentinVMS()==true)
		{
			log.info("verifyCameraIsAdded  -  Passed. ");
			Assert.assertTrue(true);
			log.info(" Expected cameras is present of Cameras and Devices page.");
		}
		else 
		{
			log.info("verifyCameraIsAdded  -  Failed. ");
			capctureScreenshot(driver, "verifyCameraIsAdded");
			log.info(" Expected camera is not added in VMS.");
			Assert.assertTrue(false);
		}   
	}
	
	
}
