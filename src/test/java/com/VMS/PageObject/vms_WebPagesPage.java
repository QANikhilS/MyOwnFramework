package com.VMS.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vms_WebPagesPage {

	WebDriver ldriver;

	public vms_WebPagesPage(WebDriver rdriver) 
	{
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//button[text()='New']")
	public WebElement addNewWebPagebtn;

	@FindBy(xpath = "//input[contains(@ng-model,'name')]")
	public WebElement webPageNametxtbox;
	
	@FindBy(xpath = "(//md-switch[@role='checkbox'])[1]")
	public WebElement visibleCheckBoxStatus;
	
	@FindBy(xpath = "(//md-switch[@role='checkbox']/div/div)[1]")
	public WebElement visibleCheckBox;
	
	@FindBy(xpath = "(//md-switch[@role='checkbox'])[2]")
	public WebElement refreshTimeCheckBox;
	
	@FindBy(xpath = "//input[contains(@ng-model,'url')]")
	public WebElement urlTextBox;
	
	@FindBy(xpath = "//button[ contains(@ng-click,'webSitesController') and text()='Save']")
	public WebElement saveBtn;
	
	
	public void clickOnNewWebpageBtn()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", addNewWebPagebtn);
	}
	
	public void enterWebPageName(String WebpgName) throws Exception
	{
		//new WebDriverWait(ldriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(webPageNametxtbox));
		Actions act = new Actions(ldriver);
		act.moveToElement(webPageNametxtbox).click().build().perform();
		Thread.sleep(300);
				
		webPageNametxtbox.clear();
		webPageNametxtbox.sendKeys(WebpgName);
	}
	
	public void enterWebPageURL(String WebpgURL) throws Exception
	{
		urlTextBox.clear();
		urlTextBox.sendKeys(WebpgURL);
	}
	
	public void enableVisiblToggleBtn()
	{
		String currentStateofvisiblity = visibleCheckBoxStatus.getAttribute("aria-checked");
		
		if(currentStateofvisiblity.equals("true"))
		{
			System.out.println("Visible toggle button is already enabled ");
		}
		else
		{
			visibleCheckBox.click();
		}
	}
	
	public void disableVisiblToggleBtn()
	{
		String currentStateofvisiblity = visibleCheckBoxStatus.getAttribute("aria-checked");
		
		if(currentStateofvisiblity.equals("false"))
		{
			System.out.println("Visible toggle button already is Disabled ");
		}
		else
		{
			visibleCheckBox.click();
		}
	}
	
	public void clickOnSaveBtn()
	{
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", saveBtn);
	}	
	
	public void addWebPage(String WebPageName, String WebPageURL) throws Exception
	{
		clickOnNewWebpageBtn();
		enterWebPageName(WebPageName);
		enterWebPageURL(WebPageURL);
		clickOnSaveBtn();
		Thread.sleep(1500);
	}
	
	
	
	
	
}
