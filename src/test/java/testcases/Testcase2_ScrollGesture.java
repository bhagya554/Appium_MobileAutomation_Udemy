package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Testcase2_ScrollGesture extends BaseTest{
  @Test
  public void scrollGestureTest() throws InterruptedException {
	  
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  Thread.sleep(2000);
	  //Lists
	  scrollToElementAction("Lists");
      Thread.sleep(2000);
  }
}
