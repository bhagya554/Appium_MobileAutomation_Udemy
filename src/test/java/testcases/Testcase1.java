package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
/*
 * id,xpath,className - Web and Mobile
 * xpath - //tagname[@attribute='attribute value']
 *
 * accessibilityId,androidUIAutomator - Mobile
 * 
 */
public class Testcase1 extends BaseTest {
  @Test
  public void WifiSettings() throws InterruptedException {
	  driverObj.findElement(AppiumBy.accessibilityId("Preference")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
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
