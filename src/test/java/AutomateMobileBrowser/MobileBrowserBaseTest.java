package AutomateMobileBrowser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowserBaseTest {
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
        capObj.setCapability("appium:chromedriverExecutable", "C:\\Users\\91733\\OneDrive\\Desktop\\AppiumBasics\\AppiumBasics\\src\\test\\resources\\chromedriver.exe");
        capObj.setCapability("appium:browserName", "Chrome");
        
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


}
