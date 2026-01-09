package GeneralStore;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest_GeneralStore {
    AppiumServiceBuilder service;
    AppiumDriverLocalService local;
    DesiredCapabilities capObj;
    protected AndroidDriver driverObj;   // made protected for subclass access
    protected WebDriverWait wait;        // reusable explicit wait

    @BeforeSuite
    public void startAppiumServer() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\91733\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723);
        local = service.build();
        local.start();
    }

    @AfterSuite
    public void stopAppiumServer() {
        local.stop();
    }

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        capObj = new DesiredCapabilities();
        capObj.setCapability("appium:deviceName", "Pixel 4a");
        capObj.setCapability("appium:platformName", "Android");
        capObj.setCapability("appium:automationName", "UiAutomator2");
        capObj.setCapability("appium:app", "C:\\Users\\91733\\OneDrive\\Desktop\\AppiumBasics\\AppiumBasics\\src\\test\\resources\\General-Store.apk");

        // ✅ Add appPackage and appActivity for stability
        capObj.setCapability("appium:appPackage", "com.androidsample.generalstore");
        capObj.setCapability("appium:appActivity", "com.androidsample.generalstore.MainActivity");

        driverObj = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), capObj);
        wait = new WebDriverWait(driverObj, Duration.ofSeconds(10));
        System.out.println("Driver and the app launched successfully");
    }

   @AfterClass
    public void tearDown() {
        if (driverObj != null) {
            driverObj.quit();
        }
        System.out.println("Driver closed successfully");
    }

    // Utility actions
    public void longClickAction(WebElement longClickElement) {
        ((JavascriptExecutor) driverObj).executeScript("mobile:longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) longClickElement).getId(),
                "duration", 3000));
    }

    public WebElement scrollToElementAction(String elementText) {
        return driverObj.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
    }

    public double getFormattedAmount(String amountInText) {
    	//return Double.parseDouble(amountInText.replaceAll("[^0-9.]", "")); (or)
    	return Double.parseDouble(amountInText.substring(1));
    }
    
    public void startActivity(String appPackage,String appActivity) {
  	  ((JavascriptExecutor)driverObj).executeScript("mobile:startActivity",
  			  ImmutableMap.of(
  					  "intent",appPackage+"/"+appActivity));
    }
    public void swipeElementAction(WebElement swipeEle) {
        ((JavascriptExecutor) driverObj).executeScript("mobile:swipeGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) swipeEle).getId(),
                        "direction", "left",
                        "percent", 0.15));
    }
}
