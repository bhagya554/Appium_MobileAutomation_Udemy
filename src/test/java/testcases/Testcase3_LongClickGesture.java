package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;



public class Testcase3_LongClickGesture extends BaseTest{
  @Test
  public void longClickGestureTest() throws InterruptedException {
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
	  Thread.sleep(2000);
	  driverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
	  Thread.sleep(2000);
	  WebElement longClickElement=driverObj.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
	  longClickAction(longClickElement);
	 
	  WebElement list=driverObj.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']"));
	  String listName=list.getText();
	  Assert.assertEquals(listName,"Sample menu");
	  Assert.assertTrue(list.isDisplayed());
  }
}
