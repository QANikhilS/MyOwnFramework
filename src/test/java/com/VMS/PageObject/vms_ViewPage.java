/**
 * 
 */
package com.VMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author nikhils
 *
 */
public class vms_ViewPage {
	
	WebDriver ldriver ; 
	
	public vms_ViewPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath = "//div[@class='flex flex-between']/button[1]" )
	public WebElement newViewbutton;

	@FindBy(xpath = "//div[@class='flex flex-between']/button[2]" )
	public WebElement deleteViewbutton;
	
	@FindBy(xpath = "//input[contains(@ng-model,'View.name')]" )
	public WebElement viewNameTextBox;
	
	@FindBy(xpath = "(//div[@view='view']/div/div[3]/div)[1]" )
	public WebElement twoBYtwoView;
	  
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[1]" )
	             public WebElement firstTileOfAnyLayout;
	         
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[2]" )
	             public WebElement secondTileOfAnyLayout;
	
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[3]" )
	             public WebElement ThirdTileOfAnyLayout;
	             
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[4]" )
	             public WebElement FourthTileOfAnyLayout;
	             
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[5]" )
	             public WebElement fifthTileOfAnyLayout;
	
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[6]" )
	             public WebElement sixthTileOfAnyLayout;
	
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[7]" )
	             public WebElement seventhTileOfAnyLayout;
	
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[8]" )
	             public WebElement eightthTileOfAnyLayout;
	
	             @FindBy(xpath = "//div[@class='vms-display-resource-container view-resources-container']//div[contains(@class, 'inner-layout')]/div[9]" )
	             public WebElement ninethTileOfAnyLayout;
	
	 @FindBy(xpath = "(//div[@view='view']/div/div[5]/div)[1]" )
	 public WebElement threeByThreeView;

	 @FindAll (@FindBy(xpath = "//div[@class='vms-resource-group-view']//dd"))
	 public List<WebElement> listOfAvailableResources;

	
	
	
	
	public void navigateToViewsPage()
	{
		vms_Home_MonitoringPage hp = new vms_Home_MonitoringPage(ldriver);
        vms_ConfigurationPage cp =  hp.openConfigurationPage();
        cp.openViewsPage();
	}
	
	public void clickOnAddNewViewButton()
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(newViewbutton)).click();
	}
	
	public void enterNameOfView(String viewName)
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(viewNameTextBox)).click();
		viewNameTextBox.clear();
		viewNameTextBox.sendKeys(viewName);
	}
	
	public void select2x2layout()
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(twoBYtwoView)).click();
	}
	
	public void select3x3layout()
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(threeByThreeView)).click();
	}
	
	public void dragableResource(String selectResourceTodrag)
	{
		for (int i= 0 ; i<listOfAvailableResources.size(); i++)
		{
			String CurrentResource = listOfAvailableResources.get(i).getText();
			if(CurrentResource.contains(selectResourceTodrag))
				{
			     	listOfAvailableResources.get(i).click();
				}
		}
	}
	
	
	
	
	
	
	
	

}
