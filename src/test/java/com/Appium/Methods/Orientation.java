package com.Appium.Methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Orientation {

	
	public AndroidDriver driver;
	@Test
	public void openOrientation() throws MalformedURLException, InterruptedException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
	
		
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		dc.setCapability("noReset", true);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		
		driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("The initial screen orientation is:: "+driver.getOrientation());
		Thread.sleep(1000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		System.out.println("the orientation of the screen after rotation is:: "+driver.getOrientation());
		
		
Dimension d=driver.manage().window().getSize();
		
		int ht=d.height;
		int wd=d.width;
		int startxv=(int) (wd*0.20);
		 
		int endxv=(int) (wd*0.20);
		 
		int startyv=(int) (ht*0.30);
		 
		 
		 int endyv=(int) (ht*0.80);
		 
		 driver.swipe(startxv, startyv, endxv, endyv, 500);
		 
		WebElement views=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
		driver.tap(1, views, 500);
		Thread.sleep(1000);
		Thread.sleep(1000);
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(1000);
		
		System.out.println("the orientation after screen rotation is:: "+driver.getOrientation());
		
		
}
}