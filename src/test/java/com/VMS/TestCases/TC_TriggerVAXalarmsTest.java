package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_TriggerVAXalarmsTest extends BaseClass 
{
    
	@Test
	 public void triggerDigitalInputAlarms() throws Exception
	 {
			 
		vaxwebserver.triggerDoorLocked();
		Thread.sleep(1000);
		vaxwebserver.triggerDoorUnlocked();
	 }
	
	
}
