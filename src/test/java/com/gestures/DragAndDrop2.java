package com.gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragAndDrop2 {
	
	

	public AndroidDriver driver;
	@Test
	public void apiDemoDarkTheme() throws MalformedURLException, InterruptedException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
	
		dc.setCapability("noReset",true);
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
		WebElement dd= driver.findElementByAccessibilityId("Drag and Drop");
		tapOnElement(dd);
		
		MobileElement src=(MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		MobileElement dest=(MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).waitAction().moveTo(dest).release().perform();
		
	}
	
	public void tapOnElement(WebElement element)
	{
		driver.tap(1, element, 500);
	}

}
