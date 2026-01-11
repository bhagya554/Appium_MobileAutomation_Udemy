package AutomateMobileBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBaseTest {

	@Test
	public void mobileBrowserTest() throws InterruptedException {
		driverObj.get("https://google.com");
		System.out.println(driverObj.getTitle());
		WebElement textArea=driverObj.findElement(By.name("q"));
		textArea.sendKeys("appium training");
		textArea.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}
}
