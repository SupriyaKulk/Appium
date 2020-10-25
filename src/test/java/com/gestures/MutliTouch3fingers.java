package com.gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MutliTouch3fingers {
	
public AndroidDriver driver;
	
	@Test
	public void multiTouch3() throws MalformedURLException, InterruptedException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
	
		
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", ".TouchScreenTestActivity");

		URL url=new URL("http://localhost:4723/wd/hub");
	
		driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		
		
		int x=(int)(driver.manage().window().getSize().getWidth()*0.50);
		
		int y=(int)(driver.manage().window().getSize().getHeight()*0.50);
		
		TouchAction f1=new TouchAction(driver);
		f1.press(x-50, y-100).moveTo(x-50, y+100);
		
		TouchAction f2=new TouchAction(driver);
		f2.press(x, y-100).moveTo(x, y+100);
		
		TouchAction f3=new TouchAction(driver);
		f3.press(x+50, y-100).moveTo(x+50, y+100);
		
		
		MultiTouchAction mta= new MultiTouchAction(driver);
		mta.add(f1).add(f2).add(f3).perform();
		
		
	}

}
