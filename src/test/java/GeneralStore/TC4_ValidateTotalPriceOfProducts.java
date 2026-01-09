package GeneralStore;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4_ValidateTotalPriceOfProducts extends BaseTest_GeneralStore {
	@Test(priority = 2)
	public void checkoutPageProductValidationTest() throws InterruptedException {
		// Select country
		WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/text1")));
		countryDropdown.click();
		// Scroll To Argentina country
		scrollToElementAction("Argentina").click();

		// Fill name
		driverObj.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Bhagya");
		driverObj.hideKeyboard();

		// Select gender
		driverObj.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		// Click Let's Shop
		driverObj.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);

		// Products to be added
		List<String> targetProducts = List.of("Converse All Star", "Jordan Lift Off");
		
		for (String product : targetProducts) {
			scrollToElementAction(product);

			List<WebElement> products = driverObj.findElements(By.id("com.androidsample.generalstore:id/productName"));
			List<WebElement> addToCartBtns = driverObj
					.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
			

			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getText().equalsIgnoreCase(product)) {
					System.out.println("Adding product: " + product);
					addToCartBtns.get(i).click();
					break;
				}
			}
		}
		

		// Go to checkout page
		driverObj.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"),
				"text", "Cart"));
		

		//calculate sum of products present in checkout page
		List<WebElement> checkoutProductPrices = driverObj.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		double expectedTotalProductsPrice=0.0;
		for (WebElement checkoutProductPrice : checkoutProductPrices) {
			//String priceText=checkoutProductPrice.getText().replaceAll("[^0-9.]", "");
			String priceText=checkoutProductPrice.getText();
			double price=getFormattedAmount(priceText);
			expectedTotalProductsPrice+=price;
		}
		System.out.println("Sum of product prices present in checkout page: " + expectedTotalProductsPrice);
		
		
		// Verify total price of products in checkout page matches checkout page total price
		WebElement checkoutTotalPrice = driverObj
				.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"));
		double actualTotalPrice = getFormattedAmount(checkoutTotalPrice.getText());
		System.out.println("Actual totalPrice: " + actualTotalPrice);

		Assert.assertEquals(actualTotalPrice, expectedTotalProductsPrice, "Total price mismatch!");
		Thread.sleep(2000);
	}
}
