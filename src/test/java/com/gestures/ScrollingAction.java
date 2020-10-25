package com.gestures;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.InputData.PropertiesFile;

import io.appium.java_client.android.AndroidDriver;

public class ScrollingAction {
	
	AndroidDriver driver;
	@Test
	public void scroll() throws IOException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		
		PropertiesFile pf=new PropertiesFile();
		
		/*fetch Device name*/
		String devicevalue= pf.fetchFromProp("deviceName");
		dc.setCapability("deviceName", devicevalue);
	
		
		
		/*fetch Automation name*/
		String autovalue= pf.fetchFromProp("automationName");
		dc.setCapability("automationName", autovalue);
		
		
		/*fetch platform value*/
		String platformvalue= pf.fetchFromProp("platformName");
		dc.setCapability("platformName", platformvalue);
		
		/*fetch platform version*/
		String platformversionvalue= pf.fetchFromProp("platformVersion");
		dc.setCapability("platformVersion", platformversionvalue);
		
		
		/*fetch UDID*/
		String UDIDvalue= pf.fetchFromProp("UDID");
		dc.setCapability("UDID", UDIDvalue);
		
		
		/*fetch appPackage*/
		String packagevalue= pf.fetchFromProp("appPackage");
		dc.setCapability("appPackage", packagevalue);
		
	
		/*fetch appActivity*/
		String activityvalue= pf.fetchFromProp("appActivity");
		dc.setCapability("appActivity", activityvalue);
		
	

		/*Fetch URL*/
		String url=pf.fetchFromProp("URL");
		
		
		 driver=new AndroidDriver(new URL(url),dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement views=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
		driver.tap(1, views, 500);
		
		scrolling("text","Layouts");
		
		WebElement layout=driver.findElementByAccessibilityId("Layouts");
		driver.tap(1, layout, 500);
		
	}
	
	
	
	
		public void scrolling(String an , String av) 
		 {
		  driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + an + "(\"" + av + "\"))");
		 }

		
		


	

}
