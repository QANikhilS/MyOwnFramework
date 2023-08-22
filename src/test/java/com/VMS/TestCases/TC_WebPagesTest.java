package com.VMS.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_WebPagesPage;

public class TC_WebPagesTest extends BaseClass
{
     public vms_WebPagesPage webpage ;
 	
    @BeforeClass
	public void OpenWebPagesPage() throws Exception 
	{
    	webpage = new vms_WebPagesPage(driver);
    }
    
    @Test(priority = 0)
    public void verifyWebPagesPageisOpened()
    {  System.out.println(readConfigData.getBaseURL()+"/#/configuration/network_entities/web_sites");
    	
    	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/web_sites"))
	       {    Assert.assertTrue(true, "Webpage is successfuly opened.");   log.info("Webpage is successfuly opened.");     	}
	   else 
	       {   capctureScreenshot(driver, "verifyWebPagesPageisOpened");
		       log.info(" Something went wrong. Webpages page is not opened");
		       Assert.assertTrue(false, "Webpage is not opened");
	       }
    }
	
	//@Test(priority = 1)
	public void AddSingleWebPages()
	{
		String ExpectedwebPageName = "Alibaba";
		String ExpectedwebURL = "www.alibaba.com";
		webpage.clickOnNewWebpageBtn(); 
        log.info("clicked on NEW button.");
        webpage.addWebPage(ExpectedwebPageName, ExpectedwebURL); 
        BaseClass.wait(1000);
        if( webpage.listOfAvailableWebPages.contains(ExpectedwebPageName))
        {   Assert.assertTrue(true);    
            log.info(" Single Webpage is added successfully.");}
        else 
        { 	capctureScreenshot(driver, "AddSingleWebPages");
			log.info(" Something went wrong. Webpage "+ExpectedwebPageName+" is not added");
    		Assert.assertTrue(false, "Webpage is not added");
		}  
     }
	

	//@Test(priority = 2)
	public void deleteWebPages() throws Exception
	 {
		webpage.deleteAllWebPages();
		BaseClass.wait(1000);

		if (webpage.listOfAvailableWebPages.size() == 0) 
		 {  Assert.assertTrue(true);
			log.info("All webpages are deleted.");
		 } 
		else 
		 {  log.info(" Something went wrong. All webpages are not deleted.");
	        capctureScreenshot(driver, "deleteWebPages");
			Assert.assertTrue(false);
		 }
	}
	
	
	@Test(priority = 3)
	   public void addAllWebpage() throws Exception 
	   {
           XSSFWorkbook workbook = new XSSFWorkbook(fs);	
           XSSFSheet sheet = workbook.getSheetAt(1);	 
           String sheetName = sheet.getSheetName();			
           Row row = sheet.getRow(0);	
           Cell column = row.getCell(0);	
           int lengthOfColumnWebpageName = sheet.getLastRowNum();
           List<String> listOfWebpagename = new ArrayList<String>() ; 
           List<String> listOfWebpageURL = new ArrayList<String>() ; 	 

           for (int i = 1 ; i< lengthOfColumnWebpageName+1 ; i++)	 
              {  String CurrentWebpageNames = sheet.getRow(i).getCell(0).getStringCellValue();		 
                 listOfWebpagename.add(CurrentWebpageNames);		 		 
       
                  for ( int j = i ; j<=i ; j++)		 
                    {   String CurrentWebpageURLs = sheet.getRow(j).getCell(1).getStringCellValue();			 
                        listOfWebpageURL.add(CurrentWebpageURLs);	  } 	
              }
           
           //add Webpages 
           for (int i = 0 ; i<listOfWebpagename.size() ; i++)
               {
        	      webpage.clickOnNewWebpageBtn();
        	      String webPageName = listOfWebpagename.get(i);
        	      webpage.enterWebPageName(webPageName);
             
                   for (int j = i ; j<=i ; j++)
                   {    String webPageURL = listOfWebpageURL.get(j);
                     	webpage.enterWebPageURL(webPageURL);
                  	    BaseClass.wait(1000);
                  	    webpage.clickOnSaveBtn();
                  	    log.info("Webpage "+webPageName+" is added.");
                  	    BaseClass.wait(2000);
                   }
                }
           if (webpage.listOfAvailableWebPagesInString().containsAll(listOfWebpagename))
           {   Assert.assertTrue(true);   
               log.info(" All webpages are added.");   }
           else
           {  log.info(" Something went wrong. All webpages are not added.");
              capctureScreenshot(driver, "addAllWebpage");
			  Assert.fail();                } 	   
       }
	
	
}
