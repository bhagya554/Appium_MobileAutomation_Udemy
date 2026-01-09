package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class Testcase2_ScrollGesture2 extends BaseTest{
  @Test
  public void scrollGestureTest() throws InterruptedException {
	  
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  Thread.sleep(2000);
	  boolean canScrollMore=true;
	  while(canScrollMore) {
	  try {
		  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Lists\"]")).click();
		  canScrollMore=false;
	  }
	  catch(Exception e){
		 canScrollMore= (Boolean)((JavascriptExecutor) driverObj).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 400,
				    "direction", "down",
				    "percent", 5.0
				)); 
		  
	  }
	  }
      Thread.sleep(2000);
  }
}
