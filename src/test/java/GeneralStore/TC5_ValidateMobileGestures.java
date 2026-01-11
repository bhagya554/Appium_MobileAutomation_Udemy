package GeneralStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC5_ValidateMobileGestures extends BaseTest_GeneralStore{
@Test
public void validateGestures() throws InterruptedException {
	// Select country
	WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/text1")));
	countryDropdown.click();

	scrollToElementAction("Algeria").click();

	// Fill name
	driverObj.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Bhagya");
	driverObj.hideKeyboard();
	// Select gender
	driverObj.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

	// Click Let's Shop
	driverObj.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	Thread.sleep(2000);
	
	driverObj.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
	driverObj.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(2000);
	WebElement terms=driverObj.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	longClickAction(terms);
	wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/alertTitle"), "text","Terms Of Conditions"));
	System.out.println("Terms Text: " + driverObj.findElement(By.id("android:id/message")).getText());
	driverObj.findElement(By.id("android:id/button1")).click();
	driverObj.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	driverObj.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	Thread.sleep(2000);



}
}
