package GeneralStore;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_HomePage extends BaseTest_GeneralStore {

	@Test(priority = 1)
	public void homePagePositiveTest() throws InterruptedException {
		// Select country
		WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/text1")));
		countryDropdown.click();

		scrollToElementAction("India").click();

		// Fill name
		driverObj.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Bhagya");
		driverObj.hideKeyboard();
		// Select gender
		driverObj.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		// Click Let's Shop
		driverObj.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void homePageNegativeTest() {
		// Click Let's Shop
		WebElement LetsShopBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("com.androidsample.generalstore:id/btnLetsShop")));
		LetsShopBtn.click();
		WebDriverWait shortWait = new WebDriverWait(driverObj, Duration.ofSeconds(2));

		WebElement toastMessage = shortWait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[1]")));
		String message = toastMessage.getAttribute("name");
		Assert.assertEquals(message, "Please enter your name");
		System.out.println("Toast message displayed: " + message);
	}
}
