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
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
 	} 
	
	public String getBrowser()
	{
		String URLValue = prop.getProperty("browser");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getAppServerVersion()
	{
		String URLValue = prop.getProperty("appserverVersion");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}

	public String getCam1IP()
	{
		String URLValue = prop.getProperty("cam1");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam2IP()
	{
		String URLValue = prop.getProperty("cam2");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam3IP()
	{
		String URLValue = prop.getProperty("cam3");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam4IP()
	{
		String URLValue = prop.getProperty("cam4");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam5IP()
	{
		String URLValue = prop.getProperty("cam5");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam6IP()
	{
		String URLValue = prop.getProperty("cam6");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam7IP()
	{
		String URLValue = prop.getProperty("cam7");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam8IP()
	{
		String URLValue = prop.getProperty("cam8");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam9IP()
	{
		String URLValue = prop.getProperty("cam9");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
	
	public String getCam10IP()
	{
		String URLValue = prop.getProperty("cam10");
		if (URLValue != null)  return URLValue;
		else throw new RuntimeException("URL is not specified in config file");
	}
}
