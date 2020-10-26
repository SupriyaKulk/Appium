package com.Appium.Methods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class KeyCode {
	
	
	@Test
	public void keyCode() throws MalformedURLException, InterruptedException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		dc.setCapability("noReset", true);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability("platformVersion", "10");
		dc.setCapability("UDID", "c291a593");
		//dc.setCapability("appPackage", "com.oppo.camera");
		//dc.setCapability("appActivity", ".Camera");

		URL url=new URL("http://localhost:4723/wd/hub");
		
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		
		//driver.findElementByXPath("//android.widget.ImageView[@content-desc='Rear Camera']").click();
		
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
	}

}
