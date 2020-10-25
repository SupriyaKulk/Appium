package com.gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDrop {
	
	@Test
	public void tapping() throws MalformedURLException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
	
		dc.setCapability("noReset",true);
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "com.mobeta.android.demodslv");
		dc.setCapability("appActivity", ".Launcher");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Basic usage playground']").click();
		
		MobileElement src=(MobileElement) driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.mobeta.android.demodslv:id/drag_handle']");
	
		MobileElement dest=(MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='Herbie Hancock']");
	
		TouchAction ta= new TouchAction(driver);
		ta.longPress(src).waitAction().moveTo(dest).release().perform();
	
		
		
	}

	
}
