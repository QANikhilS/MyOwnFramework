package com.VMS.TestCases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_Home_MonitoringPage;
import com.VMS.PageObject.vms_VAXWebpagePage;


public class TC_VAXwebpageTest extends BaseClass
{
	public String parent_VMS_window;
	public String Child_VAX_window;	 


	@Test(priority = 0)
	public void LoginTotheVAXwebpage() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		
		TC_NetworkingPageTest.networking.enableVAXTab("192.168.1.51");
		Thread.sleep(1500);
				
		hm.openVAXPageWindow();
		
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		parent_VMS_window = I1.next();
		Child_VAX_window = I1.next(); 
		
		driver.switchTo().window(Child_VAX_window);
		driver.manage().window().maximize();
		
		vaxwebserver = new vms_VAXWebpagePage(driver);
	    Thread.sleep(500);
		vaxwebserver.clickOnAdvancedBtn();
		Thread.sleep(500);
		vaxwebserver.clickOnProceedToOpenVAXpageLink();
		if (driver.getCurrentUrl().contains("192.168.1.51"))
		   { 
		      vaxwebserver.enterVAXusrname("ADMIN");  Thread.sleep(500);
		      vaxwebserver.enterVAXpassword("Cemtrex@123");  Thread.sleep(500);
		      vaxwebserver.clickOnVAXLoginbtn(); Thread.sleep(500);
		   } 
		else
		{ 
		      vaxwebserver.enterVAXusrname("vjathode@cemtrexlabs.com");  Thread.sleep(500);
		      vaxwebserver.enterVAXpassword("Cemtrex@321");  Thread.sleep(500);
		      vaxwebserver.clickOnVAXLoginbtn();   Thread.sleep(500);
		}
		if(vaxwebserver.overrideBtn.isDisplayed())
		{			
			Assert.assertTrue(true);
		}			
	}
	
	@Test(priority = 1)
	public void verifyAllVAXResources()
	{
		vaxwebserver.openDoorsPage();
		List<WebElement> allDoors = vaxwebserver.ListOfAllAvailableDoors;
		vaxwebserver.openActionPlansPage();;
		List<WebElement> allActionPlans = vaxwebserver.ListOfAllAvailableActionPlans;
		
		driver.switchTo().window(parent_VMS_window);
		VAXresources.openVAXResourcesPage();
		
		if (VAXresources.allVAXdoorsInVMS.equals(allDoors) && VAXresources.allVAXactionPlansInVMS.equals(allActionPlans))
		{   Assert.assertTrue(true, "All VAX Resources are available");   }	
		else
		{   Assert.fail();   	}
	}
	
	
	//@Test(priority = 1)
	public void triggerDoorLockUnlockOverrideEvents() throws Exception
	{
		vaxwebserver.openOverrideOptions();
		vaxwebserver.selectBothDoors();
		vaxwebserver.clickOnResumeBtn();
		vaxwebserver.triggerDoorUnlocked();
		vaxwebserver.triggerDoorLocked();
		vaxwebserver.triggerDoorUnlocked();
		vaxwebserver.triggerDoorLocked();
		vaxwebserver.triggerDoorUnlocked();
		vaxwebserver.triggerDoorLocked();
		vaxwebserver.triggerDoorUnlocked();
	    Thread.sleep(1000);
	    vaxwebserver.clickOnClearNotificationsBtn();
	    Thread.sleep(500);
	    vaxwebserver.clickOnResumeBtn();
	}

	//@Test(priority = 2)
	public void triggerDigitalInputAlarm() 
	{
		vaxwebserver.openVAXhomepage();
		vaxwebserver.openPanelsList();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		vaxwebserver.openPanelsList();
		vaxwebserver.openVAXDemopanel();
		vaxwebserver.openVAXinputOutput();
		vaxwebserver.selectVAXinput4();
	}
	
	//@Test(priority = 3)
	public void triggerRelayOutputAlarm() throws Exception 
	{
		Thread.sleep(1500);
		driver.switchTo().window(parent_VMS_window);
		Thread.sleep(1500);
		TC_RelayOutputTest.RelayOutput.openRelayOutputPage();
		TC_RelayOutputTest.RelayOutput.triggerRelayOutput("VAX_Output 3_VAX Demo");
	}
	
	//@Test(priority = 4)
	public void verifyAvailablePanelsInVAXandVMS()
	{
		vaxwebserver.openOverrideOptions();
		vaxwebserver.openPanelsList();
		vaxwebserver.getAvailablePanelLink();
		for (int i = 0 ; i < vaxwebserver.getAvailablePanelLink().size(); i++)
		{
			System.out.println(vaxwebserver.getAvailablePanelLink().get(i).getText());
		}
	}
	
}