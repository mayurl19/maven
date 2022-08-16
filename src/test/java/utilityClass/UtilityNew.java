package utilityClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class UtilityNew {

	public static String dataFromMyProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream myFile = new FileInputStream(
				"C:\\Users\\91966\\eclipse-workspace\\9even\\myProperty.properties");
		prop.load(myFile);
	 	String value = prop.getProperty(key);
		return value;

	}

	public static void waits(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}
}
