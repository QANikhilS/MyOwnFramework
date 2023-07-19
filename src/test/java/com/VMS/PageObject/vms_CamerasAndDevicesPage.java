package com.VMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;

public class vms_CamerasAndDevicesPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	
	public vms_CamerasAndDevicesPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	// Identify webElements
	@FindBy(xpath = "//span[text()='Add Discovered Devices']") 
	public WebElement addDiscoveredDevicesBtn;
	
	@FindBy(xpath = "//span[text()='Default ONVIF Credentials']") 
	public WebElement firstTimeCameraAdditonWindowTitle;
	
	@FindBy(xpath = "//input[@type='password']") 
	public WebElement firstTimeCameraAdditonWindowPassword;
	
	@FindBy(xpath = "//button[@class='vms-popup-btn']") 
	public WebElement firstTimeCameraAdditonWindowSaveBtn;
	
	
	
	
	@FindBy(xpath = "//span[text()='Add Device Manually']") 
	public WebElement addDeviceManuallyBtn;
	
	@FindBy(xpath = "//span[text()='Remove Devices']") 
	public WebElement removeDevicesBtn;
	
	@FindBy(css = "input[type='search']") 
	public WebElement searchCameraTxtbox;
	
	@FindBy(xpath = "(//input[@type='search'])[2]") 
	public WebElement searchCameraTxtboxOnDiscoveredDevicesWindow;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and @ng-if='!row.groupHeader']") 
	public List<WebElement> listOfAddedCamerasInVMS;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and @ng-if='!row.groupHeader']") 
	public WebElement filteredCameraOnCamerasAndDevicesPage;
	
	@FindBy(xpath = "//span[@ng-if='!row.groupHeader' and @class='ng-scope']") 
	public List<WebElement> listOfAvailableCamerasInDiscoveredDevicesList;
	
	@FindBy(xpath = "//span[@ng-if='!row.groupHeader' and @class='ng-scope']")
	public WebElement filteredCameraOnDiscoveredDevicesPage;
	
	@FindBy(xpath = "//button[text()='Add to NVR and close']")
	public WebElement addToNVRandCloseBtn;	
	
	@FindBy(xpath = "//span[text()='Successfully added']")
	public WebElement successMessageAfterAddingCamera;	
	
	@FindBy(xpath = "//span[contains(@ng-click,'cancel()')]")
	public WebElement closeSuccessWindowBtn;	
	
	@FindBy(css = "span[ng-show='configuration.unassociatedDeviceList.length']")
	public WebElement countOfDiscoveredDevices;	
	
	
    
	
	public void openCameraAndDevicespage()
    {
	   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
	   vms_ConfigurationPage cp = hm.openConfigurationPage();
	   cp.openProcedurePage();
	   BaseClass.wait(1000);
    }
	
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
	    BaseClass.wait(2000);
		try
		{   firstTimeCameraAdditonWindowPassword.sendKeys("1234");
			firstTimeCameraAdditonWindowSaveBtn.click();             
		}
		catch(NoSuchElementException e)
		{ e.printStackTrace(); }
	    BaseClass.wait(2000);
	 }
	
	public void clickOnAddToNVRandCloseBtn()
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addToNVRandCloseBtn));
		BaseClass.jsClick(addToNVRandCloseBtn);
	}	
	
	public void enterSimulatorIpInSearchTextBoxOfCamerasAndDevicesPage(String IPofCamera)
	{
		searchCameraTxtbox.sendKeys(IPofCamera);
	}

	public void enterSimulatorIpInSearchTextBoxOfDiscoveredDevicesPage(String IPofCamera)
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(searchCameraTxtboxOnDiscoveredDevicesWindow)).clear();
		searchCameraTxtboxOnDiscoveredDevicesWindow.sendKeys(IPofCamera);
	}
	
	public String getFilteredCameraNamefromCamerasAndDevicesPage() throws Exception
	{
		String FilteredCamera = filteredCameraOnCamerasAndDevicesPage.getText();
		return FilteredCamera;
	}

	public void selectFilteredCamerafromDiscoveredDevicesWindow() 
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(filteredCameraOnDiscoveredDevicesPage));
		filteredCameraOnDiscoveredDevicesPage.click();  BaseClass.wait(1500);  clickOnAddToNVRandCloseBtn(); 
	}

	public boolean isSimulatorCameraPresentinVMS() throws Exception 
	{
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfAddedCamerasInVMS));
		BaseClass.wait(1000);		
		searchCameraTxtbox.click();  BaseClass.wait(500);
		searchCameraTxtbox.clear();  BaseClass.wait(500);
		searchCameraTxtbox.sendKeys(BaseClass.getcurrentMachineIP());
		wait.until(ExpectedConditions.visibilityOf(filteredCameraOnCamerasAndDevicesPage));
		if (filteredCameraOnCamerasAndDevicesPage.isDisplayed())  {return true;}
		else  {return false;}
	}
	
	public void addSimulatorCamera(String IPofCamera) 
	{
		clickOnAddDiscoveredDevicesBtn();
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(searchCameraTxtboxOnDiscoveredDevicesWindow));
		enterSimulatorIpInSearchTextBoxOfDiscoveredDevicesPage(IPofCamera);
		wait.until(ExpectedConditions.visibilityOf(filteredCameraOnDiscoveredDevicesPage));
		
		String FilteredCamera = filteredCameraOnDiscoveredDevicesPage+" : 81";
		if (filteredCameraOnDiscoveredDevicesPage.getText().equalsIgnoreCase(FilteredCamera))
		{
			selectFilteredCamerafromDiscoveredDevicesWindow();
			BaseClass.wait(1000);
			clickOnAddToNVRandCloseBtn();
			wait.until(ExpectedConditions.visibilityOf(successMessageAfterAddingCamera));
			clickOnCloseSuccessWindow();
		}
		else
		{
			System.out.println("Simulator is not present in Discovered list. May be it is Offline. Kindly Check");
			clickOnCloseSuccessWindow();
		}		
	 }

	public void verifyAndAddSimulatorCamerainVMS(String IPofCamera) throws Exception 
	{
		if(isSimulatorCameraPresentinVMS() == true)
		{
	        System.out.println("Camera is already added in VMS");
		}
       else
       {
    	   addSimulatorCamera(IPofCamera);
       }
	}
	



	
	
}