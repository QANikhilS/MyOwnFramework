package com.VMS.PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VMS.TestCases.BaseClass;

public class vms_WebPagesPage {

	WebDriver ldriver;
	public JavascriptExecutor js ;

	public vms_WebPagesPage(WebDriver rdriver) 
	{
     	ldriver = rdriver;
     	js = ((JavascriptExecutor) ldriver);
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
	
	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement deleteWebPageBtn;
	
	@FindBy(xpath = "(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]")
	public WebElement firstWebPage;
	
	@FindBy(xpath = "//div[@class='ui-grid-cell-contents ng-binding ng-scope']")
	public List<WebElement> listOfAvailableWebPages;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public WebElement yesBtn;
	
	@FindBy(xpath = "//button[contains(text(),'No')]")
	public WebElement noBtn;

	@FindBy(xpath = "//div[@class='ui-grid-cell-contents']/div")
	public List<WebElement> singleWebpageCheckbox;
	


	public void openWebPagespage()
	    {
		   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		   vms_ConfigurationPage cp = hm.openConfigurationPage();
		   cp.openWebPagePage();
		   BaseClass.wait(500);
	       BaseClass.log.info("Webpage page is opened.");	
	    }
	
	public void clickOnNewWebpageBtn()
	{
		js.executeScript("arguments[0].click();", addNewWebPagebtn);
        BaseClass.log.info("Clicked on New webpage button.");	
	}
	
	public void enterWebPageName(String WebpgName) 
	{
		//new WebDriverWait(ldriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(webPageNametxtbox));
		Actions act = new Actions(ldriver);
		act.moveToElement(webPageNametxtbox).click().build().perform();
		BaseClass.wait(500);
		webPageNametxtbox.clear();
		webPageNametxtbox.sendKeys(WebpgName);
		BaseClass.log.info("Webpage name is entered.");	
	}
	
	public void enterWebPageURL(String WebpgURL) 
	{
		urlTextBox.clear();
		urlTextBox.sendKeys(WebpgURL);
		BaseClass.log.info("Webpage URL is entered.");	
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
	  BaseClass.log.info("Visible toggle button is enabled.");	
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
		  BaseClass.log.info("Visible toggle button is disabled.");			
	}
	
	public void clickOnSaveBtn()
	{
		js.executeScript("arguments[0].click();", saveBtn);
		BaseClass.log.info("Clicked on SAVE button.");	
	}	
	
	public void addWebPage(String WebPageName, String WebPageURL) 
	{
		clickOnNewWebpageBtn();
		enterWebPageName(WebPageName);
		enterWebPageURL(WebPageURL);
		clickOnSaveBtn();
		BaseClass.wait(1500);
	}
	
	public void selectWebPage()
	{
		for (int i = 0 ; i < singleWebpageCheckbox.size(); i++)
		{
			String checkboxAttibute = singleWebpageCheckbox.get(i).getAttribute("Class");
			if (checkboxAttibute.contains("selected"))   {}
			else 
			 {
			singleWebpageCheckbox.get(i).click();
			 }
		}
	}
	
	public void deleteAllWebPages()
	{
		BaseClass.wait(1500);
		selectWebPage();
		deleteWebPageBtn.click();
		yesBtn.click();		
	}
	
	public List<String> listOfAvailableWebPagesInString()
	{
		List<String> availableWebPagesStringList = new ArrayList<String>();
		for(WebElement e : listOfAvailableWebPages)
		{
			availableWebPagesStringList.add(e.getText());
		}
		return availableWebPagesStringList;
	}
	
	
}
