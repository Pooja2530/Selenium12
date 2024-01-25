package testScripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;

public class Script3 extends BaseTest {
	@Test(groups="System")
public void Cart() throws InterruptedException {
					
		//launch the browser
//	LaunchBrowser();
	
	//login to the application
	Login();
	
	//navigate to digital dounloads page
	driver.findElement(By.xpath("//a[@href=\"/digital-downloads\"][1]")).click();
	
	//verify digital dounloads page is displayed
	String digital = driver.findElement(By.cssSelector("[class=\"page-title\"]")).getText();
	if (digital.equals("Digital downloads")) {
		System.out.println("Digital dounloads page is displayed");
	} else {
		System.out.println("Digital dounloads page is not displayed");
	}
	
	//add the items to the cart
	 List<WebElement> items = driver.findElements(By.cssSelector("[value=\"Add to cart\"]"));
	for (WebElement button : items) {
		button.click();
		Thread.sleep(3000);
	}

	//navigate to cart page
driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

//verify cart page is displayed
String cart = driver.findElement(By.cssSelector("[class=\"page-title\"]")).getText();
if (cart.equals("Shopping cart")) {
	System.out.println("Cart page is displayed");
} else {
	System.out.println("Cart page is not displayed");
}
Thread.sleep(3000);

//remove the items from cart
List<WebElement> cart1 = driver.findElements(By.xpath("//input[@name='removefromcart']"));
for (WebElement remove : cart1) {
	remove.click();
}
driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();

//verify the items is removed from cart
String empty = driver.findElement(By.xpath("//div[@class='order-summary-content']")).getText();
System.out.println(empty);

//logout
Logout();

//close browser
CloseBrowser();
}
}
