package com.gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScrollingForMore {
	
	
	AndroidDriver driver;
	@Test
	public void scrollingVoonik() throws MalformedURLException, InterruptedException 

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
		
		
		driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Drawer Open']").click();
		Thread.sleep(1000);
		scrolling("text","Refund Policy");
		MobileElement element =(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Refund Policy']");
		driver.tap(1, element, 500);
	}
	
	public void scrolling(String an , String av) 
	 {
	  driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + an + "(\"" + av + "\"))");
	 }

	

}
