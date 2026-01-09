package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class AppLaunchUsingAppPackageAndActivityName extends BaseTest {
  @Test
  public void WifiSettings() throws InterruptedException {
	  ((JavascriptExecutor)driverObj).executeScript("mobile:startActivity",
			  ImmutableMap.of(
					  "intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
					  
	  Thread.sleep(2000);
	  driverObj.findElement(By.id("android:id/checkbox")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Hello");
	  Thread.sleep(2000);
	  driverObj.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
  }
}
