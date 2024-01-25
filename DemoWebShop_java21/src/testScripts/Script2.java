package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;

public class Script2 extends BaseTest {
	@Test(groups = "System")
public void Wishlist() throws InterruptedException{
		//launching the browser
//	LaunchBrowser();
	
	//login to the application
//	Login();
	
	//Navigate to book paged
	driver.findElement(By.xpath("//a[@href=\"/books\"][1]")).click();
	String book = driver.findElement(By.xpath("//h1[text()='Books']")).getText();
	if (book.equals("Books")) {
		System.out.println("Book page is displayed");
	} else {
		System.out.println("Book page is not displayed");
	}
	
	//Click on Fiction Ex Book
	driver.findElement(By.xpath("//a[text()='Fiction EX']")).click();
	String fictionbook = driver.findElement(By.cssSelector("[class=\"breadcrumb\"]")).getText();
	if (fictionbook.equals("HOME / BOOKS / FICTION EX")) {
		System.out.println("Fiction book is displayed");
	} else {
		System.out.println("Fiction book is not displayed");
	}
	
	//add book to wishlist
driver.findElement(By.xpath("//input[@id='add-to-wishlist-button-78']")).click();
String wish = driver.findElement(By.xpath("//p[text()='The product has been added to your ']")).getText();
if (wish.equals("The product has been added to your ")) {
	System.out.println("book is added to the wishlist");
} else {
	System.out.println("book is not added to the wishlist");
}

//navigate to wishlist
driver.findElement(By.xpath("//span[text()='Wishlist']")).click();

//verify wishlist page is displayed
String wishlist = driver.findElement(By.cssSelector("[class=\"page-title\"]")).getText();
if (wishlist.equals("Wishlist")) {
	System.out.println("Wishlist page is displayed");
	
} else {
	System.out.println("Wishlist page is not displayed");
	Thread.sleep(3000);
	}

//verify book is added to cart
 String book1 = driver.findElement(By.xpath("//a[text()='Fiction EX']")).getText();
 if (book1.equals("Fiction EX")) {
	System.out.println("Book is present in wishlist");
} else {
	System.out.println("Book is not present in wishlist");
}
 
 //remove book from wishlist
 driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
 driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();
 Thread.sleep(3000);
 
 //verify the book is removed from wishlist
 String book2 = driver.findElement(By.xpath("//div[@class='center-1']")).getText();
 if (book2.equals("Fiction EX")) {
	System.out.println("Book is present in wishlist");
	common_utility.toTakeScreenmshot(driver, "addToWishList");
} else {
	System.out.println("Book is not present in wishlist");
}
// Logout();
// CloseBrowser();
}
}
