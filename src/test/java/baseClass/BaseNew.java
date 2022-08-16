package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import utilityClass.UtilityNew;

public class BaseNew {

	protected static WebDriver driver;

	public void openApp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(UtilityNew.dataFromMyProperty("URL"));
		Reporter.log("Launching Kite App", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

	}
	public static void captureScreenshot (String TCID) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\91966\\OneDrive\\Pictures\\Saved Pictures\\ss" + TCID + ".png");
		FileHandler.copy(src, dest);
		Reporter.log("Taken Screenshot ", true);
	}

}
