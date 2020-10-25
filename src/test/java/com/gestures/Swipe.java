package com.gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Swipe {

	
	public AndroidDriver driver;
	
	@Test
	public void swipe() throws MalformedURLException, InterruptedException 

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
		
		Dimension d=driver.manage().window().getSize();
		
		int ht=d.height;
		int wd=d.width;
		System.out.println("height : "+ht);
		 System.out.println("width : "+wd);
		
		 
		 //Swipe vertical
		 //int startxv=(int) (wd*0.20);
		 
		// int endxv=(int) (wd*0.20);
		 
		 //int startyv=(int) (ht*0.30);
		 
		 
		// int endyv=(int) (ht*0.80);
		 
		 //driver.swipe(startxv, startyv, endxv, endyv, 500);
		 
		 
		 //Swipe horizontal
		 
		// int startxh=(int)(wd*0.20);
		//	int endxh= (int) (wd*0.80);
		//	int startyh= (int)(ht*0.50);
			
		//	int endyh=(int)(ht*0.50);
			
		//	driver.swipe(startxh, startyh, endxh, endyh, 500);
		 
		 
		// SwipeL pattern 
		 int startxv=(int) (wd*0.20);
		 
		 int endxv=(int) (wd*0.20);
		 
		 int startyv=(int) (ht*0.30);
		 
		 
		 int endyv=(int) (ht*0.80);
		 
		 swipeLine(startxv, startyv, endxv, endyv);
		 
		 
		int startxh=startxv;
		int endxh= (int) (wd*0.80);
		int startyh= endyv;
		
		int endyh=endyv;
		
		swipeLine(startxh, startyh, endxh, endyh);
		
		//SwipeL Pattern 2
		
		int x1=(int)(wd*0.10);
		int y1=(int)(ht*0.20);
		int y2=(int)(ht*0.80);
		
		swipeLine(x1, y1, x1, y2);
		Thread.sleep(1000);
		
		int endx=(int)(wd*0.80);
		swipeLine(x1, y2, endx, y2);
		
		Thread.sleep(1000);
		
		
		//SwipeX pattern
		int startx2=(int)(wd*0.80);
		int endx2=(int)(wd*0.20);
		int starty2=(int)(ht*0.20);
		int endy2=(int)(ht*0.80);
		
		swipeLine(startx2, starty2, endx2, endy2);
		
		int startx3=(int)(wd*0.20);
		int endx3=(int)(wd*0.80);
		int starty3=(int)(ht*0.20);
		int endy3=(int)(ht*0.80);
		
		swipeLine(startx3, starty3, endx3, endy3);
		
		

	}
	
	public void swipeLine(int startx,int starty,int endx,int endy)
	{
		driver.swipe(startx, starty, endx, endy, 500);
	}
}
