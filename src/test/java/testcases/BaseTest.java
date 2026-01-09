package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
/*
 * preference:
xapth: 

preference dependency:
xpath: 

wifi checkbox:
xpath: 

wifi settings:
xpath: 

editbox:
xpath: 
 */
public class BaseTest {
	AndroidDriver driverObj;
	DesiredCapabilities capObj;
	AppiumServiceBuilder service;
	AppiumDriverLocalService localService;
	@BeforeSuite
	public void startAppiumServer() {
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\91733\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723);
		localService=service.build();
		localService.start();		
	}
	
  @BeforeTest
  public void setUp() throws MalformedURLException, URISyntaxException, InterruptedException {
	  capObj = new DesiredCapabilities();
	  capObj.setCapability("appium:platformName", "Android");
	  capObj.setCapability("appium:deviceName", "Pixel 4a");
	  capObj.setCapability("appium:automationName", "UiAutomator2");
	  capObj.setCapability("appium:app", "C:\\Users\\91733\\OneDrive\\Desktop\\AppiumBasics\\AppiumBasics\\src\\test\\resources\\ApiDemos-debug.apk");
	  
	  driverObj=new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), capObj);  
	  System.out.println("Driver and the app launched successfully");
  }
  
  public void longClickAction(WebElement longClickElement) {
	  ((JavascriptExecutor)driverObj)
	  .executeScript("mobile:longClickGesture", ImmutableMap.of(
					  "elementId",((RemoteWebElement)longClickElement).getId(),
			  		  "duration",3000));
  }
  
  public void scrollToElementAction(String elementText) {
	  driverObj.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))")).click();
  }
  
  public void swipeElementAction(WebElement swipeEle) {
	  ((JavascriptExecutor)driverObj).executeScript("mobile:swipeGesture",
			  ImmutableMap.of(
					  "elementId",((RemoteWebElement)swipeEle).getId(),
					  "direction","left",
					  "percent",0.15));
  }
  
  public void startActivity(String appPackage,String appActivity) {
	  ((JavascriptExecutor)driverObj).executeScript("mobile:startActivity",
			  ImmutableMap.of(
					  "intent",appPackage+"/"+appActivity));
  }
  @AfterTest
  public void tearDown() {
	  if(driverObj!=null) {
		  driverObj.quit();
	  }
	  System.out.println("Driver closed successfully");
  }
  
  @AfterSuite
  public void stopAppiumServer() {
	  localService.stop();
  }
}
