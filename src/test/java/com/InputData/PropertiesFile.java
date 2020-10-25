package com.InputData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	public String fetchFromProp(String key) throws IOException
	{
		
		
		FileInputStream file= new FileInputStream("C:\\Users\\server\\Documents\\CapabilityFile.properties");
		
		Properties pobj=new Properties();
		
		pobj.load(file);
		
		String value=pobj.getProperty(key);
		return value;
	}

}
