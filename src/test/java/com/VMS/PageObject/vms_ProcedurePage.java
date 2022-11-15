package com.VMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vms_ProcedurePage {

	WebDriver ldriver;
	
	public vms_ProcedurePage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	
	}
	
	@FindBy(xpath = "//button[text()='New']")
	public WebElement newProcedureBtn;
	
	@FindBy(css = "input[ng-model*='Procedure.Name']")
	public WebElement procedureNameTxtbx;
	
	@FindBy(css = "div[class='md-bar']")
	public WebElement procedureEnableDisableToggleBtn;
	


	



}
