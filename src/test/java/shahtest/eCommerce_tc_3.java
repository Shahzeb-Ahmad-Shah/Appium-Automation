package shahtest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseTest {
	
	@Test
	public void FillForm () throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shahzeb Ahmad Shah");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text = 'Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
		    By.id("com.androidsample.generalstore:id/toolbar_title"), "Cart"));
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int productCount = productPrices.size();
		double sum = 0.0; 
		for(int i = 0; i < productCount; i++) {
			String amountString = productPrices.get(i).getText();
			double price = Double.parseDouble(amountString.substring(1));
			sum = sum + price;
		}
		
		String totalSum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double cash = Double.parseDouble(totalSum.substring(1));
		Assert.assertEquals(cash, sum);
		
		Thread.sleep(3000);
	}

}
