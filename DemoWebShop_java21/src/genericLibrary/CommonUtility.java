package genericLibrary;

import java.io.File;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtility {

	
	public void toTakeScreenmshot(WebDriver driver,String name)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("./ScreenShot/"+name+".png");
		try {
			org.openqa.selenium.io.FileHandler.copy(src,trg);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}

