package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VoonikOpenThroughUIAutomator {

	
	@Test
	public void VoonikOpenMore() throws MalformedURLException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
	
		dc.setCapability("noReset",true);
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "com.mrvoonik.android");
		dc.setCapability("appActivity", ".splashsection.Splash");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Drawer Open']").click();



	}
}
