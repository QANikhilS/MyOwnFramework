package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_CamerasAndDevicesPage;
import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_CameraAndDevicesPageTest extends BaseClass {

	
	@Test
	public void AddCamera() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openCamerasAndDevicesPage();
		log.info("Cameras and Devices page is opened");
	
		vms_CamerasAndDevicesPage cd = new vms_CamerasAndDevicesPage(driver);
		cd.enterSimulatorIpInSearchTextBoxOfCamerasAndDevicesPage(getcurrentMachineIP());
		cd.verifyAndAddSimulatorCameraIsAdded(getcurrentMachineIP());
		
		String ExpectedSuccessMsg = "Successfully added";
		
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
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
