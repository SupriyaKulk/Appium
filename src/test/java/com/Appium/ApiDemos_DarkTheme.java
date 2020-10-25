package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ApiDemos_DarkTheme {

	public AndroidDriver driver;
	@Test
	public void apiDemoDarkTheme() throws MalformedURLException, InterruptedException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
	
		
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		//RemoteWebDriver driver = new RemoteWebDriver(url, dc);
		driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElementByAccessibilityId("Views").click();
		WebElement views=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
		tapOnElement(views);
		
		WebElement controls=driver.findElementByAccessibilityId("Controls");
		tapOnElement(controls);
		
		WebElement theme=driver.findElementByAccessibilityId("2. Dark Theme");
		
		
		tapOnElement(theme);
		
		Boolean check1=driver.findElementByAccessibilityId("Checkbox 1").isSelected();
		
		if(check1==false)
		{
			driver.findElementByAccessibilityId("Checkbox 1").click();
			System.out.println("Check box is selected");
		}else
		{
			System.out.println("check box is enabled");
		}
		
		WebElement RadioBtn= driver.findElementByAccessibilityId("RadioButton 2");
		tapOnElement(RadioBtn);
		
		Boolean ChkRadio=RadioBtn.isEnabled();
	
		if(ChkRadio==true)
		{
			
			System.out.println("radio button is selected");
		}else
		{
			System.out.println("radio button is not selected");
		}
		
		
	}
	
	public void tapOnElement(WebElement element)
	{
		driver.tap(1, element, 500);
	}

}
