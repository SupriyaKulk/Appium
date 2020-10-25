package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpenCalculator {
	
	@Test
	public void OpenCalcu() throws MalformedURLException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
		
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "com.coloros.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		
		AndroidDriver driver=new AndroidDriver(url,dc);
	 


	}


}
