package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_MapTest extends BaseClass 
{

	@Test(priority = 1)
	public void addNewMap()
	{
	    Maps.openMapPage();	
	 //   Maps.getLocationOfAddedMap();
	   // Maps.dragAndDropAvailableResourceOnMap();
	}
	
	@Test(priority = 2)
	public void addNewMapInVMS()
	{
		Maps.openNewMapForm();
		Maps.enterMapName("Map_VAX");
		Maps.uploadMapImage(System.getProperty("user.dir")+"\\src\\main\\resource\\VAX_Map_Structure.png");
		Maps.clickOnDoneBtnTocreateNewMap();
	}
	
	
}
