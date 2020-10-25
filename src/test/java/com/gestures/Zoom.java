package com.gestures;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Zoom {
	AndroidDriver driver;
	@Test
	public void zoominAndOut() throws InterruptedException, IOException 

	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "OPPO");


		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Andriod");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("UDID", "c291a593");
		dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");
		URL url=new URL("http://localhost:4723/wd/hub");


		driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();

		driver.findElementByXPath("//android.widget.TextView[@text='Basic features']").click();

		MobileElement image=(MobileElement) driver.findElementByXPath("//android.view.View[@resource-id='com.davemorrissey.labs.subscaleview.sample:id/imageView']");
	
		//driver.zoom(image);
		int x=(int)(driver.manage().window().getSize().getWidth()*0.75);
		
		int y=(int)(driver.manage().window().getSize().getHeight()*0.40);
		driver.zoom(x, y);
		
		Thread.sleep(1000);
		screenShot();
		
		//driver.pinch(image);

	}
	
	public  void screenShot() throws IOException

	{
		EventFiringWebDriver efw= new EventFiringWebDriver(driver);
		File srcfile=efw.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./ScreenShot.png");
		FileUtils.copyFile(srcfile, destFile);
		
	}
	
	
	
}
