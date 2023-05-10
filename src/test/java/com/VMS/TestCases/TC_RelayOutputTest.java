package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_RelayOutputTest extends BaseClass
{

	@Test(priority = 0)
	public void openDigitalInputPage()
	{
		RelayOutput.openRelayOutputPage();
	}
	

	@Test(priority = 1)
	public void enableAllVAXDigitalInputs() throws Exception
	{
		RelayOutput.visibleAllRelayOutputs();
	}
	

	@Test(priority = 2)
	public void triggerRelayOutputEvent() throws Exception
	{
		RelayOutput.triggerRelayOutput("VAX_Output 3_VAX Demo");
	}
	
}
