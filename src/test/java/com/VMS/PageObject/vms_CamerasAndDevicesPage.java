package com.VMS.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vms_CamerasAndDevicesPage {
	
	WebDriver ldriver;
	
	public vms_CamerasAndDevicesPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	// Identify webElements
	@FindBy(xpath = "//span[text()='Add Discovered Devices']") 
	WebElement addDiscoveredDevicesBtn;
	
	@FindBy(xpath = "//span[text()='Add Device Manually']") 
	WebElement addDeviceManuallyBtn;
	
	@FindBy(xpath = "//span[text()='Remove Devices']") 
	WebElement removeDevicesBtn;
	
	@FindBy(css = "input[type='search']") 
	WebElement searchCameraTxtbox;
	
	@FindBy(css = "input[type='search']") 
	WebElement searchCameraTxtboxOnDiscoveredDevicesWindow;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and @ng-if='!row.groupHeader']") 
	List<WebElement> listOfAddedCamerasInVMS;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and @ng-if='!row.groupHeader']") 
	WebElement filteredCameraOnCamerasAndDevicesPage;
	
	@FindBy(xpath = "//span[@ng-if='!row.groupHeader' and @class='ng-scope']") 
	List<WebElement> listOfAvailableCamerasInDiscoveredDevicesList;
	
	@FindBy(xpath = "//span[@ng-if='!row.groupHeader' and @class='ng-scope']")
	WebElement filteredCameraOnDiscoveredDevicesPage;
	
	@FindBy(xpath = "//button[text()='Add to NVR and close']")
	WebElement addToNVRandCloseBtn;	
	
	@FindBy(xpath = "//span[text()='Successfully added']")
	WebElement successMessageAfterAddingCamera;	
	
	@FindBy(xpath = "//span[contains(@ng-click,'cancel()')]")
	WebElement closeSuccessWindowBtn;	
	
	
	
	
	
	public String successMessageOnAddingCamera()
	{
		String successmsg = successMessageAfterAddingCamera.getText();
		return successmsg;
	}
	
	public void clickOnCloseSuccessWindow()
	{
	   closeSuccessWindowBtn.click();
	}
	
	public void clickOnAddDiscoveredDevicesBtn()
	{
		addDiscoveredDevicesBtn.click();
	}
	
	public void clickOnAddToNVRandCloseBtn()
	{
		addToNVRandCloseBtn.click();
	}	
	
	public void enterSimulatorIpInSearchTextBoxOfCamerasAndDevicesPage(String IPofCamera)
	{
		searchCameraTxtbox.sendKeys(IPofCamera);
	}

	public void enterSimulatorIpInSearchTextBoxOfDiscoveredDevicesPage(String IPofCamera)
	{
		searchCameraTxtboxOnDiscoveredDevicesWindow.sendKeys(IPofCamera);
	}
	
	public String getFilteredCameraNamefromCamerasAndDevicesPage() throws Exception
	{
		String FilteredCamera = filteredCameraOnCamerasAndDevicesPage.getText();
		return FilteredCamera;
	}

	public void selectFilteredCamerafromDiscoveredDevicesWindow() throws Exception
	{
		filteredCameraOnDiscoveredDevicesPage.click();
	}
	
	public void addSimulatorCamera(String simulatoriP) throws Exception
	{
		clickOnAddDiscoveredDevicesBtn();
		
		enterSimulatorIpInSearchTextBoxOfDiscoveredDevicesPage(simulatoriP);
		Thread.sleep(3000);
		selectFilteredCamerafromDiscoveredDevicesWindow();
		Thread.sleep(1000);
		clickOnAddToNVRandCloseBtn();
	}

	public void verifyAndAddSimulatorCameraIsAdded(String IPofCamera) throws Exception
	{
		if(getFilteredCameraNamefromCamerasAndDevicesPage().equalsIgnoreCase(IPofCamera))
		{
	        System.out.println("Camera is already added in VMS");
		}
       else
       {
    	   addSimulatorCamera(IPofCamera);
       }
	}
	

	
	
}
