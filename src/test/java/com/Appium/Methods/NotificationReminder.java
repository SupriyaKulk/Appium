package com.Appium.Methods;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class NotificationReminder {
	@Test
	public void notification() throws MalformedURLException, InterruptedException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		dc.setCapability("noReset", true);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "com.bhanu.notificationreminders");
		dc.setCapability("appActivity", ".MainDrawerActivity");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		try {
		driver.findElementById("com.bhanu.notificationreminders:id/invite_friends_close").click();
	}
	catch(Throwable io)
		{
		System.out.println("Remind me later is accepted");
		}
		driver.findElementById("com.bhanu.notificationreminders:id/txtNewNoteTitle").sendKeys("reminder new");
		
		driver.findElementById("com.bhanu.notificationreminders:id/btnNotify").click();
		
		//to open notification
		
		driver.openNotifications();
		Thread.sleep(1000);
		
		WebElement read=driver.findElementByXPath("//android.widget.Button[@text='READ']");
	driver.tap(1, read, 500);
	
	}
}
