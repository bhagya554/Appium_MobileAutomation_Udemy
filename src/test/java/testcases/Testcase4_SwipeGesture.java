package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


public class Testcase4_SwipeGesture extends BaseTest{
  @Test
  public void swipeGestureTest() throws InterruptedException {
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
	  Thread.sleep(2000);
	  
	  WebElement swipeEle=driverObj.findElement(By.xpath("(//android.widget.ImageView)[1]"));
	  Assert.assertEquals(swipeEle.getAttribute("focusable"),"true");
	  swipeElementAction(swipeEle);
	  //After swipe: first element focussable becomes false as it focusses on second image
	  Assert.assertEquals(swipeEle.getAttribute("focusable"),"false");
	  Thread.sleep(2000);
  
  
  }
}
