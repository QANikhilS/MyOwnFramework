package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_DigitalInputTest extends BaseClass 
{

	@Test(priority = 0)
	public void openDigitalInputPage()
	{
		DigitalInput.openDigitalInputPage();
	}
	

	@Test(priority = 1)
	public void enableAllVAXDigitalInputs() throws Exception
	{
		DigitalInput.visibleAllVAXInputs();
	}
	
}
