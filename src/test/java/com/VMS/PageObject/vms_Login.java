package com.VMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VMS.TestCases.BaseClass;

public class vms_Login extends BaseClass {
//1. Create object of webdriver
	WebDriver ldriver;

	public vms_Login(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// Identify webElements
	@FindBy(name = "login")
	public WebElement loginTextbox;
	
	@FindBy(name = "password") 
	public WebElement passwordTextBox;
	
	@FindBy(id = "submitBtn") 
	public WebElement signInbtn;
	
	@FindBy(xpath = "//md-switch[@role='checkbox']")
	public WebElement returnToMyLastDisplay;

	@FindBy(css = "span[class*='top-menu-user-name']")
	public WebElement usernameOption;

	@FindBy(xpath = "//div[text()='About']")
	public WebElement about;
	
	@FindBy(xpath = "//div[text()='User Settings']")
	public WebElement userSettings;
	
	@FindBy(xpath = "//div[text()='Logout']")
	public WebElement logOutBtn;
	
	public void enterUsername(String username)
	{
		loginTextbox.sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		passwordTextBox.sendKeys(pwd);
	}	
	
	public void Submitbtn()
	{
		signInbtn.click();
	}
	
	public void clickOnUserNamefromTopCorner()
	{
		usernameOption.click();
	}
	
	public void clickOnLogOutBtbn()
	{
		logOutBtn.click();
	}
	
	public void enableReturnToMyLastDisplay()
	{
		if (returnToMyLastDisplay.getAttribute("aria-checked").equalsIgnoreCase("false"))
		{
			returnToMyLastDisplay.click();
		}
		else 
		{
			System.out.println(" Return to my last display is already enabled.");
		}
	}

	public void disableReturnToMyLastDisplay()
	{
		if (returnToMyLastDisplay.getAttribute("aria-checked").equalsIgnoreCase("true"))
		{
			returnToMyLastDisplay.click();
		}
		else 
		{
			System.out.println(" Return to my last display is already Disabled.");
		}
	}
	
	public void DoLogin()
	{
		//open url
		driver.get(VMSURL);
		log.info(" URL Opened");
		enterUsername("admin");
		log.info(" Entered username ");
		enterPassword("1234");
		log.info(" Entered password ");
        disableReturnToMyLastDisplay();
		Submitbtn();
		log.info(" Clicked on Sign IN button ");
		try 
		{
			handlePlayerWidnow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		log.info(" User has logged in to VMS and Monitoring page is opened.");	
	}	
	
	
	
}
