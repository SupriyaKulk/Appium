package com.gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DropDown {
	
	public AndroidDriver<MobileElement> driver;
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
		driver.hideKeyboard();
		//driver.swipe(276, 596, 276, 320, 500);
	
		
		driver.findElementByXPath("//android.widget.Spinner[@resource-id='io.appium.android.apis:id/spinner1']").click();
		
		List<MobileElement> options=driver.findElementsByClassName("android.widget.Spinner");
		
		String exp="Jupiter";
		
		for(MobileElement me:options)
		{
			String act=me.getText();
			System.out.println(act);
			if(act.equals(exp))
			{
				tapOnElement(me);
				break;
			}
		}
	}
	public void tapOnElement(WebElement element)
	{
		driver.tap(1, element, 500);
	}

}
