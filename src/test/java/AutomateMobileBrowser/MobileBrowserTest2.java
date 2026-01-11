package AutomateMobileBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest2 extends MobileBrowserBaseTest {

	@Test
	public void mobileBrowserTest() throws InterruptedException {
		driverObj.get("https://rahulshettyacademy.com/angularAppdemo/");
		System.out.println(driverObj.getTitle());
		//Click on hamburger icon
		driverObj.findElement(By.className("navbar-toggler-icon")).click();
		//Click on products
		driverObj.findElement(By.xpath("//a[@routerlink='/products']")).click();
		//scroll to select Devops
		((JavascriptExecutor)driverObj).executeScript("window.scrollBy(0,1000)","");
		String productText=driverObj.findElement(By.cssSelector("a[href*='products/3']")).getText();
		System.out.println("Product text: " + productText);
		Assert.assertEquals(productText,"Devops");
		
	}
}
