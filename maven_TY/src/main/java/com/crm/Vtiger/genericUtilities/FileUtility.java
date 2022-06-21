package com.crm.Vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	/*
	 * 
	 * this is code is for pro.property file to launch Vtiger Project
	 * 
	*/
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/pro.properties");
		Properties property=new Properties();
		property.load(fis);
		String value = property.getProperty(key);
		return value;
		
	}

}
