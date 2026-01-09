package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
//688 1053
public class Testcase5_DragGesture extends BaseTest {
  @Test
  public void dragGestureTest() throws InterruptedException {
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	  Thread.sleep(2000);
	  WebElement dragEle=driverObj.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	  ((JavascriptExecutor)driverObj).executeScript("mobile:dragGesture",
			  ImmutableMap.of(
					  "elementId",((RemoteWebElement)dragEle),
					  "endX",688,
					  "endY",1053					  
					  ));
	  Thread.sleep(2000);
	  String eleText=driverObj.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
	  Assert.assertEquals("Dropped!", eleText);
  }
}
