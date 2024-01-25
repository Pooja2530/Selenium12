package genericLibrary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public CommonUtility common_utility=new CommonUtility();
	public WebDriver driver;
	public static WebDriver listnersDriver;
	
	@BeforeClass
	public void LaunchBrowser(String browserName)
	{
		if (browserName.equals("Chrome")) {
			driver=new ChromeDriver();
		} else if(browserName.equals("Edge")){
driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Enter valid browser name");
		}
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@BeforeMethod
	public void Login()
	{
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys("pooja.bs@gmail.com");
		driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("Pooja@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void Logout()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.close();
	}
}
