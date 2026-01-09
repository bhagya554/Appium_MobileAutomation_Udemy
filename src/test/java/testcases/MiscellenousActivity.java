package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
/*
 * id,xpath,className - Web and Mobile
 * xpath - //tagname[@attribute='attribute value']
 *
 * accessibilityId,androidUIAutomator - Mobile
 * 
 */
public class MiscellenousActivity extends BaseTest {
  @Test
  public void WifiSettings() throws InterruptedException {
	  driverObj.findElement(AppiumBy.accessibilityId("Preference")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.id("android:id/checkbox")).click();
	  DeviceRotation landscape = new DeviceRotation(0, 0, 90);
	  driverObj.rotate(landscape);
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	  Thread.sleep(2000);
	  driverObj.setClipboardText("Bhagya WIFI");
	  driverObj.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(driverObj.getClipboardText());
	  Thread.sleep(2000);
	  driverObj.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	  driverObj.pressKey(new KeyEvent(AndroidKey.BACK));
	  Thread.sleep(2000);
	  driverObj.pressKey(new KeyEvent(AndroidKey.HOME));
	  
  }
}
