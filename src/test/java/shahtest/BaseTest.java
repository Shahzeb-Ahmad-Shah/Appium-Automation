package shahtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


import io.appium.java_client.windows.WindowsDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;


public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException 
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ShahzebAhmadShah//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		//Use UiAutomator2Options to avoid ambiguity
		UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Shahemulator");
        options.setApp("C://Users//ShahzebAhmadShah//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		
		//AndroidDriver
		driver = new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
	}
	
	public void longPressAction(WebElement ele)
	{
		driver.executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	@AfterClass
	public void tearDown()
	{
		
		//code to stop the appium server
		driver.quit();
		service.stop();
	} 

}
