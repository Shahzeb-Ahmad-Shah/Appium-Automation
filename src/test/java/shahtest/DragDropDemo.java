package shahtest;

import java.io.File;

import java.net.MalformedURLException;

import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.windows.WindowsDriver;

public class DragDropDemo extends BaseTest {
	
	@Test
	public void dragDropTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement dragElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		driver.executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)dragElement).getId(),
						"endX", 652,
						"endY", 589));
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
		
		Thread.sleep(2000);
		
	}

}
