package GeneralStore;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3_ValidateProductsInCheckoutPage extends BaseTest_GeneralStore {
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
		
		//Products to be added
		List<String> targetProducts=List.of("Nike Blazer Mid '77","Jordan 6 Rings");
		double expectedTotalPrice=0.0;
		for(String product:targetProducts) {
		scrollToElementAction(product);
		
		List<WebElement> products = driverObj.findElements(By.id("com.androidsample.generalstore:id/productName"));
		List<WebElement> addToCartBtns = driverObj.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
		List<WebElement> productPrices = driverObj.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getText().equalsIgnoreCase(product)) {
				String priceText=productPrices.get(i).getText();
				double price=Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
				expectedTotalPrice+=price;
	            
				System.out.println("Adding product: " + product + " | Price: " + price);
				addToCartBtns.get(i).click();
				break;
			}
		}
		}
		System.out.println("Total Price in products page: " +expectedTotalPrice);
		
		//Go to cart
		driverObj.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		//Verify products in carts page
		List<WebElement> checkoutProducts=driverObj.findElements(By.id("com.androidsample.generalstore:id/productName"));
		List<String> checkoutProductNames=new ArrayList<>();
		for(WebElement checkoutProduct:checkoutProducts) {
			checkoutProductNames.add(checkoutProduct.getText());
		}
		Assert.assertTrue(checkoutProductNames.containsAll(targetProducts),"Not all selected products are present in checkout!");
		
		
	}
}
