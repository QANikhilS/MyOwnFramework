package com.VMS.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties prop;
	
	String path = ".\\Configuration\\config.properties";
	
	public readConfig() 
	{
		try
		{
		  prop = new java.util.Properties();
		  FileInputStream fis = new FileInputStream(path);
		  prop.load(fis);
		}
		 catch (Exception e)
		{
			 e.printStackTrace();
		}
	}
	
	
	public String getBaseURL()
	{
		String URLValue = prop.getProperty("URL");
		
		if (URLValue != null)
			return URLValue;
		else
			throw new RuntimeException("URL is not specified in config file");
 
	} 
	
	
	public String getBrowser()
	{
		String browserValue = prop.getProperty("browser");
		
		if (browserValue != null)
			return browserValue;
		else
			throw new RuntimeException("Browser is not specified in config file");
 
	}
	
	public String getAppServerVersion()
	{
		String appServerVersion = prop.getProperty("appserverVersion");
		
		if (appServerVersion != null)
			return appServerVersion;
		else
			throw new RuntimeException("Application Server is not specified in config file");
 
	}

}
