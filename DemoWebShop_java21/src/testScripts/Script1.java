package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;

public class Script1 extends BaseTest {
@Test(groups = "Integration")
public void registerTestCase() {
	
	//launch the browser
//	LaunchBrowser();
	
	//navigate to register page
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	String url = driver.getCurrentUrl();
	if (url.equals("Register")) {
		System.out.println("Register page is displayed...");
	}
	else {
System.out.println("Register page is not displayed");
	}
	
	//register to the application
	driver.findElement(By.xpath("//label[text()='Female']")).click();
	driver.findElement(By.cssSelector("[id=\"FirstName\"]")).sendKeys("Pooja");
	driver.findElement(By.cssSelector("[id=\"LastName\"]")).sendKeys("B S");
	driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys("pooja25bs@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Pooja@123");
	driver.findElement(By.id("ConfirmPassword")).sendKeys("Pooja@123");
	driver.findElement(By.id("register-button")).click();
	
	//verify register is done
	String reg = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
	if (reg.equals("Your registration completed")) {
		System.out.println("Registration is complited");
	} else {
		System.out.println("Registration is not complited");
	}
	
	//close the browser
	CloseBrowser();
	}
	
}

