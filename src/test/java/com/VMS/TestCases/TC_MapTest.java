package com.VMS.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_MapPage;

public class TC_MapTest extends BaseClass 
{
	public vms_MapPage Maps ;
	
    @BeforeClass
	public void OpenMapsPage() throws Exception 
	{
    	Maps = new vms_MapPage(driver);
	}
    
    @Test(priority = 0)
    public void verifyMapPageisOpened()
    {
    	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/maps"))
    	{    Assert.assertTrue(true, "Maps is successfuly opened.");     log.info("Maps is successfuly opened.");       	}
    	else 
    	{   capctureScreenshot(driver, "verifyMapPageisOpened");
			log.info(" Something went wrong. Maps page is not opened");
    		Assert.assertTrue(false, "Maps is not opened");
    	}
	}
	
	@Test(priority = 1)
	public void addNewMap()
	{
	    Maps.openMapPage();	
	    if (driver.getCurrentUrl().contains("maps") == true)  
	     {  
	    	Assert.assertTrue(true, "Maps Page is opened");
	     }
	    else 
	    {   Assert.fail();    }    
	}
	
	@Test(priority = 2)
	public void addNewMapInVMS()
	{
		String MapName = "Map_VAX1";  String CurrentMapNames ; 
		Maps.openNewMapForm();
		Maps.enterMapName(MapName);
		Maps.uploadMapImage(System.getProperty("user.dir")+"\\src\\main\\resource\\VAX_Map_Structure.png");
		Maps.clickOnDoneBtnTocreateNewMap();
		BaseClass.wait(1000);
		List<String> allMapsName = new ArrayList<String>();
		
		for (int i = 1 ; i<Maps.listOfAvailableMaps.size() ; i++)
		{
			BaseClass.wait(500);
			CurrentMapNames = Maps.listOfAvailableMaps.get(i).getText();
			allMapsName.add(CurrentMapNames);		 		 
			BaseClass.wait(500);
		}
		if (allMapsName.contains(MapName) == true)  
	      {   Assert.assertTrue(true, "Maps is added successfully.");   }
	    else 
	      {   Assert.fail();    }
	}
	
	
}
