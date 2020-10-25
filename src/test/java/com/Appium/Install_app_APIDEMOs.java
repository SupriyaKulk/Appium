package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Install_app_APIDEMOs {
	@Test
	public void Install() throws MalformedURLException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
		
		
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "c291a593");
		//install the ApiDemos
		dc.setCapability("app", "E:\\Appium Apps\\ApiDemos-debug.apk");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		


	}

}
