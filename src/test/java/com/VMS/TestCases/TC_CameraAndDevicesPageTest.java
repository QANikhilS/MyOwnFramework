package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_CamerasAndDevicesPage;
import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_CameraAndDevicesPageTest extends BaseClass {

	
	@Test
	public void AddSimulatorCamera() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openCamerasAndDevicesPage();
		log.info("Cameras and Devices page is opened");
	
		vms_CamerasAndDevicesPage cd = new vms_CamerasAndDevicesPage(driver);
		cd.verifyAndAddSimulatorCamerainVMS("172.20.10.10");
		
		
	/*	String ExpectedSuccessMsg = "Successfully added";
		
		if (cd.successMessageOnAddingCamera().equalsIgnoreCase(ExpectedSuccessMsg))
		{
			Assert.assertTrue(true);
			log.info(getcurrentMachineIP()+" camera is added successfully");
			cd.clickOnCloseSuccessWindow();
		}
		else 
		{
			log.info("AddCamera  -  Failed. ");
			capctureScreenshot(driver, "AddCamera");
			Assert.assertTrue(false);
			cd.clickOnCloseSuccessWindow();   
		}*/
		
	}
	
	
	//@Test
	public void verifyCameraIsAdded() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openCamerasAndDevicesPage();
		log.info("Cameras and Devices page is opened");
	
		vms_CamerasAndDevicesPage cd = new vms_CamerasAndDevicesPage(driver);
		cd.isSimulatorCameraPresentinVMS();
			
		if (cd.isSimulatorCameraPresentinVMS()==true)
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
