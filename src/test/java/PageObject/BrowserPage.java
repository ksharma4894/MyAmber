package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

//public class BaePage {

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPage {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) { // ✅ Ensures only one WebDriver instance is created
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null; // ✅ Reset driver instance after quitting
		}
	}
}
