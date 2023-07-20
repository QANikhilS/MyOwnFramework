package com.VMS.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_MapTest extends BaseClass 
{

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
