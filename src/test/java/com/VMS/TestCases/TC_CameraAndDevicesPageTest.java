package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CameraAndDevicesPageTest extends BaseClass 
{
	
	@Test(priority = 0)
	public void OpenCameraAndDevicesPage() throws Exception 
	{
		camAndDev.openCameraAndDevicespage();
		log.info("Cameras and Devices page is opened");
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
