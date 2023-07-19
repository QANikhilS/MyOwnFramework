package com.VMS.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vms_MapPage 
{

	WebDriver ldriver;
	WebDriverWait wait;
	
	public vms_MapPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath = "//button[text()='Add Map']")
	public WebElement addMapBtn;
	
	@FindBy(css = "#add_map_name")
	public WebElement mapName;
	
	@FindBy(xpath = "//span[@class='add-map-file-btn']")
	public WebElement chooseFile;
	
	@FindBy(xpath = "//label[@class='add-map-popup-file']/input")
	public WebElement enterFilePathtoUpload;
	
	@FindBy(xpath = "//button[@class='big-blue-button-new-ui pull-right']")
	public WebElement doneBtnToaddMap;
	
	@FindBy(xpath = "//canvas")
	public WebElement addedImage;
	
	@FindBy(xpath = "//input[@id='map-resources-filter-input']")
	public WebElement searchTextboxOfAvailableResources;
	
	@FindBy(xpath = "//div[@tree-id='vmsTreeMapsConfig']//dd[2]/span")
	public WebElement filteredAvailableResource;
	
	@FindBy(xpath = "//canvas")
	public WebElement mapImageCanvas;	
	
	@FindAll(@FindBy(xpath = "//div[@ng-class='view-row']"))
	public List<WebElement> listOfAvailableMaps;	
	
	
	
	
	public void openMapPage()
	{
		   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		   vms_ConfigurationPage cp = hm.openConfigurationPage();
		   cp.openMapPage();
	       try {  Thread.sleep(500);  } catch (InterruptedException e)  {   e.printStackTrace();   }
	 }
	
	public void openNewMapForm()
	{
		addMapBtn.click();
	}
	
	public void enterMapName(String MapName)
	{
		mapName.clear();
		mapName.sendKeys(MapName);
	}
	
	public void uploadMapImage(String filepath)
	{
		enterFilePathtoUpload.sendKeys(filepath);
	}
	
	public void clickOnDoneBtnTocreateNewMap()
	{
		doneBtnToaddMap.click();
	}
	
  
	 public void getLocationOfAddedMap()
	 {
		
		System.out.println("+++++++++>>>>>>    "+ addedImage.getLocation());
		System.out.println("                         ");
		System.out.println("+++++++++>>>>>>    "+ addedImage.getSize());

	 }
	
	 public void dragAndDropAvailableResourceOnMap()
	 {
		 searchTextboxOfAvailableResources.sendKeys("VAX_Output 3");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Actions act = new Actions(ldriver);
		 act.moveToElement(filteredAvailableResource).clickAndHold(filteredAvailableResource).moveByOffset(900,300).release(mapImageCanvas).build().perform();
		 
		 
		 
	 }
	
}
