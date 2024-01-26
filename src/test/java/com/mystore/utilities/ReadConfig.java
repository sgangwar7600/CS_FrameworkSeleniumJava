package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	
	String path = "C:\\Users\\Shashikant\\eclipse-workspace\\MyStoreV1\\Configuration\\config.properties";
	
	//constructor
	public ReadConfig() {
	
		try {
		properties = new Properties();					//we will Initializing the object here , Properties is class name here
		
		FileInputStream fis = new FileInputStream(path);
	
		properties.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
	
	public String getBaseUrl() {
		
		String value = properties.getProperty("baseurl");
		
		if(value!=null)
			return value;
		else 
			throw new RuntimeException("url not specified in config file ..");
	}
	
	public String getBrowser() {
		
		String value = properties.getProperty("browser");
		
		if (value!=null)
			return value;
			else
				throw new RuntimeException("url not specified in config file ..");
	}
	
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		
	}

	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}
	
	
	}
